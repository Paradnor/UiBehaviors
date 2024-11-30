package be.paradnor.uibehaviors.bounded;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Target sides that could be resized for Resizing Behaviors
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 */
public enum Side {
    TOP(1),
    RIGHT(1 << 1),
    BOTTOM(1 << 2),
    LEFT(1 << 3),

    VERTICAL(TOP.value | BOTTOM.value),
    HORIZONTAL(RIGHT.value | LEFT.value),

    TOP_RIGHT_CORNER(TOP.value | RIGHT.value),
    BOTTOM_RIGHT_CORNER(BOTTOM.value | RIGHT.value),
    BOTTOM_LEFT_CORNER(BOTTOM.value | LEFT.value),
    TOP_LEFT_CORNER(TOP.value | LEFT.value),

    EXCEPT_TOP(RIGHT.value | BOTTOM.value | LEFT.value) ,
    EXCEPT_RIGHT(TOP.value | BOTTOM.value | LEFT.value) ,
    EXCEPT_BOTTOM(TOP.value | RIGHT.value | LEFT.value),
    EXCEPT_LEFT(TOP.value | RIGHT.value | BOTTOM.value),

    ALL(TOP.value | RIGHT.value | BOTTOM.value | LEFT.value);

    private final static Set<Side> BASE_SIDES = EnumSet.of(TOP, RIGHT, BOTTOM, LEFT);

    private final int value;

    Side(int value) {
        this.value = value;
    }

    /**
     * @return the value associated to this side
     */
    public final int getValue() {
        return value;
    }

    /**
     * If the side is not composed, return an empty set.
     * Else it returns all the side related to it
     * @return the sides related to the current one.
     */
    public Set<Side> getRelatedSides() {
        return Arrays.stream(values())
                .filter(e -> e != this)
                .filter(BASE_SIDES::contains)
                .filter(e -> (e.value & this.value) != 0)
                .collect(Collectors.toSet());
    }

    /**
     * @param value the value to find the related Resizable sides
     * @return the ResizableSides related to the value
     */
    public static Side fromValue(int value){
        return Arrays.stream(values())
                .filter(e -> e.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid side value: " + value));
    }
}

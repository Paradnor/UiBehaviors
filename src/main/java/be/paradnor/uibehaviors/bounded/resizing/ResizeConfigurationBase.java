package be.paradnor.uibehaviors.bounded.resizing;


import be.paradnor.uibehaviors.BehaviorConfiguration;
import be.paradnor.uibehaviors.BehaviorTarget;
import be.paradnor.uibehaviors.bounded.Side;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * Base class for Resizing Configuration
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 * @param <T> the target of the resizing
 */
public abstract class ResizeConfigurationBase<T extends BehaviorTarget<?>> implements BehaviorConfiguration<T> {
    private double triggerMargin = 5.0;
    private Set<Side> sides = EnumSet.of(Side.ALL);
    private boolean preserveAspectRatio = false;

    protected ResizeConfigurationBase() {}

    /**
     * @return the margin from which the resizing trigger must happen
     */
    public final double getTriggerMargin() {
        return triggerMargin;
    }

    /**
     * set the margin from which the resizing trigger must happen
     * @param triggerMargin the triggerMargin to set
     * @throws IllegalArgumentException if the triggerMargin < 0
     */
    public final void setTriggerMargin(double triggerMargin) {
        if(triggerMargin < 0){
            throw new IllegalArgumentException("triggerMargin should be positive or equals to 0");
        }
        this.triggerMargin = triggerMargin;
    }

    /**
     * @return the unmodifiable set of sides which can handle resizing
     */
    public final Set<Side> getResizableSides() {
        return Collections.unmodifiableSet(sides);
    }

    /**
     * Set the sides which can handle resizing event
     * @param sides the target sides
     * @throws IllegalArgumentException if the resizableSides is null or empty
     */
    public final void setResizableSides(Side... sides) {
        if(sides == null || sides.length == 0){
            throw new IllegalArgumentException("resizableSides should not be null or empty");
        }
        this.sides = EnumSet.noneOf(Side.class);
        for (Side side : sides) {
            if (side == Side.ALL) {
                this.sides.addAll(EnumSet.of(
                        Side.TOP, Side.RIGHT,
                        Side.BOTTOM, Side.LEFT
                ));
                break;
            }
            this.sides.add(side);
        }
    }

    /**
     * @param side to check
     * @return if the specified resizable side is present into the configuration
     */
    public final boolean isSideResizable(Side side){
        return this.sides.contains(side);
    }

    /**
     * @return if resizing must preserve ration
     */
    public final boolean isPreserveAspectRatio() {
        return preserveAspectRatio;
    }

    /**
     * Set if the resizing must preserve ration
     * @param preserveAspectRatio if the ratio should be preserved
     */
    public final void setPreserveAspectRatio(boolean preserveAspectRatio) {
        this.preserveAspectRatio = preserveAspectRatio;
    }
}

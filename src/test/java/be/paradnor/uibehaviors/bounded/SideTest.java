package be.paradnor.uibehaviors.bounded;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SideTest {

    @Test
    void topSideGetValueIs1() {
        assertEquals(1, Side.TOP.getValue());
    }

    @Test
    void rightSideGetValueIs2() {
        assertEquals(2, Side.RIGHT.getValue());
    }

    @Test
    void bottomSideGetValueIs4() {
        assertEquals(4, Side.BOTTOM.getValue());
    }

    @Test
    void leftSideGetValueIs8() {
        assertEquals(8, Side.LEFT.getValue());
    }

    @Test
    void allSidesGetValueIs15() {
        assertEquals(15, Side.ALL.getValue());
    }

    @Test
    void horizontalGetValueIs10() {
        assertEquals(10, Side.HORIZONTAL.getValue());
    }

    @Test
    void verticalGetValueIs5() {
        assertEquals(5, Side.VERTICAL.getValue());
    }

    @Test
    void topRightCornerGetValueIs3() {
        assertEquals(3, Side.TOP_RIGHT_CORNER.getValue());
    }

    @Test
    void bottomRightCornerGetValueIs6() {
        assertEquals(6, Side.BOTTOM_RIGHT_CORNER.getValue());
    }

    @Test
    void bottomLeftCornerGetValueIs12() {
        assertEquals(12, Side.BOTTOM_LEFT_CORNER.getValue());
    }

    @Test
    void topLeftCornerGetValueIs9() {
        assertEquals(9, Side.TOP_LEFT_CORNER.getValue());
    }

    @Test
    void exceptTopGetValueIs14() {
        assertEquals(14, Side.EXCEPT_TOP.getValue());
    }

    @Test
    void exceptRightGetValueIs13() {
        assertEquals(13, Side.EXCEPT_RIGHT.getValue());
    }

    @Test
    void exceptBottomGetValueIs11() {
        assertEquals(11, Side.EXCEPT_BOTTOM.getValue());
    }

    @Test
    void exceptLeftGetValueIs7() {
        assertEquals(7, Side.EXCEPT_LEFT.getValue());
    }

    @Test
    void getValuesAreNotIdentical() {
        assertEquals(
                15, Arrays.stream(Side.values())
                        .map(Side::getValue).distinct().count());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15})
    void allValuesAreAssignable(int value) {
        assertDoesNotThrow(() -> Side.fromValue(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 16})
    void allValuesAreNotAssignable(int value) {
        assertThrows(IllegalArgumentException.class, () -> Side.fromValue(value));
    }

    @ParameterizedTest
    @EnumSource(value = Side.class, names = {"TOP", "BOTTOM", "RIGHT", "LEFT"})
    void simpleSidesHaveEmptyRelatedSides(Side side){
        assertTrue(side.getRelatedSides().isEmpty());
    }

    @Test
    void horizontalSideHasRightAndLeftSides(){
        assertRelatedContains(Side.HORIZONTAL, Side.RIGHT, Side.LEFT);
    }

    @Test
    void verticalSideHasBottomAndTopSides(){
        assertRelatedContains(Side.VERTICAL, Side.BOTTOM, Side.TOP);
    }

    @Test
    void topRightCornerHasTopRightSides(){
        assertRelatedContains(Side.TOP_RIGHT_CORNER, Side.TOP, Side.RIGHT);
    }

    @Test
    void bottomRightCornerHasBottomRightSides(){
        assertRelatedContains(Side.BOTTOM_RIGHT_CORNER, Side.BOTTOM, Side.RIGHT);
    }

    @Test
    void bottomLeftCornerHasBottomLeftSides(){
        assertRelatedContains(Side.BOTTOM_LEFT_CORNER, Side.BOTTOM, Side.LEFT);
    }

    @Test
    void topLeftCornerHasTopLeftSides(){
        assertRelatedContains(Side.TOP_LEFT_CORNER, Side.TOP, Side.LEFT);
    }

    @Test
    void exceptTopHasAllSidesExceptTop(){
        assertRelatedContains(Side.EXCEPT_TOP, Side.RIGHT, Side.BOTTOM, Side.LEFT);
    }

    @Test
    void exceptRightHasAllSidesExceptRight(){
        assertRelatedContains(Side.EXCEPT_RIGHT, Side.TOP, Side.BOTTOM, Side.LEFT);
    }

    @Test
    void exceptBottomHasAllSidesExceptBottom(){
        assertRelatedContains(Side.EXCEPT_BOTTOM, Side.TOP, Side.RIGHT, Side.LEFT);
    }

    @Test
    void exceptLeftHasAllSidesExceptLeft(){
        assertRelatedContains(Side.EXCEPT_LEFT, Side.TOP, Side.RIGHT, Side.BOTTOM);
    }

    @Test
    void allHasAllSides(){
        assertRelatedContains(Side.ALL, Side.TOP, Side.RIGHT, Side.BOTTOM, Side.LEFT);
    }

    private static void assertRelatedContains(Side actual, Side... expected){
        Set<Side> related = actual.getRelatedSides();
        assertEquals(expected.length, related.size());
        assertTrue(related.containsAll(Arrays.asList(expected)));
    }
}

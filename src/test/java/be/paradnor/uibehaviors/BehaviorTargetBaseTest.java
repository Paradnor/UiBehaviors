package be.paradnor.uibehaviors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BehaviorTargetBaseTest {

    @Test
    void onNullObjectThrowsNPE(){
        assertThrows(NullPointerException.class, () -> new BehaviorTargetBaseImpl(null));
    }

    @Test
    public void unwrapGetWrappedObject(){
        Object target = new Object();
        BehaviorTargetBase<Object> bt = new BehaviorTargetBaseImpl<>(target);

        assertEquals(target,bt.unwrap());
    }

    static class BehaviorTargetBaseImpl<T> extends BehaviorTargetBase<T> {
        public BehaviorTargetBaseImpl(T wrapped) {
            super(wrapped);
        }

        @Override public double getWidth() {
            return 0;
        }

        @Override public double getHeight() {
            return 0;
        }

        @Override public double getX() {
            return 0;
        }

        @Override public double getY() {
            return 0;
        }

        @Override public void setWidth(double width) {

        }

        @Override public void setHeight(double height) {

        }

        @Override public void setX(double x) {

        }

        @Override public void setY(double y) {

        }

        @Override public boolean isVisible() {
            return false;
        }

        @Override public void setVisible(boolean visible) {

        }

        @Override public void requestFocus() {

        }
    }
}

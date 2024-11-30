package be.paradnor.uibehaviors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BehaviorManagerTest {
    private BehaviorTargetImpl target = new BehaviorTargetImpl(new Object());
    
    @Test
    void onNulltargetThrowsNPE(){
        assertThrows(NullPointerException.class, () -> new BehaviorManager<>(null));
    }

    @Test
    void onUnexistingBehaviorGetReturnsNull(){
        BehaviorManager manager = new BehaviorManager(target);
        assertNull(manager.getBehavior(Behavior.class));
    }

    @Test
    void onAddBehaviorGetBehaviorReturnsAddedBehavior() {
        BehaviorA behaviorA = new BehaviorA();
        BehaviorManager behaviorManager = new BehaviorManager(target)
                .addBehavior(behaviorA);

        assertEquals(behaviorA, behaviorManager.getBehavior(BehaviorA.class));
    }

    @Test
    void onTwoSameTypeBehaviorsGetBehaviorReturnsTheLastAddedBehavior() {
        BehaviorA behaviorA = new BehaviorA();
        BehaviorA behaviorA1 = new BehaviorA();
        BehaviorManager behaviorManager = new BehaviorManager(target)
                .addBehavior(behaviorA)
                .addBehavior(behaviorA1);

        assertEquals(behaviorA1, behaviorManager.getBehavior(BehaviorA.class));
    }

    @Test
    void onRemovedBehaviorGetBehaviorReturnsNull() {
        BehaviorA behaviorA = new BehaviorA();
        BehaviorManager behaviorManager = new BehaviorManager(target)
                .addBehavior(behaviorA);

        assertEquals(behaviorA, behaviorManager.getBehavior(BehaviorA.class));
        behaviorManager.removeBehavior(BehaviorA.class);
        assertNull(behaviorManager.getBehavior(BehaviorA.class));
    }

    @Test
    void onConfiguredBehaviorAddedReturnsConfiguredBehavior() {
        ConfiguredBehaviorA behaviorA = new ConfiguredBehaviorA();
        BehaviorManager behaviorManager = new BehaviorManager(target)
                .addBehavior(behaviorA, new ConfiguredBehaviorA.BehaviorConfigurationA(), o -> {});

        assertEquals(behaviorA, behaviorManager.getBehavior(ConfiguredBehaviorA.class));
    }

    @Test
    void onSeveralBehaviorsWhenAllClearedNoneRemains(){
        BehaviorA behaviorA = new BehaviorA();
        BehaviorB behaviorB = new BehaviorB();
        ConfiguredBehaviorA configuredBehaviorA = new ConfiguredBehaviorA();

        BehaviorManager behaviorManager = new BehaviorManager(target)
                .addBehavior(behaviorA)
                .addBehavior(behaviorB)
                .addBehavior(configuredBehaviorA);

        assertEquals(behaviorA, behaviorManager.getBehavior(BehaviorA.class));
        assertEquals(behaviorB, behaviorManager.getBehavior(BehaviorB.class));
        assertEquals(configuredBehaviorA, behaviorManager.getBehavior(ConfiguredBehaviorA.class));

        behaviorManager.clearBehaviors();

        assertNull(behaviorManager.getBehavior(BehaviorA.class));
        assertNull(behaviorManager.getBehavior(BehaviorB.class));
        assertNull(behaviorManager.getBehavior(ConfiguredBehaviorA.class));
    }

    static class BehaviorA extends BehaviorBase {}
    static class BehaviorB extends BehaviorBase {}

    static class ConfiguredBehaviorA extends ConfigurableBehaviorBase<BehaviorTargetImpl, ConfiguredBehaviorA.BehaviorConfigurationA>{
        @Override
        protected BehaviorConfigurationA createsDefaultConfiguration() {
            return new BehaviorConfigurationA();
        }

        public static class BehaviorConfigurationA implements BehaviorConfiguration<BehaviorTargetImpl> {

            @Override
            public Class<BehaviorTargetImpl> getTargetType() {
                return BehaviorTargetImpl.class;
            }
        }
    }

    static class BehaviorTargetImpl extends BehaviorTargetBase<Object>{
        public BehaviorTargetImpl(Object wrapped) {
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

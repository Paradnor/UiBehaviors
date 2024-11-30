package be.paradnor.uibehaviors;

/**
 * Interface which defines the base contract for Behaviors
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0%
 * @since 1.0.0
 * @param <T> the {@link BehaviorTarget}
 */
public sealed interface Behavior<T extends BehaviorTarget<?>> permits BehaviorBase, ConfigurableBehavior, EventBasedBehavior {
    /**
     * Attach the current behavior to the target
     * @param target the target to add the behavior to.
     * @throws IllegalArgumentException if target is null
     */
    void attach(T target);

    /**
     * Detach the current behavior
     */
    void detach();

    /**
     * @return true if the current behavior is attached to the target
     */
    boolean isAttached();
}

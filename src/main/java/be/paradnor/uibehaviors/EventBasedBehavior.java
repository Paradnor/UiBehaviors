package be.paradnor.uibehaviors;

/**
 * The interface for {@link Behavior} that are triggered by events
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 * @param <T> the type of the {@link BehaviorTarget}
 */
public sealed interface EventBasedBehavior<T extends BehaviorTarget<?>> extends Behavior<T> permits ConfigurableEventBasedBehaviorBase, EventBasedBehaviorBase {
    /**
     * Register all event handlers associated to this behavior
     */
    void registerEventHandlers();

    /**
     * Unregister all event handlers associated to this behavior
     */
    void unregisterEventHandlers();
}

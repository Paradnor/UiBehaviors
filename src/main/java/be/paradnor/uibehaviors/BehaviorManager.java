package be.paradnor.uibehaviors;

import org.slf4j.Logger;

import java.util.*;
import java.util.function.Consumer;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Behavior Manager to handle several behavior on the same {@link BehaviorTarget}
 *
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 */
public final class BehaviorManager<T extends BehaviorTarget<?>> {
    private static final Logger LOGGER = getLogger(BehaviorManager.class);
    private final Map<Class<? extends Behavior>, Behavior<T>> behaviors;
    private final T target;

    public BehaviorManager(T target) {
        Objects.requireNonNull(target);
        this.target = target;
        this.behaviors = new HashMap<>();
    }

    /**
     * Add the specified behavior to the target
     *
     * @param behavior the behavior to add
     * @param <B>      the behavior type
     * @return the manager
     * @throws IllegalArgumentException if the behavior is null
     */
    public <B extends Behavior<T>> BehaviorManager<T> addBehavior(B behavior) {
        if (behavior == null) {
            throw new IllegalArgumentException("behavior must not be null");
        }
        behavior.attach(target);
        behaviors.put(behavior.getClass(), behavior);
        LOGGER.debug("Behavior {} added", behavior.getClass().getSimpleName());
        return this;
    }

    /**
     * Add the specified configurable behavior to the manager
     *
     * @param <C>      the configuration
     * @param <B>      the configurable behavior
     * @param behavior the behavior to add
     * @param config   the configurator object
     * @return the manager
     * @throws IllegalArgumentException if any parameter is null
     */
    public <C extends BehaviorConfiguration<T>, B extends Behavior<T> & ConfigurableBehavior<T, C>> BehaviorManager<T> addBehavior(B behavior, C config) {
        if (behavior == null) {
            throw new IllegalArgumentException("behavior cannot be null");
        }
        if (config == null) {
            throw new IllegalArgumentException("config cannot be null");
        }
        behavior.configure(config);
        return this.addBehavior(behavior);
    }

    /**
     * Add the specified configurable behavior to the manager
     *
     * @param <C>          the configuration
     * @param <B>          the configurable behavior
     * @param behavior     the behavior to add
     * @param config       the configurator object
     * @param configurator the configuration override
     * @return the manager
     * @throws IllegalArgumentException if any parameter is null
     */
    public <C extends BehaviorConfiguration<T>, B extends Behavior<T> & ConfigurableBehavior<T, C>> BehaviorManager<T> addBehavior(B behavior, C config, Consumer<C> configurator) {
        if (configurator == null) {
            throw new IllegalArgumentException("configurator cannot be null");
        }
        configurator.accept(config);
        return this.addBehavior(behavior, config);
    }

    /**
     * Remove the behavior of the specified type
     *
     * @param behaviorType the behavior type to remove
     * @return the manager
     * @throws IllegalArgumentException if type is null
     */
    public BehaviorManager<T> removeBehavior(Class<? extends Behavior> behaviorType) {
        if (behaviorType == null) {
            throw new IllegalArgumentException("behaviorType must not be null");
        }
        Behavior behavior = behaviors.remove(behaviorType);
        if (behavior != null) {
            if (behavior instanceof EventBasedBehavior eventBasedBehavior) {
                eventBasedBehavior.unregisterEventHandlers();
            }
            behavior.detach();
        }
        LOGGER.debug("Behavior {} removed", behaviorType.getSimpleName());
        return this;
    }

    /**
     * Get the behavior related to the type
     *
     * @param behaviorType the behavior type to find
     * @param <B>          the type of the behavior
     * @return the behavior related to the type if one exist. Null otherwise
     * @throws IllegalArgumentException if the type is null
     */
    @SuppressWarnings("unchecked")
    public <B extends Behavior<T>> B getBehavior(Class<? extends Behavior> behaviorType) {
        if (behaviorType == null) {
            throw new IllegalArgumentException("behaviorType must not be null");
        }
        return (B) behaviors.get(behaviorType);
    }

    /**
     * Clean all the behaviors
     */
    public void clearBehaviors() {
        var keys = new HashSet<>(behaviors.keySet());
        keys.forEach(this::removeBehavior);
    }
}

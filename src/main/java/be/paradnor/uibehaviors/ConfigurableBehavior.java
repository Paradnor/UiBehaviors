package be.paradnor.uibehaviors;

/**
 * Interface extension for behavior which could have configurations
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 * @param <T> the {@link BehaviorTarget} associated to this config
 * @param <C> the {@link BehaviorConfiguration} associated to this behavior
 */
public sealed interface ConfigurableBehavior<T extends BehaviorTarget<?>, C extends BehaviorConfiguration<?>> extends Behavior<T> permits ConfigurableBehaviorBase, ConfigurableEventBasedBehaviorBase {
    /**
     * Configure the behavior with the specified configuration
     * @param configuration the configuration to use
     * @throws IllegalArgumentException if the configuration is null
     */
    void configure(C configuration);

    /**
     * @return the related configuration
     */
    C getConfiguration();
}

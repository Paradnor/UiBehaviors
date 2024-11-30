package be.paradnor.uibehaviors;

/**
 * Define the configuration related to the {@link BehaviorTarget}
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 * @param <T> the target of this behavior configuration
 */
public interface BehaviorConfiguration<T extends BehaviorTarget<?>> {
    /**
     * @return the target type associated to this configuration
     */
    Class<T> getTargetType();
}

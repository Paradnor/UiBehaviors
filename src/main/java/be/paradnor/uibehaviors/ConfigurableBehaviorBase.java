package be.paradnor.uibehaviors;

/**
 * Base {@link Behavior} class for common ConfigurableBehavior methods handling
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 * @param <T> the type of the BehaviorTarget
 * @param <C> the configuration type for this configurable behavior
 */
public abstract non-sealed class ConfigurableBehaviorBase<T extends BehaviorTarget<?>, C extends BehaviorConfiguration<T>> implements ConfigurableBehavior<T, C> {
    protected T target;
    protected C configuration;
    private boolean attached = false;

    protected ConfigurableBehaviorBase() {
    }

    @Override
    public final void attach(T target) {
        if(isAttached()){
            throw new IllegalStateException("Behavior already attached");
        }
        if (configuration == null) {
            configuration = createsDefaultConfiguration();
        }
        if (!configuration.getTargetType().isInstance(target)) {
            throw new IllegalArgumentException("Invalid target type for " + getClass().getSimpleName());
        }
        this.target = target;
        this.attached = true;
    }

    @Override
    public final void detach() {
        this.target = null;
        this.attached = false;
    }

    @Override
    public final boolean isAttached() {
        return attached;
    }

    @Override
    public final void configure(C configuration) {
        this.configuration = configuration;
    }

    @Override
    public final C getConfiguration() {
        return configuration;
    }

    /**
     * @return the default configuration for this resizing behavior
     */
    protected abstract C createsDefaultConfiguration();
}

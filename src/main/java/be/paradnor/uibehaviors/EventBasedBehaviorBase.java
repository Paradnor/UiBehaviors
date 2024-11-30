package be.paradnor.uibehaviors;

/**
 * Base {@link Behavior} class for common methods handling
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 * @param <T> the type of the BehaviorTarget
 */
public abstract non-sealed class EventBasedBehaviorBase<T extends BehaviorTarget<?>> implements EventBasedBehavior<T> {
    protected T target;
    private boolean attached = false;

    protected EventBasedBehaviorBase() {
    }

    @Override
    public final void attach(T target) {
        if(attached){
            throw new IllegalStateException("Behavior already attached");
        }
        this.target = target;
        this.attached = true;
        registerEventHandlers();
    }

    @Override
    public final void detach() {
        unregisterEventHandlers();
        this.target = null;
        this.attached = false;
    }

    @Override
    public final boolean isAttached() {
        return attached;
    }
}

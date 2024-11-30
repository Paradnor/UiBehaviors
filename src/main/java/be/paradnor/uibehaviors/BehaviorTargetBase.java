package be.paradnor.uibehaviors;

import java.util.Objects;

/**
 * Base {@link BehaviorTarget} class for common method handling
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 * @param <T> the type of the wrapped Object
 */
public abstract non-sealed class BehaviorTargetBase<T> implements BehaviorTarget<T> {
    protected final T wrapped;

    protected BehaviorTargetBase(T wrapped) {
        Objects.requireNonNull(wrapped);
        this.wrapped = wrapped;
    }

    @Override
    public final T unwrap() {
        return wrapped;
    }
}

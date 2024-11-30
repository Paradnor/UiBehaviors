package be.paradnor.uibehaviors;

/**
 * Interface for any target that can have a behavior
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 * @param <T> the target which handle the new behavior
 */
public sealed interface BehaviorTarget<T> permits BehaviorTargetBase {
    /**
     * @return the width of the target
     */
    double getWidth();

    /**
     * @return the height of the target
     */
    double getHeight();

    /**
     * @return the x of the target
     */
    double getX();

    /**
     * @return the y of the target
     */
    double getY();

    /**
     * @param width the width to set to the target
     */
    void setWidth(double width);

    /**
     * @param height the height to set to the target
     */
    void setHeight(double height);

    /**
     * @param x the x to set to the target
     */
    void setX(double x);

    /**
     * @param y the y to set to the target
     */
    void setY(double y);

    /**
     * @return if the target is visible
     */
    boolean isVisible();

    /**
     * @param visible to set to the target
     */
    void setVisible(boolean visible);

    /**
     * Request the focus on the target
     */
    void requestFocus();

    /**
     * @return the adapted target
     */
    T unwrap();
}

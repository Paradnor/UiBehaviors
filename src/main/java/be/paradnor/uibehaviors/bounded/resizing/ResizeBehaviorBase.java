package be.paradnor.uibehaviors.bounded.resizing;

import be.paradnor.uibehaviors.*;
import be.paradnor.uibehaviors.bounded.Side;

/**
 * Basic common implementation for ResizeBehavior
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 * @param <T> the BehaviorTarget
 * @param <C> the BehaviorConfiguration
 */
public abstract class ResizeBehaviorBase<T extends BehaviorTarget<?>, C extends ResizeConfigurationBase<T>>
    extends ConfigurableEventBasedBehaviorBase<T, C>{

    protected double startX;
    protected double startY;
    protected double startWidth;
    protected double startHeight;
    protected boolean resizing = false;
    protected Side currentSide = Side.ALL;

    /**
     * Update the size of the target
     * @param deltaX the deltaX to apply
     * @param deltaY the deltaY to apply
     */
    protected abstract void updateSize(double deltaX, double deltaY);

    /**
     * @param x the x position of the mouse
     * @param y the y position of the mouse
     * @return true if the x,y coordinate are near the target edge
     */
    protected abstract boolean isNearEdge(double x, double y);

    /**
     * Update the cursor related to the x,y coordinates
     * @param x the x position of the mouse
     * @param y the y position of the mouse
     */
    protected abstract void updateCursor(double x, double y);

    /**
     * @return the default configuration for this resizing behavior
     */
    protected abstract C createDefaultConfig();
}

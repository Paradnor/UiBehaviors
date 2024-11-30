package be.paradnor.uibehaviors.bounded.dragging;

import be.paradnor.uibehaviors.*;

/**
 * Basic common implementation for DragBehavior
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 * @param <T> the BehaviorTarget
 * @param <C> the BehaviorConfiguration
 */
public abstract class DragBehaviorBase<T extends BehaviorTarget<?>, C extends DragConfigurationBase<T>>
    extends ConfigurableEventBasedBehaviorBase<T, C>{

    protected double startX;
    protected double startY;
    protected double startMouseX;
    protected double startMouseY;
    protected boolean dragging = false;

    protected DragBehaviorBase() {
    }

    //TODO add dragging behavior
}

package be.paradnor.uibehaviors.bounded.dragging;

import be.paradnor.uibehaviors.BehaviorConfiguration;
import be.paradnor.uibehaviors.BehaviorTarget;

/**
 * Base class for Dragging Configuration
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 * @param <T> the target of the dragging
 */
public abstract class DragConfigurationBase<T extends BehaviorTarget<?>> implements BehaviorConfiguration<T> {
    private boolean constrainToParent = false;
    private BehaviorTarget dragHandle = null;
    private double gridSize = 0.0;

    protected DragConfigurationBase() {
    }

    /**
     * @return if the dragged element should be constrained by its parent
     */
    public final boolean isConstrainToParent() {
        return constrainToParent;
    }

    /**
     * Set of the dragged element should be constrained by its parent
     * @param constrainToParent if the dragged element should be constraint by its parent
     */
    public final void setConstrainToParent(boolean constrainToParent) {
        this.constrainToParent = constrainToParent;
    }

    /**
     * @return the element which handle the dragging event for the dragging target behavior
     */
    public final BehaviorTarget getDragHandle() {
        return dragHandle;
    }

    /**
     * Set the source of the dragging behavior
     * @param dragHandle the source of the dragging behavior
     */
    public final void setDragHandle(BehaviorTarget dragHandle) {
        this.dragHandle = dragHandle;
    }

    /**
     * @return the grid size if the drag event should snap a grid, else return 0
     */
    public final double getGridSize() {
        return gridSize;
    }

    /**
     * Set the grid size if the event should snap the grid.
     * If set to 0, no snap will happen
     * @param gridSize the size of the grid.
     * @throws IllegalArgumentException if the grid size is negative
     */
    public final void setGridSize(double gridSize) {
        if(gridSize < 0){
            throw new IllegalArgumentException("Grid size must be a positive number or 0");
        }
        this.gridSize = gridSize;
    }
}

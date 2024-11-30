package be.paradnor.uibehaviors.window;

import be.paradnor.uibehaviors.*;

/**
 * Basic common implementation for DragBehavior
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 * @param <T> the BehaviorTarget
 * @param <K> a Key class to handle event from Keyboard
 * @param <C> the BehaviorConfiguration
 */
public abstract class WindowStateBehaviorBase<T extends BehaviorTarget<?>, K, C extends WindowStateConfigurationBase<T, K>>
    extends ConfigurableEventBasedBehaviorBase<T,C> {

    protected double restoreX;
    protected double restoreY;
    protected double restoreWidth;
    protected double restoreHeight;
    protected boolean minimized = false;
    protected boolean maximized = false;

    //TODO add behavior
}

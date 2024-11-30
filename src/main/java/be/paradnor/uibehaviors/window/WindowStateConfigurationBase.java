package be.paradnor.uibehaviors.window;

import be.paradnor.uibehaviors.BehaviorConfiguration;
import be.paradnor.uibehaviors.BehaviorTarget;

/**
 * Base class for Window State Configuration
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 * @param <T> the target of the window state
 * @param <K> a Key class to handle event from Keyboard
 */
public abstract class WindowStateConfigurationBase<T extends BehaviorTarget<?>, K> implements BehaviorConfiguration<T> {
    private BehaviorTarget titleHandle = null;
    private boolean enableDoubleClickMaximize = true;
    private K minimizeKey = getDefaultMinimizeKey();
    private K maximizeKey = getDefaultMaximizeKey();
    private K restoreKey = getDefaultRestoreKey();

    protected WindowStateConfigurationBase() {
    }

    /**
     * @return if the window stage element should be maximized by double click
     */
    public final boolean isEnableDoubleClickMaximize() {
        return enableDoubleClickMaximize;
    }

    /**
     * Set if the window state element should be maximized by double click
     * @param enableDoubleClickMaximize if the window stage element should be maximized by double click
     */
    public final void setEnableDoubleClickMaximize(boolean enableDoubleClickMaximize) {
        this.enableDoubleClickMaximize = enableDoubleClickMaximize;
    }

    /**
     * @return the element which handle the window state event for the window state target behavior
     */
    public final BehaviorTarget getTitleHandle() {
        return titleHandle;
    }

    /**
     * Set the source of the window state behavior
     * @param titleHandle the source of the window state behavior
     */
    public final void setTitleHandle(BehaviorTarget titleHandle) {
        this.titleHandle = titleHandle;
    }

    /**
     * @return the minimize key
     */
    public final K getMinimizeKey() {
        return minimizeKey;
    }

    /**
     * Set the minimize key
     * @param minimizeKey the minimize key to set
     */
    public final void setMinimizeKey(K minimizeKey) {
        this.minimizeKey = minimizeKey;
    }

    /**
     * @return the maximize key
     */
    public final K getMaximizeKey() {
        return maximizeKey;
    }

    /**
     * Set the maximize key
     * @param maximizeKey the maximizeKey to set
     */
    public final void setMaximizeKey(K maximizeKey) {
        this.maximizeKey = maximizeKey;
    }

    /**
     * @return the restore key
     */
    public final  K getRestoreKey() {
        return restoreKey;
    }

    /**
     * Set the restore key
     * @param restoreKey the restore key to set
     */
    public final void setRestoreKey(K restoreKey) {
        this.restoreKey = restoreKey;
    }

    /**
     * @return the default minimize key
     */
    protected abstract K getDefaultMinimizeKey();

    /**
     * @return the default maximize key
     */
    protected abstract K getDefaultMaximizeKey();

    /**
     * @return the default restore key
     */
    protected abstract K getDefaultRestoreKey();
}

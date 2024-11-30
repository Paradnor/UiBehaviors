package be.paradnor.uibehaviors.window;

/**
 * The States a Window could have
 * @author Paradnor <paradnor@gmail.com>
 * @version 1.0.0
 * @since 1.0.0
 */
public enum WindowState {
    /**
     * State which is not Maximized or Minimized
     */
    NORMAL,
    /**
     * State where the window takes its maximum size related to the screen and taskbar
     */
    MAXIMIZED,
    /**
     * State where the window is not on the screen but present on the taskbar
     */
    MINIMIZED,
    /**
     * State where the window take all the screen
     */
    FULL_SCREEN;
}

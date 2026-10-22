package org.telegram.ui.Components;

public enum IconBackgroundColors {
    BLUE(0xFF1E1E1E, 0xFF141414),
    BLUE_ALT(0xFF1E1E1E, 0xFF141414),
    BLUE_DEEP(0xFF1E1E1E, 0xFF141414),
    BLUE_LIGHT(0xFF1E1E1E, 0xFF141414),

    ORANGE(0xFF1E1E1E, 0xFF141414),
    ORANGE_DEEP(0xFF1E1E1E, 0xFF141414),

    GREEN(0xFF1E1E1E, 0xFF141414),
    RED(0xFFD71920, 0xFFB7141A),
    CYAN(0xFF1E1E1E, 0xFF141414),
    PURPLE(0xFF1E1E1E, 0xFF141414),
    GRAY(0xFF1E1E1E, 0xFF141414);

    public final int top;
    public final int bottom;

    private IconBackgroundColors(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
    }
}

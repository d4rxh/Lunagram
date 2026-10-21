package org.telegram.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

import org.telegram.messenger.ApplicationLoader;
import org.telegram.messenger.FileLog;
import org.telegram.messenger.R;

public class LauncherIconController {
    private static final String[] OLD_NEKO_ICONS = {
        "MerioIcon", "RainbowIcon", "OldSchoolIcon", "MusheenIcon", "SpaceIcon", "CloudIcon", "NeonIcon", "MaterialIcon"
    };

    public static void tryFixLauncherIconIfNeeded() {
        try {
            Context ctx = ApplicationLoader.applicationContext;
            PackageManager pm = ctx.getPackageManager();
            for (String oldName : OLD_NEKO_ICONS) {
                try {
                    pm.setComponentEnabledSetting(new ComponentName(ctx.getPackageName(), "org.telegram.messenger." + oldName), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
                } catch (Throwable ignore) {
                }
            }

            for (LauncherIcon icon : LauncherIcon.values()) {
                if (isEnabled(icon)) {
                    return;
                }
            }

            setIcon(LauncherIcon.DEFAULT);
        } catch (Throwable t) {
            FileLog.e(t);
        }
    }

    public static boolean isEnabled(LauncherIcon icon) {
        try {
            Context ctx = ApplicationLoader.applicationContext;
            int i = ctx.getPackageManager().getComponentEnabledSetting(icon.getComponentName(ctx));
            return i == PackageManager.COMPONENT_ENABLED_STATE_ENABLED || i == PackageManager.COMPONENT_ENABLED_STATE_DEFAULT && icon == LauncherIcon.DEFAULT;
        } catch (Throwable t) {
            return false;
        }
    }

    public static void setIcon(LauncherIcon icon) {
        try {
            Context ctx = ApplicationLoader.applicationContext;
            PackageManager pm = ctx.getPackageManager();
            for (String oldName : OLD_NEKO_ICONS) {
                try {
                    pm.setComponentEnabledSetting(new ComponentName(ctx.getPackageName(), "org.telegram.messenger." + oldName), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
                } catch (Throwable ignore) {
                }
            }
            for (LauncherIcon i : LauncherIcon.values()) {
                try {
                    pm.setComponentEnabledSetting(i.getComponentName(ctx), i == icon ? PackageManager.COMPONENT_ENABLED_STATE_ENABLED :
                            PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
                } catch (Throwable ignore) {
                }
            }
        } catch (Throwable t) {
            FileLog.e(t);
        }
    }

    public enum LauncherIcon {
        DEFAULT("DefaultIcon", R.color.ic_launcher_background, R.drawable.ic_launcher_foreground, R.string.AppIconDefault),
        AQUA("AquaIcon", R.drawable.icon_4_background_sa, R.drawable.ic_launcher_foreground, R.string.AppIconAqua),
        PREMIUM("PremiumIcon", R.drawable.icon_3_background_sa, R.drawable.ic_launcher_foreground, R.string.AppIconPremium),
        TURBO("TurboIcon", R.drawable.icon_5_background_sa, R.drawable.ic_launcher_foreground, R.string.AppIconTurbo),
        NOX("NoxIcon", R.drawable.icon_2_background_sa, R.drawable.ic_launcher_foreground, R.string.AppIconNox);

        public final String key;
        public final int background;
        public final int foreground;
        public final int title;
        public final boolean premium;

        private ComponentName componentName;

        public ComponentName getComponentName(Context ctx) {
            if (componentName == null) {
                componentName = new ComponentName(ctx.getPackageName(), "org.telegram.messenger." + key);
            }
            return componentName;
        }

        LauncherIcon(String key, int background, int foreground, int title) {
            this(key, background, foreground, title, false);
        }

        LauncherIcon(String key, int background, int foreground, int title, boolean premium) {
            this.key = key;
            this.background = background;
            this.foreground = foreground;
            this.title = title;
            this.premium = premium;
        }
    }
}

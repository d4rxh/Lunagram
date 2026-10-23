package tw.nekomimi.nekogram.helpers;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.view.HapticFeedbackConstants;
import android.view.View;

import org.telegram.messenger.ApplicationLoader;
import org.telegram.messenger.FileLog;

import tw.nekomimi.nekogram.NekoConfig;

public class NothingHapticHelper {

    private static Vibrator getVibrator() {
        try {
            Context context = ApplicationLoader.applicationContext;
            if (context == null) return null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                VibratorManager manager = (VibratorManager) context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE);
                if (manager != null) {
                    return manager.getDefaultVibrator();
                }
            }
            return (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        } catch (Throwable t) {
            return null;
        }
    }

    public static void vibrateTick(View view) {
        if (!NekoConfig.nothingHaptics) return;
        try {
            Vibrator vibrator = getVibrator();
            if (vibrator != null && vibrator.hasVibrator()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    vibrator.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_TICK));
                    return;
                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(12, 100));
                    return;
                }
            }
            if (view != null) {
                view.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK, HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING);
            }
        } catch (Throwable t) {
            FileLog.e(t);
        }
    }

    public static void vibratePop(View view) {
        if (!NekoConfig.nothingHaptics) return;
        try {
            Vibrator vibrator = getVibrator();
            if (vibrator != null && vibrator.hasVibrator()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    vibrator.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK));
                    return;
                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(22, 220));
                    return;
                }
            }
            if (view != null) {
                view.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP, HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING);
            }
        } catch (Throwable t) {
            FileLog.e(t);
        }
    }

    public static void vibrateThump(View view) {
        if (!NekoConfig.nothingHaptics) return;
        try {
            Vibrator vibrator = getVibrator();
            if (vibrator != null && vibrator.hasVibrator()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    vibrator.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_HEAVY_CLICK));
                    return;
                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(38, 255));
                    return;
                }
            }
            if (view != null) {
                view.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING);
            }
        } catch (Throwable t) {
            FileLog.e(t);
        }
    }

    public static void testHaptics() {
        new Thread(() -> {
            try {
                vibrateTick(null);
                Thread.sleep(150);
                vibratePop(null);
                Thread.sleep(180);
                vibrateThump(null);
            } catch (Throwable ignored) {}
        }).start();
    }
}

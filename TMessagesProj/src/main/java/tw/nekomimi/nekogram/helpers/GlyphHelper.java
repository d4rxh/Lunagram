package tw.nekomimi.nekogram.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;

import com.nothing.ketchum.Common;
import com.nothing.ketchum.Glyph;
import com.nothing.ketchum.GlyphFrame;
import com.nothing.ketchum.GlyphManager;

import org.telegram.messenger.ApplicationLoader;
import org.telegram.messenger.FileLog;
import org.telegram.messenger.MessageObject;

import tw.nekomimi.nekogram.NekoConfig;

public class GlyphHelper {

    private static GlyphHelper instance;

    private GlyphManager glyphManager;
    private boolean isSessionOpen = false;
    private boolean isInitialized = false;
    private final boolean isNothingDevice;

    private HandlerThread torchThread;
    private Handler torchHandler;
    private boolean isCallRinging = false;
    private Runnable callAnimationRunnable;

    private GlyphHelper() {
        boolean nothingCheck = false;
        try {
            nothingCheck = "Nothing".equalsIgnoreCase(Build.MANUFACTURER) ||
                    "Nothing".equalsIgnoreCase(Build.BRAND) ||
                    Common.is20111() || Common.is22111() || Common.is23111() ||
                    Common.is23113() || Common.is24111() || Common.is25111() ||
                    Common.is25131();
        } catch (Throwable t) {
            FileLog.e(t);
        }
        isNothingDevice = nothingCheck;
        initSdk();
    }

    public static synchronized GlyphHelper getInstance() {
        if (instance == null) {
            instance = new GlyphHelper();
        }
        return instance;
    }

    public boolean isNothingDevice() {
        return isNothingDevice;
    }

    private void initSdk() {
        if (!isNothingDevice || isInitialized) {
            return;
        }
        try {
            Context context = ApplicationLoader.applicationContext;
            if (context == null) {
                return;
            }
            glyphManager = GlyphManager.getInstance(context);
            if (glyphManager != null) {
                glyphManager.init(new GlyphManager.Callback() {
                    @Override
                    public void onServiceConnected(ComponentName componentName) {
                        try {
                            if (Common.is20111()) {
                                glyphManager.register(Glyph.DEVICE_20111);
                            } else if (Common.is22111()) {
                                glyphManager.register(Glyph.DEVICE_22111);
                            } else if (Common.is23111()) {
                                glyphManager.register(Glyph.DEVICE_23111);
                            } else if (Common.is23113()) {
                                glyphManager.register(Glyph.DEVICE_23113);
                            } else if (Common.is24111()) {
                                glyphManager.register(Glyph.DEVICE_24111);
                            } else if (Common.is25111()) {
                                glyphManager.register(Glyph.DEVICE_25111);
                            } else if (Common.is25131()) {
                                glyphManager.register(Glyph.DEVICE_25131);
                            } else {
                                glyphManager.register();
                            }
                            glyphManager.openSession();
                            isSessionOpen = true;
                            FileLog.d("GlyphHelper: Session connected and opened successfully");
                        } catch (Throwable e) {
                            FileLog.e("GlyphHelper openSession error", e);
                        }
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName componentName) {
                        isSessionOpen = false;
                        FileLog.d("GlyphHelper: Session disconnected");
                    }
                });
                isInitialized = true;
            }
        } catch (Throwable t) {
            FileLog.e("GlyphHelper init error", t);
        }
    }

    public void onMessageNotification(MessageObject messageObject) {
        if (!NekoConfig.glyphEnabled || !NekoConfig.glyphIncomingMessages) {
            return;
        }
        triggerPulsePattern(2, 120, 70);
    }

    public void triggerPulsePattern(int pulses, int periodMs, int intervalMs) {
        if (!NekoConfig.glyphEnabled) {
            return;
        }

        if (isNothingDevice && glyphManager != null && isSessionOpen) {
            try {
                GlyphFrame.Builder builder = glyphManager.getGlyphFrameBuilder();
                if (builder != null) {
                    builder.buildChannelA();
                    builder.buildChannelB();
                    builder.buildPeriod(periodMs);
                    builder.buildCycles(pulses);
                    builder.buildInterval(intervalMs);
                    GlyphFrame frame = builder.build();
                    glyphManager.animate(frame);
                    return;
                }
            } catch (Throwable t) {
                FileLog.e(t);
            }
        }

        if (NekoConfig.glyphTorchFallback || !isNothingDevice) {
            triggerTorchStrobe(pulses, periodMs, intervalMs);
        }
    }

    public void startCallGlyph() {
        if (!NekoConfig.glyphEnabled || !NekoConfig.glyphCalls) {
            return;
        }
        isCallRinging = true;

        if (callAnimationRunnable != null) {
            return;
        }

        ensureTorchThread();
        callAnimationRunnable = new Runnable() {
            @Override
            public void run() {
                if (!isCallRinging) {
                    return;
                }
                if (isNothingDevice && glyphManager != null && isSessionOpen) {
                    try {
                        GlyphFrame.Builder builder = glyphManager.getGlyphFrameBuilder();
                        if (builder != null) {
                            builder.buildChannelA();
                            builder.buildChannelB();
                            builder.buildPeriod(450);
                            builder.buildCycles(1);
                            builder.buildInterval(100);
                            GlyphFrame frame = builder.build();
                            glyphManager.animate(frame);
                        }
                    } catch (Throwable t) {
                        FileLog.e(t);
                    }
                } else if (NekoConfig.glyphTorchFallback || !isNothingDevice) {
                    triggerTorchStrobe(1, 300, 150);
                }

                if (isCallRinging && torchHandler != null) {
                    torchHandler.postDelayed(this, 1000);
                }
            }
        };

        if (torchHandler != null) {
            torchHandler.post(callAnimationRunnable);
        }
    }

    public void stopCallGlyph() {
        isCallRinging = false;
        if (callAnimationRunnable != null && torchHandler != null) {
            torchHandler.removeCallbacks(callAnimationRunnable);
            callAnimationRunnable = null;
        }
        turnOff();
    }

    public void turnOff() {
        if (isNothingDevice && glyphManager != null && isSessionOpen) {
            try {
                glyphManager.turnOff();
            } catch (Throwable t) {
                FileLog.e(t);
            }
        }
        turnOffTorch();
    }

    public void testGlyph() {
        triggerPulsePattern(3, 180, 90);
    }

    private void ensureTorchThread() {
        if (torchThread == null) {
            torchThread = new HandlerThread("GlyphTorchThread");
            torchThread.start();
            torchHandler = new Handler(torchThread.getLooper());
        }
    }

    private void triggerTorchStrobe(final int count, final int onMs, final int offMs) {
        if (!NekoConfig.glyphTorchFallback) {
            return;
        }
        ensureTorchThread();
        torchHandler.post(() -> {
            try {
                Context context = ApplicationLoader.applicationContext;
                if (context == null) return;
                CameraManager cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
                if (cameraManager == null) return;
                String[] cameraIds = cameraManager.getCameraIdList();
                String flashId = null;
                for (String id : cameraIds) {
                    CameraCharacteristics characteristics = cameraManager.getCameraCharacteristics(id);
                    Boolean hasFlash = characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
                    Integer facing = characteristics.get(CameraCharacteristics.LENS_FACING);
                    if (hasFlash != null && hasFlash && facing != null && facing == CameraCharacteristics.LENS_FACING_BACK) {
                        flashId = id;
                        break;
                    }
                }
                if (flashId == null && cameraIds.length > 0) {
                    flashId = cameraIds[0];
                }
                if (flashId == null) return;

                for (int i = 0; i < count; i++) {
                    cameraManager.setTorchMode(flashId, true);
                    Thread.sleep(Math.max(20, onMs));
                    cameraManager.setTorchMode(flashId, false);
                    if (i < count - 1) {
                        Thread.sleep(Math.max(20, offMs));
                    }
                }
            } catch (Throwable t) {
                FileLog.e(t);
            }
        });
    }

    private void turnOffTorch() {
        if (torchHandler != null) {
            torchHandler.post(() -> {
                try {
                    Context context = ApplicationLoader.applicationContext;
                    if (context == null) return;
                    CameraManager cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
                    if (cameraManager == null) return;
                    for (String id : cameraManager.getCameraIdList()) {
                        try {
                            cameraManager.setTorchMode(id, false);
                        } catch (Throwable ignored) {}
                    }
                } catch (Throwable t) {
                    FileLog.e(t);
                }
            });
        }
    }
}

package tw.nekomimi.nekogram.settings;

import android.view.View;

import org.telegram.messenger.LocaleController;
import org.telegram.messenger.R;
import org.telegram.ui.Cells.TextCheckCell;
import org.telegram.ui.Components.BulletinFactory;
import org.telegram.ui.Components.UItem;
import org.telegram.ui.Components.UniversalAdapter;

import java.util.ArrayList;

import tw.nekomimi.nekogram.NekoConfig;
import tw.nekomimi.nekogram.helpers.GlyphHelper;

public class NekoGlyphSettingsActivity extends BaseNekoSettingsActivity {

    private final int enableRow = rowId++;
    private final int incomingMessagesRow = rowId++;
    private final int callsRow = rowId++;
    private final int torchFallbackRow = rowId++;
    private final int testRow = rowId++;

    @Override
    protected String getActionBarTitle() {
        return LocaleController.getString(R.string.GlyphSettings);
    }

    @Override
    protected void fillItems(ArrayList<UItem> items, UniversalAdapter adapter) {
        items.add(UItem.asHeader(LocaleController.getString(R.string.GlyphGeneralHeader)));
        items.add(UItem.asCheck(enableRow, LocaleController.getString(R.string.GlyphEnable), LocaleController.getString(R.string.GlyphEnableDesc)).setChecked(NekoConfig.glyphEnabled).slug("glyphEnabled"));
        items.add(UItem.asCheck(incomingMessagesRow, LocaleController.getString(R.string.GlyphIncomingMessages), LocaleController.getString(R.string.GlyphIncomingMessagesDesc)).setChecked(NekoConfig.glyphIncomingMessages).slug("glyphIncomingMessages"));
        items.add(UItem.asCheck(callsRow, LocaleController.getString(R.string.GlyphCalls), LocaleController.getString(R.string.GlyphCallsDesc)).setChecked(NekoConfig.glyphCalls).slug("glyphCalls"));
        items.add(UItem.asCheck(torchFallbackRow, LocaleController.getString(R.string.GlyphTorchFallback), LocaleController.getString(R.string.GlyphTorchFallbackDesc)).setChecked(NekoConfig.glyphTorchFallback).slug("glyphTorchFallback"));
        items.add(UItem.asShadow(null));

        items.add(UItem.asButton(testRow, LocaleController.getString(R.string.GlyphTestPattern), LocaleController.getString(R.string.GlyphTestPatternDesc)).slug("glyphTest"));
        items.add(UItem.asShadow(null));
    }

    @Override
    protected void onItemClick(UItem item, View view, int position, float x, float y) {
        if (item.id == enableRow) {
            NekoConfig.toggleGlyphEnabled();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(NekoConfig.glyphEnabled);
            }
        } else if (item.id == incomingMessagesRow) {
            NekoConfig.toggleGlyphIncomingMessages();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(NekoConfig.glyphIncomingMessages);
            }
        } else if (item.id == callsRow) {
            NekoConfig.toggleGlyphCalls();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(NekoConfig.glyphCalls);
            }
        } else if (item.id == torchFallbackRow) {
            NekoConfig.toggleGlyphTorchFallback();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(NekoConfig.glyphTorchFallback);
            }
        } else if (item.id == testRow) {
            GlyphHelper.getInstance().testGlyph();
            try {
                BulletinFactory.of(this).createSimpleBulletin(R.raw.chats_infotip, "Testing Glyph Lighting...").show();
            } catch (Throwable ignored) {}
        }
    }
}

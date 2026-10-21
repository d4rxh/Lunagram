package tw.nekomimi.nekogram.settings;

import android.view.View;

import org.telegram.messenger.LocaleController;
import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.ActionBar;
import org.telegram.ui.Cells.TextCheckCell;
import org.telegram.ui.Components.UItem;
import org.telegram.ui.Components.UniversalAdapter;

import java.util.ArrayList;

import tw.nekomimi.nekogram.NekoConfig;

public class LunaStealthSettingsActivity extends BaseNekoSettingsActivity {

    private final int ghostReadRow = rowId++;
    private final int ghostTypingRow = rowId++;
    private final int ghostStoriesRow = rowId++;
    private final int ghostOnlineRow = rowId++;

    private final int antiDeleteRow = rowId++;
    private final int saveEditHistoryRow = rowId++;

    private final int unlockPremiumRow = rowId++;
    private final int noSponsoredAdsRow = rowId++;

    @Override
    public boolean onFragmentCreate() {
        return super.onFragmentCreate();
    }

    @Override
    protected String getActionBarTitle() {
        return LocaleController.getString(R.string.LunaStealthSettings);
    }

    @Override
    protected void fillItems(ArrayList<UItem> items, UniversalAdapter adapter) {
        items.add(UItem.asHeader(LocaleController.getString(R.string.GhostModeHeader)));
        items.add(UItem.asCheck(ghostReadRow, LocaleController.getString(R.string.GhostRead), LocaleController.getString(R.string.GhostReadDesc)).setChecked(NekoConfig.ghostRead).slug("ghostRead"));
        items.add(UItem.asCheck(ghostTypingRow, LocaleController.getString(R.string.GhostTyping), LocaleController.getString(R.string.GhostTypingDesc)).setChecked(NekoConfig.ghostTyping).slug("ghostTyping"));
        items.add(UItem.asCheck(ghostStoriesRow, LocaleController.getString(R.string.GhostStories), LocaleController.getString(R.string.GhostStoriesDesc)).setChecked(NekoConfig.ghostStories).slug("ghostStories"));
        items.add(UItem.asCheck(ghostOnlineRow, LocaleController.getString(R.string.GhostOnline), LocaleController.getString(R.string.GhostOnlineDesc)).setChecked(NekoConfig.ghostOnline).slug("ghostOnline"));
        items.add(UItem.asShadow(null));

        items.add(UItem.asHeader(LocaleController.getString(R.string.AntiDeleteHeader)));
        items.add(UItem.asCheck(antiDeleteRow, LocaleController.getString(R.string.AntiDeleteMessages), LocaleController.getString(R.string.AntiDeleteMessagesDesc)).setChecked(NekoConfig.antiDelete).slug("antiDelete"));
        items.add(UItem.asCheck(saveEditHistoryRow, LocaleController.getString(R.string.SaveEditHistory), LocaleController.getString(R.string.SaveEditHistoryDesc)).setChecked(NekoConfig.saveEditHistory).slug("saveEditHistory"));
        items.add(UItem.asShadow(null));

        items.add(UItem.asHeader(LocaleController.getString(R.string.PremiumPerksHeader)));
        items.add(UItem.asCheck(unlockPremiumRow, LocaleController.getString(R.string.UnlockPremiumPerks), LocaleController.getString(R.string.UnlockPremiumPerksDesc)).setChecked(NekoConfig.unlockPremiumFeatures).slug("unlockPremium"));
        items.add(UItem.asCheck(noSponsoredAdsRow, LocaleController.getString(R.string.NoSponsoredAds), LocaleController.getString(R.string.NoSponsoredAdsDesc)).setChecked(NekoConfig.noSponsoredAds).slug("noSponsoredAds"));
        items.add(UItem.asShadow(null));
    }

    @Override
    protected void onItemClick(UItem item, View view, int position, float x, float y) {
        int id = item.id;
        if (id == ghostReadRow) {
            NekoConfig.toggleGhostRead();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(NekoConfig.ghostRead);
            }
        } else if (id == ghostTypingRow) {
            NekoConfig.toggleGhostTyping();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(NekoConfig.ghostTyping);
            }
        } else if (id == ghostStoriesRow) {
            NekoConfig.toggleGhostStories();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(NekoConfig.ghostStories);
            }
        } else if (id == ghostOnlineRow) {
            NekoConfig.toggleGhostOnline();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(NekoConfig.ghostOnline);
            }
        } else if (id == antiDeleteRow) {
            NekoConfig.toggleAntiDelete();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(NekoConfig.antiDelete);
            }
        } else if (id == saveEditHistoryRow) {
            NekoConfig.toggleSaveEditHistory();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(NekoConfig.saveEditHistory);
            }
        } else if (id == unlockPremiumRow) {
            NekoConfig.toggleUnlockPremiumFeatures();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(NekoConfig.unlockPremiumFeatures);
            }
        } else if (id == noSponsoredAdsRow) {
            NekoConfig.toggleNoSponsoredAds();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(NekoConfig.noSponsoredAds);
            }
        }
    }
}

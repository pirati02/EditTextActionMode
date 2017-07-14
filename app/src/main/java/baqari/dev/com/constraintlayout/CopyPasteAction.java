package baqari.dev.com.constraintlayout;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class CopyPasteAction implements ActionMode.Callback {
    private ActionResultListener actionResultListener;
    private AppCompatEditText target;
    private ClipboardManager clipboardManager;

    public CopyPasteAction(View view) {
        target = (AppCompatEditText) view;
        clipboardManager = (ClipboardManager) view.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
    }

    public void setResultListener(ActionResultListener result) {
        this.actionResultListener = result;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        menu.clear();
        mode.getMenuInflater().inflate(R.menu.text_action_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        CharSequence text = target.getText();

        int id = item.getItemId();
        if (id == R.id.menu_item_copy) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("copied", text));
            if (actionResultListener != null)
                actionResultListener.onResult(true, ActionType.COPY, text.toString());
            onDestroyActionMode(mode);
        } else if (id == R.id.menu_item_cut) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("copied", text));
            target.setText(null);
            if (actionResultListener != null)
                actionResultListener.onResult(true, ActionType.CUT, text.toString());
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }

    public interface ActionResultListener {
        void onResult(boolean success, ActionType type, String text);
    }

    public enum ActionType {
        COPY, CUT
    }
}
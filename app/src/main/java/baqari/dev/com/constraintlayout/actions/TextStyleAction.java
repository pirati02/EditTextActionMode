package baqari.dev.com.constraintlayout.actions;

import android.support.v7.widget.AppCompatEditText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import baqari.dev.com.constraintlayout.R;

public class TextStyleAction extends BaseAction {

    private ActionResultListener actionResultListener;

    public TextStyleAction(View view) {
        target = (AppCompatEditText) view;
    }

    public void setResultListener(ActionResultListener result) {
        this.actionResultListener = result;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        menu.clear();
        mode.getMenuInflater().inflate(R.menu.text_style_action_menu, menu);
        mode.setTitle(null);
        mode.setTitleOptionalHint(false);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        CharSequence text = target.getText();
        SpannableString contentSpan = new SpannableString(text);
        int selectionStart = target.getSelectionStart();
        int selectionEnd = target.getSelectionEnd();

        int id = item.getItemId();
        if (id == R.id.menu_item_bold) {
            if (actionResultListener != null)
                actionResultListener.onResult(true, ActionType.BOLD, text.toString());
            contentSpan.setSpan(new TextAppearanceSpan(target.getContext(), R.style.bold_style), selectionStart, selectionEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            target.setText(contentSpan, TextView.BufferType.SPANNABLE);
        } else if (id == R.id.menu_item_italic) {
            if (actionResultListener != null)
                actionResultListener.onResult(true, ActionType.ITALIC, text.toString());
            contentSpan.setSpan(new TextAppearanceSpan(target.getContext(), R.style.italic_style), selectionStart, selectionEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            target.setText(contentSpan, TextView.BufferType.SPANNABLE);
        } else if (id == R.id.menu_item_normal) {
            target.setText(null);
            if (actionResultListener != null)
                actionResultListener.onResult(true, ActionType.NORMAL, text.toString());
            contentSpan.setSpan(new TextAppearanceSpan(target.getContext(), R.style.normal_style), selectionStart, selectionEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            target.setText(contentSpan, TextView.BufferType.SPANNABLE);
       } /*else if (id == R.id.menu_item_underlined) {
             if (actionResultListener != null)
                 actionResultListener.onResult(true, ActionType.ITALIC, text.toString());
             if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT)
                 target.setText(Html.fromHtml("<u>" + text + "</u>"));
             else
                 target.setText(Html.fromHtml("<u>" + text + "</u>", FROM_HTML_MODE_LEGACY));
         }*/
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }

    public enum ActionType implements BaseType {
        BOLD, ITALIC, UNDERLINE, NORMAL
    }
}
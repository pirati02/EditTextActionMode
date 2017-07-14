package baqari.dev.com.constraintlayout.actions;


import android.content.ClipboardManager;
import android.support.v7.widget.AppCompatEditText;
import android.view.ActionMode;

public abstract class BaseAction implements ActionMode.Callback  {
    protected AppCompatEditText target;
    protected ClipboardManager clipboardManager;

    public interface BaseType {

    }

    public interface ActionResultListener {
        void onResult(boolean success, BaseType type, String text);
    }
}

package baqari.dev.com.constraintlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {

    AppCompatEditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (AppCompatEditText) findViewById(R.id.edit_text);

        CopyPasteAction action = new CopyPasteAction(editText);
        editText.setCustomSelectionActionModeCallback(action);
        action.setResultListener(new CopyPasteAction.ActionResultListener() {
            @Override
            public void onResult(boolean success, CopyPasteAction.ActionType type, String text) {
                CopyPasteAction.ActionType actionType = type;
                String copied = text;
            }
        });
    }
}
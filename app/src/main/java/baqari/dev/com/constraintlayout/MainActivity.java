package baqari.dev.com.constraintlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;

import baqari.dev.com.constraintlayout.actions.BaseAction;
import baqari.dev.com.constraintlayout.actions.CopyPasteAction;
import baqari.dev.com.constraintlayout.actions.TextStyleAction;

public class MainActivity extends Activity {

    AppCompatEditText editText, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (AppCompatEditText) findViewById(R.id.edit_text);
        editText2 = (AppCompatEditText) findViewById(R.id.edit_text2);

        CopyPasteAction action = new CopyPasteAction(editText);
        editText.setCustomSelectionActionModeCallback(action);
        action.setResultListener(new CopyPasteAction.ActionResultListener() {
            @Override
            public void onResult(boolean success, CopyPasteAction.BaseType type, String text) {
                CopyPasteAction.ActionType actionType = (CopyPasteAction.ActionType) type;
                String copied = text;
            }
        });

        TextStyleAction action1 = new TextStyleAction(editText2);
        editText2.setCustomSelectionActionModeCallback(action1);
        action1.setResultListener(new TextStyleAction.ActionResultListener() {
            @Override
            public void onResult(boolean success, BaseAction.BaseType type, String text) {
                TextStyleAction.ActionType actionType = (TextStyleAction.ActionType) type;
            }
        });
    }
}
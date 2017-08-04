# EditTextActionMode

>  editText = (AppCompatEditText) findViewById(R.id.edit_text);

        CopyPasteAction action = new CopyPasteAction(editText);
        editText.setCustomSelectionActionModeCallback(action);
        action.setResultListener(new CopyPasteAction.ActionResultListener() {
            @Override
            public void onResult(boolean success, CopyPasteAction.ActionType type, String text) {
                CopyPasteAction.ActionType actionType = type;
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

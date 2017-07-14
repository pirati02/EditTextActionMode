# FailureRepoForCi

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

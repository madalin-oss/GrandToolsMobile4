package com.grandtools.mobile;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.*;

public class ToolsKeyboard extends InputMethodService {

    void addKey(LinearLayout row, String label, String value) {
        Button b = Ui.button(this, label);
        row.addView(b, new LinearLayout.LayoutParams(0, 54, 1));

        b.setOnClickListener(v -> {
            InputConnection ic = getCurrentInputConnection();
            if (ic == null) return;

            if (value.equals("DEL")) {
                ic.deleteSurroundingText(1, 0);
            } else {
                ic.commitText(value, 1);
            }
        });
    }

    @Override
    public View onCreateInputView() {
        LinearLayout base = Ui.column(this);

        LinearLayout quick = new LinearLayout(this);
        base.addView(quick);

        for (int i = 0; i < 4; i++) {
            addKey(quick, "★" + (i + 1), Ui.command(this, i));
        }

        String[] rows = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
        };

        for (String letters : rows) {
            LinearLayout row = new LinearLayout(this);
            base.addView(row);

            for (char c : letters.toCharArray()) {
                addKey(row, "" + c, "" + c);
            }
        }

        LinearLayout bottom = new LinearLayout(this);
        base.addView(bottom);

        addKey(bottom, "⌫", "DEL");
        addKey(bottom, "Пробел", " ");
        addKey(bottom, "↵", "\n");

        return base;
    }
}

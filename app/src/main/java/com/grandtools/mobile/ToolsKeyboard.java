package com.grandtools.mobile;

import android.inputmethodservice.InputMethodService;
import android.view.*;
import android.view.inputmethod.InputConnection;
import android.widget.*;

public class ToolsKeyboard extends InputMethodService {

    LinearLayout base;

    void key(LinearLayout row, String label, String value, int weight) {
        Button b = Ui.button(this, label);

        LinearLayout.LayoutParams p =
            new LinearLayout.LayoutParams(0, 54, weight);

        p.setMargins(2, 2, 2, 2);
        row.addView(b, p);

        b.setOnClickListener(v -> {

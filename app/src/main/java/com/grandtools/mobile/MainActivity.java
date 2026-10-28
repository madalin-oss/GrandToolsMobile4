package com.grandtools.mobile;

import android.app.*;
import android.os.*;
import android.content.*;
import android.provider.Settings;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;

public class MainActivity extends Activity {

    LinearLayout root;

    void row(String title, Runnable action) {
        Button b = Ui.button(this, title);
        LinearLayout.LayoutParams p =
            new LinearLayout.LayoutParams(-1, -2);
        p.setMargins(0, 7, 0, 7);
        root.addView(b, p);
        b.setOnClickListener(v -> action.run());
    }

    @Override
    public void onCreate(Bundle b) {

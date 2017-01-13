package com.bajicdusko.androidrxstarterkit.ui.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 26-Nov-16.
 */

public class Utility {

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
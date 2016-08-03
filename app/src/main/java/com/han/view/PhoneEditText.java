package com.han.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by Han on 2016/8/3.
 */
public class PhoneEditText extends EditText {
    private static final String TAG = PhoneEditText.class.getSimpleName();

    //Exp = "\\d{3}-\\d{3}-\\d{4}"  123-456-7890
    private String mPhonenumExp;

    public PhoneEditText(Context context) {
        super(context);
        addPhoneTextWatcherListener();
    }


    public PhoneEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        addPhoneTextWatcherListener();
    }

    public PhoneEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    private void addPhoneTextWatcherListener() {
        Log.d(TAG, "addPhoneTextWatcherListener");
        addTextChangedListener(new PhoneTextWatcher(this));
    }

    public String getPhonenumExp() {
        return mPhonenumExp;
    }

    public void setPhonenumExp(String phonenumExp) {
        this.mPhonenumExp = phonenumExp;
    }

    private class PhoneTextWatcher implements TextWatcher {
        EditText mEdittext;

        public PhoneTextWatcher(EditText edittext) {
            mEdittext = edittext;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Log.d(TAG + " beforeTextChanged", "Str=" + s + "|" + "start=" + start + "|" + "count=" + count + "|" + "after=" + after);

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Log.d(TAG + " onTextChanged", "Str=" + s + "|" + "start=" + start + "|" + "before=" + before + "|" + "count=" + count);
            String realeStr = getRealeInputStr((String) s);
            mEdittext.setText("Han");
        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.d(TAG + " afterTextChanged", "Str=" + s);
            Log.d(TAG, "-----------------------------------------");

        }
    }

    public String getRealeInputStr(String input) {
        return input.replaceAll(" ", "").replaceAll("-", "");
    }

}

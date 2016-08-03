package com.han.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.han.util.FormatUtil;


/**
 * Created by Hector Han on 3/20/2016.
 * TODO:
 */


public class MoneyTextWatcher implements TextWatcher {

    private EditText numberEditText;
    int beforeLen = 0;
    int afterLen = 0;

    public MoneyTextWatcher(EditText numberEditText) {
        this.numberEditText = numberEditText;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before,
                              int count) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
        beforeLen = s.length();
    }

    @Override
    public void afterTextChanged(Editable s) {
        String txt = numberEditText.getText().toString();
        afterLen = txt.length();

        numberEditText.setText(FormatUtil.getBigDecimalString(txt));
        numberEditText.setSelection(numberEditText.getText()
                .length());
    }
}

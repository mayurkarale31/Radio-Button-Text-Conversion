package com.example.radiodialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Locale;

public class TextConvert extends Dialog {
    private Context context;
    private EditText editText;
    private RadioButton rbUppar;
    private RadioButton rbLower;
    private RadioButton rbInitCap;
    private CheckBox btnCheck;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public interface OnOkListener{
        void forTextChange(String text, TextConvert textConvert);
    }

    private OnOkListener onOkListener =null;

    public void setOnOkListener(OnOkListener onOkListener){
        this.onOkListener = onOkListener;
    }

    public TextConvert(Context context, String text){
        super(context);
        this.context = context;

        initViews();

        editText.setText(text);

        rbUppar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbUppar.isChecked();
                rbLower.setChecked(false);
                rbInitCap.setChecked(false);
                if (!editText.getText().toString().isEmpty()) {
                    String toupparcase = editText.getText().toString().toUpperCase(Locale.ROOT);
                    editText.setText(String.valueOf(toupparcase));
                }
            }
        });

        rbLower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbUppar.setChecked(false);
                rbInitCap.setChecked(false);
                if (!editText.getText().toString().isEmpty()){
                    String tolowercase = editText.getText().toString().toLowerCase(Locale.ROOT);
                    editText.setText(String.valueOf(tolowercase));
                }
            }
        });

        rbInitCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbUppar.setChecked(false);
                rbLower.setChecked(false);
                if(!editText.getText().toString().isEmpty()){
                    String initcap = editText.getText().toString().substring(0,1).toUpperCase()
                            + editText.getText().toString().substring(1).toLowerCase(Locale.ROOT);
                    editText.setText(String.valueOf(initcap));
                }
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText.getText().toString().isEmpty()){
                    StringBuffer rev= new StringBuffer(editText.getText().toString());
                    editText.setText(rev.reverse());
                }
            }
        });

        btnOk.setOnClickListener(new OkButtonClickListener());
    }
        private class OkButtonClickListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                if(rbUppar.isChecked()){
                    if(onOkListener !=null){
                        onOkListener.forTextChange(editText.getText().toString(), TextConvert.this);
                    }
                }
                else if(rbLower.isChecked()) {
                    if (onOkListener != null) {
                        onOkListener.forTextChange(editText.getText().toString(), TextConvert.this);
                    }
                }
                else if(rbInitCap.isChecked()) {
                    if (onOkListener != null) {
                        onOkListener.forTextChange(editText.getText().toString(), TextConvert.this);

                    }
                }
                else if(btnCheck.isChecked()) {
                    if (onOkListener != null) {
                        onOkListener.forTextChange(editText.getText().toString(), TextConvert.this);
                    }
                }
                else if(rbUppar.isChecked() && btnCheck.isChecked()) {
                    if (onOkListener != null) {
                        onOkListener.forTextChange(editText.getText().toString(), TextConvert.this);
                    }
                }
                else if(rbLower.isChecked() && btnCheck.isChecked()) {
                    if (onOkListener != null) {
                        onOkListener.forTextChange(editText.getText().toString(), TextConvert.this);
                    }
                }
                else if(rbInitCap.isChecked() && btnCheck.isChecked()) {
                    if (onOkListener != null) {
                        onOkListener.forTextChange(editText.getText().toString(), TextConvert.this);
                    }
                }
            }
        };
    public void mt(String text){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
    public void initViews(){
        setContentView(R.layout.convert_dialog);
        editText = findViewById(R.id.edtText);
        rbUppar = findViewById(R.id.rbUppar);
        rbLower = findViewById(R.id.rbLower);
        rbInitCap = findViewById(R.id.rbInitCap);
        btnCheck = findViewById(R.id.btnCheck);
        btnOk = findViewById(R.id.btnOk);
    }
}


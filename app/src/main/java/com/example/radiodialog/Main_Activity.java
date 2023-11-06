package com.example.radiodialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Main_Activity extends AppCompatActivity {
    private EditText edtText;
    private Button btnSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();


        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextConvert textConvert = new TextConvert(Main_Activity.this, edtText.getText().toString());
                textConvert.setOnOkListener(new MyOnOkClickListener());
                textConvert.show();
            }
        });
    }
    public void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    private class MyOnOkClickListener implements TextConvert.OnOkListener{

        @Override
        public void forTextChange(String text, TextConvert textConvert) {
            textConvert.dismiss();
            edtText.setText(text);
        }
    }
    public void initViews(){
        setContentView(R.layout.main_activity);
        edtText = findViewById(R.id.edtText);
        btnSet = findViewById(R.id.btnSet);
    }
}

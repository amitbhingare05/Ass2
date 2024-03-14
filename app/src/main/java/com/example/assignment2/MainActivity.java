package com.example.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button btn_add;
    private Button btn_sub;
    private Button btn_equals;
    private List<EditText> editTexts;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linear_layout);
        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_equals = findViewById(R.id.btn_equal);

        textViewResult = findViewById(R.id.textViewResult);

        editTexts = new ArrayList<>();

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewEditText();
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLastEditText();
            }
        });
        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    private void createNewEditText() {
        // Createing  a new EditText
        EditText editText = new EditText(this);
        editText.setHint("Enter the number");

        // Add the EditText to the LinearLayout and to the list
        linearLayout.addView(editText);
        editTexts.add(editText);
    }

    private void removeLastEditText() {
        // Check if there are views to remove
        if (!editTexts.isEmpty()) {

            linearLayout.removeView(editTexts.get(editTexts.size() - 1));
            editTexts.remove(editTexts.size() - 1);
        }
    }
    private void calculateResult() {
        int sum = 0;
        for (EditText editText : editTexts) {
            String numberText = editText.getText().toString();
            if (!numberText.isEmpty()) {
                double number = Double.parseDouble(numberText);
                sum += number;
            }
        }
        textViewResult.setText(String.valueOf(sum));
    }
}

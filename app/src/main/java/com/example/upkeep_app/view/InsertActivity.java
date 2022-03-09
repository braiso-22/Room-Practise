package com.example.upkeep_app.view;

import static com.example.upkeep_app.util.Extras.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.upkeep_app.R;

public class InsertActivity extends AppCompatActivity {



    private EditText eTFleet, eTBoat, eTService, eTComponent, eTUpkeep, eTTask, eTOperator, eTStore;
    private Button bIFleet, bIBoat, bIService, bIComponent, bIUpkeep, bITask, bIOperator, bIStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        // EditTexts
        eTFleet = findViewById(R.id.eTFleets);
        eTBoat = findViewById(R.id.eTBoats);
        eTService = findViewById(R.id.eTServices);
        eTComponent = findViewById(R.id.eTComponents);
        eTUpkeep = findViewById(R.id.eTUpkeeps);
        eTTask = findViewById(R.id.eTTasks);
        eTOperator = findViewById(R.id.eTOperators);
        eTStore = findViewById(R.id.eTStores);
        // Buttons
        bIFleet = findViewById(R.id.bInsertFleet);
        setButtonListener(bIFleet, eTFleet, EXTRA_FLEET);

        bIBoat = findViewById(R.id.bInsertBoat);
        setButtonListener(bIBoat, eTBoat, EXTRA_BOAT);

        bIService = findViewById(R.id.bInsertService);
        setButtonListener(bIService, eTService, EXTRA_SERVICE);

        bIComponent = findViewById(R.id.bInsertComponent);
        setButtonListener(bIComponent, eTComponent, EXTRA_COMPONENT);

        bIUpkeep = findViewById(R.id.bInsertUpkeep);
        setButtonListener(bIUpkeep, eTUpkeep, EXTRA_UPKEEP);

        bITask = findViewById(R.id.bInsertTask);
        setButtonListener(bITask, eTTask, EXTRA_TASK);

        bIOperator = findViewById(R.id.bInsertOperator);
        setButtonListener(bIOperator, eTOperator, EXTRA_OPERATOR);

        bIStore = findViewById(R.id.bInsertStore);
        setButtonListener(bIStore, eTStore, EXTRA_STORE);
    }

    private void setButtonListener(Button bt, EditText et, String extra) {
        bt.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(et.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String content = et.getText().toString();
                replyIntent.putExtra("content", content);
                replyIntent.putExtra("type",extra);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}
package com.example.upkeep_app.view;

import static com.example.upkeep_app.util.Extras.EXTRA_BOAT;
import static com.example.upkeep_app.util.Extras.EXTRA_COMPONENT;
import static com.example.upkeep_app.util.Extras.EXTRA_FLEET;
import static com.example.upkeep_app.util.Extras.EXTRA_OPERATOR;
import static com.example.upkeep_app.util.Extras.EXTRA_SERVICE;
import static com.example.upkeep_app.util.Extras.EXTRA_STORE;
import static com.example.upkeep_app.util.Extras.EXTRA_TASK;
import static com.example.upkeep_app.util.Extras.EXTRA_UPKEEP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.upkeep_app.R;

public class UpdateActivity extends AppCompatActivity {

    private EditText eTFleet, eTBoat, eTService, eTComponent, eTUpkeep, eTTask, eTOperator, eTStore;
    private Button bUFleet, bUBoat, bUService, bUComponent, bUUpkeep, bUTask, bUOperator, bUStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

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
        bUFleet = findViewById(R.id.bUpdateFleet);
        setButtonListener(bUFleet, eTFleet, EXTRA_FLEET);

        bUBoat = findViewById(R.id.bUpdateBoat);
        setButtonListener(bUBoat, eTBoat, EXTRA_BOAT);

        bUService = findViewById(R.id.bUpdateService);
        setButtonListener(bUService, eTService, EXTRA_SERVICE);

        bUComponent = findViewById(R.id.bUpdateComponent);
        setButtonListener(bUComponent, eTComponent, EXTRA_COMPONENT);

        bUUpkeep = findViewById(R.id.bUpdateUpkeep);
        setButtonListener(bUUpkeep, eTUpkeep, EXTRA_UPKEEP);

        bUTask = findViewById(R.id.bUpdateTask);
        setButtonListener(bUTask, eTTask, EXTRA_TASK);

        bUOperator = findViewById(R.id.bUpdateOperator);
        setButtonListener(bUOperator, eTOperator, EXTRA_OPERATOR);

        bUStore = findViewById(R.id.bUpdateStore);
        setButtonListener(bUStore, eTStore, EXTRA_STORE);
        
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
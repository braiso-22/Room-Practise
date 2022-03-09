package com.example.upkeep_app.view;

import static com.example.upkeep_app.util.Extras.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.upkeep_app.R;

public class DeleteActivity extends AppCompatActivity {

    private Button bDFleet, bDBoat, bDService, bDComponent, bDUpkeep, bDTask, bDOperator, bDStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        bDFleet = findViewById(R.id.bDeleteFleet);
        setButtonListener(bDFleet, EXTRA_FLEET);

        bDBoat = findViewById(R.id.bDeleteBoats);
        setButtonListener(bDBoat, EXTRA_BOAT);

        bDService = findViewById(R.id.bDeleteServices);
        setButtonListener(bDService, EXTRA_SERVICE);

        bDComponent = findViewById(R.id.bDeleteComponents);
        setButtonListener(bDComponent, EXTRA_COMPONENT);

        bDUpkeep = findViewById(R.id.bDeleteUpkeeps);
        setButtonListener(bDUpkeep, EXTRA_UPKEEP);

        bDTask = findViewById(R.id.bDeleteTasks);
        setButtonListener(bDTask, EXTRA_TASK);

        bDOperator = findViewById(R.id.bDeleteOperators);
        setButtonListener(bDOperator, EXTRA_OPERATOR);

        bDStore = findViewById(R.id.bDeleteStores);
        setButtonListener(bDStore, EXTRA_STORE);
    }

    private void setButtonListener(Button bt, String extra) {
        bt.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            replyIntent.putExtra("type",extra);
            setResult(RESULT_OK, replyIntent);
            finish();
        });
    }
}
package com.example.upkeep_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.upkeep_app.model.vo.Boat;
import com.example.upkeep_app.model.vo.Fleet;
import com.example.upkeep_app.view.FleetListAdapter;
import com.example.upkeep_app.view.NewFleetActivity;
import com.example.upkeep_app.viewmodel.ViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private ViewModel viewModel;
    private TextView tVFleets, tVBoats, tVServices, tVComponents, tVUpkeeps, tVTasks, tVOperators, tVStores;
    FloatingActionButton fab;
    public static final int NEW_FLEET_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewComponents();

        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        viewModelObservers();

        // Button for changing activity

        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NewFleetActivity.class);
            startActivityForResult(intent, NEW_FLEET_ACTIVITY_REQUEST_CODE);
        });
    }

    public void initViewComponents() {
        tVFleets = findViewById(R.id.fleetTV);
        tVBoats = findViewById(R.id.boatTV);
        tVServices = findViewById(R.id.serviceTV);
        tVComponents = findViewById(R.id.componentTV);
        tVUpkeeps = findViewById(R.id.upkeepTV);
        tVTasks = findViewById(R.id.taskTV);
        tVOperators = findViewById(R.id.operatorTV);
        tVStores = findViewById(R.id.storeTV);

        fab = findViewById(R.id.fab);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final FleetListAdapter adapter = new FleetListAdapter(new FleetListAdapter.FleetDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void viewModelObservers() {
        viewModel.getAllFleets().observe(this, fleets -> {
            tVFleets.setText("Fleets:\n");
            for (Fleet fleet : fleets) {
                tVFleets.setText(tVFleets.getText() + fleet.toString());
            }
        });

        viewModel.getAllBoats().observe(this, boats -> {
            tVBoats.setText("Boats:\n");
            for (Boat boat : boats) {
                tVBoats.setText(tVBoats.getText() + boat.toString());
            }
        });


        /*viewModel.getAllFleets().observe(this, fleets -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(fleets);
        });*/
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_FLEET_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Fleet fleet = new Fleet(data.getStringExtra(NewFleetActivity.EXTRA_REPLY));
            viewModel.insert(fleet);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}
package com.example.upkeep_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.upkeep_app.model.vo.Fleet;
import com.example.upkeep_app.view.FleetListAdapter;
import com.example.upkeep_app.view.NewFleetActivity;
import com.example.upkeep_app.viewmodel.ViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private ViewModel viewModel;
    private EditText eT;
    public static final int NEW_FLEET_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eT = findViewById(R.id.editTextTextPersonName);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final FleetListAdapter adapter = new FleetListAdapter(new FleetListAdapter.FleetDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getAllFleets().observe(this, fleets -> {
            for (Fleet a:fleets) {
                eT.setText(eT.getText()+a.toString());
            }
        });
        /*viewModel.getAllFleets().observe(this, fleets -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(fleets);
        });*/
        viewModel.getAllFleets().observe(this, fleets -> {

        });
        // Button for changing activity
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NewFleetActivity.class);
            startActivityForResult(intent, NEW_FLEET_ACTIVITY_REQUEST_CODE);
        });
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
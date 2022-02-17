package com.example.upkeep_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.upkeep_app.model.vo.Fleet;
import com.example.upkeep_app.view.FleetListAdapter;
import com.example.upkeep_app.view.NewFleetActivity;
import com.example.upkeep_app.viewmodel.ViewModel;

public class MainActivity extends AppCompatActivity {
    private ViewModel viewModel;
    public static final int NEW_FLEET_ACTIVITY_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final FleetListAdapter adapter = new FleetListAdapter(new FleetListAdapter.FleetDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = new ViewModelProvider(this).get(ViewModel.class);

        viewModel.getAllFleets().observe(this, words -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(words);
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_FLEET_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Fleet word = new Fleet(data.getStringExtra(NewFleetActivity.EXTRA_REPLY));
            viewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}
package com.example.upkeep_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.upkeep_app.model.vo.Boat;
import com.example.upkeep_app.model.vo.Component;
import com.example.upkeep_app.model.vo.Fleet;
import com.example.upkeep_app.model.vo.Operator;
import com.example.upkeep_app.model.vo.Service;
import com.example.upkeep_app.model.vo.Store;
import com.example.upkeep_app.model.vo.Task;
import com.example.upkeep_app.model.vo.Upkeep;
import com.example.upkeep_app.util.VOParser;
import com.example.upkeep_app.view.FleetListAdapter;
import com.example.upkeep_app.view.InsertActivity;
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
            Intent intent = new Intent(MainActivity.this, InsertActivity.class);
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

        viewModel.getAllServices().observe(this, services -> {
            tVServices.setText("Services:\n");
            for (Service service : services) {
                tVServices.setText(tVServices.getText() + service.toString());
            }
        });

        viewModel.getAllComponents().observe(this, components -> {
            tVComponents.setText("Components:\n");
            for (Component component : components) {
                tVComponents.setText(tVComponents.getText() + component.toString());
            }
        });

        viewModel.getAllUpkeeps().observe(this, upkeeps -> {
            tVUpkeeps.setText("Upkeeps:\n");
            for (Upkeep upkeep : upkeeps) {
                tVUpkeeps.setText(tVUpkeeps.getText() + upkeep.toString());
            }
        });

        viewModel.getAllTasks().observe(this, tasks -> {
            tVTasks.setText("Tasks:\n");
            for (Task task : tasks) {
                tVTasks.setText(tVTasks.getText() + task.toString());
            }
        });

        viewModel.getAllOperators().observe(this, operators -> {
            tVOperators.setText("Operators:\n");
            for (Operator operator : operators) {
                tVOperators.setText(tVOperators.getText() + operator.toString());
            }
        });

        viewModel.getAllStores().observe(this, stores -> {
            tVStores.setText("Stores:\n");
            for (Store store : stores) {
                tVStores.setText(tVStores.getText() + store.toString());
            }
        });

        /*viewModel.getAllFleets().observe(this, fleets -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(fleets);
        });*/
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_FLEET_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            String content;

            // TODO hacer clase padre para hacer esto con herencia y polimorfismo

            try {
                content = extras.get(InsertActivity.EXTRA_FLEET).toString();
                Fleet fleet = VOParser.parseFleet(content);
                viewModel.insert(fleet);
            } catch (Exception e) {

            }
            try{
                content = extras.get(InsertActivity.EXTRA_BOAT).toString();
                Boat boat = VOParser.parseBoat(content);
                viewModel.insert(boat);
            }catch(Exception e){

            }
            try{
                content = extras.get(InsertActivity.EXTRA_SERVICE).toString();
                Service service = VOParser.parseService(content);
                viewModel.insert(service);
            }catch(Exception e){

            }
            try{
                content = extras.get(InsertActivity.EXTRA_COMPONENT).toString();
                Component component = VOParser.parseComponent(content);
                viewModel.insert(component);
            }catch(Exception e){

            }
            try{
                content = extras.get(InsertActivity.EXTRA_UPKEEP).toString();
                Upkeep upkeep = VOParser.parseUpkeep(content);
                viewModel.insert(upkeep);
            }catch(Exception e){

            }
            try{
                content = extras.get(InsertActivity.EXTRA_TASK).toString();
                Task task = VOParser.parseTask(content);
                viewModel.insert(task);
            }catch(Exception e){

            }
            try{
                content = extras.get(InsertActivity.EXTRA_OPERATOR).toString();
                Operator operator = VOParser.parseOperator(content);
                viewModel.insert(operator);
            }catch(Exception e){

            }
            try{
                content = extras.get(InsertActivity.EXTRA_STORE).toString();
                Store store = VOParser.parseStore(content);
                viewModel.insert(store);
            }catch(Exception e){

            }

        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

}
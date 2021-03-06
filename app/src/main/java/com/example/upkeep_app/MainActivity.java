package com.example.upkeep_app;

import static com.example.upkeep_app.util.Extras.*;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Delete;

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
import com.example.upkeep_app.view.DeleteActivity;
import com.example.upkeep_app.view.FleetListAdapter;
import com.example.upkeep_app.view.InsertActivity;
import com.example.upkeep_app.view.UpdateActivity;
import com.example.upkeep_app.viewmodel.ViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private ViewModel viewModel;
    private TextView tVFleets, tVBoats, tVServices, tVComponents, tVUpkeeps, tVTasks, tVOperators, tVStores;
    FloatingActionButton fab, fab2, fab3;
    public static final int INSERT_ACTIVITY_REQUEST_CODE = 1, DELETE_ACTIVITY_REQUEST_CODE = 2, UPDATE_ACTIVITY_REQUEST_CODE = 3;

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
            startActivityForResult(intent, INSERT_ACTIVITY_REQUEST_CODE);
        });


        fab2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
            startActivityForResult(intent, UPDATE_ACTIVITY_REQUEST_CODE);
        });

        fab3.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
            startActivityForResult(intent, DELETE_ACTIVITY_REQUEST_CODE);
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
        fab2 = findViewById(R.id.fab2);
        fab3 = findViewById(R.id.fab3);

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
        if (resultCode != RESULT_OK) {
            Toast.makeText(
                    getApplicationContext(),
                    "no se seleccion?? nada",
                    Toast.LENGTH_LONG).show();
            return;
        }
        Bundle extras = data.getExtras();

        if (requestCode == INSERT_ACTIVITY_REQUEST_CODE) {

            String content;

            content = extras.get("content").toString();
            try {
                switch (extras.get("type").toString()) {
                    case EXTRA_FLEET:
                        Fleet fleet = VOParser.parseFleet(content);
                        viewModel.insert(fleet);
                        break;
                    case EXTRA_BOAT:
                        Boat boat = VOParser.parseBoat(content);
                        viewModel.insert(boat);
                        break;
                    case EXTRA_SERVICE:
                        Service service = VOParser.parseService(content);
                        viewModel.insert(service);
                        break;
                    case EXTRA_COMPONENT:
                        Component component = VOParser.parseComponent(content);
                        viewModel.insert(component);
                        break;
                    case EXTRA_UPKEEP:
                        Upkeep upkeep = VOParser.parseUpkeep(content);
                        viewModel.insert(upkeep);
                        break;
                    case EXTRA_TASK:
                        Task task = VOParser.parseTask(content);
                        viewModel.insert(task);
                        break;
                    case EXTRA_OPERATOR:
                        Operator operator = VOParser.parseOperator(content);
                        viewModel.insert(operator);
                        break;
                    case EXTRA_STORE:
                        Store store = VOParser.parseStore(content);
                        viewModel.insert(store);
                        break;
                    default:
                        Toast.makeText(
                                getApplicationContext(),
                                "Error imposible, seleccion de item no est?? en la base de datos",
                                Toast.LENGTH_LONG).show();

                }
            } catch (Exception e) {
                Toast.makeText(
                        getApplicationContext(),
                        e.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        }
        if (requestCode == DELETE_ACTIVITY_REQUEST_CODE) {
            try {

                switch (extras.get("type").toString()) {
                    case EXTRA_FLEET:
                        viewModel.deleteAllFleets();
                        break;
                    case EXTRA_BOAT:
                        viewModel.deleteAllBoats();
                        break;
                    case EXTRA_SERVICE:
                        viewModel.deleteAllServices();
                        break;
                    case EXTRA_COMPONENT:
                        viewModel.deleteAllComponents();
                        break;
                    case EXTRA_UPKEEP:
                        viewModel.deleteAllUpkeeps();
                        break;
                    case EXTRA_TASK:
                        viewModel.deleteAllTasks();
                        break;
                    case EXTRA_OPERATOR:
                        viewModel.deleteAllOperators();
                        break;
                    case EXTRA_STORE:
                        viewModel.deleteAllStores();
                        break;
                    default:
                        Toast.makeText(
                                getApplicationContext(),
                                "Error imposible, seleccion de item no est?? en la base de datos",
                                Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {

            }
        }
        if (requestCode == UPDATE_ACTIVITY_REQUEST_CODE) {

            String content;

            content = extras.get("content").toString();
            try {
                switch (extras.get("type").toString()) {
                    case EXTRA_FLEET:
                        Fleet fleet = VOParser.parseFleetWithId(content);
                        viewModel.update(fleet);
                        break;
                    case EXTRA_BOAT:
                        Boat boat = VOParser.parseBoatWithId(content);
                        viewModel.update(boat);
                        break;
                    case EXTRA_SERVICE:
                        Service service = VOParser.parseServiceWithId(content);
                        viewModel.update(service);
                        break;
                    case EXTRA_COMPONENT:
                        Component component = VOParser.parseComponentWithId(content);
                        viewModel.update(component);
                        break;
                    case EXTRA_UPKEEP:
                        Upkeep upkeep = VOParser.parseUpkeepWithId(content);
                        viewModel.update(upkeep);
                        break;
                    case EXTRA_TASK:
                        Task task = VOParser.parseTaskWithId(content);
                        viewModel.update(task);
                        break;
                    case EXTRA_OPERATOR:
                        Operator operator = VOParser.parseOperatorWithId(content);
                        viewModel.update(operator);
                        break;
                    case EXTRA_STORE:
                        Store store = VOParser.parseStoreWithId(content);
                        viewModel.update(store);
                        break;
                    default:
                        Toast.makeText(
                                getApplicationContext(),
                                "Error imposible, seleccion de item no est?? en la base de datos",
                                Toast.LENGTH_LONG).show();

                }
            } catch (Exception e) {
                Toast.makeText(
                        getApplicationContext(),
                        e.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        }


    }

}
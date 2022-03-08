package com.example.upkeep_app.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.upkeep_app.model.vo.Boat;
import com.example.upkeep_app.model.vo.Component;
import com.example.upkeep_app.model.vo.Fleet;
import com.example.upkeep_app.model.vo.Operator;
import com.example.upkeep_app.model.vo.Service;
import com.example.upkeep_app.model.vo.Store;
import com.example.upkeep_app.model.vo.Task;
import com.example.upkeep_app.model.vo.Upkeep;
import com.example.upkeep_app.repository.UpkeepsRepository;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private UpkeepsRepository repository;
    private final LiveData<List<Fleet>> allFleets;
    private final LiveData<List<Boat>> allBoats;
    private final LiveData<List<Service>> allServices;
    private final LiveData<List<Component>> allComponents;
    private final LiveData<List<Upkeep>> allUpkeeps;
    private final LiveData<List<Task>> allTasks;
    private final LiveData<List<Operator>> allOperators;
    private final LiveData<List<Store>> allStores;

    public ViewModel(Application application) {
        super(application);
        repository = new UpkeepsRepository(application);
        allFleets = repository.getAllFleets();
        allBoats = repository.getAllBoats();
        allServices = repository.getAllServices();
        allComponents = repository.getAllComponents();
        allUpkeeps = repository.getAllUpkeeps();
        allTasks = repository.getAllTasks();
        allOperators = repository.getAllOperators();
        allStores = repository.getAllStores();
    }

    public LiveData<List<Fleet>> getAllFleets() {
        return allFleets;
    }

    public void insert(Fleet fleet) {
        repository.insert(fleet);
    }

    public LiveData<List<Boat>> getAllBoats() {
        return allBoats;
    }

    public void insert(Boat boat) {
        repository.insert(boat);
    }

    public LiveData<List<Service>> getAllServices(){
        return allServices;
    }
    public void insert(Service service){repository.insert(service);}

    public LiveData<List<Component>> getAllComponents(){
        return allComponents;
    }
    public void insert(Component component){repository.insert(component);}

    public LiveData<List<Upkeep>> getAllUpkeeps(){
        return allUpkeeps;
    }
    public void insert(Upkeep upkeep){repository.insert(upkeep);}

    public LiveData<List<Task>> getAllTasks(){
        return allTasks;
    }
    public void insert(Task task){repository.insert(task);}

    public LiveData<List<Operator>> getAllOperators(){
        return allOperators;
    }
    public void insert(Operator operator){repository.insert(operator);}

    public LiveData<List<Store>> getAllStores(){
        return allStores;
    }
    public void insert(Store store){repository.insert(store);}

    // TODO deleteAll Methods


}

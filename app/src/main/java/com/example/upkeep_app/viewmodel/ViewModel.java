package com.example.upkeep_app.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.upkeep_app.model.vo.Boat;
import com.example.upkeep_app.model.vo.Fleet;
import com.example.upkeep_app.model.vo.Service;
import com.example.upkeep_app.repository.UpkeepsRepository;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private UpkeepsRepository repository;
    private final LiveData<List<Fleet>> allFleets;
    private final LiveData<List<Boat>> allBoats;
    private final LiveData<List<Service>> allServices;
    // private final LiveData<List<unique>> allunique;

    public ViewModel(Application application) {
        super(application);
        repository = new UpkeepsRepository(application);
        allFleets = repository.getAllFleets();
        allBoats = repository.getAllBoats();
        allServices = repository.getAllServices();
        //allunique = repository.getAllunique();
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

    /*
    public LiveData<List<unique>> getAllunique(){
        return allunique;
    }
    public void insert(unique unique){repository.insert(unique);}*/
}

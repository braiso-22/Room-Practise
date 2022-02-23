package com.example.upkeep_app.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.upkeep_app.model.vo.Boat;
import com.example.upkeep_app.model.vo.Fleet;
import com.example.upkeep_app.repository.UpkeepsRepository;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private UpkeepsRepository repository;
    private final LiveData<List<Fleet>> allFleets;
    private final LiveData<List<Boat>> allBoats;

    public ViewModel(Application application) {
        super(application);
        repository = new UpkeepsRepository(application);
        allFleets = repository.getAllFleets();
        allBoats = repository.getAllBoats();
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
}

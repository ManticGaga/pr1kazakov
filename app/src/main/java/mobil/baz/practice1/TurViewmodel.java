package mobil.baz.practice1;

import android.app.Application;
import android.app.Person;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TurViewmodel extends AndroidViewModel {
    private TurRepository repository;
    private LiveData<List<Tur>> turList;

    public TurViewmodel(Application application) {
        super(application);
        repository = new TurRepository(application);
        turList = repository.getAllTur();
    }

    public void insertTur(Tur tur) {
        repository.insert(tur);
    }

    public void updateTur(Tur tur) {
        repository.update(tur);
    }

    public void deleteTur(Tur tur) {
        repository.delete(tur);
    }

    public LiveData<List<Tur>> getAllTur() {
        return turList;
    }
}

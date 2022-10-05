package mobil.baz.practice1;

import android.app.Application;
import android.app.Person;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TurViewmodel extends AndroidViewModel {
    TurRepository repository;
    LiveData<List<Tur>> turList;
    public TurViewmodel(Application application){
        super(application);
        repository = new TurRepository(application);
        turList= repository.getTur();
    }
    LiveData<List<Tur>> getAllTurs(){
        return turList;
    }

    public void insertTur(Tur tur){
        repository.insert(tur);
    }
}

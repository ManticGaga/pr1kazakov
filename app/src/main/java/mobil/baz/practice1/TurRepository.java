package mobil.baz.practice1;

import android.app.Application;
import android.app.Person;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TurRepository {
    mobil.baz.practice1.TurDao turDao;
    TurRepository(Application application){
        mobil.baz.practice1.TurDatabase db = mobil.baz.practice1.TurDatabase.getDatabase(application);
        turDao = db.turDao();
    }

    LiveData<List<mobil.baz.practice1.Tur>> getTur() {
        return turDao.getAllTurs();
    }

    void insert(Tur tur){
        new insertAsyncTask(turDao).execute(tur);
    }
    private static class insertAsyncTask extends AsyncTask<Tur,Void,Void>{
        private TurDao taskDao;

        insertAsyncTask(TurDao turDao){
            taskDao = turDao;
        }
    @Override
        protected Void doInBackground(Tur... turers){
            taskDao.insertAll(turers[0]);
            return null;
    }

    }

}

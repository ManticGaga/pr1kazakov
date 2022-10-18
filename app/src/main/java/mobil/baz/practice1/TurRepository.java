package mobil.baz.practice1;

import android.app.Application;
import android.app.Person;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import java.util.List;

public class TurRepository {
    private TurDao turDao;
    private LiveData<List<Tur>> allTur;
    TurRepository(Application application) {
        TurDatabase db = TurDatabase.getDatabase(application);
        turDao = db.turDao();
        allTur = turDao.getAllTurLive();
    }



    public void insert(Tur tur) {
        new InsertTurAsyncTask(turDao).execute(tur);
    }

    public void update(Tur tur) {
        new UpdateTurAsyncTask(turDao).execute(tur);
    }

    public void delete(Tur tur) {
        new DeleteTurAsyncTask(turDao).execute(tur);
    }

    public LiveData<List<Tur>> getAllTur() {
        return allTur;
    }


    private static class InsertTurAsyncTask extends AsyncTask<Tur, Void, Void>{
        private TurDao turDAO;
        private InsertTurAsyncTask(TurDao turDAO){
            this.turDAO = turDAO;
        }

        @Override
        protected Void doInBackground(Tur... tur) {
            turDAO.insertTur(tur[0]);
            return null;
        }
    }

    private static class UpdateTurAsyncTask extends AsyncTask<Tur, Void, Void> {
        private TurDao turDAO;

        private UpdateTurAsyncTask(TurDao turDAO) {
            this.turDAO = turDAO;
        }

        @Override
        protected Void doInBackground(Tur... tur) {
            turDAO.updateTur(tur[0]);
            return null;
        }
    }

    private static class DeleteTurAsyncTask extends AsyncTask<Tur, Void, Void> {
        private TurDao turDAO;

        private DeleteTurAsyncTask(TurDao turDAO) {
            this.turDAO = turDAO;
        }

        @Override
        protected Void doInBackground(Tur... tur) {
            turDAO.deleteTur(tur[0]);
            return null;
        }

    }

}

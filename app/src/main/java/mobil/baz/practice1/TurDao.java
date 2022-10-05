package mobil.baz.practice1;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TurDao {

    @Insert
    void insertAll(mobil.baz.practice1.Tur... turs);

    @Query("SELECT * FROM tur")
    LiveData<List<mobil.baz.practice1.Tur>> getAllTurs();
}

package mobil.baz.practice1;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TurDao {

    @Insert
    public void insertTur(Tur tur);

    @Update
    public void updateTur(Tur tur);

    @Delete
    public void deleteTur(Tur tur);

    @Query("SELECT * FROM tur")
    LiveData<List<mobil.baz.practice1.Tur>> getAllTur();

    @Query("select * from tur where name ==:name ")
    public Tur getTur(String name);

    @Query("SELECT * FROM tur")
    public LiveData<List<Tur>> getAllTurLive();
}

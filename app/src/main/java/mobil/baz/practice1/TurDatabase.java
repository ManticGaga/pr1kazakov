package mobil.baz.practice1;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {mobil.baz.practice1.Tur.class},version = 1)
public abstract class TurDatabase extends RoomDatabase {
    public abstract mobil.baz.practice1.TurDao turDao();

    public static TurDatabase INSTANCE;

    public static TurDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (TurDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TurDatabase.class,"tur-database").fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

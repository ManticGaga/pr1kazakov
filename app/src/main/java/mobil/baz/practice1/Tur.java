package mobil.baz.practice1;

import android.app.Application;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tur {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "travel")
    public String travel;
    @ColumnInfo(name = "living")
    public String living;

    public Tur(String name, String travel,String living){
        this.name = name;
        this.travel = travel;
        this.living = living;
    }
}

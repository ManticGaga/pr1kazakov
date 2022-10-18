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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String theme) {
        this.travel = travel;
    }

    public String getLiving() {
        return living;
    }

    public void setLiving(String text) {
        this.living = living;
    }
}

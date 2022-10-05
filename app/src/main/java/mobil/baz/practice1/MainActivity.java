package mobil.baz.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TurViewmodel viewmodel = ViewModelProviders.of(this).get(TurViewmodel.class);

        Tur tur_peaking = new Tur("Turkey", "Bus", "5*");

        //db.turDao().insertAll(tur_peaking);
        //List<Tur> turList = db.turDao().getAllTurs();

        Button button = findViewById(R.id.addbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewmodel.insertTur(tur_peaking);
          
            }
        });

        viewmodel.getAllTurs().observe(this, turList ->{
            for(Tur list: turList){
                Log.d("Tur",list.name+" "+list.travel+" "+list.living);
            }
        });


    }
}
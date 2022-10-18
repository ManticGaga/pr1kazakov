package mobil.baz.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name;
        EditText travel;
        EditText living;

        name = (EditText) findViewById(R.id.name);
        travel = (EditText) findViewById(R.id.travel);
        living = (EditText) findViewById(R.id.living);

        TurViewmodel viewmodel = ViewModelProviders.of(this).get(TurViewmodel.class);

        TurDatabase db = Room.databaseBuilder(getApplicationContext(),
                TurDatabase.class, "pizza-database").allowMainThreadQueries().build();

        Tur turpeaking = new Tur("Turkey", "Bus", "5*");



        Button button = findViewById(R.id.addbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewmodel.insertTur(turpeaking);
          
            }
        });
        button.setOnClickListener(view ->  {
            String PIZZA_NAME = name.getText().toString();
            String PIZZA_RECEPT = travel.getText().toString();
            String NAME = living.getText().toString();
            Tur peaking = new Tur(NAME,PIZZA_NAME, PIZZA_RECEPT);
            viewmodel.insertTur(peaking);

            Intent intent = new Intent(MainActivity.this, TurList.class);
            startActivity(intent);

            Context context = getApplicationContext();
            CharSequence text = "Тур, добавлен.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            Toast.makeText(context, text, duration).show();

        });
        viewmodel.getAllTur().observe(this, turList ->{
            for(Tur list: turList){
                Log.d("Tur",list.name+" "+list.travel+" "+list.living);
            }
        });


    }
}
package mobil.baz.practice1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.widget.Button;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class TurList  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tur_list);
        setContentView(R.layout.activity_main);
        Button button2 = (Button)findViewById(R.id.addbtn);

    }

    public void toAddPizza(View view) {
        Intent intent = new Intent(TurList.this, MainActivity.class);
        startActivity(intent);
    }

}

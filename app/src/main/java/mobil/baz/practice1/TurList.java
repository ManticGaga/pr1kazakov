package mobil.baz.practice1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.widget.Button;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.List;


import java.util.List;
import java.util.List;

import mobil.baz.practice1.databinding.FragmentNameBinding;
import mobil.baz.practice1.databinding.TurListBinding;

public class TurList  extends Fragment {
    FragmentNameBinding binding;
    TurViewmodel model;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNameBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        model = new ViewModelProvider(this).get(TurViewmodel.class);
        binding.turRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.turRecycler.setHasFixedSize(true);
        TurAdapter turAdapter = new TurAdapter();
        binding.turRecycler.setAdapter(turAdapter);
        model.getAllTur().observe(getViewLifecycleOwner(), new Observer<List<Tur>>() {
            @Override
            public void onChanged(List<Tur> tur) {
                turAdapter.setTur(tur);
            }
        });
    }

}

package mobil.baz.practice1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;
import java.util.ArrayList;


import mobil.baz.practice1.databinding.TurListBinding;

public class TurAdapter extends RecyclerView.Adapter<TurAdapter.MyViewHolder>{

    private List<Tur> mTur =  new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TurListBinding binding = TurListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tur tur = mTur.get(position);
        holder.bindView(tur);
    }

    @Override
    public int getItemCount() {
        return mTur.size();
    }

    public void setTur(List<Tur> tur){
        this.mTur = tur;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TurListBinding binding;

        public MyViewHolder(TurListBinding binding){
            super(binding.getRoot());
            this.binding = binding;


        }
        public void bindView(Tur tur){
            binding.nameTxt.setText(tur.getName());
        }
    }
}
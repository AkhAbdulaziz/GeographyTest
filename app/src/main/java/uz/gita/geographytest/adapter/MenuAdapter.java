package uz.gita.geographytest.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.gita.geographytest.App.App;
import uz.gita.geographytest.R;
import uz.gita.geographytest.data.MenuData;
import uz.gita.geographytest.ui.MainActivity;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.VH> {
    private ArrayList<MenuData> list;

    public MenuAdapter(ArrayList<MenuData> list) {
        this.list = list;
    }

    class VH extends RecyclerView.ViewHolder {
        ImageView menuImage = itemView.findViewById(R.id.menu_item_image);
        TextView menuTitle = itemView.findViewById(R.id.menu_item_title);

        public VH(@NonNull View itemView) {
            super(itemView);
        }

        {
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(App.instance, MainActivity.class);
                intent.putExtra("game_type", getAdapterPosition());
                itemView.getContext().startActivity(intent);
            });
        }

        void bind() {
            MenuData data = list.get(getAdapterPosition());
            menuImage.setImageResource(data.getMenuImage());
            menuTitle.setText(data.getMenuTitle());
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}


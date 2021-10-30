package uz.gita.geographytest.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import uz.gita.geographytest.R;
import uz.gita.geographytest.adapter.MenuAdapter;
import uz.gita.geographytest.data.MenuData;

public class MenuActivity extends AppCompatActivity {
    private ArrayList<MenuData> data = new ArrayList<MenuData>();
    private MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        loadData();

        adapter = new MenuAdapter(data);
        RecyclerView rv = findViewById(R.id.menu_rv_container);

        rv.setAdapter(adapter);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void loadData() {
        data.add(new MenuData(R.drawable.all_flags, "Countries"));
        data.add(new MenuData(R.drawable.menu_capitals_image, "Capitals"));
        data.add(new MenuData(R.drawable.menu_maps_image, "Maps"));
        data.add(new MenuData(R.drawable.menu_currency_image, "Currencies"));
    }
}
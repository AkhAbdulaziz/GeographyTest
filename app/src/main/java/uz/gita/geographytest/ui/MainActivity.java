package uz.gita.geographytest.ui;

import android.app.UiModeManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import uz.gita.geographytest.R;
import uz.gita.geographytest.contract.FlagContract;
import uz.gita.geographytest.data.QuestionData;
import uz.gita.geographytest.presenter.GamePresenter;
import uz.gita.geographytest.repository.CapitalsRepository;
import uz.gita.geographytest.repository.CountriesRepository;
import uz.gita.geographytest.repository.CurrenciesRepository;
import uz.gita.geographytest.repository.MapsRepository;

public class MainActivity extends AppCompatActivity implements FlagContract.View {
    private final int[] variantIds = {R.id.variant1, R.id.variant2, R.id.variant3, R.id.variant4};
    private final TextView[] variantsText = new TextView[variantIds.length];
    private ImageView questionImage;
    private FlagContract.Presenter presenter;
    private Button variant1;
    private Button variant2;
    private Button variant3;
    private Button variant4;
    private TextView textView;
    private int level;
    private boolean isGameCurrency = false;
    private String game_title = "Flag ";
    private boolean singleResult = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        loadViews();
        connectActions();
        Bundle bundle = getIntent().getExtras();
        int game_type = bundle.getInt("game_type", 0);

        if (game_type == 0) {
            game_title = "Country ";
            presenter = new GamePresenter(this, new CountriesRepository());
        } else if (game_type == 1) {
            game_title = "Capital ";
            presenter = new GamePresenter(this, new CapitalsRepository());
        } else if (game_type == 2) {
            game_title = "Map ";
            presenter = new GamePresenter(this, new MapsRepository());
        } else if (game_type == 3) {
            game_title = "Currency ";
            isGameCurrency = true;
            questionImage.setPaddingRelative(150, 150, 150, 150);
            presenter = new GamePresenter(this, new CurrenciesRepository());
        }

        findViewById(R.id.backBtn).setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        singleResult = true;
    }

    private void loadViews() {
        questionImage = findViewById(R.id.questionFlagImage);
        if (isGameCurrency) {
            questionImage.setPaddingRelative(150, 150, 150, 150);
        }
        variant1 = findViewById(R.id.variant1);
        variant2 = findViewById(R.id.variant2);
        variant3 = findViewById(R.id.variant3);
        variant4 = findViewById(R.id.variant4);

        for (int i = 0; i < variantIds.length; i++) {
            variantsText[i] = findViewById(variantIds[i]);
        }
    }

    private void connectActions() {
        variant1.setOnClickListener(v -> {
            presenter.checkVariant(variant1.getId());
        });
        variant2.setOnClickListener(v -> {
            presenter.checkVariant(variant2.getId());
        });
        variant3.setOnClickListener(v -> {
            presenter.checkVariant(variant3.getId());
        });
        variant4.setOnClickListener(v -> {
            presenter.checkVariant(variant4.getId());
        });
    }

    @Override
    public void setQuestionImage(@NonNull QuestionData data) {
        level++;
        textView = findViewById(R.id.level_flag_question);
        textView.setText(game_title + level + "/10");
        questionImage.setImageResource(data.getFlagImage());
        for (int i = 0; i < variantsText.length; i++) {
            variantsText[i].setText(data.getVariantById(i));
        }
    }

    @Override
    public void finishTest(int wrongCount, int correctCount) {
        if (singleResult) {
            Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
            intent.putExtra("corrects", correctCount);
            intent.putExtra("mistakes", wrongCount);
            startActivity(intent);
            finish();
            singleResult = false;
        }
    }
}

package uz.gita.geographytest.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.yangp.ypwaveview.YPWaveView;

import uz.gita.geographytest.R;

public class ResultsActivity extends AppCompatActivity {
    private TextView correctsText;
    private TextView mistakesText;
    private int corrects;
    private int mistakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        correctsText = findViewById(R.id.correctsText);
        mistakesText = findViewById(R.id.mistakesText);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            corrects = bundle.getInt("corrects", 0);
            mistakes = bundle.getInt("mistakes", 0);
            correctsText.setText("Corrects: " + corrects);
            mistakesText.setText("Wrongs: " + mistakes);
        }
        findViewById(R.id.backBtn).setOnClickListener(v -> {
            finish();
        });
        YPWaveView progressWave = findViewById(R.id.progressWave);
        progressWave.setProgress(10 * corrects);
    }
}
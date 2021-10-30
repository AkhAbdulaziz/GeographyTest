package uz.gita.geographytest.repository;

import java.util.ArrayList;
import java.util.List;

import uz.gita.geographytest.R;
import uz.gita.geographytest.contract.FlagContract;
import uz.gita.geographytest.data.QuestionData;

public class CurrenciesRepository implements FlagContract.Model {
    ArrayList<QuestionData> data = new ArrayList<>();

    public CurrenciesRepository() {
        loadData();
    }

    private void loadData() {
        data.add(new QuestionData(R.drawable.currency_albania_lek, "united states", "canada", "united kingdom", "albania", "albania"));
        data.add(new QuestionData(R.drawable.currency_cuba_peso, "germany", "italy", "cuba", "australia", "cuba"));
        data.add(new QuestionData(R.drawable.currency_european_union_euro, "malaysia", "russia", "european union", "united states", "european union"));
        data.add(new QuestionData(R.drawable.currency_japan_yen, "japan", "russia", "france", "italy", "japan"));
        data.add(new QuestionData(R.drawable.currency_laos_kip, "iraq", "laos", "italy", "vatican", "laos"));
        data.add(new QuestionData(R.drawable.currency_mongolia_tughrik, "vietnam", "mongolia", "russia", "uzbekistan", "mongolia"));
        data.add(new QuestionData(R.drawable.currency_russia_ruble, "russia", "vietnam", "india", "turkey", "russia"));
        data.add(new QuestionData(R.drawable.currency_south_korea_won, "japan", "vietnam", "south korea", "canada", "south korea"));
        data.add(new QuestionData(R.drawable.currency_turkey_lira, "turkey", "latvia", "canada", "albania", "turkey"));
        data.add(new QuestionData(R.drawable.currency_us_dollar, "united kingdom", "russia", "united states", "australia", "united states"));

    }

    @Override
    public List<QuestionData> getQuestions() {
        return data;
    }

}

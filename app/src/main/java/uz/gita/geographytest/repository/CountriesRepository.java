package uz.gita.geographytest.repository;

import java.util.ArrayList;
import java.util.List;
import uz.gita.geographytest.R;
import uz.gita.geographytest.contract.FlagContract;
import uz.gita.geographytest.data.QuestionData;

public class CountriesRepository implements FlagContract.Model {
    ArrayList<QuestionData> data = new ArrayList<>();

    public CountriesRepository() {
        loadData();
    }

    private void loadData() {
        data.add(new QuestionData(R.drawable.usa_washington_flag, "united states", "canada", "united kingdom", "australia", "united states"));
        data.add(new QuestionData(R.drawable.australia_canberra_flag, "germany", "italy", "united kingdom", "australia", "australia"));
        data.add(new QuestionData(R.drawable.germany_berlin_flag, "malaysia", "russia", "belgium", "germany", "germany"));
        data.add(new QuestionData(R.drawable.france_paris_flag, "uzbekistan", "russia", "france", "italy", "france"));
        data.add(new QuestionData(R.drawable.italy_rome_flag, "iraq", "canada", "italy", "vatican", "italy"));
        data.add(new QuestionData(R.drawable.uzbekistan_tashkent_flag, "vietnam", "canada", "russia", "uzbekistan", "uzbekistan"));
        data.add(new QuestionData(R.drawable.vietnam_hanoi_flag, "china", "vietnam", "turkey", "australia", "vietnam"));
        data.add(new QuestionData(R.drawable.china_beijing_flag, "vietnam", "turkey", "china", "canada", "china"));
        data.add(new QuestionData(R.drawable.canada_ottawa_flag, "turkey", "japan", "canada", "albania", "canada"));
        data.add(new QuestionData(R.drawable.russia_moscow_flag, "italy", "russia", "malaysia", "australia", "russia"));
    }

    @Override
    public List<QuestionData> getQuestions() {
        return data;
    }

}

package uz.gita.geographytest.repository;

import java.util.ArrayList;
import java.util.List;

import uz.gita.geographytest.R;
import uz.gita.geographytest.contract.FlagContract;
import uz.gita.geographytest.data.QuestionData;

public class MapsRepository implements FlagContract.Model {
    ArrayList<QuestionData> data = new ArrayList<>();

    public MapsRepository() {
        loadData();
    }

    private void loadData() {
        data.add(new QuestionData(R.drawable.map_australia, "france", "england", "australia", "canada", "australia"));
        data.add(new QuestionData(R.drawable.map_brazil, "brazil", "italy", "vatican", "israel", "brazil"));
        data.add(new QuestionData(R.drawable.map_canada, "uzbekistan", "canada", "japan", "south korea", "canada"));
        data.add(new QuestionData(R.drawable.map_england, "malaysia", "colombia", "pakistan", "england", "england"));
        data.add(new QuestionData(R.drawable.map_japan, "cuba", "japan", "ecuador", "germany", "japan"));
        data.add(new QuestionData(R.drawable.map_malaysia, "malaysia", "georgia", "united states", "qatar", "malaysia"));
        data.add(new QuestionData(R.drawable.map_pakistan, "china", "pakistan", "turkey", "brazil", "pakistan"));
        data.add(new QuestionData(R.drawable.map_qatar, "chili", "bulgaria", "qatar", "cambodia", "qatar"));
        data.add(new QuestionData(R.drawable.map_saudi_arabia, "iraq", "india", "saudi arabia", "qatar", "saudi arabia"));
        data.add(new QuestionData(R.drawable.map_uzbekistan, "mali", "uzbekistan", "malaysia", "monaco", "uzbekistan"));
    }

    @Override
    public List<QuestionData> getQuestions() {
        return data;
    }

}

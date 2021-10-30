package uz.gita.geographytest.repository;

import java.util.ArrayList;
import java.util.List;

import uz.gita.geographytest.R;
import uz.gita.geographytest.contract.FlagContract;
import uz.gita.geographytest.data.QuestionData;

public class CapitalsRepository implements FlagContract.Model {
    ArrayList<QuestionData> data = new ArrayList<>();

    public CapitalsRepository() {
        loadData();
    }

    private void loadData() {
        data.add(new QuestionData(R.drawable.usa_washington_flag, "paris", "washington", "ottawa", "canberra", "washington"));
        data.add(new QuestionData(R.drawable.australia_canberra_flag, "berlin", "rome", "washington", "canberra", "canberra"));
        data.add(new QuestionData(R.drawable.south_korea_seoul_flag, "kuala lumpur", "moscow", "seoul", "pyongyang", "seoul"));
        data.add(new QuestionData(R.drawable.france_paris_flag, "tashkent", "wellington", "paris", "rome", "paris"));
        data.add(new QuestionData(R.drawable.georgia_atlanta_flag, "banjul", "ottawa", "atlanta", "bogota", "atlanta"));
        data.add(new QuestionData(R.drawable.uzbekistan_tashkent_flag, "hanoi", "canberra", "tashkent", "kabul", "tashkent"));
        data.add(new QuestionData(R.drawable.vietnam_hanoi_flag, "beijing", "hanoi", "ankara", "baghdad", "hanoi"));
        data.add(new QuestionData(R.drawable.china_beijing_flag, "pyongyang", "ankara", "beijing", "tokyo", "beijing"));
        data.add(new QuestionData(R.drawable.canada_ottawa_flag, "paris", "ottawa", "jerusalem", "tirana", "ottawa"));
        data.add(new QuestionData(R.drawable.colombia_bogota_flag, "bogota", "wellington", "santiago", "london", "bogota"));
    }

    @Override
    public List<QuestionData> getQuestions() {
        return data;
    }

}

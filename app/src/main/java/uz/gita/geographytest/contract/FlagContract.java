package uz.gita.geographytest.contract;

import java.util.List;

import uz.gita.geographytest.data.QuestionData;

public interface FlagContract {

    interface Model {
        List<QuestionData> getQuestions();
    }

    interface View {
        void setQuestionImage(QuestionData data);

        void finishTest(int wrongCount, int correctCount);
    }

    interface Presenter {
        void checkVariant(int id);
    }
}

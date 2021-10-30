package uz.gita.geographytest.presenter;

import uz.gita.geographytest.contract.FlagContract;
import uz.gita.geographytest.data.QuestionData;

public class GamePresenter implements FlagContract.Presenter {
    FlagContract.View view;
    FlagContract.Model model;
    private int wrongCount;
    private int correctCount;
    private int currentQuestion;
    private int lastSelected = 0;

    public GamePresenter(FlagContract.View view, FlagContract.Model model) {
        this.view = view;
        this.model = model;
        loadNextQuestion();
    }

    @Override
    public void checkVariant(int id) {
        lastSelected = id;

        QuestionData data = model.getQuestions().get(currentQuestion);
        String userAnswer = data.getVariantById(lastSelected);
        String originalAnswer = data.getAnswer();

        if (userAnswer.equalsIgnoreCase(originalAnswer)) {
            correctCount++;
        } else {
            wrongCount++;
        }
        if (isFinish()) {
            finishQuiz();
            return;
        }
        currentQuestion++;
        loadNextQuestion();
    }

    private boolean isFinish() {
        return currentQuestion + 1 == model.getQuestions().size();
    }

    private void loadNextQuestion() {
        QuestionData data = model.getQuestions().get(currentQuestion);
        view.setQuestionImage(data);
    }

    private void finishQuiz() {
        view.finishTest(wrongCount, correctCount);
    }
}

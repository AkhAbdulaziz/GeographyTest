package uz.gita.geographytest.data;

import uz.gita.geographytest.R;

public class QuestionData {
    private final int flagImage;
    private final String variant1;
    private final String variant2;
    private final String variant3;
    private final String variant4;
    private final String answer;

    public QuestionData(int flagImage, String variant1, String variant2, String variant3, String variant4, String answer) {
        this.flagImage = flagImage;
        this.variant1 = variant1;
        this.variant2 = variant2;
        this.variant3 = variant3;
        this.variant4 = variant4;
        this.answer = answer;
    }

    public int getFlagImage() {
        return flagImage;
    }

    public String getVariantById(int index) {
        if (index == 0 || index == R.id.variant1) return variant1;
        if (index == 1 || index == R.id.variant2) return variant2;
        if (index == 2 || index == R.id.variant3) return variant3;
        if (index == 3 || index == R.id.variant4) return variant4;
        throw new IllegalArgumentException("Xato argument berildii");
    }

    public String getAnswer() {
        return answer;
    }
}

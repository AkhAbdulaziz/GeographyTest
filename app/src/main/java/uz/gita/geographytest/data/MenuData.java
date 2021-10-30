package uz.gita.geographytest.data;

public class MenuData {
    private int menuImage;
    private String menuTitle;

    public MenuData(int menuImage, String menuTitle) {
        this.menuImage = menuImage;
        this.menuTitle = menuTitle;
    }

    public int getMenuImage() {
        return menuImage;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuImage(int menuImage) {
        this.menuImage = menuImage;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }
}

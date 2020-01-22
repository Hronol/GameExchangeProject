package game;

public class GamesData {
    private String gameTitle;
    private String gamePlatform;
    private int gameYear;
    private String gameCategory;

    public GamesData(String gameTitle, String gamePlatform, int gameYear, String gameCategory) {
        this.gameTitle = gameTitle;
        this.gamePlatform = gamePlatform;
        this.gameYear = gameYear;
        this.gameCategory = gameCategory;
    }

    public enum gameCategoryEnum{
        FPS ,
        Akcja,
        Wyścigi,
        RPG,
        Strategia,
        Symulator
    }
}



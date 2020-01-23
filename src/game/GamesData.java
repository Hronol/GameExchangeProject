package game;

public class GamesData {
    private String gameTitle;
    private String gamePlatform;
    private Integer gameYear;
    private String gameCategory;
    private Double gamePrice;

    public GamesData(String gameTitle, String gamePlatform, Integer gameYear, String gameCategory, Double gamePrice) {
        this.gameTitle = gameTitle;
        this.gamePlatform = gamePlatform;
        this.gameYear = gameYear;
        this.gameCategory = gameCategory;
        this.gamePrice = gamePrice;
    }

    public GamesData() {
        this.gameTitle = "";
        this.gamePlatform = "";
        this.gameYear = 0;
        this.gameCategory = "";
        this.gamePrice = 0.0;
    }

    public enum gameCategoryEnum{
        FPS ,
        Akcja,
        Wyścigi,
        RPG,
        Strategia,
        Symulator
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGamePlatform() {
        return gamePlatform;
    }

    public void setGamePlatform(String gamePlatform) {
        this.gamePlatform = gamePlatform;
    }

    public Integer getGameYear() {
        return gameYear;
    }

    public void setGameYear(Integer gameYear) {
        this.gameYear = gameYear;
    }

    public String getGameCategory() {
        return gameCategory;
    }

    public void setGameCategory(String gameCategory) {
        this.gameCategory = gameCategory;
    }

    public Double getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(Double gamePrice) {
        this.gamePrice = gamePrice;
    }
}




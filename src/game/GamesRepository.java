package game;

import java.util.ArrayList;
import java.util.List;

public class GamesRepository {
    public List<GamesData> gamesDataList = new ArrayList<GamesData>();

    public List<GamesData> getGamesDataList() {
        return gamesDataList;
    }

    public void addGameToRepo(GamesData gamesData){
        gamesDataList.add(gamesData);
    }

    public void addGametoRepo(String gameName, String gamePlatform, Integer gameYear, String gameCategory, Double gamePrice){
        GamesData tmp = new GamesData(gameName, gamePlatform, gameYear, gameCategory, gamePrice);
        gamesDataList.add(tmp);
    }

    public void addGame(){
        GamesData tmp = new GamesData();
        tmp.setGameTitle("GTA4");
        tmp.setGamePlatform("PS3");
        tmp.setGameYear(2008);
        tmp.setGameCategory("Akcja");
        tmp.setGamePrice(99.99);
        gamesDataList.add(tmp);
    }
}

package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class DataTest implements DataRecords{

    @Override
    public List<Player> loadData() {
        List<Player> players = new ArrayList<Player>();
//        players.add(new Player("Zorro", 56099));
//        players.add(new Player("Nami", 340));
        players.add(new Player("Tina", 99999));
//        players.add(new Player("Luffy", 679));
//        players.add(new Player("Law", 6700));
        return players;
    }

    @Override
    public void saveData(Player players) {
//        System.out.println();
    }

}

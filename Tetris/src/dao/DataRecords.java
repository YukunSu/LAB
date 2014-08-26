package dao;

import java.util.List;

import dto.Player;

public interface DataRecords {

    public List<Player> loadData();

    public void saveData(Player players);

}

package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import dto.Player;

public class DataLocal implements DataRecords{

    private static final String FILE_PATH = "Local Records/records.dat";

    @SuppressWarnings("unchecked")
    @Override
    public List<Player> loadData() {
        List<Player> playerRecords = null;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            playerRecords = (List<Player>)ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return playerRecords;
    }

    @Override
    public void saveData(Player player) {
        List<Player> players = this.loadData();
        if (players.size() < 5) {
            players.add(player);
        } else {
            players.remove(4);
            players.add(player);
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(players);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class Database implements DataRecords{

    private static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private static String DB_NAME = "TBD";

    private static String DB_URL = "jdbc:sqlserver://127.0.0.1:1443;database=" + DB_NAME;

    private static String DB_USERNAME = "admin"; //TBD

    private static String DB_PASSWORD = "admin"; // TBD

    private static String TABLE_NAME = "TBD";

    private static String LIST_USERNAME = "TBD";

    private static String LIST_SCORE = "TBD";

    private static String LIST_GAME_TYPE = "TBD"; // NOT REQUIRED

    private static String NUMBER_GAME_TYPE = "TBD"; // NOT REQUIRED

    private static String LOAD_SQL = "SELECT TOP 5 username, score FROM " + TABLE_NAME
            + " WHERE " + LIST_GAME_TYPE + " = " + NUMBER_GAME_TYPE + " ORDER BY " + LIST_SCORE + " DESC";

    private static String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + LIST_USERNAME + ", "
            + LIST_SCORE + ", " + LIST_GAME_TYPE + ") VALUES (?, ?, ?)";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Player> loadData() {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Player> players = new ArrayList<Player>();
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = conn.prepareStatement(LOAD_SQL);
            result = statement.executeQuery();
            while(result.next()) {
                players.add(new Player(result.getString(1), result.getInt(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void saveData(Player player) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = conn.prepareStatement(SAVE_SQL);
            statement.setObject(1, player.getName());
            statement.setObject(2, player.getScore());
            statement.setObject(3, 1);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

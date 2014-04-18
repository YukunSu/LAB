package service;

import dto.GameDto;
import entity.GameAct;

/**
 * 
 * @author Yukun
 * 
 */
public class GameService {

    private GameDto dto;

    public GameService(GameDto dto) {
        this.dto = dto;
        GameAct act = new GameAct();
        dto.setGameAct(act);
    }

    public void gameTest() {
    }
}

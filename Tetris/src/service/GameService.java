package service;

public interface GameService {
    public boolean keyUp();
    public boolean keyDown();
    public boolean keyLeft();
    public boolean keyRight();
    public boolean keyFunctionUp();
    public boolean keyFunctionDown();
    public boolean keyFunctionLeft();
    public boolean keyFunctionRight();
    public void startGame();
    public void mainAction();
    public void addLvl();
    public void scoreAdder();
}

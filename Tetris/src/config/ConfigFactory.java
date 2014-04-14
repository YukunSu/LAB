package config;

/**
 * 
 * @author Yukun
 *
 */
public class ConfigFactory {
	
	private static ConfigGame GAME_CONFIG = null;
	
	static {
		try{
			GAME_CONFIG  = new ConfigGame();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static ConfigGame getConfigGame(){
		return GAME_CONFIG;
	}

}

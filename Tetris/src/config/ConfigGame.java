package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Game Configuration class Frame size, window border size and padding distance
 * 
 * @author Yukun
 * 
 */
public class ConfigGame {
	private int width;
	private int height;
	private int windowBorderSize;
	private int padding;
	/**
	 * Configuration of all windows in frame
	 */
	private List<ConfigWindow> ListConfigWindow;

	/**
	 * Read configuration xml file and get all information
	 * 
	 * @throws DocumentException
	 */
	public ConfigGame() throws DocumentException {
		// Create XML reader
		SAXReader reader = new SAXReader();
		// Read XML file
		Document doc = reader.read("config/config.xml");
		// Get root element
		Element game = doc.getRootElement();
		this.setGUIConfig(game.element("frame"));
		this.setSystemConfig(game.element("system"));
		this.setDataConfig(game.element("data"));
	}

	/**
	 * Window configuration
	 * 
	 * @param frame
	 */
	private void setGUIConfig(Element frame) {
		this.width = Integer.parseInt(frame.attributeValue("width"));
		this.height = Integer.parseInt(frame.attributeValue("height"));
		this.padding = Integer.parseInt(frame.attributeValue("padding"));
		this.windowBorderSize = Integer.parseInt(frame.attributeValue("border"));

		List<Element> windows = frame.elements("window");
		ListConfigWindow = new ArrayList<ConfigWindow>();
		for (Element singleWindow : windows) {
			ConfigWindow cw = new ConfigWindow();
			cw.setClassName(singleWindow.attributeValue("className"));
			cw.setH(Integer.parseInt(singleWindow.attributeValue("x")));
			cw.setW(Integer.parseInt(singleWindow.attributeValue("y")));
			cw.setX(Integer.parseInt(singleWindow.attributeValue("w")));
			cw.setY(Integer.parseInt(singleWindow.attributeValue("h")));
			ListConfigWindow.add(cw);
		}
	}
	
	/**
	 * System configuration
	 * @param frame
	 */
	private void setSystemConfig(Element frame) {
		// TODO
	}
	
	/**
	 * Data configuraion
	 * @param frame
	 */
	private void setDataConfig(Element frame) {
		// TODO
	}

}

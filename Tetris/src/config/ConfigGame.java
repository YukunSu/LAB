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
	private String title;
	private int width;
	private int height;
	private int windowBorderSize;
	private int padding;
	private int distanceBottom;

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
		// Configuration of frame parameter
		this.setGUIConfig(game.element("frame"));
		// Configuration of system parameter
		this.setSystemConfig(game.element("system"));
		// Configuration of data access parameter
		this.setDataConfig(game.element("data"));
	}

	/**
	 * Window configuration
	 * 
	 * @param frame
	 */
	private void setGUIConfig(Element frame) {
		//Frame properties should be configured here
		this.width = Integer.parseInt(frame.attributeValue("width"));
		this.height = Integer.parseInt(frame.attributeValue("height"));
		this.padding = Integer.parseInt(frame.attributeValue("padding"));
		this.windowBorderSize = Integer.parseInt(frame.attributeValue("border"));
		this.distanceBottom = Integer.parseInt(frame.attributeValue("distanceBottom"));
		this.title = frame.attributeValue("title");

		//Get window elements in frame tag
		List<Element> windows = frame.elements("window");
		ListConfigWindow = new ArrayList<ConfigWindow>();
		for (Element singleWindow : windows) {
			ConfigWindow cw = new ConfigWindow(
					singleWindow.attributeValue("className"),
					Integer.parseInt(singleWindow.attributeValue("x")),
					Integer.parseInt(singleWindow.attributeValue("y")),
					Integer.parseInt(singleWindow.attributeValue("w")),
					Integer.parseInt(singleWindow.attributeValue("h")));
			ListConfigWindow.add(cw);
		}
	}

	/**
	 * System configuration
	 * 
	 * @param frame
	 */
	private void setSystemConfig(Element frame) {
		// TODO
	}

	/**
	 * Data configuraion
	 * 
	 * @param frame
	 */
	private void setDataConfig(Element frame) {
		// TODO
	}

	public int getDistanceBottom() {
		return distanceBottom;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getPadding() {
		return padding;
	}
	
	public String getTitle() {
		return title;
	}
	public int getWidth() {
		return width;
	}

	public int getWindowBorderSize() {
		return windowBorderSize;
	}

	public List<ConfigWindow> getListConfigWindow() {
		return ListConfigWindow;
	}
}

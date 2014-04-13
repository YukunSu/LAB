package config;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * @author Yukun
 * 
 */
public class ConfigReader {

	public static void readConfig() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read("config/config.xml");
		Element game = doc.getRootElement();
		Element frame = game.element("frame");
		List<Element> windows = frame.elements("window");
		for(Element e : windows){
			System.out.print(e.attributeValue("className")+":");
			System.out.print(e.attributeValue("x")+",");
			System.out.print(e.attributeValue("y")+",");
			System.out.print(e.attributeValue("w")+",");
			System.out.print(e.attributeValue("h"));
			System.out.println();
		}
	}

	public static void main(String[] args) throws DocumentException {
		readConfig();
	}

}

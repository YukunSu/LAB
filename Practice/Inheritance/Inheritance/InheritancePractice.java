package Inheritance;

import CommonSource.Animalia;
import CommonSource.Organism;

public class InheritancePractice {
	public static void main(String[] args) {
		Organism a = new Organism("Unicellular");
		Organism b = new Animalia("Metazoan");
		Animalia c = new Animalia("Metazoan");
		Animalia d = (Animalia) b;
		a.metabolism();
		a.move();
		
		b.heredity();
		b.move();
		
		c.myName();
		c.metabolism();
		c.heredity();
		c.move();
		
		d.myName();
		d.metabolism();
		d.heredity();
		d.move();
	}
}

package src;

public class PrintRhombus {
	public static void main(String[] args){
		char one,two;
		int edge;
		one = '*';
		two = ' ';
		edge = 9;
		Diamond diamond = new Diamond(one,two,edge);
		diamond.print();		
		diamond.setFirstSymbol('@');
		diamond.setSecondSymbol('_');
		diamond.setLongestEdge(19);
		diamond.print();
	}
}

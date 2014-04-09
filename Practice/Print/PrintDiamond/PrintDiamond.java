package PrintDiamond;

public class PrintDiamond {
	public static void main(String[] args) {
		char one = '*';
		char two = ' ';
		int edge = 9;
		Diamond diamond = new Diamond(one, two, edge);
		diamond.print();
		diamond.setFirstSymbol('@');
		diamond.setSecondSymbol('_');
		diamond.setLongestEdge(19);
		diamond.print();
	}
}

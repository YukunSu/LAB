package PrintDiamond;

public class Diamond {

    private char firstSymbol = '*';
    private char secondSymbol = ' ';
    private int longestEdge = 0;

    public Diamond(char firstSymbol, char secondSymbol, int longestEdge) {
        this.firstSymbol = firstSymbol;
        this.secondSymbol = secondSymbol;
        this.longestEdge = longestEdge;
    }

    public void setFirstSymbol(char fSymbol) {
        this.firstSymbol = fSymbol;
    }

    public void setSecondSymbol(char sSymbol) {
        this.secondSymbol = sSymbol;
    }

    public void setLongestEdge(int edge) {
        this.longestEdge = edge;
    }

    public void print() {
        int lowerHalf = 0;
        for (int i = 0; i < longestEdge; i++) {
            if (i > (longestEdge >> 1))
                lowerHalf += 2;
            for (int j = 0; j < longestEdge; j++) {
                if ((j >= Math.abs((longestEdge >> 1) - i))
                        && (j <= ((longestEdge >> 1) + i - lowerHalf)))
                    System.out.print(firstSymbol);
                else
                    System.out.print(secondSymbol);

                if (j == longestEdge - 1)
                    System.out.println();
            }
        }
    }
}


public class Main {
    public static void main(String[] args){
//        int[] test1 = {4,435,12,1,5,879,21,67,89,9};
//        int[] test2 = Sudoku.sort(test1);
//        Sudoku.printArray(test1);
//        Sudoku.printArray(test2);
//        int[] test3 = {4,4, 435,12,1,5,879,21,67,89,9};
//        int[] test4 = {4,435,12,1,5,5, 879,21,67,89,9};
//        int[] test5 = {4,435,12,1,5,879,21,67,89,9,9};
//        int[] test6 = {4,435,12,1,5,879,21,67,89,9};
//        System.out.println(Sudoku.uniqueEntries(test3));
//        System.out.println(Sudoku.uniqueEntries(test4));
//        System.out.println(Sudoku.uniqueEntries(test5));
//        System.out.println(Sudoku.uniqueEntries(test6));
//        
//        int[][] test7 = {{4,2,9,90},{3,6,8,1},{7,4,5,8}};
//        Sudoku.printArray(Sudoku.getColumn(test7, 2));
//        Sudoku.printArray(Sudoku.flatten(test7));
//        
        int[][] test8 = {{1,2,3},{4,5,6},{7,8,9}};
        Sudoku.printArray(Sudoku.flatten(Sudoku.subGrid(test8, 1, 1, 2)));
        
        int[][] test9 = {{5,3,4,6,7,8,9,1,2},
                {6,6,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9},};
        System.out.println(Sudoku.isSudoku(test9));
        
        Card a = new Card(Suit.SPADES, Value.ACE);
        String s = a.toString();
        System.out.println(s);
        
        Card b = new Card(Suit.CLUBS, Value.QUEEN);
        Card c = new Card(Suit.DIAMONDS, Value.EIGHT);
        CardPile temp = new CardPile();
        temp.addToBottom(a);
        temp.addToBottom(b);
        temp.addToBottom(c);
        System.out.println(temp.toString());
        temp.remove(1);
        System.out.println(temp.toString());
        System.out.println(temp.find(Suit.DIAMONDS, Value.EIGHT));
        System.out.println(temp.find(Suit.DIAMONDS, Value.ACE));
        temp.remove(0);
        System.out.println(temp.toString());
        temp.remove(0);
        System.out.println(temp.toString());
        System.out.println(temp.isEmpty());
        
    }
}

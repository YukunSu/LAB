public class Sudoku {
    public static int[] sort(int[] inputArray){
        //error check
        if(inputArray==null || inputArray.length==0){
            return null;
        }
        
        if(inputArray.length == 1) {
            return inputArray;
        }
        
        int[] newArray = new int[inputArray.length];
        
        //copy original array
        for(int i=0; i<inputArray.length; i++){
            newArray[i] = inputArray[i];
        }
        
        boolean flag = true;
        int temp;
        while(flag){
            flag = false;
            for(int i=0; i<newArray.length-1; i++){
                if(newArray[i] > newArray[i+1]){
                    temp = newArray[i];
                    newArray[i] = newArray[i+1];
                    newArray[i+1] = temp;
                    flag = true;
                }
            }
        }
        return newArray;
    }
    
    public static boolean uniqueEntries(int[] inputArray){
        //error check
        if(inputArray==null || inputArray.length==0){
            return false;
        }
        
        if(inputArray.length == 1) {
            return true;
        }
        
        boolean result = true;
        int[] sortedArray = Sudoku.sort(inputArray);
        for(int i=0; i<sortedArray.length-1; i++){
            int temp = inputArray[i];
            if(temp == inputArray[i+1]){
                return false;
            }
        }
        return result;
    }
    
    public static int[] getColumn(int[][] inputArray, int index){
        //error check
        if(inputArray==null || inputArray.length==0){
            return null;
        }
        
        for(int i=0; i<inputArray.length; i++){
            if(inputArray[i].length <= index){
                return null;
            }
        }
        
        int[] resultArray = new int[inputArray.length];
        for(int i=0; i<inputArray.length; i++){
            resultArray[i] = inputArray[i][index];
        }
        return resultArray;
    }
    
    public static int[] flatten(int[][] inputArray){
        //error check
        if(inputArray==null || inputArray.length==0){
            return null;
        }
        
        int[] resultArray = new int[inputArray.length*inputArray[0].length];
        int count = 0;
        for(int i=0; i<inputArray.length; i++){
            for(int j=0; j<inputArray[i].length; j++){
                resultArray[count+j] = inputArray[i][j];
            }
            count+=inputArray[i].length;
        }
        return resultArray;
    }
    
    public static int[][] subGrid(int[][] inputArray, int i, int j, int m){
        //error check
        if(inputArray==null || inputArray.length==0 || i<0 || j<0 || m<=0){
            return null;
        }
        
        int[][] resultArray = new int[m][m];
        int b=j;
        for(int l=0; l<resultArray.length; l++){
            for(int n=0; n<resultArray[l].length; n++){
//                System.out.println("l=" + l + " n=" + n);
//                System.out.println("a=" + a + " b=" + b);
//                System.out.println("input Array=" + inputArray[l][n]);
                resultArray[l][n] = inputArray[i][j];
                j++;
            }
            i++;
            j=b;
        }
        return resultArray;
    }
    
    public static boolean isSudoku(int[][] sudoku){
        if(sudoku==null || sudoku.length!=9){
            return false;
        }
        
        for(int i=0; i<sudoku.length; i++){
            if(sudoku[i].length!=9){
                return false;
            }
            if(!uniqueEntries(sudoku[i])||!uniqueEntries(getColumn(sudoku, i))){
                return false;
            }
        }
        
        for(int i=0; i<sudoku.length/3; i++){
            for(int j=0; j<sudoku.length/3; j++){
                //System.out.println("i=" + i+ " j=" + j);
                int[] temp = flatten(subGrid(sudoku, i*3, j*3, 3));
                //printArray(temp);
                if(!uniqueEntries(temp)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static void printArray(int[] inputArray){
        for(int i=0; i<inputArray.length; i++){
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }
}

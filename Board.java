package sudoku;

public class Board{
	

	public static int[] shuffle(int[] arr){
	    for(int x=0;x<arr.length;x++){
	      int i = (int)(Math.random()*arr.length);
	      int j = (int)(Math.random()*arr.length);
	            
	      int tmp = arr[i];
	      arr[i] = arr[j];
	      arr[j] = tmp;
	    }
	        
	    return arr;
	  }
	
	public int[][] initial_Board() {
		int[] row = {1,2,3,4};
		int[] row0 = shuffle(row);
		int[] row1 = {row0[2], row0[3], row0[0], row0[1]};
		int[] row2 = {row0[1], row0[0], row0[3], row0[2]};
		int[] row3 = {row0[3], row0[2], row0[1], row0[0]};
		int[][] board = {row0, row1, row2, row3};
		return board;
	
	}
	


}
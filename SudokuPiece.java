package Sudoku;

public class SudokuPiece {

    private int face_value;

    public SudokuPiece(int value){
        face_value = value;
    }

    public int valueOf(){
        return face_value;
    }
}

package Sudoku;

import java.util.Random;

public class SudokuBoard {

    private int SIZE = 4;
    private SudokuPiece[][] board;
    private SudokuPiece[][] right_board;
    private int level;

    public SudokuBoard(int l){
        level = l;
        board = new SudokuPiece[SIZE][SIZE];
        right_board = new SudokuPiece[SIZE][SIZE];

        //난이도에 따라 퍼즐보드 만들기

    }
    /**정답보드 만들기*/  //모르겠음
    public void rightBoard(){


        // 줄바꾸기

    }


}

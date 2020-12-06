import PuzzleGame.PuzzlePiece;

import java.util.Random;
import java.util.SimpleTimeZone;

public class SudokuBoard {

    private int SIZE = 4;
    public SudokuPiece[][] board;
    private SudokuPiece[][] right_board;
    private int level;


    public SudokuBoard(int l){
        level = l;
        board = new SudokuPiece[SIZE][SIZE];
        right_board = new SudokuPiece[SIZE][SIZE];
        rightBoard();

        //난이도에 따라 랜덤으로 퍼즐보드 만들기
        board = right_board;
        board[0][3] = new SudokuPiece(0);
        board[1][2] = new SudokuPiece(0);
        board[3][3] = new SudokuPiece(0);
        board[2][0] = new SudokuPiece(0);
        board[1][0] = new SudokuPiece(0);
        board[2][2] = new SudokuPiece(0);

    }
    /**정답보드 만들기*/  //모르겠음
    public void rightBoard() {
        for (int i = 0; i < SIZE; i++){
            right_board[0][i] = new SudokuPiece(i);
        }

        for (int i = 0; i < SIZE; i++{
            int a = (int)(Math.random() * SIZE);
            SudokuPiece tmp = right_board[0][a];

        }
    }


    public void fill(int n, int row, int col){
        board[row][col] = new SudokuPiece(n);
    }

    public SudokuPiece[][] contents() {
        SudokuPiece[][] answer = new SudokuPiece[SIZE][SIZE];
        for (int i = 0; i != SIZE; i = i + 1)
            for (int j = 0; j != SIZE; j = j + 1)
                answer[i][j] = right_board[i][j];
        return answer;
    }
}


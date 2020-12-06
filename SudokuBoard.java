import PuzzleGame.PuzzlePiece;

import java.util.Random;

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
    public void rightBoard(){
        for (int i = 1; i < 5; i++){
            SudokuPiece p = new SudokuPiece(i);
            right_board[0][i - 1] = p;
        }
        SudokuPiece p = new SudokuPiece(3);
        right_board[1][0] = p;
        SudokuPiece p1 = new SudokuPiece(4);
        right_board[1][1] = p1;
        SudokuPiece p2 = new SudokuPiece(1);
        right_board[1][2] = p2;
        SudokuPiece p3 = new SudokuPiece(2);
        right_board[1][3] = p3;

        SudokuPiece p4 = new SudokuPiece(2);
        right_board[2][0] = p4;
        SudokuPiece p5 = new SudokuPiece(1);
        right_board[2][1] = p5;
        SudokuPiece p6 = new SudokuPiece(4);
        right_board[2][2] = p6;
        SudokuPiece p7 = new SudokuPiece(3);
        right_board[2][3] = p7;

        for(int i = 1; i < 5; i++){
            SudokuPiece p8 = new SudokuPiece(i);
            right_board[3][4 - i] = p8;
        }

        //줄 랜덤 바꾸기
    }
    public SudokuPiece[][] contents() {
        SudokuPiece[][] answer = new SudokuPiece[SIZE][SIZE];
        for (int i = 0; i != SIZE; i = i + 1)
            for (int j = 0; j != SIZE; j = j + 1)
                answer[i][j] = right_board[i][j];
        return answer;
    }
}

import java.util.Random;
import java.util.SimpleTimeZone;

public class SudokuBoard {

    private int SIZE = 4;
    public SudokuPiece[][] board;
    private SudokuPiece[][] right_board;
    private int level;


    /**Constructor - SudokuBoard 초기 스도쿠 보드 설치
     * @param l - 스도쿠 난이도*/
    public SudokuBoard(int l){
        level = l;
        board = new SudokuPiece[SIZE][SIZE];
        right_board = new SudokuPiece[SIZE][SIZE];
        rightBoard(); //정답보드 생성

        // board 생성
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++){
                board[i][j] = new SudokuPiece(right_board[i][j].valueOf(),false);
            }

        // 난이도대로 board 뚫기
        int hole = 0;
        if (level == 1)
            hole = 6;
        else if(level == 2)
            hole = 8;
        else
            hole = 10;

        int count = 0;
        while (count < hole){
            int a = (int)(Math.random() * SIZE);
            int b = (int)(Math.random() * SIZE);

            if( !board[a][b].possible()){
                board[a][b].input_possible(true);
                board[a][b].getValue(0);
                count += 1;
            }


        }

    }
    /** rightBoard - 정답보드 만들기 */  //모르겠음
    public void rightBoard() {
        for (int i = 0; i < SIZE; i++){
            right_board[0][i] = new SudokuPiece(i+1,false);
        }
        //right_board[0][] 랜덤 배열
        for (int i = 0; i < SIZE; i++){
            int a = (int)(Math.random() * SIZE);
            SudokuPiece tmp1 = right_board[0][a];
            int b = (int)(Math.random() * SIZE);
            SudokuPiece tmp2 = right_board[0][b];
            right_board[0][a] = tmp2;
            right_board[0][b] = tmp1;
        }

        right_board[1][0] = new SudokuPiece(right_board[0][2].valueOf(),false);
        right_board[1][1] = new SudokuPiece(right_board[0][3].valueOf(),false);
        right_board[1][2] = new SudokuPiece(right_board[0][0].valueOf(),false);
        right_board[1][3] = new SudokuPiece(right_board[0][1].valueOf(),false);

        right_board[2][0] = new SudokuPiece(right_board[0][1].valueOf(),false);
        right_board[2][1] = new SudokuPiece(right_board[0][0].valueOf(),false);
        right_board[2][2] = new SudokuPiece(right_board[0][3].valueOf(),false);
        right_board[2][3] = new SudokuPiece(right_board[0][2].valueOf(),false);

        right_board[3][0] = new SudokuPiece(right_board[0][3].valueOf(),false);
        right_board[3][1] = new SudokuPiece(right_board[0][2].valueOf(),false);
        right_board[3][2] = new SudokuPiece(right_board[0][1].valueOf(),false);
        right_board[3][3] = new SudokuPiece(right_board[0][0].valueOf(),false);


        SudokuPiece[][] arr = new SudokuPiece[SIZE][SIZE];

        //줄 랜덤으로 바꾸기
        for(int i = 0; i%2==0&&i<SIZE; i++){
            if (Math.random() >= 0.5) {
                for (int j = 0; j < SIZE; j++) {
                    arr[i][j] = right_board[i][j];
                    right_board[i][j].getValue(right_board[i + 1][j].valueOf());
                    right_board[i + 1][j].getValue(arr[i][j].valueOf());
                }
            }
        }

        for(int i = 0; i%2==0&&i<SIZE; i++){
            if (Math.random() >= 0.5) {
                for (int j = 0; j < SIZE; j++) {
                    arr[j][i] = right_board[j][i];
                    right_board[j][i].getValue(right_board[j][i+1].valueOf());
                    right_board[j][i+1].getValue(arr[j][i].valueOf());
                }
            }
        }

    }


    /** fill - 입력받은 숫자 채우기
     * @param n - 채워넣을 숫자
     * @param row - 행
     * @param col - 열  */
    public void fill(int n, int row, int col){
            board[row][col].getValue(n);
    }



    /** contents - 정답보드 리턴 */
    public SudokuPiece[][] contents() {
        SudokuPiece[][] answer = new SudokuPiece[SIZE][SIZE];
        for (int i = 0; i != SIZE; i = i + 1)
            for (int j = 0; j != SIZE; j = j + 1)
                answer[i][j] = right_board[i][j];
        return answer;
    }

    /** user_contents - 사용자보드 리턴*/
    public SudokuPiece[][] user_contents() {
        SudokuPiece[][] answer = new SudokuPiece[SIZE][SIZE];
        for (int i = 0; i != SIZE; i = i + 1)
            for (int j = 0; j != SIZE; j = j + 1)
                answer[i][j] = board[i][j];
        return answer;
    }
}

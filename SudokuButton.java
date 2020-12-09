import javax.swing.*import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SudokuButton extends JButton implements ActionListener {

    private SudokuBoard model;
    private SudokuFrame view;
    private int row;
    private int col;

    /** SudokuButton - 컨트롤러
     *  @param m - 버튼위치의 행
     *  @param n - 버튼위치의 열*/
    public SudokuButton(SudokuBoard b, SudokuFrame f, int m, int n){
        model = b;
        view = f;
        row = m;
        col = n;
        addActionListener(this);
    }

    /** actionPerformed - '버튼 누르기' 액션 이벤트를 처리
     * @param e - 이벤트  */
    public void actionPerformed(ActionEvent e) {
        String s = getText();
        if (model.board[row][col].possible()) {
            int num = view.getSelection();
            if (num != 0){
                model.fill(num, row, col);
                view.update();
                }

            }
        }
}

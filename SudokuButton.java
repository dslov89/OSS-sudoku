import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;

public class SudokuButton extends JButton implements ActionListener {

    private SudokuBoard model;
    private SudokuFrame view;
    private int row;
    private int col;

    public SudokuButton(SudokuBoard b, SudokuFrame f, int m, int n){
        model = b;
        view = f;
        row = m;
        col = n;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String s = getText();
        if (model.board[row][col].valueOf() == 0) {
            int num = Integer.parseInt(JOptionPane.showInputDialog("1~4"));
            if (1 <= num && num <= 4) {
                //board 에 숫자입력
                model.fill(num, row, col);
                view.update();
            }
        }
    }
}

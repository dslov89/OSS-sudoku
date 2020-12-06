package Sudoku;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;

public class SudokuButton extends JButton implements ActionListener {

    private SudokuBoard board;
    private SudokuFrame view;

    public SudokuButton(SudokuBoard b, SudokuFrame f){
        board = b;
        view = f;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        String s = getText();
        int num = Integer.parseInt(s);

        if(1 <= num && num <= 4 ){
            //board 에 숫자입력

            //view update()
        }
    }
}

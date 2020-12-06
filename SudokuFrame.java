package Sudoku;


import PuzzleGame.PuzzleButton;

import javax.swing.*;
import java.awt.*;

public class SudokuFrame extends JFrame {

    private int SIZE = 4;
    private SudokuBoard board;
    private SudokuButton[][] button;
    private int button_size = 60;

    public SudokuFrame(SudokuBoard b) {
        board = b;
        button = new SudokuButton[SIZE][SIZE];
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(SIZE, SIZE));

        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                button[i][j] = new SudokuButton(board, this);
                cp.add(button[i][j]);
            }
        update();
        setTitle("Sudoku");
        setSize(SIZE * button_size + 10, SIZE * button_size + 10);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void update(){

    }
}

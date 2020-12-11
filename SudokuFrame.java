import javax.swing.*;


public class SudokuFrame extends JFrame {

    private int SIZE = 4;
    public SudokuBoard board;
    private SudokuButton[][] button;
    private int button_size = 60;

    private List[] list;
    private JList items;

    /** constructor - SudokuFrame 초기 보드 나타내기 */
    public SudokuFrame(SudokuBoard b) {
        board = b;
        button = new SudokuButton[SIZE][SIZE];
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 1));

        JPanel p = new JPanel(new GridLayout(SIZE,SIZE));
        // 보드 버튼배열 생성한 후, 패널 p에 추가
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                button[i][j] = new SudokuButton(board, this, i, j);
                p.add(button[i][j]);
            }

        cp.add(p);  //패널 p 넣음

        JPanel sp = new JPanel(new GridLayout(2,1));
        JPanel ap = new JPanel(new FlowLayout());
        List[] list = new List[SIZE];
        for (int i = 0; i < SIZE; i++){
            list[i] = new List(i);
        }
        items = new JList(list);
        ap.add(items);  //리스트 넣음

        JButton ok_button = new JButton("OK");
        ok_button.addActionListener( new OkButton(this, board));
        ap.add(ok_button);  //OK 버튼 넣음

        sp.add(ap);

        JLabel label = new JLabel("<html>STEP1 : 빈 보드 선택 <br><html>STEP2 : 숫자 선택 <br>STEP3 : 모든 빈 보드 입력 후 OK버튼 누르기");    //라벨 넣음
        sp.add(label);

        cp.add(sp);

        update();
        setTitle("Sudoku");
        setSize(SIZE * button_size + 40, SIZE * button_size + 250);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    /** getSelection - 선택된 리스트의 인덱스 + 1 리턴*/
    public int getSelection(){
        return items.getSelectedIndex() + 1;
    }


    /** update - 사용자 보드 업데이트*/
    public void update() {
        SudokuPiece[][] r = board.user_contents();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(!r[i][j].possible()) {
                    button[i][j].setBackground(Color.yellow);
                    button[i][j].setText("" + r[i][j].valueOf());
                }
                else if (r[i][j].possible() && r[i][j].valueOf() != 0){
                    button[i][j].setBackground(Color.white);
                    button[i][j].setText("" + r[i][j].valueOf());
                }
                else{
                    button[i][j].setBackground(Color.white);
                    button[i][j].setText("");
                }
            }
        }
    }
}

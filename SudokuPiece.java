public class SudokuPiece {

    private int face_value;
    private boolean input;

    /**Constructor - SudokuPiece - 스도쿠보드 조각을 만듬
     * @param value - 스도쿠 조각 위에 표시되는 값
     * @param a - 스도쿠 조각 위에 표시되는 값을 변경 가능한지 여부 */
    public SudokuPiece(int value, boolean a){
        face_value = value;
        input = a;
    }

    /** valueOf - 조각의 액면 값을 리턴  */
    public int valueOf(){
        return face_value;
    }

    /** getValue - 조각의 액면 값 변경
     *  @param n - 변경할 조각의 액면 값 */
    public void getValue(int n) {
        if (input) {
            face_value = n;
        }
    }

    /** input_possible - 조각의 액면 값 변경가능 여부를 받고 수정 */
    public void input_possible(boolean a){
        input = a;
    }

    /** possible - 조각의 액면 값 변경가능 여부를 리턴*/
    public boolean possible(){
        return input;
    }

}


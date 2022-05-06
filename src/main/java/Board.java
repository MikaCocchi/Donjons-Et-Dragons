public class Board {
    private Object[] board = new Object[64];
    private int position = 0;

    ///////////////GETTER and SETTER /////////////////
    public Object[] getBoard() {
        return board;
    }

    public void setBoard(Object[] board) {
        this.board = board;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    //////////////END GETTER and SETTER/////////////

    /**
     *
     * @param diceThrow An int which represent how far the character will move on the board
     */
    public void moveForward(int diceThrow) {
        int positionWithDiceThrow = this.getPosition() + diceThrow;
        if (positionWithDiceThrow < getBoard().length) {
            this.setPosition(positionWithDiceThrow);
            System.out.println("You are now placed at space : " + positionWithDiceThrow);
        } else {
            this.setPosition(positionWithDiceThrow);
            System.out.println("You have reached the edge of the board. Well done !");
        }

    }
}

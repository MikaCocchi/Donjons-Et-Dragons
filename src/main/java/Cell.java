import interfaces.BoardEvent;

/**
 * This class represent a cell of the board
 */
public class Cell {
    private BoardEvent randomEvent;

    public BoardEvent getRandomEvent() {
        return randomEvent;
    }
    public void setRandomEvent(BoardEvent randomEvent) {
        this.randomEvent = randomEvent;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "randomEvent=" + randomEvent +
                '}';
    }
}

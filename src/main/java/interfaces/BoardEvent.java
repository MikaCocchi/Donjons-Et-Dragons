package interfaces;


import character.heroes.Hero;
import Cell.Cell;

/**
 * An interface we can use to create a bond between all the classes considered as a board event
 */
public interface BoardEvent {
    boolean interactWithCell(Hero player, Cell cell);
}

package interfaces;


import character.heros.Hero;

/**
 * An interface we can use to create a bond between all the classes considered as a board event
 */
public interface BoardEvent {
    void interactWithCell(Hero player);
}

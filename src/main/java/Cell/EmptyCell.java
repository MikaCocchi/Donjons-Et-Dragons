package Cell;

import character.heroes.Hero;
import interfaces.BoardEvent;

public class EmptyCell implements BoardEvent {
    @Override
    public boolean interactWithCell(Hero player,Cell cell) {
        System.out.println(" _____                _                    _ _ \n" +
                "|  ___|              | |                  | | |\n" +
                "| |__ _ __ ___  _ __ | |_ _   _    ___ ___| | |\n" +
                "|  __| '_ ` _ \\| '_ \\| __| | | |  / __/ _ \\ | |\n" +
                "| |__| | | | | | |_) | |_| |_| | | (_|  __/ | |\n" +
                "\\____/_| |_| |_| .__/ \\__|\\__, |  \\___\\___|_|_|\n" +
                "               | |         __/ |               \n" +
                "               |_|        |___/               " +
                "\nYou just found an empty Cell ... ");
        return true;
    }
}

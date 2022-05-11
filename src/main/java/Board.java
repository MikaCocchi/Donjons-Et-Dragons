import character.enemies.Dragon;
import character.enemies.Enemy;
import character.enemies.Goblin;
import character.enemies.Warlock;
import character.heros.Hero;
import equipement.potion.BigHealingPotion;
import equipement.potion.HealingPotion;
import equipement.potion.StandardHealingPotion;
import equipement.weapon.*;

import java.util.Arrays;

/**
 * this is the game board and its functions
 */
public class Board {
    private Cell[] board = new Cell[64];
    private int position = 0;

    ///////////////GETTER and SETTER /////////////////
    public Cell[] getBoard() {
        return board;
    }

    public void setBoard(Cell[] board) {
        this.board = board;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    //////////////END GETTER and SETTER/////////////
    public Board() {
        for (int i = 0; i < board.length; i++) {
            Cell cell = new Cell();
            int random = (int) (Math.random() * 3);
            if (random == 0) {
                cell.setRandomEvent(randomEnemy());
            } else if (random == 1) {
                cell.setRandomEvent(randomWeapon());
            } else if (random == 2) {
                cell.setRandomEvent(randomPotion());
            }
            board[i] = cell;
        }
    }

    public Enemy randomEnemy() {
        Enemy enemy = null;
        int random = (int) (Math.random() * 3);
        if (random == 0) {
            enemy = new Goblin();
        } else if (random == 1) {
            enemy = new Warlock();
        } else if (random == 2) {
            enemy = new Dragon();
        }
        return enemy;
    }

    public Weapon randomWeapon() {
        int random = (int) (Math.random() * 4);
        Weapon weapon = null;
        if (random == 0) {
            weapon = new FireBall();
        } else if (random == 1) {
            weapon = new LightningBolt();
        } else if (random == 2) {
            weapon = new Sword();
        } else if (random == 3) {
            weapon = new stick();
        }
        return weapon;
    }

    public HealingPotion randomPotion() {
        HealingPotion potion = null;
        int random = (int) (Math.random() * 2);
        if (random == 0) {
            potion = new StandardHealingPotion();
        } else if (random == 1) {
            potion = new BigHealingPotion();
        }
        return potion;
    }

    /**
     * function moves the character, depending on the diceThrow
     *
     * @param diceThrow An int which represent how far the character will move on the board
     */
    public void moveForward(int diceThrow, Hero player) {
        int positionWithDiceThrow = this.getPosition() + diceThrow;
        try {
            setPosition(positionWithDiceThrow);
            playTheRound(board[positionWithDiceThrow], player);
            System.out.println("You are now placed at space : " + positionWithDiceThrow);
        } catch (Exception e) {
            this.setPosition(64);
            System.out.println("You have reached the edge of the board. Well done !" +
                    "\n             ___________\n" +
                    "            '._==_==_=_.'\n" +
                    "            .-\\:      /-.\n" +
                    "           | (|:.     |) |\n" +
                    "            '-|:.     |-'\n" +
                    "              \\::.    /\n" +
                    "               '::. .'\n" +
                    "                 ) (\n" +
                    "               _.' '._\n" +
                    "              `\"\"\"\"\"\"\"`");
        }
    }

    public void playTheRound(Cell cell, Hero player) {
        cell.getRandomEvent().interactWithCell(player);
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}

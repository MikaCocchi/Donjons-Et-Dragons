import character.enemies.Dragon;
import character.enemies.Enemy;
import character.enemies.Goblin;
import character.enemies.Warlock;
import character.heros.Hero;
import equipement.potion.BigHealingPotion;
import equipement.potion.HealingPotion;
import equipement.potion.StandardHealingPotion;
import equipement.weapon.*;
import character.Character;

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
        if (cell.getRandomEvent() instanceof Enemy) {
            //DISPLAY THE ENEMY YOU ARE FIGHTING
            System.out.println(((Enemy) cell.getRandomEvent()).getImage() + "\n You are fighting against a " + ((Enemy) cell.getRandomEvent()).getName());
            //Fight an Enemy
            while (player.getHeal() > 0 && ((Enemy) cell.getRandomEvent()).getHeal() > 0) {
                //ENEMY HEALTH MINUS PLAYER STRENGTH
                ((Enemy) cell.getRandomEvent()).setHeal(((Enemy) cell.getRandomEvent()).getHeal() - player.getStrength());
                if (((Enemy) cell.getRandomEvent()).getHeal() > 0) {
                    //CHARACTER HEALTH MINUS ENEMY STRENGTH
                    player.setHeal(player.getHeal() - ((Enemy) cell.getRandomEvent()).getStrength());
                    if (player.getHeal() <= 0) {
                        System.out.println("You have been defeated !\n" +
                                "  _____                         ____                 \n" +
                                " / ____|                       / __ \\                \n" +
                                "| |  __  __ _ _ __ ___   ___  | |  | |_   _____ _ __ \n" +
                                "| | |_ |/ _` | '_ ` _ \\ / _ \\ | |  | \\ \\ / / _ \\ '__|\n" +
                                "| |__| | (_| | | | | | |  __/ | |__| |\\ V /  __/ |   \n" +
                                " \\_____|\\__,_|_| |_| |_|\\___|  \\____/  \\_/ \\___|_|   ");
                        System.exit(0);
                    }
                } else {
                    System.out.println(((Enemy) cell.getRandomEvent()).getName() + " has been killed");
                }
            }
        } else if (cell.getRandomEvent() instanceof Weapon) {
            //DISPLAY THE WEAPON YOU FOUND
            System.out.println(((Weapon) cell.getRandomEvent()).getImage() + "\nyou just found a " + ((Weapon) cell.getRandomEvent()).getName());
            if (((Weapon) cell.getRandomEvent()).getClassType().equals(player.getClass().getSimpleName())) {
                player.setStrength(Math.min(player.getStrength() + ((Weapon) cell.getRandomEvent()).getAttackPower(), player.getMaxStrength()));
                if (player.getStrength() == player.getMaxStrength()) {
                    System.out.println("your strength is maxed out !");
                } else {
                    System.out.println("You just found a " + ((Weapon) cell.getRandomEvent()).getName() + " ,here is your strength : " + player.getStrength());
                }
            } else {
                System.out.println("You can't use this weapon");
            }
        } else if (cell.getRandomEvent() instanceof HealingPotion) {
            System.out.println(((HealingPotion) cell.getRandomEvent()).getImage() + "\nYou found a " + ((HealingPotion) cell.getRandomEvent()).getName());
            player.setHeal(Math.min(player.getHeal() + ((HealingPotion) cell.getRandomEvent()).getHealingAmount(), player.getMaxHeal()));
            if (player.getHeal() == player.getMaxHeal()) {
                System.out.println("your health is maxed out !");
            } else {
                System.out.println("You just drank a potion, here is your heal : " + player.getHeal());
            }
        }
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}

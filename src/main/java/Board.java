import enemies.Dragon;
import enemies.Enemy;
import enemies.Goblin;
import enemies.Warlock;
import equipement.potion.BigHealingPotion;
import equipement.potion.HealingPotion;
import equipement.potion.StandardHealingPotion;
import equipement.weapon.*;
import interfaces.BoardEvent;
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
            BoardEvent[] randomEvent = {randomEnemy(),randomWeapon(),randomPotion()};
            int random = (int) (Math.random() * 3);
            cell.setRandomEvent(randomEvent[random]);
            board[i] = cell;
        }
    }
    public Enemy randomEnemy() {
        Enemy[] possibilities = {new Goblin(), new Warlock(), new Dragon()};
        int random = (int) (Math.random() * 3);
        return possibilities[random];
    }
    public Weapon randomWeapon() {
        Weapon[] possibilities = {new FireBall(), new LightningBolt(), new Sword(), new Club()};
        int random = (int) (Math.random() * 4);
        return possibilities[random];
    }
    public HealingPotion randomPotion() {
        HealingPotion[] possibilities = {new StandardHealingPotion(), new BigHealingPotion()};
        int random = (int) (Math.random() * 2);
        return possibilities[random];
    }

    /**
     * function moves the character, depending on the diceThrow
     *
     * @param diceThrow An int which represent how far the character will move on the board
     */
    public void moveForward(int diceThrow, Character player) {
        int positionWithDiceThrow = this.getPosition() + diceThrow;
        try {
            this.setPosition(positionWithDiceThrow);
            System.out.println("You are now placed at space : " + positionWithDiceThrow);
            System.out.println("Cell : " + board[positionWithDiceThrow]);
            playTheRound(board[positionWithDiceThrow], player);
        } catch (Exception e) {
            this.setPosition(64);
            System.out.println("You have reached the edge of the board. Well done !");
        }
    }
    public void playTheRound(Cell cell, Character player){
        System.out.println("test "+ board[position].getRandomEvent());
        if (cell.getRandomEvent() instanceof Enemy){
            System.out.println("c'est un ennemi");

        } else if (cell.getRandomEvent() instanceof Weapon){
            System.out.println("you just found a "+ ((Weapon) cell.getRandomEvent()).getName());
            if(((Weapon) cell.getRandomEvent()).getClassType().equals(player.getClass().getSimpleName())){
                player.setStrength(Math.min(player.getStrength() + ((Weapon) cell.getRandomEvent()).getAttackPower(), player.getMaxStrength()));
                if (player.getStrength() == player.getMaxStrength()) {
                    System.out.println("your strength is maxed out !");
                } else {
                    System.out.println("You just found a "+ ((Weapon) cell.getRandomEvent()).getName() +" ,here is your strength : " + player.getStrength());
                }
            } else {
                System.out.println("You can't use this weapon");
            }
        } else if (cell.getRandomEvent() instanceof HealingPotion){
            System.out.println("You found a "+ ((HealingPotion) cell.getRandomEvent()).getName());
            player.setHeal(Math.min(player.getHeal()+((HealingPotion) cell.getRandomEvent()).getHealingAmount(),player.getMaxHeal()));
            if (player.getHeal() == player.getMaxHeal()){
                System.out.println("your health is maxed out !");
            } else {
                System.out.println("You just drank a potion, here is your heal : " +player.getHeal());
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

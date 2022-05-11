package character;

/**
 * a super class which contains all the stats a player's character need
 */
public abstract class Character {
    private int heal;
    private int strength;
    private String image;
    private String name;


    ///////////GETTER and SETTER

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}

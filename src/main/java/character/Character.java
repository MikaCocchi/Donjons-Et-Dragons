package character;

public abstract class Character {
    private int maxHeal;
    private int heal;
    private int maxStrength;
    private int strength;
    private String image;
    private String name;

    public int getMaxHeal() {
        return maxHeal;
    }

    public void setMaxHeal(int maxHeal) {
        this.maxHeal = maxHeal;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getMaxStrength() {
        return maxStrength;
    }

    public void setMaxStrength(int maxStrength) {
        this.maxStrength = maxStrength;
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
    /**
     * this function display all the character stats in the terminal
     * @param characterClass a string which contains the Class from which we want to display the informations
     */
    public void getAllStats(String characterClass) {
        String name = getName();
        System.out.println("Welcome new " + characterClass + " here are your statistics :");
        System.out.println("name : "+ name);
        System.out.println("health : " + getHeal());
        System.out.println("strength : " + getStrength());
    }
}

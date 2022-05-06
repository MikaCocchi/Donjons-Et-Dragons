package equipement.potion;
public abstract class HealingPotion {

    private String name;
    private int healingAmount;

    @Override
    public String toString() {
        return this.name + " " + this.healingAmount;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }
}

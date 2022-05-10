package equipement.potion;

import interfaces.BoardEvent;

public class StandardHealingPotion extends HealingPotion {
    public StandardHealingPotion() {
        setName("StandardHealingPotion");
        setHealingAmount(2);
    }
}

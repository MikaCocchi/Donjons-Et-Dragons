package interfaces;


import character.enemies.Dragon;
import character.enemies.Goblin;
import character.enemies.Warlock;
import character.heroes.Hero;
import Cell.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import equipement.defence.Philter;
import equipement.defence.Shield;
import equipement.potion.BigHealingPotion;
import equipement.potion.StandardHealingPotion;
import equipement.weapon.FireBall;
import equipement.weapon.LightningBolt;
import equipement.weapon.Stick;
import equipement.weapon.Sword;

/**
 * An interface we can use to create a bond between all the classes considered as a board event
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BigHealingPotion.class, name = "BigHealingPotion"),
        @JsonSubTypes.Type(value = StandardHealingPotion.class, name = "StandardHealingPotion"),
        @JsonSubTypes.Type(value = EmptyCell.class, name = "EmptyCell"),
        @JsonSubTypes.Type(value = Dragon.class, name = "Dragon"),
        @JsonSubTypes.Type(value = Goblin.class, name = "Goblin"),
        @JsonSubTypes.Type(value = Warlock.class, name = "Warlock"),
        @JsonSubTypes.Type(value = Philter.class, name = "Philter"),
        @JsonSubTypes.Type(value = Shield.class, name = "Shield"),
        @JsonSubTypes.Type(value = FireBall.class, name = "FireBall"),
        @JsonSubTypes.Type(value = LightningBolt.class, name = "LightningBolt"),
        @JsonSubTypes.Type(value = Sword.class, name = "Sword"),
        @JsonSubTypes.Type(value = Stick.class, name = "Stick"),


}

)public interface BoardEvent {
    boolean interactWithCell(Hero player, Cell cell, boolean useDefenceItem);
}

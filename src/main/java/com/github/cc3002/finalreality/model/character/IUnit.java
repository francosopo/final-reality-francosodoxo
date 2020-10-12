package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.UnitClass;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

/**
 * This represents a unit from the game. That is to say, the player's characters
 * and the enemies
 * */
public interface IUnit {
    /**
     * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
     * seconds before adding the character to the queue.
     */
    void waitTurn();

    /**
     * Add a unit to the queue
     * */
    void addToQueue();

    /**
     * Get the unit's name
     * */
    String getName();

    /**
     * Get the unit's class
     * */
    UnitClass getUnitClass();

    /**
     * Set the health points
     * */
    void setHealthPoints(int newValue);

    IUnit copy();

    /**
     * Get Health points
     * */
    int getHealthPoints();

    /**
     * Set this unit defense
     * */
    void setDefense(int i);

    int getDefense();
}

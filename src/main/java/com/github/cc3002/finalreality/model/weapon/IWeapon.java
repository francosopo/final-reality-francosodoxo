package com.github.cc3002.finalreality.model.weapon;
/**
 * This shows what a Weapon can do, whatever it is
 * */
public interface IWeapon {
    /**
     * Get the weapon's name
     * */
    String getName();

    /**
     * Get the weapon's damage
     * */
    int getDamage();

    /**
     * Get the weapon's weight
     * */
    abstract int getWeight();

    /**
     * Get the weapon's type*/
    WeaponType getType();

    IWeapon copy();
}
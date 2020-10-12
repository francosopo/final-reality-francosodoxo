package com.github.cc3002.finalreality.model.character;

import com.github.cc3002.finalreality.model.character.player.UnitClass;
import com.github.cc3002.finalreality.model.weapon.IWeapon;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Seguel
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Equips a weapon to the character.
   */
  void equip(IWeapon weapon);

  /**
   * Return this character's equipped weapon.
   */
  IWeapon getEquippedWeapon();

  /**
   * Returns this character's class.
   */
  UnitClass getUnitClass();

  /**
   * Returns this character defense
   * */
  int getDefense();


  void setDefense(int newDefense);
}

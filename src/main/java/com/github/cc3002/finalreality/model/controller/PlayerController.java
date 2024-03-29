package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.listeners.AttackToCharacterHandler;
import com.github.cc3002.finalreality.model.listeners.CharacterDeadHandler;
import com.github.cc3002.finalreality.model.weapon.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Flow;

public class PlayerController {
  private HashMap<String, ICharacter> playerCharacters;
  private HashMap<String, IWeapon> weapons;
  private PropertyChangeSupport noPlayersOnGame = new PropertyChangeSupport(this);
  private CharacterDeadHandler characterDeadHandler = new CharacterDeadHandler(this);
  private AttackToCharacterHandler attackToCharacterHandler;
  private int charactersAlive;
  private TurnController turnController;
  /**
   * Class to manage the player's actions
   */
  public PlayerController(TurnController turnController){
    playerCharacters = new HashMap<String,ICharacter>();
    weapons = new HashMap<String,IWeapon>();
    charactersAlive = 0;
    this.turnController = turnController;
  }

  /**
   * Add a listener to the property when all the characters are dead
   * @param listener
   */
  public void addNoPlayersOnGameListener(PropertyChangeListener listener){
    noPlayersOnGame.addPropertyChangeListener(listener);
  }

  /**
   * It is invoked when a character is dead
   */
  public void characterDead(ICharacter character){
    int oldCharactersAlive = charactersAlive;
    charactersAlive--;
    if(charactersAlive == 0){
      noPlayersOnGame.firePropertyChange("noCharactersOnGame",oldCharactersAlive,charactersAlive);
    }
    turnController.deleteCharacter(character);
  }

  /**
   * Add a created character to the player's ownership
   * @param character
   */
  public void add(ICharacter character) {
    playerCharacters.put(character.getName(),character);
    ((IUnit) character).addUnitDeadListener(characterDeadHandler);
    charactersAlive++;
  }

  /**
   * Check if a character, identified by their name, is in the player's ownership
   * @param name
   * @return
   */
  public boolean contains(String name) {
    return playerCharacters.containsKey(name);
  }

  /**
   * Get a character's name
   * @param character
   * @return
   */
  public String getName(ICharacter character) {
    return character.getName();
  }

  /**
   * Get a character's health points, identified by their name
   * @param name
   * @return
   */
  public int getHealthPoints(String name) {
    return ((IUnit) playerCharacters.get(name)).getHealthPoints();
  }

  /**
   * Get a character's defense identified by their name
   * @param name
   * @return
   */
  public int getDefense(String name) {
    return playerCharacters.get(name).getDefense();
  }

  public void tryToEquip(String name, IWeapon weapon){
    playerCharacters.get(name).tryToEquip(weapon);
  }


  /**
   * Get a black magician's weapon identified by their name
   * @param name
   * @return
   */
  public IWeaponBlack getBlackWeapon(String name) {
    return ((IBlackAllowedWeapons) playerCharacters.get(name)).getEquippedWeapon();
  }


  /**
   * Get a engineer's weapon identified by their name
   * @param engineerName
   * @return
   */
  public IWeaponEngineer getEngineerWeapon(String engineerName) {
    return ((IEngineerAllowedWeapons) playerCharacters.get(engineerName)).getEquippedWeapon();
  }



  /**
   * Get a knight's weapon identified by their name
   * @param knightName
   * @return
   */
  public IWeaponKnight getKnightWeapon(String knightName) {
    return ((IKnightAllowedWeapons) playerCharacters.get(knightName)).getEquippedWeapon();
  }



  /**
   * Get a thief's weapon identified by their name
   * @param thiefName
   * @return
   */
  public IWeaponThief getThiefWeapon(String thiefName) {
    return ((IThiefAllowedWeapons) playerCharacters.get(thiefName)).getEquippedWeapon();
  }




  /**
   * Get a white magician's weapon identified by their name
   * @param whiteMagicianName
   * @return
   */
  public IWeaponWhite getWhiteWeapon(String whiteMagicianName) {
    return  ((IWhiteAllowedWeapons) playerCharacters.get(whiteMagicianName)).getEquippedWeapon();
  }

  /**
   * Add a weapon to the player's inventory
   * @param weapon
   */
  public void addToInventory(IWeapon weapon) {
    weapons.put(weapon.getName(),weapon);
  }

  /**
   * Get a weapon from the inventory
   * @param name
   * @return
   */
  public IWeapon getFromInventory(String name) {
    return weapons.get(name);
  }

  /**
   * Get the number of characters that the player has, no matter if they are alive or dead.
   * To get the number of alive characters, use getCharactersAlive() method written bellow
   * @return
   */
  public int getNumberOfCharacters() {
    return playerCharacters.size();
  }

  /**
   * Get the number of alive characters the player has.
   * @return
   */
  public int getCharactersAlive() {
    return charactersAlive;
  }

  public ICharacter chooseCharacter() {
    ICharacter[] characters = (ICharacter[]) playerCharacters.values().toArray();
    Random rnd = new Random();
    int index = rnd.nextInt(5);
    return characters[index];
  }

  public AttackToCharacterHandler getAttackToCharacterHandler() {
    return attackToCharacterHandler;
  }

  public void addFlowController(FlowController flowController){
    attackToCharacterHandler = new AttackToCharacterHandler(this, flowController);
  }
}

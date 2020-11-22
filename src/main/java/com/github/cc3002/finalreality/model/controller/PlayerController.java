package com.github.cc3002.finalreality.model.controller;

import com.github.cc3002.finalreality.model.character.ICharacter;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;

import java.util.HashMap;

public class PlayerController {
  private HashMap<String, ICharacter> playerCharacters;

  public PlayerController(){
    playerCharacters = new HashMap<String,ICharacter>();
  }

  public void add(ICharacter character) {
    playerCharacters.put(character.getName(),character);
  }

  public boolean contains(String name) {
    return playerCharacters.containsKey(name);
  }

  public String getName(ICharacter character) {
    return character.getName();
  }

  public int getHealthPoints(String name) {
    return ((IUnit) playerCharacters.get(name)).getHealthPoints();
  }

  public int getDefense(String name) {
    return playerCharacters.get(name).getDefense();
  }

  public void equipBlack(String name, IWeaponBlack weapon) {
    ((IBlackAllowedWeapons) playerCharacters.get(name)).equip(weapon);
  }

  public IWeaponBlack getBlackWeapon(String name) {
    return ((IBlackAllowedWeapons) playerCharacters.get(name)).getEquippedWeapon();
  }

  public void equipEngineer(String engineerName, IWeaponEngineer weapon) {
    ((IEngineerAllowedWeapons) playerCharacters.get(engineerName)).equip(weapon);
  }

  public IWeaponEngineer getEngineerWeapon(String engineerName) {
    return ((IEngineerAllowedWeapons) playerCharacters.get(engineerName)).getEquippedWeapon();
  }

  public void equipKnight(String knightName, IWeaponKnight weapon) {
    ((IKnightAllowedWeapons) playerCharacters.get(knightName)).equip(weapon);
  }

  public IWeaponKnight getKnightWeapon(String knightName) {
    return ((IKnightAllowedWeapons) playerCharacters.get(knightName)).getEquippedWeapon();
  }

  public void equipThief(String thiefName, IWeaponThief weapon) {
    ((IThiefAllowedWeapons) playerCharacters.get(thiefName)).equip(weapon);
  }

  public IWeaponThief getThiefWeapon(String thiefName) {
    return ((IThiefAllowedWeapons) playerCharacters.get(thiefName)).getEquippedWeapon();
  }

  public void equipWhite(String whiteMagicianName, IWeaponWhite weapon) {
    ((IWhiteAllowedWeapons) playerCharacters.get(whiteMagicianName)).equip(weapon);
  }

  public IWeaponWhite getWhiteWeapon(String whiteMagicianName) {
    return  ((IWhiteAllowedWeapons) playerCharacters.get(whiteMagicianName)).getEquippedWeapon();
  }
}

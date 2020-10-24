package com.github.cc3002.finalreality.model;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.IUnit;
import com.github.cc3002.finalreality.model.character.player.*;
import com.github.cc3002.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.BlockingQueue;

public class AbstractSetUpTest {
  private BlackMagician blackMagician;
  private WhiteMagician whiteMagician;
  private Engineer engineer;
  private Knight knight;
  private Thief thief;
  private Enemy enemy;

  private IWeapon axe;
  private IWeapon bow;
  private IWeapon knife;
  private IWeapon staff;
  private IWeapon sword;

  private String BLACK_MAGICIAN_NAME;
  private String WHITE_MAGICIAN_NAME;
  private String ENGINEER_NAME;
  private String KNIGHT_NAME;
  private String THIEF_NAME;

  private String AXE_NAME;
  private String BOW_NAME;
  private String KNIFE_NAME;
  private String STAFF_NAME;
  private String SWORD_NAME;

  private int HEALTH_POINTS;
  private int DEFENSE_POINTS;
  private int DAMAGE;
  private int WEIGHT;

  private BlockingQueue<IUnit> turnsQueue;

  @BeforeEach
  public void setUp(){
    BLACK_MAGICIAN_NAME = "Javier";
    WHITE_MAGICIAN_NAME = "Rodrigo";
    ENGINEER_NAME = "Malu";
    KNIGHT_NAME = "Quijote";
    THIEF_NAME = "Andrea";

    AXE_NAME = "Basic Axe";
    BOW_NAME = "Basic Bow";
    KNIFE_NAME = "Basic knife";
    STAFF_NAME = "Basic Staff";
    SWORD_NAME = "Basic Sword";

    HEALTH_POINTS = 10;
    DEFENSE_POINTS = 4;
    DAMAGE = 5;
    WEIGHT = 2;

    blackMagician = new BlackMagician(BLACK_MAGICIAN_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    whiteMagician = new WhiteMagician(WHITE_MAGICIAN_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    engineer = new Engineer(ENGINEER_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    knight = new Knight(KNIGHT_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    thief = new Thief(THIEF_NAME, turnsQueue, HEALTH_POINTS, DEFENSE_POINTS);
    enemy = new Enemy("enemy1",10,getTurnsQueue(),10,7,6);

    axe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
    bow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
    knife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);
    staff = new Staff(STAFF_NAME, DAMAGE, WEIGHT);
    sword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
  }

  public BlackMagician getBlackMagician(){
    return blackMagician;
  }

  public Engineer getEngineer(){
    return engineer;
  }

  public Knight getKnight(){
    return knight;
  }

  public Thief getThief(){
    return thief;
  }

  public WhiteMagician getWhiteMagician(){
    return whiteMagician;
  }

  public Enemy getEnemy(){
    return enemy;
  }

  public IWeapon getAxe(){
    return axe;
  }

  public IWeapon getBow(){
    return bow;
  }

  public IWeapon getKnife(){
    return knife;
  }

  public IWeapon getStaff(){
    return staff;
  }

  public IWeapon getSword(){
    return sword;
  }

  public void setHealthPoints(int HEALTH_POINTS) {
    this.HEALTH_POINTS = HEALTH_POINTS;
  }

  public void setDefensePoints(int n){
    this.DEFENSE_POINTS = n;
  }

  public void setDamage(int n){
    this.DAMAGE = n;
  }

  public void setWeight(int WEIGHT) {
    this.WEIGHT = WEIGHT;
  }

  public BlockingQueue<IUnit> getTurnsQueue(){
    return turnsQueue;
  }
}

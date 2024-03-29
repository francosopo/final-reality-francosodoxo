package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnifeTest extends AbstractWeaponTest {
    private Knife knife;
    @BeforeEach
    public void setUp(){
        super.basicSetUp();
        knife = new Knife(super.getName(), super.getDamage(),super.getWeight());
    }
    @Test
    public void testCopy(){
        assertEquals(knife,knife.copy());
    }

    @Test
    public void testSameObject(){
        assertEquals(knife,knife);
    }
    @Test
    public void KnifeNotOtherKnifeTest(){
        assertNotEquals(knife, super.getOtherKnife());
    }
    public void KnifeNotAxeTest(){
        assertNotEquals(knife, super.getOtherAxe());
    }

    @Test
    public void KnifeNotBowTest(){
        assertNotEquals(knife,super.getOtherBow());
    }

    @Test
    public void KnifeNotNullTest(){
        assertNotEquals(knife,NullWeapon.getNullWeapon());
    }

    @Test
    public void KnifeNotStaffTest(){
        assertNotEquals(knife,super.getOtherStaff());
    }

    @Test
    public void KnifeNotSwordTest(){
        assertNotEquals(knife,super.getOtherSword());
    }

    @Test
    public void testKnifeType(){
        assertEquals(knife.getType(),WeaponType.KNIFE);
    }

    @Test
    public void testKnifeName(){
        Knife knife1 = new Knife("knife1",10,8);
        Knife knife2 = new Knife("knife2",10,8);
        assertNotEquals(knife1,knife2);
    }

    @Test
    public void testKnifeDamage(){
        Knife knife1 = new Knife("knife1",10,8);
        Knife knife2 = new Knife("knife1",8,8);
        assertNotEquals(knife1,knife2);
    }

    @Test
    public void testKnifeWeight(){
        Knife knife1 = new Knife("knife1",10,8);
        Knife knife2 = new Knife("knife1",10,5);
        assertNotEquals(knife1,knife2);
    }
}

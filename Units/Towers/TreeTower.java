package TowDef.Units.Towers;

import TowDef.GUI.GUI;
import TowDef.Map.MapCells.LandCell;
import TowDef.Units.Intruders.DarkIntruder;
import TowDef.Units.Intruders.FireIntruder;
import TowDef.Units.Intruders.Intruder;

import javax.jws.Oneway;

public class TreeTower extends Tower {
    private static final int BULLET_SPEED = 100;
    public static int[] costByLevel = new int[]{100, 100, 100};
    static int[] rangeByLevel = new int[]{7, 10, 12};
    static int[] damageByLevel = new int[]{20, 8, 9};
    static int[] timeStepByLevel = new int[]{10, 4, 3};
    public TreeTower(LandCell cell) {
        super(cell);

        value = costByLevel[0];
        highPerformance = DarkIntruder.class;
        lowPerformance = FireIntruder.class;
    }

    public int getCostByLevel(int index) {
        return costByLevel[index];
    }
    @Override
    public int getRangeByLevel(int index) {
        return rangeByLevel[index];
    }

    @Override
    public int getTimeStepByLevel(int index) {
        return timeStepByLevel[index];
    }

    @Override
    public int getDamageByLevel(int index) {
        return damageByLevel[index];
    }

    @Override
    public void SpecialAbilityAttacking(Intruder choice, int damage) {
        //stun
        choice.stun();
    }

    @Override
    public void fire(LandCell cell, Intruder choice, int damage) {
        //lazer
        GUI.getInstance().getGameGraphics().laserAnimation(this, choice, false);
        choice.damage(damage);

    }
}

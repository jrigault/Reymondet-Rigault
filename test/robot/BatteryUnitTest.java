package robot;


import org.junit.Assert;
import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;


public class BatteryUnitTest {


    // méthode chargeFunction en privée

    @Test
    public void testCharge(){
        Battery battery = new Battery();
        battery.charge();
        Assert.assertEquals(110,battery.getChargeLevel(),0);
    }

    @Test
    public void testSetUp(){
        // a faire
    }

    @Test
    public void testGetChargeLevel(){
        Battery battery = new Battery();
        Assert.assertEquals(100,battery.getChargeLevel(),0);
    }

    @Test
    public void testTimeToSufficientCharge(){
        Battery battery=new Battery();
        Assert.assertEquals(1000,battery.timeToSufficientCharge(110),0);
    }





}



package robot;


import org.junit.Assert;
import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;


public class BatteryUnitTest {


    // méthode chargeFunction en privée sera testé dans testCharge

    @Test
    public void testCharge(){
        Battery battery = new Battery();
        battery.charge();
        Assert.assertEquals(110,battery.getChargeLevel(),0);
    }

    // test la méthode use et setUp en même temps
    @Test (expected = InsufficientChargeException.class)
    public void testSetUp() throws InsufficientChargeException {
        Battery battery = new Battery();
        Assert.assertEquals(100,battery.getChargeLevel(),0);
        battery.use(50);
        Assert.assertEquals(50, battery.getChargeLevel(), 0);
        battery.setUp();
        Assert.assertEquals(50,battery.getChargeLevel(),0); // vérifie que la battery s'incrémente que à partir d'un certain temps
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {}}, 0, 1010);
        Assert.assertEquals(60, battery.getChargeLevel(), 0); // bug de rare fois, à cause du Timer
        battery.use(100);
    }

    @Test
    public void testGetChargeLevel(){
        Battery battery = new Battery();
        Assert.assertEquals(100,battery.getChargeLevel(),0);
    }

    @Test
    public void testTimeToSufficientCharge(){
        Battery battery=new Battery();
        Assert.assertEquals(1000,battery.timeToSufficientCharge(110),0); // test chargeFunction en même temps
    }

    @Test
    public void testCanDeliver(){
        Battery battery=new Battery();
        Assert.assertTrue(battery.canDeliver(100));
        Assert.assertFalse(battery.canDeliver(110));
    }
}



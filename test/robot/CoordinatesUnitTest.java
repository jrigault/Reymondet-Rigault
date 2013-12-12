package robot;

import org.junit.Assert;
import org.junit.Test;


public class CoordinatesUnitTest {

    @Test
    public void TestGet(){
        Coordinates coord=new Coordinates(5,6);
        Assert.assertEquals(5,coord.getX(),0);
        Assert.assertEquals(6,coord.getY(),0);
    }
}

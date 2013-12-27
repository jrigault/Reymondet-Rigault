package robot;


import org.junit.Assert;
import org.junit.Test;

public class InsufficientChargeExceptionUnitTest {

    @Test (expected = InsufficientChargeException.class)
    public void testInsufficientChargeException() throws InsufficientChargeException {
        Battery battery = new Battery();
        Assert.assertEquals(100, battery.getChargeLevel(), 0);
        battery.use(120);
    }


}

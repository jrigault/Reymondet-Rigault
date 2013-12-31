package robot;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoadBookUnitTest {

    @Test
    public void testHasInstruction(){
        List instructions = new ArrayList<Instruction>();
        instructions.add(Instruction.TURNLEFT);
        instructions.add(Instruction.FORWARD);
        RoadBook book= new RoadBook(instructions);
        Assert.assertTrue(book.hasInstruction());

        List instructions2 = new ArrayList<Instruction>();
        RoadBook book2= new RoadBook(instructions2);
        Assert.assertFalse(book2.hasInstruction());
    }

    @Test
    public void testNext(){
        List instructions = new ArrayList<Instruction>();
        instructions.add(Instruction.TURNLEFT);
        instructions.add(Instruction.FORWARD);
        RoadBook book= new RoadBook(instructions);
        Assert.assertEquals(Instruction.TURNLEFT,book.next());
        Assert.assertEquals(Instruction.FORWARD,book.next());
    }
}

package pieces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author crist
 */
public class HorseTest {

    /**
     * Test of move method, of class Horse.
     */
    @Test
    public void testMove() {
        System.out.println("Line Up Right...");
        int from_row = 2;
        int from_col = 3;
        int to_row = 4;
        int to_col = 4;
        String color = "";
        Horse instance = new Horse();
        boolean expResult = true;
        boolean result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("Fail: Move Line Up Right");
        }
        
        System.out.println("Line Down Right...");
        from_row = 2;
        from_col = 3;
        to_row = 0;
        to_col = 4;
        color = "";
        instance = new Horse();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("Fail: Move Line Down Right");
        }
        
        System.out.println("Line Up Left...");
        from_row = 2;
        from_col = 3;
        to_row = 4;
        to_col = 2;
        color = "";
        instance = new Horse();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("Fail: Move Line Up Left");
        }
        
        System.out.println("Line Down Left...");
        from_row = 2;
        from_col = 3;
        to_row = 0;
        to_col = 2;
        color = "";
        instance = new Horse();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("Fail: Move Line Down Left");
        }
        
        System.out.println("Line Right Up...");
        from_row = 2;
        from_col = 3;
        to_row = 3;
        to_col = 5;
        color = "";
        instance = new Horse();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("Fail: Move Line Right Up");
        }
        
        System.out.println("Line Right Down...");
        from_row = 2;
        from_col = 3;
        to_row = 1;
        to_col = 5;
        color = "";
        instance = new Horse();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("Fail: Move Line Right Down");
        }
        
        System.out.println("Line Left Up...");
        from_row = 2;
        from_col = 3;
        to_row = 3;
        to_col = 1;
        color = "";
        instance = new Horse();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("Fail: Move Line Left Up");
        }
        
        System.out.println("Line Left Down...");
        from_row = 2;
        from_col = 3;
        to_row = 1;
        to_col = 1;
        color = "";
        instance = new Horse();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("Fail: Move Line Left Down");
        }
    }
}

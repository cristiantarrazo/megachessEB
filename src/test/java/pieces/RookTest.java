package pieces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Cristian Tarrazó
 */
public class RookTest {

    /**
     * Test of move method, of class Rook.
     */
    @Test
    public void testMove() {
        System.out.println("Move Line Up...");
        int from_row = 14;
        int from_col = 1;
        int to_row = 15;
        int to_col = 1;
        String color = "";
        Rook instance = new Rook();
        boolean expResult = true;
        boolean result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("Fail: Move Line Up");
        }
        
        System.out.println("Move Line Down...");
        from_row = 14;
        from_col = 1;
        to_row = 3;
        to_col = 1;
        color = "";
        instance = new Rook();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("Fail: Move Line Down");
        }
        
        System.out.println("Move Line Right...");
        from_row = 14;
        from_col = 1;
        to_row = 14;
        to_col = 15;
        color = "";
        instance = new Rook();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("Fail: Move Line Right");
        }
        
        System.out.println("Move Line Left...");
        from_row = 14;
        from_col = 1;
        to_row = 14;
        to_col = 0;
        color = "";
        instance = new Rook();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("Fail: Move Line Left");
        }
    }
    
}

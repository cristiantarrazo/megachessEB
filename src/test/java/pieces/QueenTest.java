package pieces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Cristian Tarrazó
 */
public class QueenTest {

    /**
     * Test of move method, of class Queen.
     */
    @Test
    public void testMove() {
        System.out.println("Move Line Up...");
        int from_row = 7;
        int from_col = 6;
        int to_row = 12;
        int to_col = 6;
        String color = "";
        Queen instance = new Queen();
        boolean expResult = true;
        boolean result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("Fail: Move Line Up");
        }
        
        System.out.println("Move Line Down...");
        from_row = 8;
        from_col = 6;
        to_row = 3;
        to_col = 6;
        color = "";
        instance = new Queen();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("Fail: Move Line Down");
        }
        
        System.out.println("Move Line Left...");
        from_row = 8;
        from_col = 6;
        to_row = 8;
        to_col = 0;
        color = "";
        instance = new Queen();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("Fail: Move Line Left");
        }
        
        System.out.println("Move Line Right...");
        from_row = 8;
        from_col = 6;
        to_row = 8;
        to_col = 15;
        color = "";
        instance = new Queen();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("Fail: Move Line Right");
        }
        
        System.out.println("Move Diagonal Left Down...");
        from_row = 8;
        from_col = 6;
        to_row = 5;
        to_col = 3;
        color = "";
        instance = new Queen();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("Fail: Move Diagonal Left Down");
        }
        
        System.out.println("Move Diagonal Left Up...");
        from_row = 7;
        from_col = 8;
        to_row = 11;
        to_col = 4;
        color = "";
        instance = new Queen();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("Fail: Move Diagonal Left Up");
        }
        
        System.out.println("Move Diagonal Right Down...");
        from_row = 8;
        from_col = 6;
        to_row = 4;
        to_col = 10;
        color = "";
        instance = new Queen();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("Fail: Move Diagonal Right Down");
        }
        
        System.out.println("Move Diagonal Right Up...");
        from_row = 7;
        from_col = 10;
        to_row = 11;
        to_col = 14;
        color = "";
        instance = new Queen();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("Fail: Move Diagonal Right Up");
        }
    }
}

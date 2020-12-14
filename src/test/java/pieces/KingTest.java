/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import transfer.DTOMovement;

/**
 *
 * @author crist
 */
public class KingTest {

    /**
     * Test of move method, of class King.
     */
    @Test
    public void testMove() {
        System.out.println("Move Line Up...");
        int from_row = 1;
        int from_col = 7;
        int to_row = 2;
        int to_col = 7;
        String color = "black";
        King instance = new King();
        boolean expResult = true;
        boolean result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
        
        System.out.println("Move Line Down...");
        from_row = 1;
        from_col = 7;
        to_row = 0;
        to_col = 7;
        color = "black";
        instance = new King();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
        
        System.out.println("Move Line Right...");
        from_row = 1;
        from_col = 7;
        to_row = 1;
        to_col = 8;
        color = "black";
        instance = new King();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
        
        System.out.println("Move Line Left...");
        from_row = 1;
        from_col = 7;
        to_row = 1;
        to_col = 6;
        color = "black";
        instance = new King();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
        
        System.out.println("Move Diagonal Up Right...");
        from_row = 1;
        from_col = 7;
        to_row = 2;
        to_col = 8;
        color = "black";
        instance = new King();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
        
        System.out.println("Move Diagonal Up Left...");
        from_row = 1;
        from_col = 7;
        to_row = 2;
        to_col = 6;
        color = "black";
        instance = new King();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
        
        System.out.println("Move Diagonal Down Right...");
        from_row = 1;
        from_col = 7;
        to_row = 0;
        to_col = 8;
        color = "black";
        instance = new King();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
        
        System.out.println("Move Diagonal Down Left...");
        from_row = 1;
        from_col = 7;
        to_row = 0;
        to_col = 6;
        color = "black";
        instance = new King();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
}

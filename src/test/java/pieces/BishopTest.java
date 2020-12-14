/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Cristian Tarrazó
 */
public class BishopTest {
    /**
     * Test of move method, of class Bishop.
     */
    @Test
    public void testMove() {
        System.out.println("Move Diagonal Left Down...");
        int from_row = 8;
        int from_col = 6;
        int to_row = 5;
        int to_col = 3;
        String color = "";
        Bishop instance = new Bishop();
        boolean expResult = true;
        boolean result = instance.move(from_row, from_col, to_row, to_col, color);
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
        instance = new Bishop();
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
        instance = new Bishop();
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
        instance = new Bishop();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("Fail: Move Diagonal Right Up");
        }
    }
}
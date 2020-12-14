/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author crist
 */
public class PawnTest {
    
    public PawnTest() {
    }

    /**
     * Test of move method, of class Pawn.
     */
    @org.junit.jupiter.api.Test
    public void testMove() {
        //Black
        System.out.println("Black move one step in line...");
        int from_row = 3;
        int from_col = 6;
        int to_row = 4;
        int to_col = 6;
        String color = "black";
        Pawn instance = new Pawn();
        boolean expResult = true;
        boolean result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
        
        System.out.println("Black move two step in line...");
        from_row = 3;
        from_col = 6;
        to_row = 5;
        to_col = 6;
        color = "black";
        instance = new Pawn();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
        
        System.out.println("Black move one step left...");
        from_row = 3;
        from_col = 6;
        to_row = 4;
        to_col = 5;
        color = "black";
        instance = new Pawn();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
        
        System.out.println("Black move one step right...");
        from_row = 3;
        from_col = 6;
        to_row = 4;
        to_col = 7;
        color = "black";
        instance = new Pawn();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
        
        //White
        System.out.println("White move one step in line...");
        from_row = 12;
        from_col = 6;
        to_row = 11;
        to_col = 6;
        color = "white";
        instance = new Pawn();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
        
        System.out.println("White move two step in line...");
        from_row = 12;
        from_col = 6;
        to_row = 10;
        to_col = 6;
        color = "white";
        instance = new Pawn();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
        
        System.out.println("White move one step left...");
        from_row = 12;
        from_col = 6;
        to_row = 11;
        to_col = 5;
        color = "white";
        instance = new Pawn();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
        
        System.out.println("White move one step right...");
        from_row = 12;
        from_col = 6;
        to_row = 11;
        to_col = 7;
        color = "white";
        instance = new Pawn();
        expResult = true;
        result = instance.move(from_row, from_col, to_row, to_col, color);
        assertEquals(expResult, result);
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
}

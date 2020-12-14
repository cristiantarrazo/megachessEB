package strategy;

import transfer.DTOMovement;

/**
 *
 * @author Cristian Tarrazó
 */
public interface IStrategy {
    
    public DTOMovement moveStrategy (String board, String color);
    
}

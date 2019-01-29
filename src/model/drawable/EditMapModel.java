package model.drawable;

import java.util.ArrayList;

/**
  * The class <code>EditMapModel</code> represents the model of the edit map
  * @version 1.0
  * @author Dorian Terbah 
**/

public class EditMapModel {

    /**
     * Boolean to know if the view must to display the tiles or not
     */
    private boolean canDisplayTiles;

    public EditMapModel() { 
        this.canDisplayTiles = true; //default value
    }

    /***************************** 
    ************GETTER************
    *****************************/
    public boolean canDisplayTiles() {
        return this.canDisplayTiles;
    }

    /***************************** 
    ************SETTER************
    *****************************/
    public void canDisplayTiles(boolean canDisplayTiles) {
        this.canDisplayTiles = canDisplayTiles;
    }
}
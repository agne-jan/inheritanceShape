
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.geom.*;
import java.awt.Graphics2D;

/**
 * Class LithuanianFlag is a class that inherits all data members
 * and methods from Shape class and draws a Lithuanian flag.
 *
 * @author Agne Januskeviciute
 * @version 2020-05-04
 */
public class LithuanianFlag extends Shape
{
    //flag variables
    private int flagWidth;
    private int flagHeight;
    
    /**
     * LithuanianFlag (int x, int y)
     * ___________________________________________
     * Constructor for class LithuanianFlag that takes two
     * ints as parameters as required by Shape class.
     * 
     * PRE: x, y must be valid positive integers
     * POST: x and y will be set, flagHeight and flagWidth
     * will be set to a default 10 and 30 respectively.
     * 
     * @param int x, int y
     */
    public LithuanianFlag (int x, int y)
    {
      super (x, y);
      this.flagHeight = 10;
      this.flagWidth = 30;
    }
    
    /**
     * LithuanianFlag (int x, int y, int flagHeight, int flagWidth)
     * ___________________________________________
     * Constructor for class LithuanianFlag that takes 
     * two ints as parameters as required by Shape class
     * and two ints for flag height and width.
     * 
     * PRE: x, y, flagHeight and flagWidth must be valid 
     * positive integers.
     * POST: x, y, flagHeight and flagWidth will be set.
     * 
     * @param int x, int y, int flagHeight, int flagWidth
     */
    public LithuanianFlag (int x, int y, int flagHeight, int flagWidth)
    {
      super (x, y);
      
      if (flagHeight > 0 && flagWidth > 0)
      {
        this.flagHeight = flagHeight;
        this.flagWidth = flagWidth;
      } 
      else
      {
        System.out.println("Invalid flagHeight or flagWidth. Setting height and width to 10 and 30.");
        this.flagHeight = 10;
        this.flagWidth = 30;
      }
    }

    /**
     * getFlagWidth ()
     * _________________________________________
     * Returns the flag width.
     * 
     * @return int flagWidth
     */
    public int getFlagWidth()
    {
        return this.flagWidth;
    }
    
    /**
     * getFlagHeight ()
     * _________________________________________
     * Returns the flag height.
     * 
     * @return int flagheight
     */
    public int getFlagHeight()
    {
        return this.flagHeight;
    }
    
    /**
     * setFlagWidth(int flagWidth)
     * ___________________________________________
     * Sets flagWidth. 
     * 
     * PRE: flagWidth must be a valid positive integer.
     * POST: sets the new flagWidth.
     * 
     * @param int flagWidth
     */
    public void setFlagWidth(int flagWidth)
    {
        if (flagWidth > 0)
        this.flagWidth = flagWidth;
        else System.out.println("Invalid width!");
    }
    
    /**
     * setFlagHeight (int flagHeight)
     * ___________________________________________
     * Sets flagHeight. 
     * 
     * PRE: flagHeight must be a valid positive integer.
     * POST: sets the new flagHeight.
     * 
     * @param int flagHeight
     */
     public void setFlagHeight(int flagHeight)
    {
        if (flagHeight > 0)
        this.flagHeight = flagHeight;
        else System.out.println("Invalid height!");
    }
    
    @Override
    /**
     * getArea ()
     * _____________________________________
     * This method overrides Shape's getArea
     * method and returns the area of the flag.
     * 
     * @return double area
     */
    public double getArea()
    {
        return this.flagHeight * this.flagWidth;
    }
    
    @Override
    
    /**
     * draw (Graphics g)
     * _____________________________________
     * This method draws the flag using Graphics2D method.
     * Example taken from Spray class that was provided.
     * 
     * PRE: Graphics object must be valid.
     * POST: paints a Lithuanian flag on the screen.
     * 
     * @param Graphics g
     */
    public void draw (Graphics g)
    {
      Graphics2D g2d = (Graphics2D) g;
        
      final int x = getX();
      final int y = getY();
      final int width = getFlagWidth();
      final int height = getFlagHeight();
      
      g2d.setColor(Color.YELLOW);
 
      //g2d.draw(new Rectangle2D.Double(x, y, this.flagWidth, this.flagHeight/3));
      g2d.fill(new Rectangle2D.Double(x, y, width, height/3));
    

      g2d.setColor(Color.GREEN);
    
      //g2d.draw(new Rectangle2D.Double(x, y+this.flagHeight/3, this.flagWidth, this.flagHeight/3));
      g2d.fill(new Rectangle2D.Double(x, y+height/3, width, height/3));
    
      g2d.setColor(Color.RED);
    
      //g2d.draw(new Rectangle2D.Double(x, y+2*this.flagHeight/3, this.flagWidth, this.flagHeight/3));
      g2d.fill(new Rectangle2D.Double(x, y+2*height/3, width, height/3));   
    }
    
    @Override
    /**
     * toString()
     * __________________________________
     * Overrides toString method and returns
     * representation of this class.
     * 
     * @return String
     */
    public String toString() 
    {
        return "This is a Lithuanian flag at coordinates (" + getX() + "," + getY() + ")" + 
        " that has height " + getFlagHeight() + " and width " + getFlagWidth() + " with an area of " + 
        getArea() + ".";
    }
    
    @Override
    /**
     * equals(Object o)
     * ___________________________________
     * Overrides equals method and returns true
     * if objects are the same and false if 
     * they are not.
     * 
     * @return true/false
     */
    public boolean equals(Object o)
    {
        if (o != null && o.toString().equals(this.toString()))
        return true;
        else return false;
    }
}

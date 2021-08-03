
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.geom.*;
import java.awt.Graphics2D;

/**
 * Class House inherits all the data members and methods from Shape class and
 * draws .
 *
 * @author Agne Januskeviciute
 * @version 2020-05-04
 */
public class House extends Shape
{
    //all values will be manipulated from one
    private int houseWidth;
    
    /**
     * House (int x, int y)
     * ___________________________________________
     * Constructor for class House that takes two
     * ints as parameters as required by Shape class.
     * 
     * PRE: x, y must be valid positive integers
     * POST: x and y will be set and house width will be set
     * to a default 10.
     * 
     * @param int x, int y
     */
     public House (int x, int y)
    {
        super (x, y);
        this.houseWidth = 10;
    }
    
    /**
     * House(int x, int y, int houseWidth)
     * ___________________________________________
     * Constructor for class House that takes two
     * ints as parameters as required by Shape class
     * and an int for radius.
     * 
     * PRE: x, y and houseWidth must be valid positive integers.
     * POST: x, y and houseWidth will be set.
     * 
     * @param int x, int y
     */
    public House(int x, int y, int houseWidth)
    {
        super (x, y);
        if (houseWidth > 0)
          this.houseWidth = houseWidth;
        else 
        {
           System.out.println("Invalid houseWidth. Setting houseWidth to 10.");
           this.houseWidth = 10;
        }      
    }

    /**
     * getWidth ()
     * _________________________________________
     * Returns the houseWidth.
     * 
     * @return int houseWidth
     */
    public int getWidth ()
    {
        return this.houseWidth;        
    }
    
    /**
     * setWidth (int houseWidth)
     * ___________________________________________
     * Sets houseWidth. 
     * 
     * PRE: houseWidth must be a valid positive integer.
     * POST: sets the new houseWidth.
     * 
     * @param double radius
     */
    public void setWidth (int houseWidth)
    {
        if (houseWidth > 0)
          this.houseWidth = houseWidth;
        else System.out.println("Invalid houseWidth!");
    }
    
    @Override
    
    /**
     * getArea ()
     * _____________________________________
     * This method overrides Shape's getArea
     * method and returns the area of the house.
     * 
     * Area is calculated by calculating the 
     * area of the main frame + roof.
     * 
     * @return double area
     */
    
    public double getArea()
    {
        return this.houseWidth * this.houseWidth + this.houseWidth * 0.5 * (houseWidth/2);
    }
    
    @Override
    
    /**
     * draw (Graphics g)
     * _____________________________________
     * This method draws the House using Graphics2D method.
     * Example taken from Spray class that was provided.
     * 
     * PRE: Graphics object must be valid.
     * POST: paints a house on the screen.
     * 
     * @param Graphics g
     */
    public void draw (Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        
        final int x = getX();
        final int y = getY();
        final int houseWidth = getWidth();
        
	//main frame:
	g2d.setColor(Color.GREEN);
	g2d.fill(new Rectangle2D.Double(x, y, houseWidth, houseWidth));
	
	//window:
	g2d.setColor(Color.CYAN);
	g2d.fill(new Rectangle2D.Double(x+(houseWidth/2), y+(houseWidth/5), houseWidth/4, (houseWidth)/4));
	
	//door:
	g2d.setColor(Color.DARK_GRAY);
	g2d.fill(new Rectangle2D.Double(x+5, y+(houseWidth)/2, houseWidth/4, (houseWidth)/2));
	
	//roof (https://stackoverflow.com/questions/675878/how-to-fill-color-on-triangle):
        int xPoints[] = {x,x+houseWidth/2,x+houseWidth};
        int yPoints[] = {y,y-houseWidth/2,y};
        int npoints = xPoints.length;
      
        g2d.setColor(Color.RED);
        g.fillPolygon(xPoints, yPoints, npoints);//paints a polygon
        
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
        return "This is a house at coordinates (" + getX() + "," + getY() + ")" + 
        " that is drawn with house width of " + getWidth() + " to shape a house with an area of " + 
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

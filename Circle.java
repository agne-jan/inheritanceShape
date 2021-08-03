
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.geom.*;

/**
 * Class Circle is a class that inherits Shape data members and methods
 * and draws a circle. 
 *
 * @author Agne Januskeviciute
 * @version 2020-05-04
 */
public class Circle extends Shape
{
    //instance variables:
    private final double PI = Math.PI; //PI cannot be changed ever.
    private double radius = 10;
    
    /**
     * Circle (int x, int y)
     * ___________________________________________
     * Constructor for class Circle that takes two
     * ints as parameters as required by Shape class.
     * 
     * PRE: x, y must be valid positive integers
     * POST: x and y will be set and radius will be set
     * to a default 10.
     * 
     * @param int x, int y
     */
     public Circle (int x, int y)
    {
        super (x, y);
        this.radius = 10;
    }
    
    /**
     * Circle (int x, int y, double radius)
     * ___________________________________________
     * Constructor for class Circle that takes two
     * ints as parameters as required by Shape class
     * and a double for radius.
     * 
     * PRE: x, y must be valid positive integers and 
     * radius must be a valid positive double.
     * POST: x, y and radius will be set.
     * 
     * @param int x, int y
     */
    public Circle (int x, int y, double radius)
    {
        super (x, y);
        
        if (radius > 0)
          this.radius = radius;
        else 
        {
           System.out.println("Invalid radius. Setting radius to 10.");
           this.radius = 10;
        }
    }
    
    /**
     * getRadius ()
     * _________________________________________
     * Returns the radius.
     * 
     * @return double radius
     */
    public double getRadius ()
    {
        return this.radius;        
    }
    
    /**
     * setRadius (double radius)
     * ___________________________________________
     * Sets radius. 
     * 
     * PRE: radius must be a valid positive double.
     * POST: sets the new radius.
     * 
     * @param double radius
     */
    public void setRadius (double radius)
    {
        if (radius > 0)
          this.radius = radius;
        else System.out.println("Invalid radius!");
    }
    
    @Override 
    
    /**
     * getArea ()
     * _____________________________________
     * This method overrides Shape's getArea
     * method and returns the area of the circle.
     * 
     * @return double area
     */
    public double getArea ()
    {
        return this.PI * this.radius * this.radius;
    }
    
    @Override
    
    /**
     * draw (Graphics g)
     * _____________________________________
     * This method draws the Circle using Graphics2D method.
     * Example taken from Spray class that was provided.
     * 
     * PRE: Graphics object must be valid.
     * POST: paints a circle on the screen.
     * 
     * @param Graphics g
     */
    public void draw (Graphics g)
    {
      Graphics2D g2d = (Graphics2D) g; //creating Graphics2D object
      
      //setting the values:
      final int x = getX();
      final int y = getY();
      final double radius = getRadius();
    
      g2d.setColor(Color.BLUE); //setting colors
      
      //drawing:
      g2d.draw(new Ellipse2D.Double(x, y, radius, radius));
      g2d.fill(new Ellipse2D.Double(x, y, radius, radius));
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
        return "This is a circle at coordinates (" + getX() + "," + getY() + ")" + 
        " that is drawn with radius " + getRadius() + " to shape a circle with an area of " + 
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

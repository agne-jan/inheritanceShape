
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.geom.*;
import java.awt.Graphics2D;

/**
 * Class UFO inherits Shape's data members and methods and draws a flying alien ship.
 *
 * @author Agne Januskeviciute
 * @version 2020-05-04
 */
public class UFO extends Shape
{
    //since all the shapes are tied to a circle, only one variable is needed.
    //Saucer is technically a radius but this name is more fun.
    private int saucer;

    /**
     * UFO (int x, int y)
     * ___________________________________________
     * Constructor for class UFO that takes two
     * ints as parameters as required by Shape class.
     * 
     * PRE: x, y must be valid positive integers
     * POST: x and y will be set and saucer will be set
     * to a default 10.
     * 
     * @param int x, int y
     */
     public UFO (int x, int y)
    {
        super (x, y);
        this.saucer = 10;
    }
    
    /**
     * UFO (int x, int y, int saucer)
     * ___________________________________________
     * Constructor for class UFO that takes two
     * ints as parameters as required by Shape class
     * and an int for saucer.
     * 
     * PRE: x, y and saucer must be valid positive integers.
     * POST: x, y and saucer will be set.
     * 
     * @param int x, int y, int saucer
     */
    public UFO (int x, int y, int saucer)
    {
        super (x, y);
        if (saucer > 0)
          this.saucer = saucer;
        else 
        {
           System.out.println("Invalid saucer size. Setting saucer to 10.");
           this.saucer = 10;
        }        
    }

    /**
     * getSaucer ()
     * _________________________________________
     * Returns the saucer value.
     * 
     * @return int saucer.
     */
    public int getSaucer ()
    {
        return this.saucer;        
    }
    
    /**
     * setSaucer (int saucer)
     * ___________________________________________
     * Sets saucer value. 
     * 
     * PRE: saucer must be a valid positive integer.
     * POST: sets the new saucer.
     * 
     * @param int saucer
     */
    public void setSaucer (int saucer)
    {
        if (saucer > 0)
          this.saucer = saucer;
        else System.out.println("Invalid saucer value!");
    }
    
    @Override
    /**
     * getArea ()
     * _____________________________________
     * This method overrides Shape's getArea
     * method and returns an approximate area of the UFO.
     * The area calculated as follows:
     * the middle part (stretched circle) + top part (half a circle
     * that sits on top) + bottom part (the triangle that "shines light").
     * 
     * @return double area
     */
    public double getArea()
    {
        double top = (Math.PI * getSaucer() * getSaucer())/2;
        double beamUp = (getSaucer() * getSaucer())/2;
        double middle = getSaucer() * getSaucer() * Math.PI;
        double area = top + beamUp + middle;
        return area;
    }
    
    @Override
    /**
     * draw (Graphics g)
     * _____________________________________
     * This method draws the UFO using Graphics2D method.
     * Example taken from Spray class that was provided.
     * 
     * Used this tutorial to learn the semi-circle: 
     * http://www.itsprings.co.in/java/How-to-draw-semi-circle-in-Java
     * 
     * Used this tutorial to learn triangles:
     * https://docs.oracle.com/javase/tutorial/2d/geometry/arbitrary.html
     * 
     * PRE: Graphics object must be valid.
     * POST: paints a UFO on the screen.
     * 
     * @param Graphics g
     */
    public void draw (Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        final int x = getX();
        final int y = getY();
        final int saucer = getSaucer();
        
        //top half
        g2d.setColor(Color.BLACK);
       // g2d.draw(new Arc2D.Double(x, y, saucer, saucer, 0, 180, Arc2D.CHORD));
        g2d.fill(new Arc2D.Double(x, y, saucer, saucer, 0, 180, Arc2D.CHORD));
     
        //stretched area
        g2d.setColor(Color.GRAY);
       // g2d.draw(new Ellipse2D.Double(x-saucer*1.5/5, (y+saucer/3), saucer*1.5, (saucer+2)/4));
        g2d.fill(new Ellipse2D.Double(x-saucer*1.5/5, (y+saucer/3), saucer*1.5, (saucer+2)/4));
     
        //alien windows
        g2d.setColor(Color.YELLOW);
       // g2d.draw(new Ellipse2D.Double(x+saucer/1.3, (y+saucer/5), saucer/10, saucer/10));
        g2d.fill(new Ellipse2D.Double(x+saucer/1.3, (y+saucer/5), saucer/10, saucer/10));
      
        //g2d.draw(new Ellipse2D.Double(x+saucer/2, (y+saucer/5), saucer/10, saucer/10));
        g2d.fill(new Ellipse2D.Double(x+saucer/2, (y+saucer/5), saucer/10, saucer/10));
      
       // g2d.draw(new Ellipse2D.Double(x+saucer/4, (y+saucer/5), saucer/10, saucer/10));
        g2d.fill(new Ellipse2D.Double(x+saucer/4, (y+saucer/5), saucer/10, saucer/10));
    
        //beaming up area:
        int xPoints[] = {x+saucer/2,x,x+saucer};
        int yPoints[] = {(y+saucer/2),(y+saucer),(y+saucer)};
        int npoints = xPoints.length;

       // g2d.drawPolygon(xPoints, yPoints, npoints);//draws polygon outline
        g2d.fillPolygon(xPoints, yPoints, npoints);//paints a polygon
    
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
        return "This is an alien ship at coordinates (" + getX() + "," + getY() + ")" + 
        " that is manipulated from size " + getSaucer() + " to shape a flying UFO with an area of " +
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

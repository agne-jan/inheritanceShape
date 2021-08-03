
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.geom.*;
import java.awt.Graphics2D;

/**
 * Class Panda inherits all data members and methods from Shape class
 * and draws a panda head.
 *
 * @author  Agne Januskeviciute
 * @version 2020-05-04
 */
public class Panda extends Shape
{
    //everything is manipulated from one measure
    private int panda;


    /**
     * Panda (int x, int y)
     * ___________________________________________
     * Constructor for class Panda that takes two
     * ints as parameters as required by Shape class.
     * 
     * PRE: x, y must be valid positive integers
     * POST: x and y will be set and panda will be set
     * to a default 10.
     * 
     * @param int x, int y
     */
     public Panda (int x, int y)
    {
        super (x, y);
        this.panda = 10;
    }
    
    /**
     * Panda (int x, int y, int panda)
     * ___________________________________________
     * Constructor for class Panda that takes two
     * ints as parameters as required by Shape class
     * and an int for panda.
     * 
     * PRE: x, y, panda must be valid positive integers.
     * POST: x, y and panda will be set.
     * 
     * @param int x, int y
     */
    public Panda (int x, int y, int panda)
    {
        super (x, y);
        if (panda > 0)
          this.panda = panda;
        else 
        {
           System.out.println("Invalid panda size. Setting panda size to 10.");
           this.panda = 10;
        }
    }
    
    /**
     * getPanda ()
     * _________________________________________
     * Returns the panda size.
     * 
     * @return int panda
     */
    public int getPanda ()
    {
        return this.panda;        
    }
    
    /**
     * setPanda (int panda)
     * ___________________________________________
     * Sets panda size. 
     * 
     * PRE: panda must be a valid positive integer.
     * POST: sets the new panda size.
     * 
     * @param int panda
     */
    public void setPanda (int panda)
    {
        if (panda > 0)
          this.panda = panda;
        else System.out.println("Invalid panda size!");
    }
    
    
    @Override
    /**
     * getArea ()
     * _____________________________________
     * This method overrides Shape's getArea
     * method and returns an approximate area
     * of the panda head.
     * 
     * Area approximated like this: 
     * panda head + panda ears (assuming that
     * one circle would make two ears).
     * 
     * @return double area
     */
    public double getArea()
    {
        return this.panda * this.panda * Math.PI + (Math.PI * (this.panda/4) * (this.panda/4));
    }
    
    @Override
    
    /**
     * draw (Graphics g)
     * _____________________________________
     * This method draws the panda head using Graphics2D method.
     * Example taken from Spray class that was provided.
     * 
     * PRE: Graphics object must be valid.
     * POST: paints a panda on the screen.
     * 
     * @param Graphics g
     */
    public void draw (Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        final int x = getX();
        final int y = getY();
        final int panda = getPanda();
        
        g2d.setColor(Color.BLACK);
        //ears
        //g2d.draw(new Ellipse2D.Double(x, y, panda/4, panda/4));
        g2d.fill(new Ellipse2D.Double(x, y, panda/4, panda/4));
        
        //g2d.draw(new Ellipse2D.Double(x+panda/1.3, y, panda/4, panda/4));
        g2d.fill(new Ellipse2D.Double(x+panda/1.3, y, panda/4, panda/4));

        //head outline
        g2d.draw(new Ellipse2D.Double(x, y, panda, panda));
        //head fill
        g2d.setColor(Color.WHITE);
        g2d.fill(new Ellipse2D.Double(x, y, panda, panda));
        
        //round area around eyes
        g2d.setColor(Color.BLACK);
        //g2d.draw(new Ellipse2D.Double(x+panda/5, y+panda/4, panda/4, panda/4));
        g2d.fill(new Ellipse2D.Double(x+panda/5, y+panda/4, panda/4, panda/4));
        
        //g2d.draw(new Ellipse2D.Double(x+panda/1.7, y+panda/4, panda/4, panda/4));
        g2d.fill(new Ellipse2D.Double(x+panda/1.7, y+panda/4, panda/4, panda/4));
        
        //blue eyes because why not
        g2d.setColor(Color.CYAN);
        //g2d.draw(new Ellipse2D.Double(x+panda/1.5, y+panda/3, panda/10, panda/10));
        g2d.fill(new Ellipse2D.Double(x+panda/1.5, y+panda/3, panda/10, panda/10));
        
        //g2d.draw(new Ellipse2D.Double(x+panda/3.7, y+panda/3, panda/10, panda/10));
        g2d.fill(new Ellipse2D.Double(x+panda/3.7, y+panda/3, panda/10, panda/10));
        
        //pupils
        g2d.setColor(Color.BLACK);
        //g2d.draw(new Ellipse2D.Double(x+panda/1.45, y+panda/2.75, panda/20, panda/20));
        g2d.fill(new Ellipse2D.Double(x+panda/1.45, y+panda/2.75, panda/20, panda/20));
        
        //g2d.draw(new Ellipse2D.Double(x+panda/3.455, y+panda/2.75, panda/20, panda/20));
        g2d.fill(new Ellipse2D.Double(x+panda/3.455, y+panda/2.75, panda/20, panda/20));
        
        //the crooked nose
        int xPoints[] = {x+panda/2, x+panda/3, x+panda/2+panda/5 };
        int yPoints[] = {y+panda/2+panda/4, y+panda/2+panda/8, y+panda/2+panda/8};
        int npoints = xPoints.length;

        // g2d.drawPolygon(xPoints, yPoints, npoints);//draws polygon outline
        g2d.fillPolygon(xPoints, yPoints, npoints);//paints a polygon
        // g2d.setColor(Color.RED); == couldn't see before
        g2d.draw(new Line2D.Double(x+panda/2, y+panda-panda/5, x+panda/2, y+panda/2+panda/8));
      
        //mouth; learned from here: https://docs.oracle.com/javase/tutorial/2d/geometry/primitives.html
        QuadCurve2D q = new QuadCurve2D.Double();
        q.setCurve(x+panda/3, y+panda-panda/4, x+panda/2, y+panda-panda/8, x+panda/2+panda/5, y+panda-panda/4);
        g2d.draw(q);        
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
        return "This is a panda at coordinates (" + getX() + "," + getY() + ")" + 
        " that is drawn with size " + getPanda() + " to shape a panda with an area of " + 
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

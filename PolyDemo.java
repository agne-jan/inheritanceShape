import java.util.*;
import javax.swing.*;
import java.awt.*;


/*
 * Class PolyDemo (is a JFrame) and PolyDemoPanel (is a JPanel)
 * 
 * Author: Rob Nash
 */


class PolyDemo extends JFrame {
    
    
    public PolyDemo() {
        getContentPane().add( new PolyDemoPanel() );
        // just some windowing stuff that must happen 
        // for all Frames
        setSize( 300,300 );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    
    
    public static void main( String args[] ) {
        PolyDemo myApp = new PolyDemo();
        
        /* TESTS:
         * circleTest();
         * flagTest();
         * UFOTest();
         * pandaTest();
         * houseTest();*/
    }
    
    
    // this is our first "inner" or internal class 
    // the purpose of this class is solely to support 
    // the JFrame class above, and I don't want it 
    // reused in arbitrary contexts, so by nesting this 
    // class here I can indicate the intent a bit more 
    // clearly that this class "goes with" the class above it.
    // In general, each class is a separate entity that 
    // should be contained in a separate file
    public class PolyDemoPanel extends JPanel {     
        Shape[] myShapes= new Shape[5];
        
        public PolyDemoPanel() {
            Shape a = new Shape( getRandInt(), getRandInt());
            Shape b = new Circle( getRandInt(), getRandInt(), getRandInt() );
        
            //a = new Square(getRandInt(), getRandInt(), getRandInt(), getRandInt() );
        
            //a = getRandShape();

            ( (Circle) b ).getRadius();
        
        
            /***************************************
            * Code for populating our myShapes 
            * changes minimally when new classes 
            * are introduced (only in getRandShape())
            *******************************************/
            ////changed to myShapes.length so that only one variable is needed to be changed.
            for( int i = 0; i < myShapes.length; i++ ) {
                myShapes[i] =  getRandShape();
            }
        }
        
        /*******************************************************
         * Code for drawing our shapes doesn't change at all! 
         * Since we intended to take advantage of polymorphism, 
         * we coded this "in general" with respect to the 
         * superclass, and not specific to any subclass.
         *****************************************************/
        public void paint( Graphics g ) {
            super.paint(g);  //don't remove - required for GUI widgets to draw correctly
            /************************
             * Late Binding Demo
             ************************/
            for( int i = 0; i < myShapes.length; i++ ){
                // which draw method is invoked here? 
                // There are many forms of the method (polymorphic), 
                // so which is chosen?
                // Java has RTTI (run-time type info)
                // about every object, 
                // and it uses this info to choose 
                // the correct method to invoke!
                myShapes[i].draw( g );  
            }   
        }
            
        
        public int getRandInt() {
            return ( (int) ( Math.random() * 200 ) );   
        }
        
        public Shape getRandShape() {
            Shape retVal = null;
            final int x = getRandInt();
            final int y = getRandInt();
            
            
            /********************************
             * Polymorphic extensibility demo
             *
             *******************************/
            switch( ( int )(Math.random() * 5) ) { //All the shapes I created:
               case 0:     retVal = new Circle(x, y, getRandInt()); //I deemed it too simple so I added an extra class
                           break;
                           
               case 1:     retVal = new LithuanianFlag (x, y, getRandInt(), getRandInt());
                           break;
                           
               case 2:     retVal = new House( x, y, getRandInt());
                           break;
                           
               case 3:     retVal = new UFO( x, y, getRandInt());
                           break; 
                           
               case 4:     retVal = new Panda(x, y, getRandInt());
                           break;
            }
        
            return retVal;
        }
    }   
    
    /**
     * circleTest()
     * ____________________________________________
     * Tests various returned values from Circle 
     * class.
     */
    public static void circleTest()
    {   
        System.out.println("Circle tests"+"\n");
        Circle noRadius = new Circle(50, 50);
        Circle fullCons = new Circle (50, 50, 100);

        System.out.println(noRadius.toString());
        System.out.println("No-radius constructor. Radius equals 10: " + noRadius.getRadius());
        System.out.println(fullCons.toString());
        System.out.println("Full argument constructor. Radius equals 100: " + fullCons.getRadius());
        System.out.println();
        
        System.out.println("Equals test. Should be false: " + noRadius.equals(fullCons));
        System.out.println();
        System.out.println("Equals test. Should be true: " + noRadius.equals(noRadius));
        System.out.println();
        
        noRadius.setRadius(20);
        System.out.println("Radius equals 20: " + noRadius.getRadius());
        
        noRadius.getArea();
        System.out.println();
        System.out.print("Area equals ~1256: ");
        System.out.printf("%.2f", noRadius.getArea());
        
        System.out.println();
        System.out.println();
        System.out.println("Invalid radius test:");
        
        Circle badCons = new Circle (50, 50, -100);
        
        System.out.println();
        
        System.out.println("Invalid radius set to 10: " + badCons.getRadius());
        System.out.print("Invalid radius set to -19: ");
        badCons.setRadius(-19);
        
        System.out.println("_____________________________________________________________________________");
    }
    
    /**
     * flagTest()
     * ____________________________________________
     * Tests various returned values from LithuanianFlag 
     * class.
     */
    public static void flagTest()
    {
        System.out.println("Flag tests"+"\n");
        LithuanianFlag noWidthHeight = new LithuanianFlag (50, 50);
        LithuanianFlag fullConstructor = new LithuanianFlag (50, 50, 20, 60);
        
        System.out.println(noWidthHeight.toString());
        System.out.println("No-width, no-height constructor. Height = 10, width = 30:  " + 
        "height = "+ noWidthHeight.getFlagHeight() + ", width = " + noWidthHeight.getFlagWidth());
        
        System.out.println(fullConstructor.toString());
        System.out.println("Full argument constructor. Height = 20, width = 60:  " + 
        "height = "+ fullConstructor.getFlagHeight() + ", width = " + fullConstructor.getFlagWidth());

        System.out.println("Equals test. Should be false: " + noWidthHeight.equals(fullConstructor));
        System.out.println();
        System.out.println("Equals test. Should be true: " + noWidthHeight.equals(noWidthHeight));
        System.out.println();
        
        noWidthHeight.setFlagHeight(20);
        System.out.println("Height equals 20: " + noWidthHeight.getFlagHeight());
        
        noWidthHeight.getArea();
        System.out.println();
        System.out.print("Area equals 600: ");
        System.out.printf("%.2f", noWidthHeight.getArea());
        
        System.out.println();
        System.out.println();
        System.out.println("Invalid height test:");
        
        LithuanianFlag badConstructor = new LithuanianFlag (50, 50, -10, 50);
        
        System.out.println();
        
        System.out.println("Invalid height set to 10: " + badConstructor.getFlagHeight());
        System.out.print("Invalid height set to -19: ");
        badConstructor.setFlagHeight(-19);
        System.out.println();
        System.out.println("_____________________________________________________________________________");    
    }
    
    /**
     * UFOTest()
     * ____________________________________________
     * Tests various returned values from UFO 
     * class.
     */
    public static void UFOTest()
    {   
        System.out.println("UFO tests"+"\n");
        UFO noSaucer = new UFO(50, 50);
        UFO fullConstructor = new UFO (50, 50, 100);
        
        System.out.println(noSaucer.toString());
        System.out.println("No-saucer constructor. Saucer size equals 10: " + noSaucer.getSaucer());
        System.out.println(fullConstructor.toString());
        System.out.println("Full argument constructor. Saucer size equals 100: " + fullConstructor.getSaucer());
        
        System.out.println();
        
        System.out.println("Equals test. Should be false: " + noSaucer.equals(fullConstructor));
        System.out.println();
        System.out.println("Equals test. Should be true: " + noSaucer.equals(noSaucer));
        System.out.println();
        
        noSaucer.setSaucer(20);
        System.out.println("Saucer size equals 20: " + noSaucer.getSaucer());
        System.out.println();
        
        noSaucer.getArea();
        System.out.print("Area equals ~2084: ");
        System.out.printf("%.2f", noSaucer.getArea());
        
        System.out.println();
        System.out.println();
        System.out.println("Invalid saucer test:");
        
        UFO badCons = new UFO (50, 50, -100);
        
        System.out.println();
        
        System.out.println("Invalid saucer set to 10: " + badCons.getSaucer());
        System.out.print("Invalid saucer set to -19: ");
        badCons.setSaucer(-19);
        
        System.out.println("_____________________________________________________________________________");
    }
    
    /**
     * pandaTest()
     * ____________________________________________
     * Tests various returned values from Panda 
     * class.
     */
    public static void pandaTest()
    {   
        System.out.println("Panda tests"+"\n");
        Panda noPanda = new Panda(50, 50);
        Panda fullConstructor = new Panda (50, 50, 100);
        
        System.out.println(noPanda.toString());
        System.out.println("No-panda constructor. Saucer size equals 10: " + noPanda.getPanda());
        System.out.println(fullConstructor.toString());
        System.out.println("Full argument constructor. Saucer size equals 100: " + fullConstructor.getPanda());
        
        System.out.println();
        
        System.out.println("Equals test. Should be false: " + noPanda.equals(fullConstructor));
        System.out.println();
        System.out.println("Equals test. Should be true: " + noPanda.equals(noPanda));
        System.out.println();
        
        noPanda.setPanda(20);
        System.out.println("Panda size equals 20: " + noPanda.getPanda());
        System.out.println();
        
        noPanda.getArea();
        System.out.print("Area equals ~1335: ");
        System.out.printf("%.2f", noPanda.getArea());
        
        System.out.println();
        System.out.println();
        System.out.println("Invalid panda test:");
        
        Panda badPanda = new Panda (50, 50, -100);
        
        System.out.println();
        
        System.out.println("Invalid panda set to 10: " + badPanda.getPanda());
        System.out.print("Invalid panda set to -19: ");
        badPanda.setPanda(-19);
        
        System.out.println("_____________________________________________________________________________");
    }
    
    /**
     * houseTest()
     * ____________________________________________
     * Tests various returned values from House 
     * class.
     */
    public static void houseTest()
    {   
        System.out.println("House tests"+"\n");
        House noWidth = new House(50, 50);
        House fullCons = new House (50, 50, 100);

        System.out.println(noWidth.toString());
        System.out.println("No-width constructor. Width equals 10: " + noWidth.getWidth());
        System.out.println(fullCons.toString());
        System.out.println("Full argument constructor. Width equals 100: " + fullCons.getWidth());
        System.out.println();
        
        System.out.println("Equals test. Should be false: " + noWidth.equals(fullCons));
        System.out.println();
        System.out.println("Equals test. Should be true: " + noWidth.equals(noWidth));
        System.out.println();
        
        noWidth.setWidth(20);
        System.out.println("Radius equals 20: " + noWidth.getWidth());
        
        noWidth.getArea();
        System.out.println();
        System.out.print("Area equals ~500: ");
        System.out.printf("%.2f", noWidth.getArea());
        
        System.out.println();
        System.out.println();
        System.out.println("Invalid width test:");
        
        House badCons = new House (50, 50, -100);
        
        System.out.println();
        
        System.out.println("Invalid width set to 10: " + badCons.getWidth());
        System.out.print("Invalid width set to -19: ");
        badCons.setWidth(-19);
        
        System.out.println("_____________________________________________________________________________");
    }
}












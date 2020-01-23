
/* Author:  Eli and whoever made the drawing code template
   Date:    12/2019
   Special Thanks to:   DemoEmoji.java
   Purpose: give our game graphics
 */ 

import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;    // Using Swing's components and containers
 
/** Custom Drawing Code Template */
// A Swing application extends javax.swing.JFrame
public class GraphicsPainter extends JFrame 
{
   // Define constants to set window dimensions
   public static final int CANVAS_WIDTH  = 500;
   public static final int CANVAS_HEIGHT = 500;
   //Define board, a String that tells it where to put all the x and o
   public String board;
   // Declare an instance of the drawing canvas,
   // which is an inner class called DrawCanvas extending javax.swing.JPanel.
   private DrawCanvas canvas;
 
   // Constructor to set up the GUI components and event handlers
   public GraphicsPainter(String board) 
   {
      this.board = board;    //initialize board variable
      canvas = new DrawCanvas();    // Construct the drawing canvas
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
      // Set the Drawing JPanel as the JFrame's content-pane
      Container cp = getContentPane();
      cp.add(canvas);
      // or "setContentPane(canvas);"
 
      setDefaultCloseOperation(EXIT_ON_CLOSE);   // Handle the CLOSE button
      pack();              // Either pack() the components; or setSize()
      setTitle("Tic-tac-toe");  // "super" JFrame sets the title
      setVisible(true);    // "super" JFrame show
   }
 
   /**
    * Define inner class DrawCanvas, which is a JPanel used for custom 
    * drawing.
    */
   private class DrawCanvas extends JPanel 
   {
      // Override paintComponent to perform your own painting
      //This is the place to work if we want to improve our graphics
      @Override
      public void paintComponent(Graphics g) 
      {
         super.paintComponent(g);     
         setBackground(Color.WHITE);   
         
         // Examples showing how to work the graphic
             // g.setColor(Color.YELLOW);
             // g.fillOval(100,100,300,300);
             // g.setColor(new Color(10,25,125));
             // g.setColor(new Color(81, 45, 14));
             // g.drawArc(220,280,60,40,0,180);  
             // g.fillArc(190, 280, 120, 80, 0, -180);
             // g.fillRect(225, 320, 20, 20);
             // g.fillRect(255, 320, 20, 20);
             // int[] xPointsBowtie = new int[] {170, 330, 330, 170};
             // int[] yPointsBowtie = new int[] {380, 450, 380, 450};
             // g.fillPolygon(xPointsBowtie, yPointsBowtie, 4);
             // g.drawString(words ,5,30);  
         
         //PAINT THE BOARD
         g.setColor(Color.BLACK);
         g.fillRect(160, 0, 10, 500);
         g.fillRect(330, 0, 10, 500);
         g.fillRect(0, 160, 500, 10);
         g.fillRect(0, 330, 500, 10);
         
         //PAINT THE CHARACTERS ON IT
         String ch = "x";
         int[] x1 = new int[] {0, 170, 340};
         int[] y1 = new int[] {0, 170, 340};
         int[] x2 = new int[] {160, 330, 500};
         int[] y2 = new int[] {160, 330, 500};
         for (int i = 0; i < board.length(); i++)
         {
             ch =  board.substring(i, i + 1);
             if (ch.equalsIgnoreCase("x"))
             {
                 g.drawLine(x1[i%3], y1[i/3], x2[i%3], y2[i/3]);
                 g.drawLine(x2[i%3], y1[i/3], x1[i%3], y2[i/3]);
             } 
             else if (ch.equalsIgnoreCase("o"))
             {
                 g.drawArc(x1[i%3], y1[i/3], (x2[i%3]-x1[i%3]), (y2[i/3]-y1[i/3]), 0, 360);
             }
             
         }
      }
    }
   // The entry main method
   public static void paint(String game) 
   {
      // Run the GUI codes on the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() 
      {
         @Override
         public void run() 
         {
            new GraphicsPainter(game); // Let the constructor do the job
         }
      });
   }
}
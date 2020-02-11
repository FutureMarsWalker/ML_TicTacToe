import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
public class Game
{ 
    
    //Graphics
        private JFrame f = new JFrame();

        private ImageIcon imgO = new ImageIcon("O.png");
        private ImageIcon imgX = new ImageIcon("X.png");

        private JButton[] buttons = new JButton[9];
        
        private boolean waitingForButton = false;
        private int buttonReturned = -1;
        
    public String theBoard()
    {
        return "123456789";
    }
    public String xPlays(String bd, int x)
    {
        String b = bd;
        b = b.substring(0, x - 1) + "x" + b.substring(x);
        return b;
    }
    public String oPlays(String bd, int x)
    {
        String b = bd;
        try 
        {
            b = b.substring(0, x - 1) + "o" + b.substring(x);
        }
        catch(Exception e)
        {
            b = "Y";
            System.out.println("illegal move, passed in" + x);
        }
        return b;
    }
    public void printGame(String bd)
    {
        String b = bd;
        if (buttons[0] == null)
        {
            //alternative method:
            //Arrays.setAll(buttons, puke -> new JButton());//"puke" is a new function that returns a new button
            
            //The old version of the code:
            for (int i = 0; i < buttons.length; i++)
            {
                buttons[i] = new JButton();
            }
        }
        for (JButton butt: buttons)
        {
            f.add(butt);
        }
        for (int i = 0; i < buttons.length; i++)
        {
            if(b.substring(i, i+1).equalsIgnoreCase("x"))
            {
                buttons[i].setIcon(imgX);
            }
            else if(b.substring(i, i+1).equalsIgnoreCase("o"))
            {
                buttons[i].setIcon(imgO);
            }
            else
            {
                buttons[i].setIcon(null);
            }
        }
        
        buttons[0].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    if(waitingForButton)
                    {
                    buttonReturned = 1;
                    waitingForButton = false;
                    }
                }
            });
        buttons[1].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    if(waitingForButton)
                    {
                    buttonReturned = 2;
                    waitingForButton = false;
                    }
                }
            });
        buttons[2].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    if(waitingForButton)
                    {
                    buttonReturned = 3;
                    waitingForButton = false;
                    }
                }
            });
        buttons[3].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    if(waitingForButton)
                    {
                    buttonReturned = 4;
                    waitingForButton = false;
                    }
                }
            });
        buttons[4].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    if(waitingForButton)
                    {
                    buttonReturned = 5;
                    waitingForButton = false;
                    }
                }
            });
        buttons[5].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    if(waitingForButton)
                    {
                    buttonReturned = 6;
                    waitingForButton = false;
                    }
                }
            });
        buttons[6].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    if(waitingForButton)
                    {
                    buttonReturned = 7;
                    waitingForButton = false;
                    }
                }
            });
        buttons[7].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    if(waitingForButton)
                    {
                    buttonReturned = 8;
                    waitingForButton = false;
                    }
                }
            });
        buttons[8].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    if(waitingForButton)
                    {
                    buttonReturned = 9;
                    waitingForButton = false;
                    }
                }
            });
        f.setLayout(new GridLayout(3,3));
        f.setBounds(0, 0, 500, 500);
        f.show(true);
    }
    public void printChances(String bd)
    {
        String b = bd;
        //WORK HERE
        //remove all the 1s after - in bd
        b = removeNegative1(b);
        
        System.out.println("[" + b.substring(0,1) + "][" + b.substring(1,2) + "][" + b.substring(2,3) + "]");
        System.out.println("[" + b.substring(3,4) + "][" + b.substring(4,5) + "][" + b.substring(5,6) + "]");
        System.out.println("[" + b.substring(6,7) + "][" + b.substring(7,8) + "][" + b.substring(8,9) + "]");
    }
    public int waitForButton()
    {
        waitingForButton = true;
        while (true){
            if (!waitingForButton)
            {
                return buttonReturned;
            } else {
                System.out.print("");//I have no idea why this is necessary, but it makes the code work
            }
        } //waits until waitingForButton = false
    }
    public static String removeNegative1 (String str)
    {
        for(int i = 0; i < str.length() - 1; i++)
        {
            if (str.substring(i, i + 2).equals("-1"))
            {
                str = str.substring(0, i + 1) + str.substring (i + 2);
            }
        }
        return str;
    }
    
}

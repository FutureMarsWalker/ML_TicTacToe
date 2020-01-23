import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Game
{ 
    
    //Graphics
        private JFrame f = new JFrame();

        private ImageIcon imgO = new ImageIcon("O.png");
        private ImageIcon imgX = new ImageIcon("X.png");
        
        // private JButton b1 = new JButton();
        // private JButton b2 = new JButton();
        // private JButton b3 = new JButton();
        // private JButton b4 = new JButton();
        // private JButton b5 = new JButton();
        // private JButton b6 = new JButton();
        // private JButton b7 = new JButton();
        // private JButton b8 = new JButton();
        // private JButton b9 = new JButton();
        private JButton[] buttons = new JButton[9];
        
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
        b = b.substring(0, x - 1) + "o" + b.substring(x);
        return b;
    }
    public void printGame(String bd)
    {

        String b = bd;
        System.out.println("[" + b.substring(0,1) + "][" + b.substring(1,2) + "][" + b.substring(2,3) + "]");
        System.out.println("[" + b.substring(3,4) + "][" + b.substring(4,5) + "][" + b.substring(5,6) + "]");
        System.out.println("[" + b.substring(6,7) + "][" + b.substring(7,8) + "][" + b.substring(8,9) + "]");

        // b1.setText(b.substring(0,1));
        // b2.setText(b.substring(1,2));
        // b3.setText(b.substring(2,3));
        // b4.setText(b.substring(3,4));
        // b5.setText(b.substring(4,5));
        // b6.setText(b.substring(5,6));
        // b7.setText(b.substring(6,7));
        // b8.setText(b.substring(7,8));
        // b9.setText(b.substring(8,9));
        
        // f.add(b1);
        // f.add(b2);
        // f.add(b3);
        // f.add(b4);
        // f.add(b5);
        // f.add(b6);
        // f.add(b7);
        // f.add(b8);
        // f.add(b9);
        if (buttons[0] == null)
        {
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
        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    buttons[0].setText("Good Job");
                }
            });
        }
        f.setLayout(new GridLayout(3,3));
        f.setBounds(0, 0, 500, 500);
        f.show(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        
    }
}

import java.awt.*;
import java.io.*;
import java.awt.event.*;  
import javax.imageio.*;  

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;





public class gameFrame  implements ActionListener {       

  JFrame page1;
  JFrame infoPage;
  DregerButton start;
  DregerButton info;
  JPanel b1;
  JPanel b2;
  JPanel rule;
  //MainGame mg;
  Container thisContainer;
  Toolkit tk = Toolkit.getDefaultToolkit();
  int size;
  public gameFrame(int i)
  {


    size=i;
    this.init();

    //mg.mainFrame.setVisible(false);
  }
  public void init() {

    page1=new JFrame("Let's Link");
    infoPage = new JFrame("INFO");
    //page1.setContentPane(new JLabel(new ImageIcon("1.png")));
    page1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    page1.setLayout(new FlowLayout());         
    start=new DregerButton("start");
    info=new DregerButton("info");
    b2=new JPanel();
    b1=new JPanel();
    b1.add(start);
    b2.add(info);
    page1.add(b1);
    page1.add(b2);
    start.addActionListener(this);
    info.addActionListener(this);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    page1.setSize(screenSize.width, screenSize.height);

    page1.setVisible(true);
     JOptionPane.showMessageDialog (page1,
                         "Welcome to Let's Link! If you are a single player, please read the instructions on the information page and proceed to the game. If there are two players, please open this program on both computers and proceed." ,"Welcome Message" , JOptionPane.INFORMATION_MESSAGE);
    infoPage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    infoPage.setLayout(new BorderLayout());
    infoPage.setSize(screenSize.width, screenSize.height);


    infoPage.add(new JLabel(new ImageIcon("rule.png")));
    //infoPage.setVisible(true);
  }


  public void actionPerformed(ActionEvent e) {
 



    //super.actionPerformed(e); 
    if (e.getSource() == start) {
    
     Object[] Opts = { "1", "2", "3","4" };
    ImageIcon image2 = new ImageIcon(getClass().getResource("charc.png"));
   int selectedValue1 = JOptionPane.showOptionDialog(null, "", "Please Choose a charactor",
JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
image2, Opts, Opts[0]);

      /*
  if(selectedValue==0)
 //mg.level(120,15);

  if(selectedValue==1)
  {
//mg.level(120,10);


}
else if(selectedValue==2)
{
//mg.level(90,10);

}
else
*/

                         
    Object[] Levels = { "Easy", "Normal", "Difficult" };
   int selectedValue = JOptionPane.showOptionDialog(null, "Modes of Difficulty", "",
JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
null, Levels, Levels[0]);
System.out.print(selectedValue);
      
      MainGame mg=new MainGame(size);
      page1.setVisible(false);
    
       if(selectedValue==0)
 mg.level(120,15);

 else if(selectedValue==1)
  {
mg.level(120,10);


}
else if(selectedValue==2)
{
mg.level(90,10);

}
else
mg.level(120,15);
mg.init();
  mg.mainFrame.setVisible(true); 


   // }
    /*  System.out.println("wtf");
      MainGame mg=new MainGame(size);
      page1.setVisible(false);
      mg.mainFrame.setVisible(true);  
      //init();*/
    }
    if (e.getSource() == info) {
      System.out.println("wtf3");
     // page1.setVisible(false);
      infoPage.setVisible(true);
    }
  }

  public static void main(String[] args) {                   

    gameFrame p1=new gameFrame(4);


    // p1.mainFrame.setVisible(true);
  }
}

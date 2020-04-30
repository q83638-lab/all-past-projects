import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.Timer;
import javax.swing.JComponent;


import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Duel{
      JFrame frame;
      
      int emojiThis;
      int emojiOther;
      int sizeForThis=50;
      int sizeForOther=50;
Toolkit tk = Toolkit.getDefaultToolkit();
      JButton expThis;
      JButton expOther;
      int numThis=225;
      int numOther=225;
      JPanel north;
      Cen centre;
      Container con;
      int attackT;
      int count=1;
      int loc2=100;
      int loc1=100;
      int countl=1;
      int attackO;
      int textlocO=25;

      Boolean KeyPressedD=false;
      Boolean KeyPressedL=false;
      
      public Duel(int i, int j, int size1, int size2){
      emojiThis=i;
      emojiOther=j;
      sizeForThis=size1;
      sizeForOther=size2;

      if (size1>size2)
      {
         attackO=60;
         attackT=50;
         }
       
      else if (size2>size1)
      {
         attackT=60;
         attackO=50;
         
      }
      else 
         attackT=attackO=50;
     
}
      public void init ()
      {
      frame=new JFrame("duel");
      expThis=new JButton("exp");
      expOther=new JButton("exp");
     
      north=new JPanel();
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

      String fileThis=Integer.toString(emojiThis)+".png";
      String fileOther=Integer.toString(emojiOther)+".png";
      frame.setSize(screenSize.width, screenSize.height);
            
      con= frame.getContentPane();

      con.setLayout(new BorderLayout());
      
            
      expThis.setBackground(Color.RED);
      expThis.setPreferredSize(new Dimension(numThis,25));
      expOther.setPreferredSize(new Dimension(numOther,25));
      expOther.setBackground(Color.RED);
      north.add(expThis);
      north.add(expOther);
      
      
      
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         AbstractAction da=new AbstractAction()
         {
            public void actionPerformed( ActionEvent tf )      {
           
           if(numThis>0&&numOther>0)
           {
           KeyPressedD=true;
           expOther.setVisible(false);
           numOther-=attackT*225/(sizeForOther*sizeForOther);//algarithm
           expOther.setPreferredSize(new Dimension(numOther,25));
           expOther.setVisible(true);
           
           centre.repaint();
           }
           
                             } 
          };
     
         
         AbstractAction la=new AbstractAction()
         {
            public void actionPerformed( ActionEvent tf )      {
                       if(numThis>0&&numOther>0){
            KeyPressedL=true;
            expThis.setVisible(false);
           numThis-=attackO*225/(sizeForThis*sizeForThis);//algarithm
           expThis.setPreferredSize(new Dimension(numThis,25));
           expThis.setVisible(true);
                       centre.repaint();
                       }

                     }


         };
         centre=new Cen(fileThis,fileOther,sizeForThis,sizeForOther);
         centre.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke(KeyEvent.VK_D, 0),
                "doDAction" );
         centre.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "d" ),
                "doDAction" );
         centre.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0),
                "doLAction" );
         centre.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( KeyEvent.VK_KP_LEFT,0 ),
                "doLAction" );
         
         centre.getActionMap().put( "doDAction", da );
         
         centre.getActionMap().put("doLAction",la);
                                       
      con.add(north, "North");
      con.add(centre);
      
            frame.setSize(screenSize.width, screenSize.height);

     frame.setVisible(true);

}      


     public static void main(String[] args) {


         
         Duel  d=new Duel(1,8,60,80);
         d.init();
         
         
         




}

             

public class Cen extends JComponent {
            
            String fileThis;
            String fileOther;
            int sizeForThis;
            int sizeForOther;
            public  Cen(String a, String b, int c, int d)
            {
               fileThis=a;
               fileOther=b;
               sizeForThis=c;
              sizeForOther=d;
               this.setFocusable(true);
               this.requestFocusInWindow();


            
            }

            public void paintComponent(Graphics g) {
               super.paintComponent(g);
               BufferedImage imageT;
               BufferedImage imageO;
                         try{
                          imageT = ImageIO.read(new File(fileThis));
                  
                           imageO = ImageIO.read(new File(fileOther));
                         
                        }
                        catch (IOException ex){
                          System.out.println ("no image");
                          imageT=null;
                          imageO=null;
                          
                      }
               if (numThis>0)
               {
               g.drawRect(150,300-sizeForThis,sizeForThis,sizeForThis);
               g.drawImage(imageT,150,300-sizeForThis,null);
               }
               else 
               {
               g.drawString("You win",150+sizeForThis+1,325);
               }
               
               if(numOther>0)
               {
               g.drawRect(150+sizeForThis, 300-sizeForOther, sizeForOther,sizeForOther);
               g.drawImage(imageO,150+sizeForThis, 300-sizeForOther,null);
               }
               else
               {
               g.drawString("You win",150+sizeForThis-50,325);
               }

               g.drawLine(0,300, 500, 300);
               g.drawLine(150+sizeForThis,25,150+sizeForThis,450);
               g.drawString("Use 'D' to attack",150+sizeForThis-90,50);
               g.drawString("Use left arrow to attack",150+sizeForThis+1,50);
                                                     
               if(KeyPressedD==true)
               {
                
                count++;
                KeyPressedD=false;
                 
                
               }
                for( int i =0; i<count-1;i++)
                {              
                g.drawString("-"+attackT,310,loc1);//algarithms
                loc1+=10;
                }
                loc1=100;
                
               if(KeyPressedL==true)
               {
                
                
                countl++;
                KeyPressedL=false;
                
                }

               for(int j=0; j<countl-1;j++)
                {
                g.drawString("-"+attackO,110,loc2);
                loc2+=10;
                }
                loc2=100;


             }  
             
             
                          }
             


}



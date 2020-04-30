/*bugs:error at the beginning, reset also resets count resizing doesnt work on other frames */

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.Timer;


public class MainGame implements ActionListener {
     Toolkit tk = Toolkit.getDefaultToolkit();
        
        int columnCount=10;
        int rowCount=10;
        int count=0;

       
        int exppt=0;
        int deamount=10;

        JFrame mainFrame;
        

        Container thisContainer;

        JPanel centerPanel, southPanel, northPanel; 

        DregerButton diamondsButton[][] = new DregerButton[rowCount][columnCount];

        DregerButton exitButton,resetButton; 

        JLabel score = new JLabel("0"); 

        DregerButton firstButton, secondButton; 

        JLabel label;
 
 
        Timer countdownTimer;

    // Initial game time
    
    
boolean happend=false;
       int timeRemaining;
       int time;
       

       


        int grid[][] = new int[rowCount+2][columnCount+2];
        

        static boolean pressInformation = false; 

        int x0 = 0, y0 = 0, x = 0, y = 0, fristMsg = 0, secondMsg = 0, validateLV; 

        int i, j, k, n;
        
        public MainGame(int i)
        { columnCount=rowCount=i;
          pressInformation = false; 
          grid= new int[rowCount+2][columnCount+2];
          diamondsButton = new DregerButton[i][i];
          this.randomBuild();
          timeRemaining=this.timeRemaining;
     time=timeRemaining;
           countdownTimer = new Timer(1000, new CountdownTimerListener());
        countdownTimer.start();    


            //this.init();        
                           }
                 public void init() {
             
                mainFrame = new JFrame("game");

                thisContainer = mainFrame.getContentPane();

                thisContainer.setLayout(new BorderLayout());
                
                mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                centerPanel = new JPanel();

                southPanel = new JPanel();

                northPanel = new JPanel();

                thisContainer.add(centerPanel, "Center");

                thisContainer.add(southPanel, "South");

                thisContainer.add(northPanel, "North");
                northPanel.add(score);

                centerPanel.setLayout(new GridLayout(rowCount, columnCount));

                for (int cols = 0; cols < rowCount; cols++) {

                        for (int rows = 0; rows < columnCount; rows++) {

                                String file=Integer.toString(grid[cols + 1][rows + 1])+".png";

                              diamondsButton[cols][rows] = new DregerButton(

                                            );


                              diamondsButton[cols][rows].setIcon(new ImageIcon(file));

                                diamondsButton[cols][rows].addActionListener(this);

                                centerPanel.add(diamondsButton[cols][rows]);
                                                               
                        }

                }               

                exitButton = new DregerButton("exit");

                exitButton.addActionListener(this);

                resetButton = new DregerButton("reset");

                resetButton.addActionListener(this);

                

                

                southPanel.add(exitButton);

                southPanel.add(resetButton);

                
                score.setText(String.valueOf(exppt));
               // northPanel.add(fractionLable);
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


                mainFrame.setSize(screenSize.width, screenSize.height);
               
                //mainFrame.setVisible(true);

         label = new JLabel(String.valueOf(timeRemaining));

        northPanel.add(label);

        
        label.setVisible(true);

        

        }

        public void randomBuild() {

                int randoms, cols, rows;

                for (int twins = 1; twins <=rowCount*columnCount/2; twins++) {

                        randoms = (int) (Math.random() * 25 + 1);

                        for (int alike = 1; alike <= 2; alike++) {

                                cols = (int) (Math.random() * rowCount + 1);

                                rows = (int) (Math.random() * columnCount + 1);

                                while (grid[cols][rows] != 0) {

                                        cols = (int) (Math.random() * rowCount + 1);

                                        rows = (int) (Math.random() * columnCount + 1);

                                }                              

                                this.grid[cols][rows] = randoms;                           

                        }

                }

        }
         
        public void fraction() {

            /*    fractionLable.setText(String.valueOf(Integer.parseInt(fractionLable

                                .getText())  + 100));*/

        }

        public void reload() {

                int save[] = new int[rowCount*columnCount];

                int n = 0, cols, rows;

                int grid[][] = new int[rowCount+2][columnCount+2]
                
            ;

                for (int i = 0; i <= rowCount; i++) {

                        for (int j = 0; j <= columnCount; j++) {

                                if (this.grid[i][j] != 0) {

                                        save[n] = this.grid[i][j];

                                        n++;

                                                                       }

                        }

                }

                n = n - 1;

                this.grid = grid;

                while (n >= 0) {

                        cols = (int) (Math.random() * rowCount + 1);

                        rows = (int) (Math.random() * columnCount + 1);

                        while (grid[cols][rows] != 0) {

                                cols = (int) (Math.random() * rowCount + 1);

                                rows = (int) (Math.random() * columnCount + 1);

                        }

                        this.grid[cols][rows] = save[n];

                        n--;

                }

                mainFrame.setVisible(false);

                pressInformation = false; 

                init();

                for (int i = 0; i < rowCount; i++) {

                        for (int j = 0; j < columnCount; j++) {

                                if (grid[i + 1][j + 1] == 0)

                                        diamondsButton[i][j].setVisible(false);

                        }

                }

        }

        public void estimateEven(int placeX, int placeY, DregerButton bz) {

                if (pressInformation == false) {

                        x = placeX;

                        y = placeY;

                        secondMsg = grid[x][y];

                        secondButton = bz;

                        pressInformation = true;

                } else {

                        x0 = x;

                        y0 = y;

                        fristMsg = secondMsg;

                        firstButton = secondButton;

                        x = placeX;

                        y = placeY;

                        secondMsg = grid[x][y];

                        secondButton = bz;

                        if (fristMsg == secondMsg && secondButton != firstButton) {
                        count++;

                                xiao();

                        }

                }

        }

        public void xiao() { 

                if ((x0 == x && (y0 == y + 1 || y0 == y - 1))

                                || ((x0 == x + 1 || x0 == x - 1) && (y0 == y))) { 

                        remove();

                } else {

                        for (j = 0; j < columnCount+2; j++) {

                                if (grid[x0][j] == 0) { 

                                        if (y > j) {

                                                for (i = y - 1; i >= j; i--) {

                                                        if (grid[x][i] != 0) {

                                                                k = 0;

                                                                break;

                                                        } else {

                                                                k = 1;

                                                        } 

                                                }

                                                if (k == 1) {

                                                        linePassOne();

                                                }

                                        }

                                        if (y < j) { 

                                                for (i = y + 1; i <= j; i++) { 

                                                        if (grid[x][i] != 0) {

                                                                k = 0;

                                                                break;

                                                        } else {

                                                                k = 1;

                                                        }

                                                }

                                                if (k == 1) {

                                                        linePassOne();

                                                }

                                        }

                                        if (y == j) {

                                                linePassOne();

                                        }

                                }

                                if (k == 2) {

                                        if (x0 == x) {

                                                remove();

                                        }

                                        if (x0 < x) {

                                                for (n = x0; n <= x - 1; n++) {

                                                        if (grid[n][j] != 0) {

                                                                k = 0;

                                                                break;

                                                        }

                                                        if (grid[n][j] == 0 && n == x - 1) {

                                                                remove();

                                                        }

                                                }

                                        }

                                        if (x0 > x) {

                                                for (n = x0; n >= x + 1; n--) {

                                                        if (grid[n][j] != 0) {

                                                                k = 0;

                                                                break;

                                                        }

                                                        if (grid[n][j] == 0 && n == x + 1) {

                                                                remove();

                                                        }

                                                }

                                        }

                                }

                        }

                        for (i = 0; i < rowCount+2; i++) { 

                                if (grid[i][y0] == 0) {

                                        if (x > i) {

                                                for (j = x - 1; j >= i; j--) {

                                                        if (grid[j][y] != 0) {

                                                                k = 0;

                                                                break;

                                                        } else {

                                                                k = 1;

                                                        }

                                                }

                                                if (k == 1) {

                                                        rowPassOne();

                                                }

                                        }

                                        if (x < i) {

                                                for (j = x + 1; j <= i; j++) {

                                                        if (grid[j][y] != 0) {

                                                                k = 0;

                                                                break;

                                                        } else {

                                                                k = 1;

                                                        }

                                                }

                                                if (k == 1) {

                                                        rowPassOne();

                                                }

                                        }

                                        if (x == i) {

                                                rowPassOne();

                                        }

                                }

                                if (k == 2) {

                                        if (y0 == y) {

                                                remove();

                                        }

                                        if (y0 < y) {

                                                for (n = y0; n <= y - 1; n++) {

                                                        if (grid[i][n] != 0) {

                                                                k = 0;

                                                                break;

                                                        }

                                                        if (grid[i][n] == 0 && n == y - 1) {

                                                                remove();

                                                        }

                                                }

                                        }

                                        if (y0 > y) {

                                                for (n = y0; n >= y + 1; n--) {

                                                        if (grid[i][n] != 0) {

                                                                k = 0;

                                                                break;

                                                        }

                                                        if (grid[i][n] == 0 && n == y + 1) {

                                                                remove();

                                                        }

                                                }

                                        }

                                }

                        }

                }

        }

        public void linePassOne() {

                if (y0 > j) { 

                        for (i = y0 - 1; i >= j; i--) { 

                                if (grid[x0][i] != 0) {

                                        k = 0;

                                        break;

                                } else {

                                        k = 2;

                                } 

                        }

                }

                if (y0 < j) { 

                        for (i = y0 + 1; i <= j; i++) {

                                if (grid[x0][i] != 0) {

                                        k = 0;

                                        break;

                                } else {

                                        k = 2;

                                }

                        }

                }

        }

        public void rowPassOne() {

                if (x0 > i) {

                        for (j = x0 - 1; j >= i; j--) {

                                if (grid[j][y0] != 0) {

                                        k = 0;

                                        break;

                                } else {

                                        k = 2;

                                }

                        }

                }

                if (x0 < i) {

                        for (j = x0 + 1; j <= i; j++) {

                                if (grid[j][y0] != 0) {

                                        k = 0;

                                        break;

                                } else {

                                        k = 2;

                                }

                        }

                }

        }

        public void remove() {

                firstButton.setVisible(false);

                secondButton.setVisible(false);

                fraction();

                pressInformation = false;

                k = 0;

                grid[x0][y0] = 0;

                grid[x][y] = 0;

        }

        public void actionPerformed(ActionEvent e) {

                
 if (e.getSource() == resetButton)
          {
          System.out.println("wtf");
                        reload();
                        mainFrame.setVisible(true);
                        }

                if (e.getSource() == exitButton)

                        System.exit(0);

               

                for (int cols = 0; cols < rowCount; cols++) {

                        for (int rows = 0; rows < columnCount; rows++) {

                                if (e.getSource() == diamondsButton[cols][rows])

                                        estimateEven(cols + 1, rows + 1, diamondsButton[cols][rows]);

                        }

                }

        }

      

       

      

    class CountdownTimerListener implements ActionListener {
    

        public void actionPerformed(ActionEvent e) {

            if (--timeRemaining > 0&&count!=((columnCount*rowCount)/2)) {

                label.setText(String.valueOf(timeRemaining));

            } else {
            if(timeRemaining<0&&count<((columnCount*rowCount)/2)&&happend==false)
            {
            happend=true;
            System.out.println("wtf3");
                 int choice = JOptionPane.showConfirmDialog (mainFrame,
                         "GAME OVER! Are you going to continue to the duel on this computer?" ,"Continuing?" , JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                         System.out.println(count);
                         if(choice==0)
                         {
                         String entry = JOptionPane.showInputDialog("What is your partner's score?");
                         Duel dd=new Duel(1,8,exppt,Integer.parseInt(entry));
            mainFrame.setVisible(false);
            dd.init();

                         }
                         else{
                          JOptionPane.showMessageDialog (mainFrame,
                         "Thanks for playing!Your score is: "+exppt+".  Please continue to the dual at the other player's computer or restart the game! " ,"" , JOptionPane.INFORMATION_MESSAGE);
                         System.out.println(count);
                         System.exit(0);

                         }
          /*  Duel dd=new Duel(1,8,60,80);
            mainFrame.setVisible(false);
            dd.init();*/
            countdownTimer.stop();
            }
            else if(timeRemaining>=0&&count>=((columnCount*rowCount)/2))
            {
            exppt+=timeRemaining;
            //count=0;
            columnCount+=2;
            rowCount+=2;
      
                       
      mainFrame.setVisible(false);
                      MainGame wtf=new MainGame(columnCount);
                      wtf.time=time;
                             wtf.time+=addamount;
                             wtf.count=0;
            

               wtf.exppt=exppt;
             wtf.timeRemaining = wtf.time;
             wtf.init();
             wtf.mainFrame.setVisible(true);

             System.out.println(timeRemaining);

                countdownTimer.stop();
                
            }
            
            }

            }

        }

    }

 

        



import java.awt.Color;

import java.awt.Font;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.MatteBorder;

public class DregerButton extends JButton {

    //Font defaultFont = new Font("Gill Sans MT",Font.BOLD,30);
    Font customFont;
        try{
          customFont = Font.createFont(Font.TRUETYPE_FONT, new File("P.otf")).deriveFont(30f);        
          }
          catch(Exception e){
     customFont=new Font("bold",Font.BOLD,30);
        }                  //Font font1 = new Font(customFont,Font.BOLD,130);


    Color textColor = Color.decode("#000080");

    Color backgroundColor = (Color.WHITE);
        Color hoverColor = Color.decode("#A7DBD8");

    
   public DregerButton() {

       

        this.setFocusPainted(true);

        //this.setText(s);
        

               this.setForeground(backgroundColor);

        this.setBackground(backgroundColor);

        this.setFont(defaultFont);

        this.setOpaque(true);

        //addMouseListener(this);

    }
    public DregerButton(String s) {

       

        this.setFocusPainted(true);

        this.setText(s);

       // this.setBorder(null);
       this.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));

        this.setForeground(textColor);

        this.setBackground(backgroundColor);
                  this.setFont(customFont);


        //this.setFont(defaultFont);

        this.setOpaque(false);

        //addMouseListener(this);

    }

  }

    
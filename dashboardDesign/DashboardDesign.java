package dashboardDesign;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager; 
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import java.awt.event.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;



public class DashboardDesign extends JFrame{  // Container **
    JButton b1,b2,b3,b4,b5,b6;
    JMenu file,edit,view;
    JMenuBar mb;
    JMenuItem save,saveas,saveall,exit;
    JMenuItem cut,copy,paste;
   
    public DashboardDesign()
    {   
        setSize(1500,700);
        setLayout(null);
//        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
    }
    public void menu() 
    {
        
        file=new JMenu("File");
        edit=new JMenu("Edit");
        view=new JMenu("View");
        
        save=new JMenuItem("Save");
        saveas=new JMenuItem("Save As");
        saveall=new JMenuItem("Save All");
        exit=new JMenuItem("Exit");
        cut=new JMenuItem("Cut");
        copy=new JMenuItem("Copy");
        paste=new JMenuItem("Paste");
        mb=new JMenuBar();
        
        //Sub menu item add
        file.add(save);
        file.add(saveas);
        file.add(saveall);
        file.add(exit);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        
        //Menu item add to the menubar
        mb.add(file);
        mb.add(edit);
        mb.add(view);
        
        setJMenuBar(mb);
        
        //Font change of the Menu
        Font font= new Font(mb.getFont().getFontName(), mb.getFont().getStyle(), 16);  //Change menubar size
        UIManager.put("Menu.font", font);
        SwingUtilities.updateComponentTreeUI(new JFrame());
        


    }
    
    public void frameButton()
    {
        b1=new JButton("Check BOOK");
        b1.setBounds(200,200, 130, 130);
        b2=new JButton("Book Search");
        b2.setBounds(400,200, 130, 130);
        
        b3=new JButton();
        b3.setBounds(600,200, 130, 130);
        b4=new JButton();
        b4.setBounds(800,200, 130, 130);
        
        b1.setBackground(new Color(204, 255, 204));
        b2.setBackground(new Color(204, 255, 204));
        b3.setBackground(new Color(204, 255, 204));
        b4.setBackground(new Color(204, 255, 204));
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
    } 

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        
//        Toolkit t=Toolkit.getDefaultToolkit();  
//        Image i=t.getImage("G:/Project 2021/Library Management System/p1.jpg");  
//        g.drawImage(i, 12,10,this); 
        //1st Rectangle
//        g.drawString("Operation", 120, 235);
        
        Graphics2D g1 = (Graphics2D) g;
        g1.setPaint(new Color(0, 153, 51));
        g1.setStroke(new BasicStroke(2.0f));
        g1.drawRoundRect(100, 230, 1180, 190, 50, 50);  //50 and 50 is round size & x and y is position of rectangle
        //2nd Rectangle
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(new Color(0, 153, 51));
        g2.setStroke(new BasicStroke(2.0f));
        g2.drawRoundRect(100, 485, 1180, 190, 50, 50);  //50 and 50 is round size of rectangle
    }

}


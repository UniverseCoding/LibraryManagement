package dashboardDesign;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager; 
import javax.swing.SwingUtilities;
import java.awt.event.*;
import java.awt.*;

public class DashboardDesign {
    JFrame frame;
    JButton b1,b2,b3,b4,b5,b6;
    JMenu file,edit,view;
    JMenuBar mb;
    JMenuItem save,saveas,saveall,exit;
    JMenuItem cut,copy,paste;
    public void menu() 
    {
        frame=new JFrame();
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
        
        frame.setJMenuBar(mb);
        
        Font font= new Font(mb.getFont().getFontName(), mb.getFont().getStyle(), 16);  //Change menubar size
        UIManager.put("Menu.font", font);
        SwingUtilities.updateComponentTreeUI(frame);
        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
    }
    public void frameButton()
    {
        b1=new JButton("Check BOOK");
        b1.setBounds(20,60, 200, 80);
        b1.setBackground(new Color(204, 255, 204));
        b2=new JButton("Book Search");
        b2.setBounds(400,60, 200, 80);
        b2.setBackground(new Color(204, 255, 204));

        /*
        b3=new JButton();
        b4=new JButton();
        b5=new JButton();
        b6=new JButton();
        */
        
        frame.add(b1);
        frame.add(b2);
    }
}


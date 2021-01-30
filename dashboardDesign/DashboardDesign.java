package dashboardDesign;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.*;

public class DashboardDesign {
    JFrame frame;
    JMenu file,edit,view;
    JMenuBar mb;
    JMenuItem save,saveas,saveall,exit;
    JMenuItem cut,copy,paste;
    public void gui() 
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
        
        file.add(save);
        file.add(saveas);
        file.add(saveall);
        file.add(exit);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        
        mb.add(file);
        mb.add(edit);
        mb.add(view);
        
        frame.setJMenuBar(mb);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
    }
}

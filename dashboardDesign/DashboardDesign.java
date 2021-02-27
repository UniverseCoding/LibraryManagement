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
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class DashboardDesign extends JFrame implements ActionListener{  // Container **
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    JMenu file,edit,view;
    JMenuBar mb;
    JMenuItem save,saveas,saveall,exit;
    JMenuItem cut,copy,paste;
   
    public DashboardDesign()
    {   
        setTitle("Library Management System");
        setIconSize();
        setSize(1500,700);
        setLayout(null);
//        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
    ImageIcon newImc1,newImc2,newImc3,newImc4,newImc5,newImc6,newImc7,newImc8;
    private void setIconSize()
    {
        ImageIcon icon1=new ImageIcon("G:/Project 2021/Library Management System/Librarian/src/dashboardDesign/p1.png");   //Please change image path
        ImageIcon icon2=new ImageIcon("G:/Project 2021/Library Management System/Librarian/src/dashboardDesign/p5.png");
        ImageIcon icon3=new ImageIcon("G:/Project 2021/Library Management System/Librarian/src/dashboardDesign/p1.png");
        ImageIcon icon4=new ImageIcon("G:/Project 2021/Library Management System/Librarian/src/dashboardDesign/p3.png");
        ImageIcon icon5=new ImageIcon("G:/Project 2021/Library Management System/Librarian/src/dashboardDesign/p7.png");
        ImageIcon icon6=new ImageIcon("G:/Project 2021/Library Management System/Librarian/src/dashboardDesign/p7.png");
        ImageIcon icon7=new ImageIcon("G:/Project 2021/Library Management System/Librarian/src/dashboardDesign/p2.png");
        ImageIcon icon8=new ImageIcon("G:/Project 2021/Library Management System/Librarian/src/dashboardDesign/p4.png");
        
        Image img1 = icon1.getImage();
        Image img2 = icon2.getImage();
        Image img3 = icon3.getImage();
        Image img4 = icon4.getImage();
        Image img5 = icon5.getImage();
        Image img6 = icon6.getImage();
        Image img7 = icon7.getImage();
        Image img8 = icon8.getImage();
        
        Image newImg1 = img1.getScaledInstance(127, 127, Image.SCALE_SMOOTH);
        Image newImg2 = img2.getScaledInstance(127, 127, Image.SCALE_SMOOTH);
        Image newImg3 = img3.getScaledInstance(127, 127, Image.SCALE_SMOOTH);
        Image newImg4 = img4.getScaledInstance(127, 127, Image.SCALE_SMOOTH);
        Image newImg5 = img5.getScaledInstance(127, 127, Image.SCALE_SMOOTH);
        Image newImg6 = img6.getScaledInstance(127, 127, Image.SCALE_SMOOTH);
        Image newImg7 = img7.getScaledInstance(127, 127, Image.SCALE_SMOOTH);
        Image newImg8 = img8.getScaledInstance(127, 127, Image.SCALE_SMOOTH);
        
        newImc1 = new ImageIcon(newImg1);
        newImc2 = new ImageIcon(newImg2);
        newImc3 = new ImageIcon(newImg3);
        newImc4 = new ImageIcon(newImg4);
        newImc5 = new ImageIcon(newImg5);
        newImc6 = new ImageIcon(newImg6);
        newImc7 = new ImageIcon(newImg7);
        newImc8 = new ImageIcon(newImg8);
    }
    public void frameButton()
    {
        b1=new JButton(newImc1);
        b2=new JButton(newImc2); 
        b3=new JButton(newImc3);
        b4=new JButton(newImc4);
        b5=new JButton(newImc5);
        b6=new JButton(newImc6);
        b7=new JButton(newImc7);
        b8=new JButton(newImc8);
        
        b1.setBounds(200,200, 130, 130);
        b2.setBounds(475,200, 130, 130);
        b3.setBounds(750,200, 130, 130);
        b4.setBounds(1025,200, 130, 130);
        b5.setBounds(200,455, 130, 130);
        b6.setBounds(475,455, 130, 130);
        b7.setBounds(750,455, 130, 130);
        b8.setBounds(1025,455, 130, 130);
        
        //JButton color add
        b1.setBackground(new Color(255, 255, 255));
        b2.setBackground(new Color(255, 255, 255));
        b3.setBackground(new Color(255, 255, 255));
        b4.setBackground(new Color(255, 255, 255)); 
        b5.setBackground(new Color(255, 255, 255));
        b6.setBackground(new Color(255, 255, 255));
        b7.setBackground(new Color(255, 255, 255));
        b8.setBackground(new Color(255, 255, 255));
        
        //JButton adding with JFrame
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
    } 
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source=e.getSource();
        dispose();
        if(source == b1)
        {
            NewStudent ns=new NewStudent();
        }
        if(source == b2)
        {
            NewBook nb=new NewBook();
        }
        if(source == b3)
        {
            NewAccount na=new NewAccount();
        }
        if(source == b4)
        {
            Statistics st=new Statistics();
        }
        if(source == b5)
        {
            IssueBook ib=new IssueBook();
        }
        if(source == b6)
        {
            ReturnBook rb=new ReturnBook();
        }
        if(source == b7)
        {
            SearchBook sb=new SearchBook();
        }
        if(source == b8)
        {
            StudentInformation si=new StudentInformation();
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        

        //1st Rectangle      
        Graphics2D g1 = (Graphics2D) g;
        g1.setPaint(new Color(0, 0, 0));
        g1.setStroke(new BasicStroke(2.0f));
        g1.drawRoundRect(145, 230, 1080, 190, 50, 50);  //50 and 50 is round size & x and y is position of rectangle
        
        //2nd Rectangle
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(new Color(0, 0, 0));
        g2.setStroke(new BasicStroke(2.0f));
        g2.drawRoundRect(145, 485, 1080, 190, 50, 50);  //50 and 50 is round size of rectangle
        
        g.setFont(g.getFont().deriveFont(15f));
//        g.setFont(new Font("Bold", Font.PLAIN, 15)); 

        g.drawString("Operation", 175, 234);
        g.drawString("Action", 175, 490);
        
        g.drawString("New Student", 232, 400);
        g.drawString("New Book", 515, 400);
        g.drawString("New Account", 780, 400);
        g.drawString("Statistics", 1067, 400);
        g.drawString("Issue Book", 238, 655);
        g.drawString("Return Book", 515, 655);
        g.drawString("Search Book", 780, 655);
        g.drawString("Student Information", 1035, 655);      
    }

}


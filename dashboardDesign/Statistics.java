package dashboardDesign;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import librarian.Librarian;

public class Statistics extends JFrame{

    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JLabel dot;
    
    Statistics()
    {
        
        setTitle("Library Management System");
        setSize(1500,700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        
    }
    
    public void gui()
    {
      
        JButton j = new JButton();
        l=new JLabel("100%");
        l1=new JLabel("80%");
        l2=new JLabel("60%");
        l3=new JLabel("40%");
        l4=new JLabel("20%");
        l5=new JLabel("0%");
        
        l6=new JLabel("Arts");
        l7=new JLabel("Science");
        l8=new JLabel("Biographies");
        l9=new JLabel("Business");
        l10=new JLabel("Computer & Tech.");
        l11=new JLabel("Entertainment");
        l12=new JLabel("Health & Fitness");
        l13=new JLabel("Religion");
        l14=new JLabel("Sports");
        l15=new JLabel("Others");
        
       
        j.setBounds(10,10,35,20);
        l.setBounds(60,40,170,50);
        l1.setBounds(65,40,170,240);
        l2.setBounds(65,40,170,440);
        l3.setBounds(65,40,170,640);
        l4.setBounds(65,40,170,840);
        l5.setBounds(70,40,170,1050);
        
        l6.setBounds(100,220,170,715);
        l7.setBounds(190,220,170,715);
        l8.setBounds(290,220,170,715);
        l9.setBounds(420,220,170,715);
        l10.setBounds(540,220,170,715);
        l11.setBounds(720,220,170,715);
        l12.setBounds(870,220,170,715);
        l13.setBounds(1020,220,170,715);
        l14.setBounds(1130,220,170,715);
        l15.setBounds(1240,220,170,715);

        add(j);
        add(l);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        
        add(l6);
        add(l7);
        add(l8);
        add(l9);
        add(l10);
        add(l11);
        add(l12);
        add(l13);
        add(l14);
        add(l15);
        
          j.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            Librarian ob = new Librarian();
            setVisible(false);
            
        } 
       }); 
    }
    
    void data() //throws SQLException
    {
        int Arts_c = 0,Science_c=0,Biographies_c=0,Business_c=0,Entertainment_c=0,Computer_c=0,Religion_c=0,Sports_c=0,Health_c=0,Others_c=0 ;
        // set  preparedStatement and resultset for 10 difference query
        
        PreparedStatement st = null;
        ResultSet rs =null;
        
        PreparedStatement st2 = null;
        ResultSet rs2 =null;
        
        PreparedStatement st3 = null;
        ResultSet rs3 =null;
        
        PreparedStatement st4 = null;
        ResultSet rs4 =null;
        
        PreparedStatement st5 = null;
        ResultSet rs5 =null;
        
        PreparedStatement st6 = null;
        ResultSet rs6 =null;
        
        PreparedStatement st7 = null;
        ResultSet rs7 =null;
        
        PreparedStatement st8 = null;
        ResultSet rs8 =null;
        
        PreparedStatement st9 = null;
        ResultSet rs9 =null;
        PreparedStatement st10 = null;
        ResultSet rs10 =null;
      try{  
            Conn con = new Conn();               
            //Conn con2 = new Conn();
            String sql = "select count(*) from issuebook where category='Arts'";
            String sql2 = "select count(*) from issuebook where category='Science'";
            String sql3 = "select count(*) from issuebook where category='Biographies'";
            String sql4 = "select count(*) from issuebook where category='Business'";
            String sql5 = "select count(*) from issuebook where category='Computer & Tech'";
            String sql6 = "select count(*) from issuebook where category='Entertainment'";
            String sql7 = "select count(*) from issuebook where category='Health & Fitness'";
            String sql8 = "select count(*) from issuebook where category='Religion'";
            String sql9 = "select count(*) from issuebook where category='Sports'";
            String sql10 = "select count(*) from issuebook where category='Others'";
           
            st = con.c.prepareStatement(sql);
            rs = st.executeQuery();
             
            st2= con.c.prepareStatement(sql2);            
            rs2= st2.executeQuery();
            
            st3= con.c.prepareStatement(sql3);            
            rs3= st3.executeQuery();
            
            st4= con.c.prepareStatement(sql4);            
            rs4= st4.executeQuery();
            
            st5= con.c.prepareStatement(sql5);            
            rs5= st5.executeQuery();
            
            st6= con.c.prepareStatement(sql6);            
            rs6= st6.executeQuery();
            
            st7= con.c.prepareStatement(sql7);            
            rs7= st7.executeQuery();
            
            st8= con.c.prepareStatement(sql8);            
            rs8= st8.executeQuery();
            
            st9= con.c.prepareStatement(sql9);            
            rs9= st9.executeQuery();
            
            st10= con.c.prepareStatement(sql10);            
            rs10= st10.executeQuery();
            
            
            
            if(rs.next()){
            Arts_c = rs.getInt(1); 
            //System.out.print(Arts_c);
            }
            
             if(rs2.next()){
             Science_c = rs2.getInt(1);         
            }
             
              if(rs3.next()){
            Biographies_c = rs3.getInt(1);        
            }
              
                if(rs4.next()){
            Business_c = rs4.getInt(1);           
            }
                
             if(rs5.next()){
             Computer_c = rs5.getInt(1);
             
            }
             
              if(rs6.next()){
            Entertainment_c= rs6.getInt(1);  
            
            }
              
                 if(rs7.next()){
             Health_c = rs7.getInt(1); 
             
            }
                 
              if(rs8.next()){
            Religion_c = rs8.getInt(1);        
            }
              
                if(rs9.next()){
            Sports_c = rs9.getInt(1);           
            }
                
             if(rs10.next()){
             Others_c = rs10.getInt(1);         
            }
             
          
            
        }catch(Exception ea)
            {
                JOptionPane.showMessageDialog(null,ea);              
            }
      catagory_value(Arts_c,Science_c,Biographies_c,Business_c,Computer_c,Entertainment_c,Health_c,Religion_c,Sports_c,Others_c);
      
    }
    
    
    void catagory_value(int arts,int science,int biographies,int business,int computerTech,int entertainment,int healthFit,int religion,int sports,int others)
            
    {
        long sum= arts+science+biographies+business+computerTech+entertainment+healthFit+religion+sports+others;

        for(int i=0;i<10;i++)
        {
            int x=0,n=0;
            switch(i)
            {
                
                case 0:
                    n=(int)((100*arts)/sum);                
                    x=110;
                    break;
                case 1:
                    n=(int) ((100*science)/sum);
                    x=210;
                    break;
                case 2:
                    n=(int) ((100*biographies)/sum);
                    x=322;
                    break;
                case 3:
                    n=(int) ((100*business)/sum);             
                    x=445;
                    break;
                case 4:
                    n=(int) ((100*computerTech)/sum);
                    x=590;
                    break;
                case 5:
                    n=(int) ((100*entertainment)/sum);
          
                    x=757;
                    break;
                case 6:
                    n=(int) ((100*healthFit)/sum);
                    x=910;
                    break;
                case 7:
                    n=(int) ((100*religion)/sum);
                    x=1040;
                    break;
                case 8:
                    n=(int) ((100*sports)/sum);
                    x=1147;
                    break;
                default:
                    n=(int) ((100*others)/sum);
                    x=1256;
                    break;
            } 
            
            int space=1000;
            for(int j=0;j<n;j++)
            {
                dot=new JLabel(".");
                dot.setBounds(x, 60, 400, space);
                add(dot);
                space-=10;
            }
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);  
        Graphics2D g2 = (Graphics2D) g;
        Line2D li = new Line2D.Float(100, 50, 100, 600);
        Line2D li1 = new Line2D.Float(100, 600, 1290, 600);
        g2.draw(li);
        g2.draw(li1);
    }
    
}

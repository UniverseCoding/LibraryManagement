
package dashboardDesign;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
        
        /*"Arts","Science","Biographies","Business","Comics","Computer & Tech",
            "Cooking","Entertainment","Health & Fitness","Literature",
            "Religion","Sports","Others*/

        l.setBounds(65,40,170,50);
        l1.setBounds(70,40,170,240);
        l2.setBounds(70,40,170,440);
        l3.setBounds(70,40,170,640);
        l4.setBounds(70,40,170,840);
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
        
    }
    void catagory_value(int arts,int science,int biographies,int business,int computerTech,int entertainment,int healthFit,int religion,
        int sports,int others)
    {
        long sum= arts+science+biographies+business+computerTech+entertainment+healthFit+religion+sports+others;
        for(int i=0;i<10;i++)
        {
            int x=0,n=0;
            switch(i)
            {
                
                case 0:
                    n=(int)(100*(sum/arts));
                    x=110;
                    break;
                case 1:
                    n=(int) (100*(sum/science));
                    x=210;
                    break;
                case 2:
                    n=(int) (100*(sum/biographies));
                    x=322;
                    break;
                case 3:
                    n=(int) (sum/(business*100));             //***
                    x=445;
                    System.out.println(n);
                    break;
                case 4:
                    n=(int) (100*(sum/computerTech));
                    x=590;
                    break;
                case 5:
                    n=(int) (100*(sum/entertainment));
                    x=757;
                    break;
                case 6:
                    n=(int) (100*(sum/healthFit));
                    x=910;
                    break;
                case 7:
                    n=(int) (100*(sum/religion));
                    x=1040;
                    break;
                case 8:
                    n=(int) (100*(sum/sports));
                    x=1147;
                    break;
                default:
                    n=(int) (100*(sum/others));
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

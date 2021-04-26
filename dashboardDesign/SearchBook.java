
package dashboardDesign;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import librarian.Librarian;


public class SearchBook extends JFrame{
    
    private JTextField jtext;
    private JTable table;
    private JComboBox cb2;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private String[] columns = {"Category","Book Name","ISBN","Auther Name",
                              "Publisher Name","Year of publication","Edition","Price"};
    private String category_jcom[]={"Select","Arts","Science","Biographies","Business","Comics","Computer & Tech",
                           "Cooking","Entertainment","Health & Fitness","History","Literature","Medical",
                           "Religion","Romance","Self-Help","Sports","Travel","Others"};
    
    private String search_by[] = {"Select","All Book","Name","Category","ISBN","Author Name"};
    private String select;
    int rowcount;

    SearchBook()
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
        Font font=new Font("Bold", 1, 22);//Create a new font.       
        JLabel jlabel_search=new JLabel("Book search By");//create a jlabel
        jlabel_search.setBounds(350,20,190,100); //set jlabel location
        jlabel_search.setFont(font); //set Jlabel font size
        add(jlabel_search);// added label
            
        //create jtextfield 
        jtext = new JTextField();
        jtext.setBounds(680,57,170,30);
        add(jtext);
        jtext.setVisible(false);
        
        //create jBotton
         JButton jbutton_search=new JButton("Search");
         jbutton_search.setBounds(870,57,80,30);
         add(jbutton_search);
         //create back button
         JButton back =new JButton("Back");
         back.setBounds(970,57,80,30);
         add(back);
         
         //create jcombobox
         JComboBox cb = new JComboBox(search_by);
         cb.setBounds(540,57,120,30);
         add(cb);
         
        //create jcombobox for select category
        cb2 = new JComboBox(category_jcom);
        cb2.setBounds(690,57,140,30);
        add(cb2);
        cb2.setVisible(false);
        

        // create table
         table = new JTable();
         model = new DefaultTableModel();
         model.setColumnIdentifiers(columns);
        
         table.setModel(model);
        // table.setFont(font);
         table.setRowHeight(30);
       
        
         scroll =new JScrollPane(table);
         scroll.setBounds(200,200,940,355);
         add(scroll);
         
         //jcombobox acctionlistener for category select
         cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
               select = cb.getSelectedItem().toString();             
               
               if(select=="Category")
               {
                    cb2.setVisible(true);
                    jtext.setVisible(false);                  
               }
               
               else if(select=="Select")
               {
                    jtext.setVisible(false);
                    cb2.setVisible(false);
                }
               
               else if(select=="All Book")
               {
                    jtext.setVisible(false);
                    cb2.setVisible(false);
                    //show all books from database
                    try
                    {
                        Conn con2 = new Conn();
                        String sql2 = "select *from newbook";
                        PreparedStatement st2 = con2.c.prepareStatement(sql2);
                        ResultSet rs2 = st2.executeQuery();
                        reset();
                        if(rs2.next()==false)
                        {   
                            JOptionPane.showMessageDialog(null,"No Record Found!");
                        }
                        else
                        {
                            do
                            {                          
                                String category = rs2.getString("category");
                                String bName = rs2.getString("bName"); 
                                String isbn = rs2.getString("isbn");
                                String aName = rs2.getString("aName");
                                String pName = rs2.getString("pName");
                                String year = rs2.getString("year_of_publication");
                                String edition = rs2.getString("edition");
                                String price = rs2.getString("price");

                                model.addRow(new Object[]{category,bName,isbn,aName,pName,year,edition,price});                                              
                                table.setModel(model);            
                            }while(rs2.next());  
                        }
                             st2.close();
                             rs2.close();
                    }catch(Exception ea)
                    {
                        JOptionPane.showMessageDialog(null,ea);                                   
                    }
                     
                }             
                else
                {
                    jtext.setVisible(true);
                    cb2.setVisible(false);
                }
                
            }
        });
         
         //add actionlistener for Jbutton_search
         jbutton_search.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
           try{
                            
                Conn con = new Conn();           
                String sql = "select * from newbook where bname=? || isbn = ? || category =? || aName=? ";		
                PreparedStatement st = con.c.prepareStatement(sql);                
		st.setString(1, jtext.getText());
                st.setString(2, jtext.getText());
                st.setString(3, cb2.getSelectedItem().toString());
                st.setString(4, jtext.getText());
                ResultSet rs = st.executeQuery(); 
                
                reset();
                                                                             
                if(rs.next()==false) 
                {   
                     JOptionPane.showMessageDialog(null,"No Record Found!");
                }
                
                 else
                {
                    do
                    {                      
                        String category = rs.getString("category");
                        String bName = rs.getString("bName"); 
                        String isbn = rs.getString("isbn");
                        String aName = rs.getString("aName");
                        String pName = rs.getString("pName");
                        String year = rs.getString("year_of_publication");
                        String edition = rs.getString("edition");
                        String price = rs.getString("price");

                        model.addRow(new Object[]{category,bName,isbn,aName,pName,year,edition,price});                                              
                        table.setModel(model); 
                        
                    } while(rs.next());  
                }
                                     
                    st.close();
                    rs.close();		              
               
            }catch(Exception ea)
            {
                JOptionPane.showMessageDialog(null,ea);              
            }
          
        }
        });
         
        back.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            Librarian ob = new Librarian();
            setVisible(false);
            
        } 
       });  
    }
    //create reset method to clear jtable data 
     public void reset()
    {
        jtext.setText("");    
        for(int i = model.getRowCount() -1; i>=0; i--)
        {
            model.removeRow(i);
        }             
    }
}

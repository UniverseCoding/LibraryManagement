
package dashboardDesign;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class SearchBook extends JFrame{
    
    private JTextField jtext;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private String[] columns = {"Category","Book Name","ISBN","Auther Name",
                    "Publisher Name","Year of publication","Edition","Price"};
    private String[] rows = new String[8];
    int rowcount,rowcount2;

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
        JLabel jlabel_search=new JLabel("Book search");//create a jlabel
        jlabel_search.setBounds(415,20,150,100); //set jlabel location
        jlabel_search.setFont(font); //set Jlabel font size
        add(jlabel_search);// added label
            
        //create jtextfield 
        jtext = new JTextField();
        jtext.setBounds(580,57,170,30);
        add(jtext);
        
        //create jBotton
         JButton jbutton_search=new JButton("Search");
         jbutton_search.setBounds(770,57,80,30);
         add(jbutton_search);
         // create table
         table = new JTable();
         model = new DefaultTableModel();
         model.setColumnIdentifiers(columns);
         table.setModel(model);
        // table.setFont(font);
         table.setRowHeight(30);
         
         
         scroll =new JScrollPane(table);
         scroll.setBounds(200,200,940,285);
         add(scroll);
         
         //add actionlistener
         jbutton_search.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
           try{
               Conn con = new Conn();
                String sql = "select * from newbook where bName=? || isbn = ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, jtext.getText());
                st.setString(2, jtext.getText());
                ResultSet rs = st.executeQuery();             
                if(rs.next())
                {
                    
                   // rs.beforeFirst();
                
                      rows[0] = rs.getString("category");
                      rows[1] = rs.getString("bName");
                      rows[2] = rs.getString("isbn");
                      rows[3] = rs.getString("aName");
                      rows[4] = rs.getString("pName");
                      rows[5] = rs.getString("year_of_publication");
                      rows[6] = rs.getString("edition");
                      rows[7] = rs.getString("price");
                      rowcount = table.getRowCount();
                                            
                      if(rowcount>0)
                      model.removeRow(0); //delete zeros no row
                      
                      reset();//reset method call for reset jtextfield
                      model.addRow(rows); 
                                                                                                         
		}
                    else
                    {                     
                        rowcount2 = table.getRowCount();
                        
                        if(rowcount2>0)  
                            model.removeRow(0); //delete zeros no row
                        
                        reset();                      
                        JOptionPane.showMessageDialog(null,"No Record Found!");                 
                        
                    }
                
                    st.close();
                    rs.close();		              
               
            }catch(Exception ea){
                   System.out.println(ea);              
            }
          
        }
        });
                              
    }
    
     public void reset()
    {
        jtext.setText("");    
            
    }
}

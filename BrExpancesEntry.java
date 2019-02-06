package bismilResto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;


public class BrExpancesEntry extends JFrame {
    JLabel backimg5 ,title5;
    JTable tb2;
    JButton btnsave5,btnupdate5,btnhome5;
    

public BrExpancesEntry(){
super("Expancess Entry");
    setLayout(null);
    
    backimg5 =new JLabel(new ImageIcon("F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\ee.jpg"));
        backimg5.setBounds(0,0,1000,500);
        add(backimg5);
          title5 =new JLabel("Expancess");
        title5.setBounds(430,10,200,30);
        title5.setForeground(new Color(153,153,153));
        title5.setFont(new Font("serif",Font.BOLD,20));
        backimg5.add(title5);
        JPanel titlepanel5 =new JPanel(null);
        titlepanel5.setBounds(350,10,250,30);
        titlepanel5.setBackground(new Color(0,0,0,150));
        backimg5.add(titlepanel5);
        
        JPanel tablepanel5 = new JPanel(null);
        tablepanel5.setBounds(15,130,950,350);
        tablepanel5.setBackground(new Color(0,0,0,150));
        backimg5.add(tablepanel5);
        
        tb2 =new JTable();
       tb2.setModel(new DefaultTableModel( 
        new Object[][] {{/*"date","gorssary","vegetable","meat","chicken","fish","other"*/},
            {null,null,null,null,null,null,null},{null,null,null,null,null,null,null},{null,null,null,null,null,null,null}
        },
        new String[]{"date","gorssary","vegetable","meat","chicken","fish","other"}
        
        ));
          
        tb2.setBounds(5,5,945,345);
        tb2.setBackground(new Color(0,0,0));
        tb2.setForeground(new Color(255,255,255));
        tb2.setRowHeight(20); 
        //tablepanel5.add(tb2);
        JScrollPane jsp = new JScrollPane(tb2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setBounds(0,0,945,145);
        tablepanel5.add(jsp);
        jsp.setViewportView(tb2);
        
        btnsave5 =new JButton("Save");
        btnsave5.setBounds(750,60,90,30);
        btnsave5.setFont(new Font("serif",Font.BOLD,15));
        btnsave5.setBackground(new Color(0,0,0,150));
        btnsave5.setForeground(new Color(153,153,153));
        backimg5.add(btnsave5);
         btnsave5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Connection conn=null;
            PreparedStatement ps =null;
            try
            {
                int rows =tb2.getRowCount();
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
      //          conn =DriverManager.getConnection("jdbc:ucanaccess://F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\msDAta\\bismil.accdb");
              conn =DriverManager.getConnection("jdbc:ucanaccess:bismil.accdb");
            
                conn.setAutoCommit(false);
                String sql="insert into br_expancess(date,gorssary,vegetable,meat,chicken,fish,other) values(?,?,?,?,?,?,?)";
                ps =conn.prepareStatement(sql);
                for(int row=0;row<rows;row++){
                 String date =(String)tb2.getValueAt(row,0);
                 String gorssary =(String)tb2.getValueAt(row,1);
                 String vegetable =(String)tb2.getValueAt(row,2);
                 String meat =(String)tb2.getValueAt(row,3);
                 String chicken =(String)tb2.getValueAt(row,4);
                 String fish =(String)tb2.getValueAt(row,5);
                 String other =(String)tb2.getValueAt(row,6);
                 ps.setString(1,date);
                 ps.setString(2,gorssary);
                 ps.setString(3,vegetable);
                 ps.setString(4,meat);
                 ps.setString(5,chicken);
                 ps.setString(6,fish);
                 ps.setString(7,other);
                
                 ps.addBatch();
                }
               
               ps.executeBatch();
               conn.commit();
               JOptionPane.showMessageDialog(null,"SuccessFully , Saved Data");
            }   catch (ClassNotFoundException ex) {
                System.out.println(ex);
                //  JOptionPane.showMessageDialog(null,"Class Not Found");
            } catch (SQLException ex) {
              System.out.println(ex);
            }
            }});
       
      
         
       /* btnupdate5 =new JButton("Update");
        btnupdate5.setBounds(650,60,90,30);
        btnupdate5.setFont(new Font("serif",Font.BOLD,15));
        btnupdate5.setBackground(new Color(0,0,0,150));
        btnupdate5.setForeground(new Color(153,153,153));
        backimg5.add(btnupdate5);*/
      
          btnhome5 =new JButton("Home");
        btnhome5.setBounds(850,60,90,30);
        btnhome5.setFont(new Font("serif",Font.BOLD,15));
        btnhome5.setBackground(new Color(0,0,0,150));
        btnhome5.setForeground(new Color(153,153,153));
        backimg5.add(btnhome5);
        btnhome5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new User_form();
            }
        });
      
    
    
    
    
    setSize(1000,500);
    setVisible(true);
    setDefaultCloseOperation(HIDE_ON_CLOSE);
    setLocationRelativeTo(null);
    
}    
public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
    UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
 
    
    new BrExpancesEntry();
}
}

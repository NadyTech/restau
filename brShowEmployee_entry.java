package bismilResto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import net.proteanit.sql.DbUtils;

public class brShowEmployee_entry extends JFrame {
    JLabel backimg6 ,title6,ldate,lname,lintime,louttime,lid;
    JTable tb3;
    JButton btnshow,btnhome;
    
    public brShowEmployee_entry(){
     super("Employee Details");
        setLayout(null);
            
        backimg6 =new JLabel(new ImageIcon("F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\ee.jpg"));
        backimg6.setBounds(0,0,1000,500);
        add(backimg6);
       
        title6 =new JLabel("Employee Details");
        title6.setBounds(400,10,200,30);
        title6.setForeground(new Color(153,153,153));
        title6.setFont(new Font("serif",Font.BOLD,20));
        backimg6.add(title6);
        JPanel titlepanel =new JPanel(null);
        titlepanel.setBounds(350,10,250,30);
        titlepanel.setBackground(new Color(0,0,0,150));
        backimg6.add(titlepanel);
      
        JPanel tablepanel = new JPanel(null);
        tablepanel.setBounds(15,130,950,350);
        tablepanel.setBackground(new Color(0,0,0,150));
        backimg6.add(tablepanel);
        
         Font f =new Font("serif",Font.BOLD,18);
        
        JPanel tableheader =new JPanel(null);
        tableheader.setBackground(new Color(0,0,0,150));
        tableheader.setBounds(15,103,950,30);
        backimg6.add(tableheader);
        
        ldate = new JLabel("Date");
        ldate.setBounds(0,0,50,20);
        ldate.setFont(f);
        ldate.setForeground(new Color(153,153,153));
        tableheader.add(ldate);
        
        lname =new JLabel("Empl_Name");
        lname.setBounds(425,0,250,20);
        lname.setFont(f);
        lname.setForeground(new Color(153,153,153));
        tableheader.add(lname);
        
        lid =new JLabel("Empl_Id");
        lid.setBounds(250,0,250,20);
        lid.setFont(f);
        lid.setForeground(new Color(153,153,153));
        tableheader.add(lid);
        
        lintime = new JLabel("In_Time");
        lintime.setBounds(625,0,250,20);
        lintime.setFont(f);
        lintime.setForeground(new Color(153,153,153));
        tableheader.add(lintime);
        
        louttime = new JLabel("In_Time");
        louttime.setBounds(825,0,250,20);
        louttime.setFont(f);
        louttime.setForeground(new Color(153,153,153));
        tableheader.add(louttime);
       
       tb3 =new JTable();
       tb3.setModel(new DefaultTableModel( 
        new Object[][] {{/*"Date","Empl_id","Empl_name","In_Time","Out_Time"*/},
            {null,null,null,null,null},{null,null,null,null,null},{null,null,null,null,null}
        },
        new String[]{"Date","empl_id","empl_name","in_time","out_time"}
        
        ));
          
        tb3.setBounds(5,5,945,345);
        tb3.setBackground(new Color(0,0,0));
        tb3.setForeground(new Color(255,255,255));
        tb3.setRowHeight(20); 
//      tablepanel.add(tb3);
        
        btnshow = new JButton("Show");
        btnshow.setBounds(750,60,90,30);
        btnshow.setFont(new Font("serif",Font.BOLD,15));
        btnshow.setBackground(new Color(0,0,0,150));
        btnshow.setForeground(new Color(153,153,153));
        backimg6.add(btnshow);
        btnshow.addActionListener(new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent e) {
            Connection conn=null;
            PreparedStatement ps =null;
             ResultSet rs =null;
            try{
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          //      conn =DriverManager.getConnection("jdbc:ucanaccess://F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\msDAta\\bismil.accdb");
                conn =DriverManager.getConnection("jdbc:ucanaccess:bismil.accdb");
              
          String sql ="SELECT * FROM employee_table";                   
                ps =conn.prepareStatement(sql);
                rs =ps.executeQuery();
                tb3.setModel(DbUtils.resultSetToTableModel(rs));
                JOptionPane.showMessageDialog(null,"Successfully Connection");
        
            } catch (ClassNotFoundException ex) {
                 System.out.println(ex);
            } catch (SQLException ex) {
               System.out.println(ex);
            }
         }
     });
         JScrollPane jsp =new JScrollPane();
        jsp.setBounds(0,0,950,150);
        tablepanel.add(jsp);
        jsp.setViewportView(tb3);
               
        btnhome =new JButton("Home");
        btnhome.setBounds(850,60,90,30);
        btnhome.setFont(new Font("serif",Font.BOLD,15));
        btnhome.setBackground(new Color(0,0,0,150));
        btnhome.setForeground(new Color(153,153,153));
        backimg6.add(btnhome);
        btnhome.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
           new Admin_form();
          }
     });
   
        setSize(1000,500);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
    
    }
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
     UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
 
        new brShowEmployee_entry();
    }
}


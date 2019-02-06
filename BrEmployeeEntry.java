package bismilResto;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
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


public class BrEmployeeEntry extends JFrame {
    JLabel backimg4 ,title4,ldate,lname,lintime,louttime,lid;
    JTable tb1;
    JButton btnsave,btnupdate,btnhome;
    
    
    public  BrEmployeeEntry(){
        super("Employee Entry");
        setLayout(null);
            
        backimg4 =new JLabel(new ImageIcon("F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\ee.jpg"));
        backimg4.setBounds(0,0,1000,500);
        add(backimg4);
       
        title4 =new JLabel("Employee Details");
        title4.setBounds(400,10,200,30);
        title4.setForeground(new Color(153,153,153));
        title4.setFont(new Font("serif",Font.BOLD,20));
        backimg4.add(title4);
        JPanel titlepanel =new JPanel(null);
        titlepanel.setBounds(350,10,250,30);
        titlepanel.setBackground(new Color(0,0,0,150));
        backimg4.add(titlepanel);
        
        
        JPanel tablepanel = new JPanel(null);
        tablepanel.setBounds(15,130,950,350);
        tablepanel.setBackground(new Color(0,0,0,150));
        backimg4.add(tablepanel);
       /**
        * HERE IS THE EXTRA LABLEL REMOVING FROME JFRAME
        * COUSE OF ADDING JSCROLLPANE
        Font f =new Font("serif",Font.BOLD,18);
        
        JPanel tableheader =new JPanel(null);
        tableheader.setBackground(new Color(0,0,0,150));
        tableheader.setBounds(15,103,950,30);
        backimg4.add(tableheader);
        
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
        */
        
    /*    tb1 =new JTable();
        Object[]columns ={"Date","Empl_id","Empl_name","In_Time","Out_Time"}; 
        DefaultTableModel model =new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        //model.addRow(rows);
        tb1.setModel(model);
        tb1.setBounds(5,5,945,345);
        tb1.setBackground(new Color(0,0,0));
        tb1.setForeground(new Color(255,255,255));
        tb1.setRowHeight(20); 
        tablepanel.add(tb1);*/
/**
 * here is new jtable for some logical problems(Create shrtcuts);
 * autoincrement not ok please recheck it .....
 */
       tb1 =new JTable();
       tb1.setModel(new DefaultTableModel( 
        new Object[][] {{/*"Date","Empl_id","Empl_name","In_Time","Out_Time"*/},
           {null,null,null,null,null},{null,null,null,null,null},{null,null,null,null,null}
        },
        new String[]{"Date","empl_id","empl_name","in_time","out_time"}
        
        ));
          
        tb1.setBounds(5,5,945,345);
        tb1.setBackground(new Color(0,0,0));
        tb1.setForeground(new Color(255,255,255));
        tb1.setRowHeight(20); 
       // tablepanel.add(tb1);
        JScrollPane jsp = new JScrollPane(tb1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setBounds(0,0,945,150);
        tablepanel.add(jsp);
        jsp.setViewportView(tb1);
     
        
        
        btnupdate =new JButton("Update");
        btnupdate.setBounds(650,60,90,30);
        btnupdate.setFont(new Font("serif",Font.BOLD,15));
        btnupdate.setBackground(new Color(0,0,0,150));
        btnupdate.setForeground(new Color(153,153,153));
        backimg4.add(btnupdate);
        
        btnsave = new JButton("Save");
        btnsave.setBounds(750,60,90,30);
        btnsave.setFont(new Font("serif",Font.BOLD,15));
        btnsave.setBackground(new Color(0,0,0,150));
        btnsave.setForeground(new Color(153,153,153));
        backimg4.add(btnsave);
       
        btnsave.addActionListener(new ActionListener() {
            @Override
              
            public void actionPerformed(ActionEvent e) {
            Connection conn=null;
            PreparedStatement ps =null;
            try
            {
                 
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           //     conn =DriverManager.getConnection("jdbc:ucanaccess://F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\msDAta\\bismil.accdb");
               conn =DriverManager.getConnection("jdbc:ucanaccess:bismil.accdb");
              
           //  conn.setAutoCommit(false);
                 String sql="insert into employee_table(Date,empl_id,empl_name,in_time,out_time) values(?,?,?,?,?)";
                 ps =conn.prepareStatement(sql);
                int rows =tb1.getRowCount();
                for(int row=0;row<rows;row++){
                 String Date =(String)tb1.getValueAt(row,0);
                 String empl_id =(String)tb1.getValueAt(row,1);
                 String empl_name =(String)tb1.getValueAt(row,2);
                 String in_time =(String)tb1.getValueAt(row,3);
                 String out_time =(String)tb1.getValueAt(row,4);
                 ps.setString(1,Date);
                 ps.setString(2,empl_id);
                 ps.setString(3,empl_name);
                 ps.setString(4,in_time);
                 ps.setString(5,out_time);
                 ps.addBatch();
                }
               ps.executeBatch();
               //conn.commit();
               JOptionPane.showMessageDialog(null,"SuccessFully , Saved Data");
            }   catch (ClassNotFoundException ex) {
                System.out.println(ex);
                //  JOptionPane.showMessageDialog(null,"Class Not Found");
            } catch (SQLException ex) {
              System.out.println(ex);
            }
            }});
        btnhome =new JButton("Home");
        btnhome.setBounds(850,60,90,30);
        btnhome.setFont(new Font("serif",Font.BOLD,15));
        btnhome.setBackground(new Color(0,0,0,150));
        btnhome.setForeground(new Color(153,153,153));
        backimg4.add(btnhome);
        btnhome.addActionListener(new ActionListener() {
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
 
        new BrEmployeeEntry();
    }
}
package bismilResto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class brShowExpancess extends JFrame {
     JLabel backimg7 ,title7;
    JTable tb4;
    JButton btnshow,btnhome7;
  
    public brShowExpancess(){
    super("Expancess Entry");
    setLayout(null);
    
        backimg7 =new JLabel(new ImageIcon("F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\ee.jpg"));
        backimg7.setBounds(0,0,1000,500);
        add(backimg7);
          title7 =new JLabel("Expancess");
        title7.setBounds(430,10,200,30);
        title7.setForeground(new Color(153,153,153));
        title7.setFont(new Font("serif",Font.BOLD,20));
        backimg7.add(title7);
        JPanel titlepanel5 =new JPanel(null);
        titlepanel5.setBounds(350,10,250,30);
        titlepanel5.setBackground(new Color(0,0,0,150));
        backimg7.add(titlepanel5);
        
        JPanel tablepanel5 = new JPanel(null);
        tablepanel5.setBounds(15,130,950,350);
        tablepanel5.setBackground(new Color(0,0,0,150));
        backimg7.add(tablepanel5);
        tb4 =new JTable();
       tb4.setModel(new DefaultTableModel( 
        new Object[][] {{/*"date","gorssary","vegetable","meat","chicken","fish","other"*/},
            {null,null,null,null,null,null,null},{null,null,null,null,null,null,null},{null,null,null,null,null,null,null}
        },
        new String[]{"date","gorssary","vegetable","meat","chicken","fish","other"}
        
        ));
       
          
        tb4.setBounds(5,5,945,345);
        tb4.setBackground(new Color(0,0,0));
        tb4.setForeground(new Color(255,255,255));
        tb4.setRowHeight(20); 
//        tablepanel5.add(tb4);
       
        btnshow =new JButton("Show");
         btnshow.setBounds(750,60,90,30);
        btnshow.setFont(new Font("serif",Font.BOLD,15));
        btnshow.setBackground(new Color(0,0,0,150));
        btnshow.setForeground(new Color(153,153,153));
        backimg7.add(btnshow);
       btnshow.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        Connection conn=null;
            PreparedStatement ps =null;
             ResultSet rs =null;
            try{
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                //conn =DriverManager.getConnection("jdbc:ucanaccess://F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\msDAta\\bismil.accdb");
                      conn =DriverManager.getConnection("jdbc:ucanaccess:bismil.accdb");
            
                String sql ="SELECT * FROM br_expancess";                   
                ps =conn.prepareStatement(sql);
                rs =ps.executeQuery();
                tb4.setModel(DbUtils.resultSetToTableModel(rs));
                JOptionPane.showMessageDialog(null,"Successfully Connection");
        
            } catch (ClassNotFoundException ex) {
                 System.out.println(ex);
            } catch (SQLException ex) {
               System.out.println(ex);
            }
      }
    });
        JScrollPane jsp = new JScrollPane(tb4,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setBounds(0,0,950,150);
         tablepanel5.add(jsp);
        jsp.setViewportView(tb4);
               
         btnhome7 =new JButton("Home");
        btnhome7.setBounds(850,60,90,30);
        btnhome7.setFont(new Font("serif",Font.BOLD,15));
        btnhome7.setBackground(new Color(0,0,0,150));
        btnhome7.setForeground(new Color(153,153,153));
        backimg7.add(btnhome7);
        btnhome7.addActionListener(new ActionListener() {
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
 
        new brShowExpancess();
    }
}

package bismilResto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class User_form extends JFrame {
    JLabel userImg;
     JButton btnUsereml,btnUserexp,btnUsermenu,btnUserbackhome,btnUsercancel;
   
    int x=0,y=100;
   
 public void paint(Graphics g){
 super.paint(g);
    Graphics2D g2 =(Graphics2D)g;
        Font f =new Font("serif",Font.BOLD,65);
        g.setFont(f);
        g.setColor(new Color(153,153,153));
        g.drawString("Bismil Restaurant",x,y);
        try{
        Thread.sleep(100);
        } catch (InterruptedException ex) { }
        x+=10;
        if(x>this.getWidth()){
        x=0;
        }
        repaint();
    }
 
    public User_form(){
    super("Userform");
        setLayout(null);
        userImg =new JLabel(new ImageIcon("F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\Home.jpg"));
        userImg.setBounds(0,0,1200,900);
        add(userImg);
        
        btnUsereml =new JButton(" Employee Entry");
        btnUsereml.setBounds(80,150,300,50);
        btnUsereml.setFont(new Font("serif",Font.BOLD,25));
        btnUsereml.setBackground(new Color(128,0,0));
        userImg.add(btnUsereml);
        btnUsereml.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          new BrEmployeeEntry();
        }
    });
        
        
        btnUserexp =new JButton(" Today Exapances");
        btnUserexp.setBounds(425,300,300,50);
        btnUserexp.setFont(new Font("serif",Font.BOLD,25));
        btnUserexp.setBackground(new Color(128,0,0));
        userImg.add(btnUserexp);
        btnUserexp.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        new BrExpancesEntry();
        }
    });
        
        btnUsermenu =new JButton("Go To Customer ");
        btnUsermenu.setBounds(750,150,300,50);
        btnUsermenu.setFont(new Font("serif",Font.BOLD,25));
        btnUsermenu.setBackground(new Color(128,0,0));
        userImg.add(btnUsermenu);
        btnUsermenu.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          new Customer_Bill();
        }
    });
        
//        btnbackhome =new JButton("Back To Main Form");
//        btnbackhome.setBounds(900,700,180,30);
//        btnbackhome.setFont(new Font("serif",Font.BOLD,15));
//        btnbackhome.setBackground(new Color(128,0,0));
//        backimg2.add(btnbackhome);
//        btnbackhome.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//          new HomePage();
//        }
//    });
        btnUsercancel = new JButton("Log Out");
        btnUsercancel.setBounds(1080,700,100,30);
        btnUsercancel.setFont(new Font("serif",Font.BOLD,15));
        btnUsercancel.setBackground(new Color(128,0,0));
        userImg.add(btnUsercancel);
        btnUsercancel.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showConfirmDialog(null,"Do you Want to Log Out");
            dispose();
        }
    });
    
        
        
        
        setSize(1200,900);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 public static void main(String Args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
 
     new User_form();
 }
}

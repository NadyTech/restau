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

public class Admin_form extends JFrame{
    JLabel backimg2;
    JButton btneml,btnexp,btnmenu,btnbackhome,btncancel;
    int x=0, y=100;
    
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
    public Admin_form(){
    super("ADMINISTRATIVE");
        setLayout(null);
        backimg2 =new JLabel(new ImageIcon("F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\Home.jpg"));
        backimg2.setBounds(0,0,1200,900);
        add(backimg2);
        
        btneml =new JButton("Show Employee Entry");
        btneml.setBounds(80,150,300,50);
        btneml.setFont(new Font("serif",Font.BOLD,25));
        btneml.setBackground(new Color(128,0,0));
        backimg2.add(btneml);
        btneml.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
         new brShowEmployee_entry();
        }
    });
        
        btnexp =new JButton("Show Today Exapances");
        btnexp.setBounds(750,150,300,50);
        btnexp.setFont(new Font("serif",Font.BOLD,25));
        btnexp.setBackground(new Color(128,0,0));
        backimg2.add(btnexp);
        btnexp.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
         new brShowExpancess();
        }
    });
        
       /* btnmenu =new JButton("Show Today Menu");
        btnmenu.setBounds(750,150,300,50);
        btnmenu.setFont(new Font("serif",Font.BOLD,25));
        btnmenu.setBackground(new Color(128,0,0));
        backimg2.add(btnmenu);*/
        
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
        btncancel = new JButton("Check Out");
        btncancel.setBounds(1080,700,100,30);
        btncancel.setFont(new Font("serif",Font.BOLD,15));
        btncancel.setBackground(new Color(128,0,0));
        backimg2.add(btncancel);
        btncancel.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showConfirmDialog(null,"Do You Want to Check Out");
            dispose();
        }
    });
       
        
        setSize(1200,900);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
    
        new Admin_form();
    }
}

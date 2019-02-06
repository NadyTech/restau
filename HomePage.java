package bismilResto;

import com.jtattoo.plaf.BaseBorders;
import com.sun.java.swing.plaf.motif.MotifBorders;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class HomePage extends JFrame{
    JLabel backImg,bismil,adminImg,userimg,slide,slide2,slide3,lbladmin,lbluser;
    JTextField tfAname,tfUname;
    JPasswordField pswAdm,pswUer;
    JButton btncheck ,btnlog,btcreate;
    JPanel slidepanel ,slidepanel2,slidepanel3;
    Timer tm,tm2 ,tm3;
    int x=0 ,y=0 ,z=0;
    String[]list={"F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\1.jpg",
                 "F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\2.jpg",
                  "F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\3.jpg",
                  "F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\4.jpg",
                   "F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\5.jpg"};
    String[]list2={"F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\veg\\1.jpg",
                    "F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\veg\\2.jpg",
                   "F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\veg\\3.jpg",
                   "F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\veg\\4.jpg",
                    "F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\veg\\5.jpg",
                    "F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\veg\\6.jpg"};
    String[]list3={"F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\drink &chinese\\1.jpg",
                   "F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\drink &chinese\\2.jpg",
                    "F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\drink &chinese\\3.jpg",
                    "F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\drink &chinese\\4.jpg",
                     "F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\drink &chinese\\5.jpg",
                      "F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\drink &chinese\\6.jpg",
                        "F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\drink &chinese\\7.jpg"};
    public HomePage(){
    super("Home Page");
        setLayout(null);
        backImg =new JLabel(new ImageIcon("F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\Home.jpg"));
        backImg.setBounds(0,0,1200,900);
        add(backImg);
        bismil =new JLabel("Bismil Restaurant");
        bismil.setBounds(380,2,800,70);
        bismil.setFont(new Font("serif",Font.BOLD,65));
        bismil.setForeground(new Color(153,153,153));
        backImg.add(bismil);
        JPanel title1 =new JPanel(null);
        title1.setBounds(0,2,800,70);
        title1.setBackground(new Color(0,0,0,150));
        backImg.add(title1);
        
        JPanel adminpanel =new JPanel(null);
        adminpanel.setBounds(10,160,550,300);
        adminpanel.setBackground(new Color(0,0,0,80));
        backImg.add(adminpanel);
        /*adminImg =new JLabel(new ImageIcon("F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\adminpanelImg.jpg"));
        adminImg.setBounds(0,0,550,300);
        adminpanel.add(adminImg);*/
        lbladmin =new JLabel("Administrative");
        lbladmin.setBounds(180,0,250,50);
        lbladmin.setFont(new Font("serif",Font.BOLD,28));
        lbladmin.setForeground(new Color(153,153,153));
        adminpanel.add(lbladmin);
        tfAname =new JTextField("Admin Name");
        tfAname.setBounds(140,80,250,25);
        tfAname.setBackground(new Color(0,0,0,250));
        tfAname.setForeground(Color.DARK_GRAY);
        tfAname.setBorder(BorderFactory.createLineBorder(Color.BLACK,1 ,true));
        //tfAname.setOpaque(false);
        adminpanel.add(tfAname);
        pswAdm =new JPasswordField("000000");
        pswAdm.setBounds(140,160,250,25);
        pswAdm.setBackground(new Color(0,0,0,250));
        pswAdm.setForeground(Color.DARK_GRAY);
        pswAdm.setBorder(BorderFactory.createLineBorder(Color.BLACK,1 ,true));
        adminpanel.add(pswAdm);
        btncheck =new JButton("Check In");
        btncheck.setBounds(190,220,100,30);
        btncheck.setBackground(new Color(139,0,0));
        btncheck.setForeground(new Color(153,153,153));
        btncheck.setFont(new Font("serif",Font.BOLD,20));
        adminpanel.add(btncheck);
        btncheck.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           Connection conn=null;
           PreparedStatement ps =null;
            ResultSet rs=null;
            try
            {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//                conn =DriverManager.getConnection("jdbc:ucanaccess://F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\msDAta\\bismil.accdb");
                conn =DriverManager.getConnection("jdbc:ucanaccess:bismil.accdb");
            
                String sql="select * from admin_tbl where admin_name='"+tfAname.getText()+"'and admin_password='"+pswAdm.getText()+"'";
                ps =conn.prepareStatement(sql);
                rs=ps.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(null," Check In Successfully Welcome");
                     new Admin_form();
                }else{
                JOptionPane.showMessageDialog(null,"Invalid , please use Valid Information");
                }
                
            } catch (ClassNotFoundException ex) {
             JOptionPane.showMessageDialog(null,"System Not Find You !!");
            } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Are You Admin !!!! nop....");
            }
           
        }
    });
        tfAname.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==32){
            tfAname.requestFocus();
            }
            else if(tfAname.getText().equals("Admin Name"))
            {
                tfAname.setText("");
                tfAname.setForeground(Color.WHITE);
                tfAname.setCaretColor(Color.WHITE);
            }}

        @Override
        public void keyReleased(KeyEvent e) {
        }
    });
        pswAdm.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==38){
            pswAdm.requestFocus();
            }
            else if(pswAdm.getText().equals("000000")){
         pswAdm.setText("");
         pswAdm.setCaretColor(Color.WHITE);
         }else{}
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    });
        
        JPanel userpanel =new JPanel(null);
        userpanel.setBounds(605,160,570,300);
        userpanel.setBackground(new Color(0,0,0,80));
        backImg.add(userpanel);
        /*userimg =new JLabel(new ImageIcon("F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\userimg.jpg"));
        userimg.setBounds(0,0,570,300);
        userpanel.add(userimg);*/
        lbluser = new JLabel("User LogIn");
        lbluser.setForeground(new Color(153,153,153));
        lbluser.setBounds(220,0,150,50);
        lbluser.setFont(new Font("serif",Font.BOLD,25));
        userpanel.add(lbluser);
        tfUname =new JTextField("User Name");
        tfUname.setBounds(80,80,250,25);
        tfUname.setBackground(new Color(0,0,0,250));
        tfUname.setForeground(Color.DARK_GRAY);
        tfUname.setBorder(BorderFactory.createLineBorder(Color.BLACK,1 ,true));
        userpanel.add(tfUname);
        pswUer =new JPasswordField("000000");
        pswUer.setBounds(80,165,250,25);
        pswUer.setBackground(new Color(0,0,0,250));
        pswUer.setForeground(Color.DARK_GRAY);
        pswUer.setBorder(BorderFactory.createLineBorder(Color.BLACK,1 ,true));
        userpanel.add(pswUer);
        btnlog =new JButton("Log In");
        btnlog.setBounds(130,215,80,30);
        btnlog.setBackground(new Color(139,0,0));
        btnlog.setForeground(new Color(153,153,153));
        btnlog.setFont(new Font("serif",Font.BOLD,20));
        userpanel.add(btnlog);
        btnlog.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
         Connection conn =null;
         PreparedStatement ps =null;
         ResultSet rs =null;
         try{
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         //conn=DriverManager.getConnection("jdbc:ucanaccess://F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\msDAta\\bismil.accdb");
              conn =DriverManager.getConnection("jdbc:ucanaccess:bismil.accdb");
            
         String sql ="select * from user_tbl where user_name='"+tfUname.getText()+"'and user_password='"+pswUer.getText()+"'";   
         ps =conn.prepareStatement(sql);
         rs=ps.executeQuery();
         if(rs.next()){
         
         new User_form();
         }else{
         JOptionPane.showMessageDialog(null,"please check!!!! Enter Valid Inforamtion");}
         }  catch (ClassNotFoundException ex) {
         JOptionPane.showMessageDialog(null,"System not Find You !!");
                 
         } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"Are you User !! nop....");
         }
        }
    });
        tfUname.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
         if(tfUname.getText().equals("User Name")){
         tfUname.setText("");}
         tfUname.setCaretColor(Color.WHITE);
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    });
        pswUer.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(pswUer.getText().equals("000000")){
            pswUer.setText("");
            pswUer.setCaretColor(Color.WHITE);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    });
        btcreate =new JButton("Exit");
        btcreate.setBackground(new Color(139,0,0));
        btcreate.setBounds(450,270,60,30);
        btcreate.setForeground(new Color(153,153,153));
        btcreate.setFont(new Font("serif",Font.BOLD,20));
        userpanel.add(btcreate);
        btcreate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
               JOptionPane.showConfirmDialog(null,"Do you Want To Exit");
               System.exit(0);
        }
    });
        
        slidepanel =new JPanel(null);
        slidepanel.setBounds(420,485,370,230);
        backImg.add(slidepanel);
        slide =new JLabel(new ImageIcon("F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\slideImg.jpg"));
        slide.setBounds(0,0,370,230);
        slidepanel.add(slide);
           SetImageSize(4);
        tm =new Timer(2000,new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SetImageSize(x);
            x+=1;
            if(x>=list.length){
                x=0;
            }
        }
    });  
         tm.start();
       
        slidepanel2 =new JPanel(null);
        slidepanel2.setBounds(40,485,370,230);
        backImg.add(slidepanel2);
        slide2 =new JLabel(new ImageIcon("F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\slideImg.jpg"));
        slide2.setBounds(0,0,370,230);
        slidepanel2.add(slide2);
        SetImageSize2(5);
         tm2 =new Timer(2000,new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SetImageSize2(y);
            y+=1;
            if(y>=list2.length){
                y=0;
            }
        }
    });
        tm2.start();
        slidepanel3 =new JPanel(null);
        slidepanel3.setBounds(800,485,370,230);
        backImg.add(slidepanel3);
        slide3 =new JLabel();
        slide3.setBounds(0,0,370,230);
        slidepanel3.add(slide3);
          SetImageSize3(6);
         tm3 =new Timer(2000,new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SetImageSize3(z);
            z+=1;
            if(z>=list3.length){
                z=0;
            }
        }
    }); 
        tm3.start();
        setVisible(true);
        setSize(1200,900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void SetImageSize(int i){
    ImageIcon icon = new ImageIcon(list[i]);
    Image img =icon.getImage();
    Image newImg = img.getScaledInstance(slide.getWidth(),slide.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon newImc = new ImageIcon(newImg);
    slide.setIcon(newImc);
    }
    public void SetImageSize2(int j){
    ImageIcon icon2 = new ImageIcon(list2[j]);
    Image img2 =icon2.getImage();
    Image newImg2 = img2.getScaledInstance(slide2.getWidth(),slide2.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon newImc2 = new ImageIcon(newImg2);
    slide2.setIcon(newImc2);
    }
    public void SetImageSize3(int k){
    ImageIcon icon3 = new ImageIcon(list3[k]);
    Image img3 =icon3.getImage();
    Image newImg3 = img3.getScaledInstance(slide3.getWidth(),slide3.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon newImc3 = new ImageIcon(newImg3);
    slide3.setIcon(newImc3);
    
    }
    
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, UnsupportedLookAndFeelException, IllegalAccessException{
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        new HomePage();
     /*   EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            try{
               HomePage ne = new HomePage();
               ne.setVisible(true);
            }catch(Exception ex){
            ex.printStackTrace();
            }
            }
        });*/
    }
}


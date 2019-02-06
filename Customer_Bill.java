package bismilResto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Customer_Bill extends JFrame {

    JLabel backImg, bismil, lblcstomertitle, lblvegFood, lblnonvegFood, lblchineseFood, lblbtrroti, lbltndroti, lblbread;
    JComboBox veg, non_veg, chienese;
    JTextField tfbtr, tftdr, tfbred;
    JList Showlist, nonveglist, chienlist;
    ArrayList<String> food = new ArrayList<>();
    ArrayList<String> food1 = new ArrayList<>();
    ArrayList<String> food2 = new ArrayList<>();

    public Customer_Bill() {
        super("Customer Bill");
        setLayout(null);
        backImg = new JLabel(new ImageIcon("F:\\JAVA\\java projects\\Bismil Restaourant\\bismilaimage\\Home.jpg"));
        backImg.setBounds(0, 0, 1200, 900);
        add(backImg);
        bismil = new JLabel("Bismil Restaurant");
        bismil.setBounds(380, 2, 800, 70);
        bismil.setFont(new Font("serif", Font.BOLD, 65));
        bismil.setForeground(new Color(153, 153, 153));
        backImg.add(bismil);
        JPanel title1 = new JPanel(null);
        title1.setBounds(0, 2, 800, 70);
        title1.setBackground(new Color(0, 0, 0, 150));
        backImg.add(title1);

        lblcstomertitle = new JLabel("Customer Bill");
        lblcstomertitle.setBounds(510, 100, 250, 40);
        lblcstomertitle.setFont(new Font("tahoma", Font.BOLD, 30));
        lblcstomertitle.setForeground(new Color(153, 153, 153));
        backImg.add(lblcstomertitle);

        JPanel AddLable = new JPanel(null);
        AddLable.setBackground(new Color(0, 0, 0, 150));
        AddLable.setBounds(80, 180, 140, 250);
        backImg.add(AddLable);

        JPanel p4 = new JPanel(null);
        p4.setBounds(800, 175, 350, 550);
        p4.setBackground(new Color(0, 0, 0, 150));
        backImg.add(p4);
        JTextField tftotal = new JTextField();
        tftotal.setBounds(240, 389, 200, 30);
        tftotal.setFont(new Font("times", Font.BOLD, 25));
        p4.add(tftotal);
        JLabel price = new JLabel("Price");
        price.setBounds(270, 0, 50, 20);
        price.setForeground(new Color(153, 153, 153));
        price.setFont(new Font("times", Font.BOLD, 20));
        p4.add(price);

        lblvegFood = new JLabel("Veg Food");
        lblvegFood.setForeground(new Color(153, 153, 153));
        lblvegFood.setBounds(30, 20, 150, 25);
        lblvegFood.setFont(new Font("times", Font.BOLD, 20));
        AddLable.add(lblvegFood);
        veg = new JComboBox();
        veg.addItem("Matar-Paneer");
        veg.addItem("Kaju-Kari");
        veg.addItem("Mix-Veg");
        veg.addItem("Palak-Paneer");
        veg.addItem("Misal");
        veg.setEditable(true);
        veg.setBounds(250, 200, 150, 20);
        veg.setFont(new Font("times", Font.BOLD, 14));
        veg.setForeground(new Color(153, 153, 153));
        backImg.add(veg);
        Showlist = new JList();
        Showlist.setBounds(25, 25, 150, 112);
        Showlist.setBackground(new Color(0, 0, 0));
        Showlist.setForeground(new Color(153, 153, 153));
        Showlist.setBorder(BorderFactory.createBevelBorder(1, Color.lightGray, Color.white));
        p4.add(Showlist);
        JButton btn = new JButton("Veg");
        btn.setBounds(250, 250, 80, 30);
        btn.setBackground(new Color(139, 0, 0));
        backImg.add(btn);
        Object a = new Object();
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String) veg.getSelectedItem();
                food.add(str);
                Object[] a = food.toArray();
                Showlist.setListData(a);
            }
        });
        JTextField tfveg1 = new JTextField("0");
        tfveg1.setBounds(270, 25, 60, 18);
        tfveg1.setCaretPosition(1);
        tfveg1.setForeground(Color.LIGHT_GRAY);
        p4.add(tfveg1);
        JTextField tfveg2 = new JTextField("0");
        tfveg2.setBounds(270, 43, 60, 18);
         tfveg2.setCaretPosition(1);
        tfveg2.setForeground(Color.LIGHT_GRAY);
        p4.add(tfveg2);
        JTextField tfveg3 = new JTextField("0");
         tfveg3.setCaretPosition(1);
        tfveg3.setForeground(Color.LIGHT_GRAY);
        tfveg3.setBounds(270, 61, 60, 18);
        p4.add(tfveg3);
        JTextField tfveg4 = new JTextField("0");
        tfveg4.setForeground(Color.LIGHT_GRAY);
         tfveg4.setCaretPosition(1);
        tfveg4.setBounds(270, 79, 60, 18);
        p4.add(tfveg4);
        JTextField tfveg5 = new JTextField("0");
        tfveg5.setForeground(Color.LIGHT_GRAY);
         tfveg5.setCaretPosition(1);
        tfveg5.setBounds(270, 97, 60, 18);
        p4.add(tfveg5);
        JTextField tfveg6 = new JTextField("0");
        tfveg6.setForeground(Color.LIGHT_GRAY);
         tfveg6.setCaretPosition(1);
        tfveg6.setBounds(270, 115, 60, 18);
        p4.add(tfveg6);

        lblnonvegFood = new JLabel("Non-Veg");
        lblnonvegFood.setForeground(new Color(153, 153, 153));
        lblnonvegFood.setBounds(30, 120, 150, 25);
        lblnonvegFood.setFont(new Font("times", Font.BOLD, 20));
        AddLable.add(lblnonvegFood);
        non_veg = new JComboBox();
        non_veg.addItem("MatanFry");
        non_veg.addItem("ChickenFry");
        non_veg.addItem("Matan-Handi");
        non_veg.addItem("Chicken-Handi");
        non_veg.setForeground(new Color(153, 153, 153));
        non_veg.setBounds(250, 300, 150, 25);
        non_veg.setEditable(true);
        non_veg.setFont(new Font("times", Font.BOLD, 14));
        backImg.add(non_veg);
        nonveglist = new JList();
        nonveglist.setBounds(25, 140, 150, 112);
        nonveglist.setBackground(new Color(0, 0, 0));
        nonveglist.setForeground(new Color(153, 153, 153));
        nonveglist.setBorder(BorderFactory.createBevelBorder(1, Color.lightGray, Color.white));
        p4.add(nonveglist);
        JButton btn1 = new JButton("Non-Veg");
        btn1.setBounds(250, 350, 80, 30);
        btn1.setForeground(new Color(0, 0, 0));
        btn1.setBackground(new Color(139, 0, 0));
        backImg.add(btn1);
        Object a1 = new Object();
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str1 = (String) non_veg.getSelectedItem();
                food1.add(str1);
                Object[] a1 = food1.toArray();
                nonveglist.setListData(a1);
            }
        });

        JTextField tfnonveg1 = new JTextField("0");
        tfnonveg1.setBounds(270, 140, 60, 18);
         tfnonveg1.setCaretPosition(1);
        tfnonveg1.setForeground(Color.LIGHT_GRAY);
        p4.add(tfnonveg1);
        JTextField tfnonveg2 = new JTextField("0");
        tfnonveg2.setBounds(270, 158, 60, 18);
         tfnonveg2.setCaretPosition(1);
        tfnonveg2.setForeground(Color.LIGHT_GRAY);
        p4.add(tfnonveg2);
        JTextField tfnonveg3 = new JTextField("0");
        tfnonveg3.setBounds(270, 176, 60, 18);
        tfnonveg3.setCaretPosition(1);
        tfnonveg3.setForeground(Color.LIGHT_GRAY);
        p4.add(tfnonveg3);
        JTextField tfnonveg4 = new JTextField("0");
        tfnonveg4.setBounds(270, 194, 60, 18);
         tfnonveg4.setCaretPosition(1);
        tfnonveg4.setForeground(Color.LIGHT_GRAY);
        p4.add(tfnonveg4);
        JTextField tfnonveg5 = new JTextField("0");
         tfnonveg5.setCaretPosition(1);
        tfnonveg5.setBounds(270, 212, 60, 18);
        tfnonveg5.setForeground(Color.LIGHT_GRAY);
        p4.add(tfnonveg5);
        JTextField tfnonveg6 = new JTextField("0");
         tfnonveg6.setCaretPosition(1);
        tfnonveg6.setBounds(270, 230, 60, 18);
        tfnonveg6.setForeground(Color.LIGHT_GRAY);
        p4.add(tfnonveg6);

        lblchineseFood = new JLabel("Chienese");
        lblchineseFood.setForeground(new Color(153, 153, 153));
        lblchineseFood.setBounds(30, 215, 150, 25);
        lblchineseFood.setFont(new Font("times", Font.BOLD, 20));
        AddLable.add(lblchineseFood);
        chienese = new JComboBox();
        chienese.addItem("Veg-Noodles");
        chienese.addItem("Chicken-Lolypop");
        chienese.addItem("Veg-Rice");
        chienese.addItem("Non-veg Rice");
        chienese.setEditable(true);
        chienese.setForeground(new Color(153, 153, 153));
        chienese.setBounds(250, 400, 150, 25);
        chienese.setFont(new Font("times", Font.BOLD, 14));
        backImg.add(chienese);
        chienlist = new JList();
        chienlist.setBounds(25, 255, 150, 112);
        chienlist.setBackground(new Color(0, 0, 0));
        chienlist.setForeground(new Color(153, 153, 153));
        chienlist.setBorder(BorderFactory.createBevelBorder(1, Color.lightGray, Color.white));
        p4.add(chienlist);
        JButton btn2 = new JButton("Chienese");
        btn2.setBounds(250, 450, 80, 30);
        btn2.setForeground(new Color(0, 0, 0));
        btn2.setBackground(new Color(139, 0, 0));
        backImg.add(btn2);
        Object a2 = new Object();
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str1 = (String) chienese.getSelectedItem();
                food2.add(str1);
                Object[] a2 = food2.toArray();
                chienlist.setListData(a2);
            }
        });

        JTextField tfchi1 = new JTextField("0");
        tfchi1.setBounds(270, 255, 60, 18);
         tfchi1.setCaretPosition(1);
        tfchi1.setForeground(Color.LIGHT_GRAY);
        p4.add(tfchi1);
        JTextField tfchi2 = new JTextField("0");
          tfchi2.setCaretPosition(1);
        tfchi2.setForeground(Color.LIGHT_GRAY);
        tfchi2.setBounds(270, 273, 60, 18);
        p4.add(tfchi2);
        JTextField tfchi3 = new JTextField("0");
          tfchi3.setCaretPosition(1);
        tfchi3.setForeground(Color.LIGHT_GRAY);
        tfchi3.setBounds(270, 291, 60, 18);
        p4.add(tfchi3);
        JTextField tfchi4 = new JTextField("0");
          tfchi4.setCaretPosition(1);
        tfchi4.setForeground(Color.LIGHT_GRAY);
        tfchi4.setBounds(270, 309, 60, 18);
        p4.add(tfchi4);
        JTextField tfchi5 = new JTextField("0");
          tfchi5.setCaretPosition(1);
        tfchi5.setForeground(Color.LIGHT_GRAY);
        tfchi5.setBounds(270, 327, 60, 18);
        p4.add(tfchi5);
        JTextField tfchi6 = new JTextField("0");
          tfchi6.setCaretPosition(1);
        tfchi6.setForeground(Color.LIGHT_GRAY);
        tfchi6.setBounds(270, 345, 60, 18);
        p4.add(tfchi6);

        JLabel ttlprice = new JLabel("Total");
        ttlprice.setBounds(155, 390, 150, 30);
        ttlprice.setBackground(new Color(139, 0, 0));
        ttlprice.setForeground(new Color(153, 153, 153));
        ttlprice.setFont(new Font("times", Font.BOLD, 20));
        p4.add(ttlprice);

        JButton clear = new JButton("Clear");
        clear.setBounds(245, 440, 90, 30);
        clear.setBackground(new Color(139, 0, 0));
        clear.setForeground(new Color(153, 153, 153));
        clear.setFont(new Font("times", Font.BOLD, 20));
        p4.add(clear);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == clear) {

                    tfchi1.setText("0");
                    tfchi2.setText("0");
                    tfchi3.setText("0");
                    tfchi4.setText("0");
                    tfchi5.setText("0");
                    tfchi6.setText("0");
                    tfnonveg1.setText("0");
                    tfnonveg2.setText("0");
                    tfnonveg3.setText("0");
                    tfnonveg4.setText("0");
                    tfnonveg5.setText("0");
                    tfnonveg6.setText("0");
                    tfveg1.setText("0");
                    tfveg2.setText("0");
                    tfveg3.setText("0");
                    tfveg4.setText("0");
                    tfveg5.setText("0");
                    tfveg6.setText("0");
                    tfbred.setText("0");
                    tftdr.setText("0");
                    tfbtr.setText("0");
                    tftotal.setText("0");
                    
                    food.removeAll(food);
                    Object a[] =food.toArray();
                    Showlist.setListData(a);
                    food1.removeAll(food1);
                    Object a1[] =food1.toArray();
                    chienlist.setListData(a1);
                    food2.removeAll(food2);
                    Object a2[] =food2.toArray();
                    nonveglist.setListData(a2);
                }

            }
        });

        JButton p4titl = new JButton("Total Bill");
        p4titl.setBounds(80, 440, 150, 30);
        p4titl.setBackground(new Color(139, 0, 0));
        p4titl.setForeground(new Color(153, 153, 153));
        p4titl.setFont(new Font("times", Font.BOLD, 20));
        p4.add(p4titl);
        p4titl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double tf1 = 0, tf2 = 0, tf3 = 0, tf4 = 0, tf5 = 0, tf6 = 0, tf7 = 0, tf8 = 0, tf9 = 0, tf10 = 0, tf11 = 0, tf12 = 0, tf13 = 0, tf14 = 0, tf15 = 0, tf16 = 0, tf17 = 0, tf18 = 0, tf19 = 0, tf20 = 0, tf21 = 0;
                if (e.getSource() == p4titl) {
                    if (tf1 == 0 && tf2 == 0 && tf3 == 0 && tf4 == 0 && tf5 == 0 && tf6 == 0 && tf7 == 0 && tf8 == 0 && tf9 == 0 && tf10 == 0 && tf11 == 0 && tf12 == 0 && tf13 == 0 && tf14 == 0 && tf15 == 0 && tf16 == 0 && tf17 == 0 && tf18 == 0 && tf19 == 0 && tf20 == 0 && tf21 == 0) {
                        try {
                            tf1 = Double.parseDouble(tfveg1.getText());
                            tf2 = Double.parseDouble(tfveg2.getText());
                            tf3 = Double.parseDouble(tfveg3.getText());
                            tf4 = Double.parseDouble(tfveg4.getText());
                            tf5 = Double.parseDouble(tfveg5.getText());
                            tf6 = Double.parseDouble(tfveg6.getText());
                            tf7 = Double.parseDouble(tfbtr.getText());
                            tf8 = Double.parseDouble(tftdr.getText());
                            tf21 = Double.parseDouble(tfbred.getText());
                            tf9 = Double.parseDouble(tfnonveg1.getText());
                            tf10 = Double.parseDouble(tfnonveg2.getText());
                            tf11 = Double.parseDouble(tfnonveg3.getText());
                            tf12 = Double.parseDouble(tfnonveg4.getText());
                            tf13 = Double.parseDouble(tfnonveg5.getText());
                            tf14 = Double.parseDouble(tfnonveg6.getText());
                            tf15 = Double.parseDouble(tfchi1.getText());
                            tf16 = Double.parseDouble(tfchi2.getText());
                            tf17 = Double.parseDouble(tfchi3.getText());
                            tf18 = Double.parseDouble(tfchi4.getText());
                            tf19 = Double.parseDouble(tfchi5.getText());
                            tf20 = Double.parseDouble(tfchi6.getText());
                            String total = String.valueOf(tf1 + tf2 + tf3 + tf4 + tf5 + tf6 + tf7 + tf8 + tf9 + tf10 + tf11 + tf12 + tf13 + tf14 + tf15 + tf16 + tf17 + tf18 + tf19 + tf20 + tf21);
                            tftotal.setText(total);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "cant convert");
                            System.out.println(ex);
//                     ex.printStackTrace();
                        }
                    }
                }
            }

        });

        JPanel p2 = new JPanel(null);
        p2.setBounds(420, 180, 140, 250);
        p2.setBackground(new Color(0, 0, 0, 150));
        backImg.add(p2);

        String btr_roti[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        JComboBox btr = new JComboBox(btr_roti);
        btr.setBounds(580, 200, 50, 20);
        btr.setEditable(true);
        btr.setFont(new Font("times", Font.BOLD, 14));
        btr.setForeground(new Color(153, 153, 153));
        backImg.add(btr);

        lblbtrroti = new JLabel("Butter Roti");
        lblbtrroti.setForeground(new Color(153, 153, 153));
        lblbtrroti.setBounds(10, 20, 150, 25);
        lblbtrroti.setFont(new Font("times", Font.BOLD, 20));
        p2.add(lblbtrroti);
        tfbtr = new JTextField("0");
        tfbtr.setBounds(650, 200, 50, 20);
        tfbtr.setCaretPosition(1);
        tfbtr.setFont(new Font("times", Font.BOLD, 14));
        tfbtr.setForeground(new Color(153, 153, 153));
        backImg.add(tfbtr);

        String tdr_roti[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        JComboBox tdr = new JComboBox(tdr_roti);
        tdr.setEditable(true);
        tdr.setBounds(580, 300, 50, 20);
        tdr.setFont(new Font("times", Font.BOLD, 14));
        tdr.setForeground(new Color(153, 153, 153));
        backImg.add(tdr);

        lbltndroti = new JLabel("Tanduri Roti");
        lbltndroti.setForeground(new Color(153, 153, 153));
        lbltndroti.setBounds(10, 120, 150, 25);
        lbltndroti.setFont(new Font("times", Font.BOLD, 20));
        p2.add(lbltndroti);
        tftdr = new JTextField("0");
        tftdr.setBounds(650, 300, 50, 20);
        tftdr.setCaretPosition(1);
        tftdr.setFont(new Font("times", Font.BOLD, 14));
        tftdr.setForeground(new Color(153, 153, 153));
        backImg.add(tftdr);

        String bread_roti[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        JComboBox brad = new JComboBox(bread_roti);
        brad.setBounds(580, 400, 50, 20);
        brad.setEditable(true);
        brad.setFont(new Font("times", Font.BOLD, 14));
        brad.setForeground(new Color(153, 153, 153));
        backImg.add(brad);
        lblbread = new JLabel("Bread");
        lblbread.setForeground(new Color(153, 153, 153));
        lblbread.setBounds(30, 215, 150, 25);
        lblbread.setFont(new Font("times", Font.BOLD, 20));
        p2.add(lblbread);
        tfbred = new JTextField("0");
        tfbred.setBounds(650, 400, 50, 20);
          tfbred.setCaretPosition(1);
        tfbred.setFont(new Font("times", Font.BOLD, 14));
        tfbred.setForeground(new Color(153, 153, 153));
        backImg.add(tfbred);
        
        
        JButton Home = new JButton("Home");
        Home.setBounds(250,600,150,60);
        Home.setBackground(new Color(139,0,0));
        Home.setForeground(new Color(153,153,153));
        Home.setFont(new Font("serif",Font.BOLD,20));
        backImg.add(Home);
        Home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new User_form();
            }
        });
         
        JButton Exit = new JButton("Exit");
        Exit.setBounds(510,600,150,60);
        Exit.setBackground(new Color(139,0,0));
        Exit.setForeground(new Color(153,153,153));
        Exit.setFont(new Font("serif",Font.BOLD,20));
        backImg.add(Exit);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              JOptionPane.showMessageDialog(null,"Do you Want to Exit");
              dispose();
            }
        });

        JPanel p3 = new JPanel(null);
        p3.setBounds(650, 175, 75, 20);
        p3.setBackground(new Color(0, 0, 0, 150));
        backImg.add(p3);
        JLabel bllp3 = new JLabel("Price");
        bllp3.setBounds(0, 0, 50, 15);
        bllp3.setForeground(new Color(153, 153, 153));
        p3.add(bllp3);
        setVisible(true);
        setSize(1200, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        new Customer_Bill();
    }

}

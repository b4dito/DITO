package 测试;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Thirdinter extends JFrame
{
    String myid;
    Thirdinter(String UID)
    {
        myid=UID;
        setTitle("我的个人界面");
        setSize(500, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp1=new JPanel();
        jp1.setLayout(null);
        setContentPane(jp1);
        String IDD;
        String NAME;
        String icon;
        String s;
        /*try {
                Class.forName("com.mysql.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/internet", "root","niit1234");
                 Statement st=con.createStatement();
               String sql="select 账号,网名,头像,电话 from usermassege where 账号=\"10000\";";
               ResultSet rs=st.executeQuery(sql);
              IDD=rs.getString("账号");
              NAME=rs.getString("网名");
              icon=rs.getString("头像");
              s=rs.getString("电话");
             
        
               rs.close();
               st.close();
               con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Linkdatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Linkdatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        * 
        */
         JLabel jl1=new JLabel(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p5.png"));
         jl1.setBounds(20,50, 100, 100);
        jp1.add(jl1);
        JLabel jl2=new JLabel("沧浪之水");
        jl2.setBounds(130,50, 200, 50);
        jl2.setFont(new Font("宋体",1,28));
        jp1.add(jl2);
        JLabel jl3=new JLabel("账号：10000");
        jl3.setBounds(130,100, 200, 50);
        jl3.setFont(new Font("宋体",1,20));
        jp1.add(jl3);
        JTextField jt1=new JTextField("明朝散发弄扁舟");
        jt1.enable(false);
        jt1.setFont(new Font("宋体",1,16));
        jt1.setBounds(120,170 , 300, 50);
        jp1.add(jt1);
        JLabel jl4=new JLabel("个性签名：");
        jl4.setBounds(20,170, 100, 50);
        jl3.setFont(new Font("宋体",1,16));
        jp1.add(jl4);
        
        
        JButton jb4=new JButton(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p6.jpg"));
        
        jb4.setBounds(20,250, 450, 80);
        jb4.setBackground(Color.GRAY);
        jp1.add(jb4);
         JButton jb5=new JButton(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p7.jpg"));
      jb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb5event(evt);
            }
        });
        jb5.setBounds(20,350, 450, 80);
        jb5.setBackground(Color.GRAY);
        jp1.add(jb5);
       
        
        
        JButton jb1=new JButton(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p1.png"));
        jb1.setFont(new Font("宋体",1,24));
        jb1.setBounds(166, 710, 166, 100);
        jb1.setBackground(Color.GRAY);
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1event(evt);
            }
        });
        jp1.add(jb1);
        JButton jb2=new JButton(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p2.png"));
        jb2.setFont(new Font("宋体",1,24));
        jb2.setBounds(0, 710, 166, 100);
        jb2.setBackground(Color.GRAY);
        jb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb2event(evt);
            }
        });
        jp1.add(jb2);
        JButton jb3=new JButton(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p3.png"));
        jb3.setFont(new Font("宋体",1,24));
        jb3.setBounds(332, 710, 166, 100);
        jb3.setBackground(Color.GRAY);
        jp1.add(jb3);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-200)/2, (Toolkit.getDefaultToolkit().getScreenSize().height-200)/8);
        setVisible(true);
    }
    
    
     public void jb1event(ActionEvent e)
    {
        dispose();
        Maininterface m=new Maininterface(myid);
    }
     
      public void jb2event(ActionEvent e)
    {
        dispose();
        Minterface m=new Minterface(myid);
    }
      
      public void jb5event(ActionEvent e)
    {
        dispose();
        Interface3 i3=new Interface3(myid);
        i3.show();
    }
    
    public static void main(String args[])
    {
        new Thirdinter("10000");
    }
}   

package 测试;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Add extends JFrame
{
    String myid;
    String friend;
    Add(String UID,String F)
    {
        friend=F;
        myid=UID;
        setTitle("查找好友界面");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp1=new JPanel();
        jp1.setLayout(null);
        setContentPane(jp1);
        JLabel jl1=new JLabel(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p14.jpg"));
        jl1.setBounds(20,50, 100, 100);
        jp1.add(jl1);
        JLabel jl2=new JLabel("软件攻城狮");
        jl2.setBounds(130,50, 200, 50);
        jl2.setFont(new Font("宋体",1,28));
        jp1.add(jl2);
        JLabel jl3=new JLabel("账号：10003");
        jl3.setBounds(130,100, 200, 50);
        jl3.setFont(new Font("宋体",1,20));
        jp1.add(jl3);
        JButton jb8=new JButton("返回");
  jb8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb8event(evt);
            }
        });
        jb8.setFont(new Font("宋体",1,14));
        jb8.setBounds(380, 50, 100, 50);
       
        jp1.add(jb8);
        JTextField jt1=new JTextField("弃我去者昨日之日不可留");
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
         JButton jb5=new JButton("加为好友");
          jb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb5event(evt);
            }
        });
        jb5.setFont(new Font("宋体",1,24));
        jb5.setForeground(Color.white);
        jb5.setBounds(20,450, 450, 80);
        jb5.setBackground(Color.GRAY);
        jp1.add(jb5);
         this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-200)/2, (Toolkit.getDefaultToolkit().getScreenSize().height-200)/8);
         this.setVisible(true);
    }
    
     public void jb5event(ActionEvent e)
    {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/internet", "root","niit1234");
                 CallableStatement cs=con.prepareCall("call addfriend(?,?)");
                           cs.setString(1, myid);
                           cs.setString(2,friend );
                           
                           cs.execute();
                           cs.close();
    
                            cs.close();
                            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Linkdatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Linkdatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
       JOptionPane.showMessageDialog(this, "好友请求消息发送成功！");
    }
     
       public void jb8event(ActionEvent e)
    {
        new Maininterface("10000");
    }
    
    public static void main(String args[])
    {
       new Add("10000","10003");
        
    }
}   

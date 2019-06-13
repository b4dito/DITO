package 测试;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;



public class Maininterface extends JFrame
{
    String friend;
    JTextField jt1=new JTextField("");
    String myid;
    
    Maininterface(String UID)
    {
         myid=UID;
         setTitle("我的主界面");
        setSize(500, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp1=new JPanel();
        jp1.setLayout(null);
        
        setContentPane(jp1);
        JLabel jl2=new JLabel(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p8.png"));
        jl2.setBounds(0, 0, 100, 50);
        jp1.add(jl2);
        
        jt1.setFont(new Font("宋体",1,24));
        JLabel jl1=new JLabel("           我的好友列表");
        jl1.setBackground(Color.GRAY);
        jl1.setFont(new Font("宋体",1,24));
        jl1.setBounds(0, 50, 400, 50);
        jp1.add(jl1);
        JButton jbb=new JButton("查找");
        jbb.setFont(new Font("宋体",1,24));
        jbb.setBounds(400,0, 100, 50);
        jbb.setBackground(Color.GRAY);
        jbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbbevent(evt);
            }
        });
        jp1.add(jbb);
        JScrollPane js1=new JScrollPane();
        JPanel jp2=new JPanel();
        BoxLayout bl1=new BoxLayout(jp2,BoxLayout.Y_AXIS);
        jp2.setLayout(bl1);
        js1.setViewportView(jp2);
        js1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jt1.setBounds(100, 0, 400, 50);
        js1.setBounds(0,100, 480, 600);
        jp1.add(jt1);
        jp1.add(js1);
        
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/internet", "root","niit1234");
                 Statement st=con.createStatement();
                 
                 String dname="u"+myid;
               String sql="select 账号,网名,头像 from "+dname+".myfriend join usermassege on 好友账号=账号;";
               ResultSet rs=st.executeQuery(sql);
               while(rs.next())
               {
                   friend=rs.getString("账号");
                   String name=rs.getString("网名");
                   String icon=rs.getString("头像");
                    JButton tjb=new JButton(name+"                                      ",new ImageIcon(icon));
                    tjb.addActionListener(new java.awt.event.ActionListener() {
                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tjbevent(evt);
                    }
                });
            tjb.setFont(new Font("宋体",1,24));
            tjb.setBackground(Color.blue);
            jp2.add(tjb);
                   
               }
               rs.close();
               st.close();
               con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Linkdatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Linkdatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0;i<10;i++)
        {
            if(i%3==0)
            {
                 JButton tjb=new JButton("   沧海横流                                   ",new ImageIcon("C:\\Users\\Lenovo\\Desktop\\abc.jpg"));
                    tjb.addActionListener(new java.awt.event.ActionListener() {
                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tjbevent(evt);
                    }
                });
            tjb.setFont(new Font("宋体",1,24));
            tjb.setBackground(Color.blue);
            jp2.add(tjb);
            }
            if(i%3==1)
            {
                 JButton tjb=new JButton("Ashork.  。                                ",new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p12.jpg"));
                    tjb.addActionListener(new java.awt.event.ActionListener() {
                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tjbevent(evt);
                    }
                });
            tjb.setFont(new Font("宋体",1,24));
            tjb.setBackground(Color.blue);
            jp2.add(tjb);
            }
            if(i%3==2)
            {
                 JButton tjb=new JButton("          我归你                            ",new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p4.png"));
                    tjb.addActionListener(new java.awt.event.ActionListener() {
                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tjbevent(evt);
                    }
                });
            tjb.setFont(new Font("宋体",1,24));
            tjb.setBackground(Color.blue);
            jp2.add(tjb);
            }
        }
        
        
        
       
        JButton jb1=new JButton(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p1.png"));
        jb1.setFont(new Font("宋体",1,24));
        jb1.setBounds(166, 710, 166, 100);
        jb1.setBackground(Color.GRAY);
        
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
        jb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb3event(evt);
            }
        });
        jp1.add(jb3);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-200)/2, (Toolkit.getDefaultToolkit().getScreenSize().height-200)/8);
        setVisible(true);
        
        int count=0;
        try {
                Class.forName("com.mysql.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/internet", "root","niit1234");
                 Statement st=con.createStatement();
               String sql="select 状态 from massege where 接收人="+myid+";";
               ResultSet rs=st.executeQuery(sql);
               while(rs.next())
               {
                   int a=rs.getInt("状态");
                  
                  if(a==0)
                      count++;
               
               }
               rs.close();
               st.close();
               con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Linkdatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Linkdatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(count!=0)
        {
            Object options []={"立即查看","我知道了，暂不查看"};
            int ch=JOptionPane.showOptionDialog(this, "收到新信息,是否查看", "新信息通知", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if(ch==0)
            {
                dispose();
                Minterface open=new Minterface(myid);
            }
        }
        
    }
    
     public void jb2event(ActionEvent e)
    {
       dispose();
        Minterface open=new Minterface(myid);
    }
      public void jb3event(ActionEvent e)
    {
        dispose();
        Thirdinter open=new Thirdinter(myid);
    }
       public void tjbevent(ActionEvent e)
    {
        dispose();
        Myfriend u1=new Myfriend(myid,friend);
        u1.show();
    }
       
        public void jbbevent(ActionEvent e)
    {
       String id=jt1.getText();
       String database="u"+myid;
       String s1="10001";
       String s2="10003";
       if(id.equals(s1))
       {
                    dispose();
                     Myfriend open=new Myfriend(myid,friend);
                     open.show();
                     
       }
       else
       {
             dispose();
                     Add open=new Add(myid,friend);
                     open.show();
       }
       /*try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/internet", "root","niit1234");
                Statement st=con.createStatement();
                 String t;
               String sql;
               ResultSet rs;
               
                sql="select 账号 from usermassege;";
               rs=st.executeQuery(sql);
                int c=0;
               while(rs.next())
               {
                  
                 t=rs.getString("账号");
                 if(id.equals(t))
                 {
                    c++;
                 }
               }
                 if(c==0){
                     JOptionPane.showMessageDialog(this, "账号不存在！");
                     jt1.setText("");
                     id="";
               }
               String temp="";
               if(!id.equals(temp))
               {
               sql="select 好友账号 from "+database+".myfriend;";
               rs=st.executeQuery(sql);
               while(rs.next())
               {
                String t2=rs.getString("好友账号");
                 
                 if(id.equals(t2))
                 {
                     dispose();
                     Myfriend open=new Myfriend(myid,friend);
                     open.show();
                     break;
                 }
               }
               sql="select 账号 from usermassege where (账号 not in (select 好友账号 from "+database+".myfriend) and 账号 not in ("+myid+"));";
               rs=st.executeQuery(sql);
               while(rs.next())
               {
                String t1=rs.getString("账号");
                 if(id.equals(t1))
                 {
                     dispose();
                     Add open=new Add(myid,friend);
                     open.show();
                     break;
                 }
               }
               }
               
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
       
    }
    public static void main(String args[])
    {
        
        
    }
}   




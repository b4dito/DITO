package 测试;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Minterface extends JFrame
{
    String myid;
    String friend;
    Minterface(String UID)
    {
        String name="";
        String icon="";
        String text="";
        myid=UID;
        
        setTitle("消息列表界面");
        setSize(500, 850);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp1=new JPanel();
        jp1.setLayout(null);
        
        setContentPane(jp1);
        JTextField jt1=new JTextField("搜索聊天消息");
        jt1.setForeground(Color.BLUE);
        jt1.setFont(new Font("宋体",1,24));
        JLabel jl1=new JLabel("           我的消息列表");
        jl1.setFont(new Font("宋体",1,24));
        jl1.setBounds(0, 50, 500, 50);
        jp1.add(jl1);
        JScrollPane js1=new JScrollPane();
        JPanel jp2=new JPanel();
        BoxLayout bl1=new BoxLayout(jp2,BoxLayout.Y_AXIS);
        jp2.setLayout(bl1);
        js1.setViewportView(jp2);
        js1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jt1.setBounds(0, 0, 500, 50);
        js1.setBounds(0,100, 480, 600);
        jp1.add(jt1);
        jp1.add(js1);
        
        for(int i=0;i<18;i++)
        {
            if(i%3==0)
            {
            JButton tjb=new JButton(" My                                       ",new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p4.png"));
            tjb.setFont(new Font("宋体",1,24));
            tjb.setBackground(Color.GREEN);
            tjb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tjbevent(evt);
            }
        });
            JLabel tjl=new JLabel("今晚有什么打算？");
            tjl.setFont(new Font("宋体",0,18));
            jp2.add(tjb);
            jp2.add(tjl);
        }
             if(i%3==1)
            {
            JButton tjb=new JButton(" 半城烟沙                                       ",new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p12.jpg"));
            tjb.setFont(new Font("宋体",1,24));
            tjb.setBackground(Color.GREEN);
            tjb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tjbevent(evt);
            }
        });
            JLabel tjl=new JLabel("我们已经成为好友啦！请和我开始聊天吧");
            tjl.setFont(new Font("宋体",0,18));
            jp2.add(tjb);
            jp2.add(tjl);
        }
              if(i%3==2)
            {
            JButton tjb=new JButton("  千年之约                                      ",new ImageIcon("C:\\Users\\Lenovo\\Desktop\\abc.jpg"));
            tjb.setFont(new Font("宋体",1,24));
            tjb.setBackground(Color.GREEN);
            tjb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tjbevent(evt);
            }
        });
            JLabel tjl=new JLabel("兄弟，快来北门哈");
            tjl.setFont(new Font("宋体",0,18));
            jp2.add(tjb);
            jp2.add(tjl);
        }
        }
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
               String sql="select 状态 from massege where 接收人="+myid+" and 消息类型=1;";
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
           Approve open= new Approve(myid);
           open.show();
       }
    }
    
     public void jb1event(ActionEvent e)
    {
        hide();
        Maininterface m=new Maininterface(myid);
    }
     
      public void jb3event(ActionEvent e)
    {
        dispose();
        Thirdinter m=new Thirdinter(myid);
    }
      
      public void tjbevent(ActionEvent e)
    {
        dispose();
        Chatinterface m=new Chatinterface(myid,friend);
    }
    
    public static void main(String args[])
    {
       new Minterface("10000");
    }
}   

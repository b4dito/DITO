package 测试;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Approve extends JFrame
{
    String myid;
     Approve(String UID)
    {
        myid=UID;
        setTitle("验证消息界面");
        setSize(500, 600);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp1=new JPanel();
        jp1.setLayout(null);
        
        setContentPane(jp1);
        JLabel jl1=new JLabel("            验证消息列表");
        jl1.setBackground(Color.GRAY);
        jl1.setFont(new Font("宋体",1,20));
        jl1.setBounds(0, 0, 400, 50);
        jp1.add(jl1);
         JButton jb=new JButton("关闭");
         jb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbevent(evt);
            }
        });
         jb.setBounds(375, 0, 100, 50);
         jp1.add(jb);
        JScrollPane js1=new JScrollPane();
        JPanel jp2=new JPanel();
        BoxLayout bl1=new BoxLayout(jp2,BoxLayout.Y_AXIS);
        jp2.setLayout(bl1);
        js1.setViewportView(jp2);
        js1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        js1.setBounds(0,50, 480, 500);
       
        jp1.add(js1);
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/internet", "root","niit1234");
                 Statement st=con.createStatement();
               String sql="select 状态 from massege where 接收人="+myid+" and 消息类型=1 order by 发送时间;";
               ResultSet rs=st.executeQuery(sql);
               while(rs.next())
               {
                   int a=rs.getInt("状态");
                  
                  if(a==0)
                  {
                      for(int i=0;i<10;i++)
                      {
                          if(i%3==0)
                          {
                            JLabel tjl1=new JLabel("My    请求添加您为好友",new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p4.png"),JLabel.LEFT);
                            
                           jp2.add(tjl1);
                            JLabel tjl2=new JLabel("                                                                                                                  立即处理");
                            tjl1.setFont(new Font("宋体",1,18));
                            tjl1.setFont(new Font("宋体",0,14));
                            tjl2.setForeground(Color.BLUE);
                           jp2.add(tjl2);
                           tjl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tjl2MouseClicked(evt);
            }
        });
                          }
                            if(i%3==1)
                          {
                            JLabel tjl1=new JLabel("软件攻城狮    请求添加您为好友",new ImageIcon("C:\\Users\\Lenovo\\Desktop\\abc.jpg"),JLabel.LEFT);
                           jp2.add(tjl1);
                            JLabel tjl2=new JLabel("                                                                                                                  立即处理");
                            
                           jp2.add(tjl2); tjl1.setFont(new Font("宋体",1,18));
                            tjl1.setFont(new Font("宋体",0,14));
                            tjl2.setForeground(Color.BLUE);
                           tjl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tjl2MouseClicked(evt);
            }
        });
                          }
                              if(i%3==0)
                          {
                            JLabel tjl1=new JLabel("苦逼程序猿    请求添加您为好友",new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p12.jpg"),JLabel.LEFT);
                           jp2.add(tjl1);
                           JLabel tjl2=new JLabel("                                                                                                                  立即处理");
                            
                             tjl1.setFont(new Font("宋体",1,18));
                            tjl1.setFont(new Font("宋体",0,14));
                            tjl2.setForeground(Color.BLUE);
                           jp2.add(tjl2);
                           tjl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tjl2MouseClicked(evt);
            }
        });
                          }
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
        
        this.setVisible(true);
    }
     
      public void jbevent(ActionEvent e)
    {
        dispose();
        
    }
      
      private void tjl2MouseClicked(java.awt.event.MouseEvent evt) {                                         
        Object options []={"同意","拒绝，忽略"};
            int ch=JOptionPane.showOptionDialog(this, "是否同意该请求", "好友验证信息通知", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if(ch==0)
                JOptionPane.showMessageDialog(this, "添加成功！苦逼程序猿已成为您的好友");
      }     
       
    
    public static void main(String args[])
    {
       new Approve("10000");
    }
 
}

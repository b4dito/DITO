package 测试;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
public class Chatinterface extends JFrame
{
    JPanel jp1=new JPanel();
    JPanel jp2=new JPanel();
    JTextArea jta1=new JTextArea();
    String myid;
    String friend;
    Chatinterface( String UID,String F)
    {
        friend=F;
        myid=UID;
        setTitle("聊天界面");
        setSize(500, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        jp1.setLayout(null);
        
        setContentPane(jp1);
        JButton jb1=new JButton("返回");
        jb1.setBounds(0, 0, 100, 50);
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1event(evt);
            }
        });
        jp1.add(jb1);
        JScrollPane js1=new JScrollPane();
        
        BoxLayout bl1=new BoxLayout(jp2,BoxLayout.Y_AXIS);
        jp2.setLayout(bl1);
        js1.setViewportView(jp2);
        js1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        js1.setBounds(0,50, 480, 650);
        jp1.add(js1);
       
        jta1.setBounds(0, 700, 500, 100);
        jta1.setBackground(Color.BLACK);
        jta1.setFont(new Font("宋体",0,24));
        jta1.setForeground(Color.white);
        jp1.add(jta1);
        JButton jb2=new JButton("发送消息");
        jb2.setBackground(Color.GRAY);
        jb2.setBounds(380, 800, 100, 50);
        jb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb2event(evt);
            }
        });
        jp1.add(jb2);
        
        try {
            Connection con;
            Statement st;
          
               Class.forName("com.mysql.jdbc.Driver");
               con=DriverManager.getConnection("jdbc:mysql://localhost:3306/internet", "root","niit1234");
               st=con.createStatement();
               String sql="select 网名,发送时间,内容,头像 from  usermassege join massege on (发送人=账号)  order by 发送时间 ;";
               ResultSet rs=st.executeQuery(sql);
               while(rs.next())
               {
                   String time=rs.getString("发送时间");
                   String text=rs.getString("内容");
                   String name=rs.getString("网名");
                   String icon=rs.getString("头像");
                    JTextField tjt=new JTextField(text);
           tjt.setEditable(false);
           tjt.setFont(new Font("宋体",2,18));
           JLabel tjl=new JLabel(name+"-   "+time,new ImageIcon(icon),JLabel.LEFT);
           tjl.setBackground(Color.red);
           tjl.setFont(new Font("宋体",1,18));
           jp2.add(tjl);
           jp2.add(tjt);
                   
               }
               rs.close();
               st.close();
               con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Linkdatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Linkdatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        for(int i=0;i<6;i++)
        {
          
        }
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-200)/2, (Toolkit.getDefaultToolkit().getScreenSize().height-200)/8);
       setVisible(true);
      
      
    }
    
    public void jb1event(ActionEvent e)
    {
        dispose();
        Minterface m=new Minterface(myid);
    }
    
    public void jb2event(ActionEvent e)
    {
        
            String masg=jta1.getText();
            jta1.setText("");
            JTextField tjt1=new JTextField(masg);
           tjt1.setEditable(false);
           tjt1.setFont(new Font("宋体",2,18));
           JLabel tjl1=new JLabel("沧浪之水    2019/5/16 ",new ImageIcon("C:\\Users\\Lenovo\\Desktop\\p4.png"),JLabel.LEFT);
           tjl1.setBackground(Color.red);
           tjl1.setFont(new Font("宋体",1,18));
       
           jp2.add(tjl1);
           jp2.add(tjt1);
           jp2.updateUI();
           jp2.validate();
           tjl1.scrollRectToVisible(new Rectangle(tjl1.getBounds()));
           tjt1.scrollRectToVisible(new Rectangle(tjt1.getBounds()));
          
        
    }
    public static void main(String args[])
       {
          new Chatinterface("10000","10001");
       }
}

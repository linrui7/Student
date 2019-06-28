import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SearchOneStudent extends JFrame {
    JLabel jlnumber = new JLabel("学号：");
    JLabel jlname = new JLabel("姓名：");
    JLabel jlsex = new JLabel("性别：");
    JLabel jlbirthday = new JLabel("生日：");
    JLabel jldepartment = new JLabel("专业班级：");
    JTextField jtnumber = new JTextField("",20);
    JLabel jname = new JLabel();
    JLabel jsex = new JLabel();
    JLabel jbirthday = new JLabel();
    JLabel jdepartment = new JLabel();

    JButton buttonask = new JButton("查询");
    JButton buttonreturn = new JButton("返回");


    public SearchOneStudent() {
        JPanel jpnumber = new JPanel();
        JPanel jpname = new JPanel();
        JPanel jpsex = new JPanel();
        JPanel jpbirthday = new JPanel();
        JPanel jpdepartment = new JPanel();
        JPanel jpforbutton = new JPanel(new FlowLayout(1,1,30));
        jlnumber.setFont(new Font("Dialog", 1, 15));
        jlname.setFont(new Font("Dialog", 1, 15));
        jlsex.setFont(new Font("Dialog", 1, 15));
        jlbirthday.setFont(new Font("Dialog", 1, 15));
        jldepartment.setFont(new Font("Dialog", 1, 15));
        buttonask.setFont(new Font("Dialog", 1, 20));
        buttonreturn.setFont(new Font("Dialog", 1, 20));
        jpnumber.add(jlnumber);
        jpnumber.add(jtnumber);
        jpname.add(jlname);
        jpname.add(jname);
        jpsex.add(jlsex);
        jpsex.add(jsex);
        jpbirthday.add(jlbirthday);
        jpbirthday.add(jbirthday);
        jpdepartment.add(jldepartment);
        jpdepartment.add(jdepartment);
        jpforbutton.add(buttonask);
        buttonask.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Connection conn = null;
                ResultSet res = null;
                Statement stat = null;
                String sql = "SELECT number,name,sex,birthday,department FROM student;";
                try{
                    System.out.println("查找功能启动");
                    Class.forName("com.mysql.jdbc.Driver");

                }catch(Exception d){
                    System.out.println("jdbc fall");
                    d.printStackTrace();
                }
                try{
                    conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/studentInfo?useSSL=false","root","aaaaaa");
                    stat=conn.createStatement();
                    res=stat.executeQuery(sql);
                    while (res.next())
                    {
                        if (res.getString(1).equals(jtnumber.getText()))
                        {
                            jname.setText(res.getString(2));
                            jsex.setText(res.getString(3));
                            jbirthday.setText(res.getString(4));
                            jdepartment.setText(res.getString(5));
                            break;
                        }
                    }
                }catch (SQLException e1) {
                    e1.printStackTrace();
                }
                finally{
                    try{
                        conn.close();
                    }catch(SQLException ar){
                        ar.printStackTrace();
                    }

                }}}
        );
        buttonreturn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Main window = new Main();
            }
        });
        this.setTitle("查询单个学生信息");
        this.setLayout(new GridLayout(9,1));
        this.add(jpnumber);
        this.add(jpname);
        this.add(jpsex);
        this.add(jpbirthday);
        this.add(jpdepartment);
        this.add(jpforbutton);
        this.setLocation(400,300);
        this.setSize(800,600);
        this.setVisible(true);
    }
}
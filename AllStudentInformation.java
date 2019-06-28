import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class AllStudentInformation extends JFrame {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet res = null;
    JTable jtable;
    JScrollPane jscrollpane = new JScrollPane();
    Vector columnNames = null;
    Vector rowData = null;
    public AllStudentInformation() {
        JPanel jpforbutton = new JPanel(new GridLayout(1,1));
        columnNames = new Vector();
        columnNames.add("学号");
        columnNames.add("姓名");
        columnNames.add("性别");
        columnNames.add("生日");
        columnNames.add("专业班级");
        rowData = new Vector();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/studentInfo?useSSL=false","root","aaaaaa");
            ps = conn.prepareStatement("SELECT * FROM student");
            res = ps.executeQuery();
            while (res.next())
            {
                Vector hang = new Vector();
                hang.add(res.getString(1));
                hang.add(res.getString(2));
                hang.add(res.getString(3));
                hang.add(res.getString(4));
                hang.add(res.getString(5));
                rowData.add(hang);
            }
            System.out.println("显示所有人信息");
        }catch (Exception q){
            System.out.println(q.getMessage());
        }finally{
            try{
                res.close();
                ps.close();
                conn.close();
            }catch (SQLException o){
                System.out.println(o.getMessage());
            }
        }

        jtable = new JTable(rowData,columnNames);
        jscrollpane = new JScrollPane(jtable);
        this.add(jscrollpane);
        this.setTitle("所有学生信息");
        this.setLayout(new FlowLayout());
        this.add(jpforbutton);
        this.setLocation(300,300);
        this.setSize(550,600);
        this.setBackground(Color.BLUE);
        this.setVisible(true);
        this.setResizable(false);
    }
}
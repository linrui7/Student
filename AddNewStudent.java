import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddNewStudent extends JFrame {

    public AddNewStudent() {
        JLabel jlnumber = new JLabel("  *学号：");
        JLabel jlname = new JLabel("  *姓名：");
        JLabel jlsex = new JLabel("  *性别：");
        JLabel jlbirthday = new JLabel("  *生日：");
        JLabel jldepartment = new JLabel("*专业班级：");
        JTextField jtnumber = new JTextField("", 20);
        JTextField jtname = new JTextField("", 20);
        JTextField jtsex = new JTextField("", 20);
        JTextField jtbirthday = new JTextField("", 20);
        JTextField jtdepartment = new JTextField("", 18);

        JButton buttonadd = new JButton("添加");
        JButton buttonreturn = new JButton("返回");
        JPanel jpnumber = new JPanel();
        JPanel jpname = new JPanel();
        JPanel jpsex = new JPanel();
        JPanel jpbirthday = new JPanel();
        JPanel jpdepartment = new JPanel();
        JPanel jpforbutton = new JPanel();

        jlnumber.setFont(new Font("Dialog", 1, 20));
        jlname.setFont(new Font("Dialog", 1, 20));
        jlsex.setFont(new Font("Dialog", 1, 20));
        jlbirthday.setFont(new Font("Dialog", 1, 20));
        jldepartment.setFont(new Font("Dialog", 1, 20));
        buttonadd.setFont(new Font("Dialog", 1, 30));
        buttonreturn.setFont(new Font("Dialog", 1, 30));

        jpnumber.add(jlnumber);
        jpnumber.add(jtnumber);
        jpname.add(jlname);
        jpname.add(jtname);

        jpsex.add(jlsex);
        jpsex.add(jtsex);

        jpbirthday.add(jlbirthday);
        jpbirthday.add(jtbirthday);

        jpdepartment.add(jldepartment);
        jpdepartment.add(jtdepartment);

        jpforbutton.add(buttonadd);
        jpforbutton.add(buttonreturn);

        buttonadd.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {

                                            Connection conn = null;
                                            Statement stat = null;
                                            PreparedStatement ps = null;
                                            String sql = "INSERT INTO student(number,name,sex,birthday,department) "
                                                    + "values(?,?,?,?,?)";
                                            try {
                                                System.out.println("添加学生信息");
                                                Class.forName("Driver");
                                            } catch (Exception a) {
                                                System.out.println(a.getMessage());
                                            }
                                            try {
                                                conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/studentInfo?useSSL=false", "root", "aaaaaa");
                                                ps = conn.prepareStatement(sql);

                                                ps.setString(1, jtnumber.getText());
                                                ps.setString(2, jtname.getText());
                                                ps.setString(3, jtsex.getText());
                                                ps.setString(4, jtbirthday.getText());
                                                ps.setString(5, jtdepartment.getText());

                                                ps.executeUpdate();
                                            } catch (SQLException b) {
                                                System.out.println(b.getMessage());
                                            } finally {
                                                try {
                                                    conn.close();
                                                } catch (SQLException c) {
                                                    System.out.println(c.getMessage());
                                                }
                                            }
                                        }
                                    }
        );

        buttonreturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main window = new Main();
            }
        });
        this.setTitle("添加学生信息");
        this.setLayout(new GridLayout(9, 1));
        this.add(jpnumber);
        this.add(jpname);
        this.add(jpsex);
        this.add(jpbirthday);
        this.add(jpdepartment);
        this.add(jpforbutton);
        this.setLocation(400, 300);
        this.setSize(800, 500);
        this.setVisible(true);
    }
}
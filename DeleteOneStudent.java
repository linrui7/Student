import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class DeleteOneStudent extends JFrame {
    JLabel jlnumber = new JLabel("学号：");
    JTextField jtnumber = new JTextField("", 20);
    JButton buttondelete = new JButton("删除");
    JButton buttonreturn = new JButton("返回");

    public DeleteOneStudent() {
        JPanel jpnumber = new JPanel();
        JPanel jpforbutton = new JPanel();
        jpnumber.add(jlnumber);
        jpnumber.add(jtnumber);
        jpforbutton.add(buttondelete);
        jpforbutton.add(buttonreturn);
        jlnumber.setFont(new Font("Dialog", 1, 30));
        buttonreturn.setFont(new Font("Dialog", 1, 20));
        buttondelete.setFont(new Font("Dialog", 1, 20));

        buttondelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String number = jtnumber.getText();
                Connection conn = null;
                ResultSet res = null;
                Statement stat = null;
                String sql = "DELETE FROM student WHERE number='" + number + "'";
                try {
                    System.out.println("删除功能启动");
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (Exception a) {
                    a.printStackTrace();
                }
                try {
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/studentInfo?useSSL=false", "root", "aaaaaa");
                    stat = conn.createStatement();
                    stat.executeUpdate(sql);
                } catch (SQLException h) {
                    System.out.println(h.getMessage());
                } finally {
                    try {
                        conn.close();
                    } catch (SQLException j) {
                        System.out.println(j.getMessage());
                    }

                }

            }
        });

        buttonreturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main window = new Main();
            }
        });
        this.setTitle("删除学生信息");
        this.setLayout(new GridLayout(9, 1));
        this.add(jpnumber);
        this.add(jpforbutton);
        this.setLocation(400, 300);
        this.setSize(800, 400);
        this.setVisible(true);
    }
}


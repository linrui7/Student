import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jframe = new JFrame("学生管理系统");
        JButton button1 = new JButton("添加");
        button1.setFont(new Font("Dialog", 1, 30));
        JButton button2 = new JButton("修改");
        button2.setFont(new Font("Dialog", 1, 30));
        JButton button3 = new JButton("查询");
        button3.setFont(new Font("Dialog", 1, 30));
        JButton button4 = new JButton("删除学生信息");
        button4.setFont(new Font("Dialog", 1, 30));
        JButton button5 = new JButton("查看所有信息");
        button5.setFont(new Font("Dialog", 1, 30));
        FlowLayout flow = new FlowLayout(1, 80, 80);
        JPanel panel = new JPanel(flow);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.setBackground(Color.white);
        jframe.add(panel);
        jframe.setLocation(400, 300);
        jframe.setSize(750, 400);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);

        //添加监听器
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddNewStudent add = new AddNewStudent();
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangeOneInformation change = new ChangeOneInformation();
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchOneStudent ask = new SearchOneStudent();
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteOneStudent delete = new DeleteOneStudent();
            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AllStudentInformation look = new AllStudentInformation();
            }
        });
    }
}
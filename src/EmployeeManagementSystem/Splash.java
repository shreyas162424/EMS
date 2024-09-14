package EmployeeManagementSystem;

import javax.swing.* ;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {

    Splash(){

        getContentPane().setBackground(Color.WHITE);


        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(80,30,1200,60);
        heading.setFont(new Font("seriff",Font.PLAIN,60));
        heading.setForeground(Color.RED);
        add(heading);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);

        JButton clickhere = new JButton("Click Here To Continue");
        clickhere.setBackground(Color.WHITE);
        clickhere.setBounds(400,400,300,70);
        clickhere.addActionListener(this);
        image.add(clickhere);

        setSize(1170,650);
        setLocation(200,50);
        setVisible(true);

        while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);

            }catch(Exception e){

            }
            heading.setVisible(true);
            try{
                Thread.sleep(500);

            }catch(Exception e){

            }
        }
    }
    public static void main(String args[]){
        new Splash();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();

    }
}

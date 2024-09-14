package EmployeeManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JButton add,view,Update,Remove;
    Home(){




        setLayout(null);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);


        JLabel heading= new JLabel("Employee Management System");
        heading.setBounds(620,20,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(heading);

         add=new JButton("Add Employee");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        image.add(add);


         view=new JButton("view Employees");
        view.setBounds(820,80,150,40);
        view.addActionListener(this);
        image.add(view);

         Update=new JButton("Update Employees");
        Update.setBounds(650,140,150,40);
        Update.addActionListener(this);
        image.add(Update);

        Remove=new JButton("Remove Employees");
        Remove.setBounds(820,140,150,40);
        Remove.addActionListener(this);
        image.add(Remove);

        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    }

    public static void main(String args[]){
        new Home();
    }


   public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== add){
            setVisible(false);
            new AddEmployee();

        } else if (ae.getSource()==view) {
                   setVisible(false);
                   new ViewEmployee();
        } else if (ae.getSource()==Update) {
            setVisible(false);
            new ViewEmployee();

        }else {
            setVisible(false);
            new RemoveEmployee();

        }

    }
}

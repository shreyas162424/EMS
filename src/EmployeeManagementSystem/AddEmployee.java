package EmployeeManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddEmployee  extends JFrame implements ActionListener {

    JDateChooser dcdob;
    JButton add, back;
    Random ran = new Random();
    JComboBox cbeducation;
    JLabel lblempId;
    int number = ran.nextInt(999999);

    JTextField tfname, tffname, tfphone, tfaadhar, tfemail, tfsalary, tfAddress, tfdesignation;


    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN SERIFF", Font.BOLD, 25));
        image.add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 151, 150, 30);
        labelname.setFont(new Font("seriff", Font.PLAIN, 20));
        image.add(labelname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        image.add(tfname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("seriff", Font.PLAIN, 20));
        image.add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        image.add(tffname);

        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("seriff", Font.PLAIN, 20));
        image.add(labeldob);


        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        image.add(dcdob);

        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(50, 250, 150, 30);
        labelsalary.setFont(new Font("seriff", Font.PLAIN, 20));
        image.add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        image.add(tfsalary);

        JLabel labelAddress = new JLabel("Address");
        labelAddress.setBounds(400, 200, 150, 30);
        labelAddress.setFont(new Font("seriff", Font.PLAIN, 20));
        image.add(labelAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(200, 250, 150, 30);
        image.add(tfAddress);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        image.add(tfphone);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("seriff", Font.PLAIN, 20));
        image.add(labelphone);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        image.add(tfemail);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("seriff", Font.PLAIN, 20));
        image.add(labelemail);

        JLabel labeleducation = new JLabel("Highest Education ");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("seriff", Font.PLAIN, 17));
        image.add(labeleducation);

        String courses[] = {"BBA", "BCA", "BA", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "BSc"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBounds(600, 300, 150, 30);
        cbeducation.setBackground(Color.WHITE);
        image.add(cbeducation);

        JLabel labelDesignation = new JLabel("Designation");
        labelDesignation.setBounds(50, 350, 150, 30);
        labelDesignation.setFont(new Font("seriff", Font.PLAIN, 20));
        image.add(labelDesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        image.add(tfdesignation);

        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("seriff", Font.PLAIN, 20));
        image.add(labelaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        image.add(tfaadhar);

        JLabel labelempId = new JLabel("Employee ID");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("seriff", Font.PLAIN, 20));
        image.add(labelempId);

        lblempId = new JLabel("" + number);
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("seriff", Font.PLAIN, 20));
        image.add(lblempId);

        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        image.add(add);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        image.add(back);


        setSize(900, 700);
        setLocation(300, 90);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {
            String name = tfname.getText();
            String tfname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfAddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String empid = lblempId.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into employee values('" + name + "','" + tfname + "','" + dob + "','" + salary + "','" + address + "','" + phone + "','" + email + "','" + education + "','" + designation + "','" + aadhar + "','" + empid + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String args[]) {
        new AddEmployee();
    }
}

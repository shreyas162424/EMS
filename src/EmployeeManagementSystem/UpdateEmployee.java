package EmployeeManagementSystem;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateEmployee  extends JFrame implements ActionListener {


    JButton add, back;
    JLabel lblempId;


    JTextField tfeducation, tffname, tfphone, tfaadhar, tfemail, tfsalary, tfAddress, tfdesignation;
    String empID;

    UpdateEmployee(String EmpId) {
        this.empID= empID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);



//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(900,500,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(0,0,900,500);
//        add(image);


        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN SERIFF", Font.BOLD, 25));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("seriff", Font.PLAIN, 20));
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("seriff", Font.PLAIN, 20));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("seriff", Font.PLAIN, 20));
        add(labeldob);


        JLabel lbldob = new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);

        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(50, 250, 150, 30);
        labelsalary.setFont(new Font("seriff", Font.PLAIN, 20));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);

        JLabel labelAddress = new JLabel("Address");
        labelAddress.setBounds(400, 200, 150, 30);
        labelAddress.setFont(new Font("seriff", Font.PLAIN, 20));
        add(labelAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(200, 250, 150, 30);
        add(tfAddress);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("seriff", Font.PLAIN, 20));
        add(labelphone);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("seriff", Font.PLAIN, 20));
        add(labelemail);

        JLabel labeleducation = new JLabel("Highest Education ");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("seriff", Font.PLAIN, 13));
        add(labeleducation);

         tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        add(tfeducation);

        JLabel labelDesignation = new JLabel("Designation");
        labelDesignation.setBounds(50, 350, 150, 30);
        labelDesignation.setFont(new Font("seriff", Font.PLAIN, 20));
        add(labelDesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);

        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("seriff", Font.PLAIN, 20));
        add(labelaadhar);

        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150, 30);
        add(lblaadhar);

        JLabel labelempId = new JLabel("Employee ID");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("seriff", Font.PLAIN, 20));
        add(labelempId);

        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("seriff", Font.PLAIN, 20));
        add(lblempId);


        try{
            Conn c=new Conn();
            String query="select * from employee where empId='"+empID+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfAddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfemail.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
                tfdesignation.setText(rs.getString("designation"));


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);


        setSize(900, 700);
        setLocation(300, 90);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfAddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) tfeducation.getText();
            String designation = tfdesignation.getText();

            try {
                Conn conn = new Conn();
                String query = "update  employee set fname='" + fname + "','" + salary + "',address='" + address + "',phone='" + phone + "',email='" + email + "',education='" + education + "',designation='" + designation + "'where empId='" + empID + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
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
        new UpdateEmployee("");
    }
}

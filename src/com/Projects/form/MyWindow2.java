package com.Projects.form;

import javax.swing.*;
import java.awt.*;

public class MyWindow2 extends JFrame {
    private JLabel heading;
    Font font= new Font("", Font.BOLD,30);
    private JPanel mainPanel;
    private JLabel nameLabel, passwordLabel;
    private JTextField nameTextField;
    private JPasswordField passwordField;
    private JButton button1,button2;

    public MyWindow2() {
        super.setTitle("My First Form");
        super.setSize(550,500);
        super.setLocation(100,100);
        //close the program . stop the jre running on the background
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createGUI();
//        super.setVisible(true);
        //you can call these methods normally like this also because these methods are not in the class so by default java understands these methods are of parent class
        setVisible(true);//but using super keyword is good coding practice
        System.out.println("this is a constructor....");
    }
    public void createGUI(){
        //this method create our gui
        this.setLayout(new BorderLayout());
        heading = new JLabel("My first Form...");
        heading.setFont(font);
        heading.setHorizontalAlignment(JLabel.CENTER);
        this.add(heading,BorderLayout.NORTH);

        ////working with JPanel....
        mainPanel = new JPanel();
        //setting layout of main panel
        mainPanel.setLayout(new GridLayout(3,2));
        nameLabel= new JLabel("Enter name :");
        nameLabel.setFont(font);
        passwordLabel= new JLabel("Enter password :");
        passwordLabel.setFont(font);
        nameTextField= new JTextField();
        nameTextField.setFont(font);
        passwordField= new JPasswordField();
        passwordField.setFont(font);
        // now if you will not make object of these then you will get null pointer exception
        //making objects of all these
        button1 = new JButton("Submit");
        button1.setFont(font);
        button2= new JButton("Reset");
        button2.setFont(font);

        //adding all the components
        mainPanel.add(nameLabel);
        mainPanel.add(nameTextField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(button1);
        mainPanel.add(button2);

        //adding mainPanel to the layout
        this.add(mainPanel,BorderLayout.CENTER);

    }
}


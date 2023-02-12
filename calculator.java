package Calculaor_app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class calculator implements ActionListener
{
    JFrame frame; //For frame
    JTextField text_field; //For Texts
    JButton[] buttons = new JButton[10]; //Holds all numbered buttons (0-9)
    JButton[] func_buttons = new JButton[9]; //Holds all functional buttons
    JButton addition, subtraction, multiplication, division;
    JButton decimal, equal, delete, clear, negative;
    JPanel panel; //For holding all the separate button
    Font font = new Font("Serif Bold",Font.PLAIN , 30); //For fonts
    double num1=0, num2=0, result=0; //Holds digits
    char ch; //For holding mul, div, sub etc sign

    //CONSTRUCTOR
    calculator()
    {
        //INITIALIZING
        frame = new JFrame("Calculator"); //Title : Calculator
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        frame.setBackground(Color.yellow);

        //where the operation and values will be showed
        text_field = new JTextField();
        text_field.setBounds(50,25,300,50);//dimension of text field
        text_field.setFont(font); 
        text_field.setEditable(false); //restricting user from writing in the text field
        
        //INITIALIZING VALUES TO THE VARIABLES
        addition = new JButton("+");
        subtraction = new JButton("-");
        multiplication = new JButton("*");
        division = new JButton("/");
        equal = new JButton("=");
        clear = new JButton("cls");
        delete = new JButton("del");
        decimal = new JButton(".");
        negative = new JButton("(-)");


        //ASSIGNING VARIABLES TO THE BUTTONS
        func_buttons[0] = addition;
        func_buttons[1] = subtraction;
        func_buttons[2] = multiplication;
        func_buttons[3] = division;
        func_buttons[4] = equal;
        func_buttons[5] = decimal;
        func_buttons[6] = clear;
        func_buttons[7] = delete;
        func_buttons[8] = negative;

        //FOR FUNCTIONAL BUTTONS
        for(int i=0; i<9; i++)
        {
            func_buttons[i].addActionListener(this);
            func_buttons[i].setFont(font);
            func_buttons[i].setFocusable(false);
        }

        //FOR NUMBER BUTTONS
        for(int i=0; i<10; i++)
        {
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].addActionListener(this);
            buttons[i].setFont(font);
            buttons[i].setFocusable(false);
        }
        
        //FOR DELETE AND CLEAR BUTTONS
        negative.setBounds(50,430,100,50);
        delete.setBounds(150,430,100,50);
        clear.setBounds(250,430,100,50);

        //PANEL FOR HOLDING ALL THE BUTTONS
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.BLACK);

        //DECORATING THE BUTTONS FROM TOP LEFT TO RIGHT
        panel.add(buttons[1]);
        panel.add(buttons[2]);
        panel.add(buttons[3]);
        panel.add(addition);
        panel.add(buttons[4]);
        panel.add(buttons[5]);
        panel.add(buttons[6]);
        panel.add(subtraction);
        panel.add(buttons[7]);
        panel.add(buttons[8]);
        panel.add(buttons[9]);
        panel.add(multiplication);
        panel.add(decimal);
        panel.add(buttons[0]);
        panel.add(equal);
        panel.add(division);

        //ADDING EVERYTHING TO FRAME
        frame.add(panel);
        frame.add(negative);
        frame.add(delete);
        frame.add(clear);
        frame.add(text_field);

        //FOR VISIBILITY OF ALL BUTTONS, (TRUE)
        frame.setVisible(true);
    }
    //MAIN CLASS
    public static void main(String[] args)
    {
        calculator cal=new calculator();

    }

    //TO ADD FUNCTIONALITY
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // WHEN WE CLICK ON NUMBER IT WILL UPDATE ON THE TEXT FIELD
        for(int i=0; i<10; i++)
        {
            if(e.getSource() == buttons[i])
            {
                text_field.setText(text_field.getText().concat(String.valueOf(i)));
            }
        } 
        //FUNCTIONALITY OF DECIMAL
        if(e.getSource() == decimal)
        {
            text_field.setText(text_field.getText().concat("."));
        }
        //FUNCTIONALITY OF ADDITION
        if(e.getSource() == addition)
        {
            num1=Double.parseDouble(text_field.getText());
            ch='+';
            text_field.setText(" ");
        }
        //FUNCTIONALITY OF SUBTRACTION
        if(e.getSource() == subtraction)
        {
            num1=Double.parseDouble(text_field.getText());
            ch='-';
            text_field.setText(" ");
        }
        //FUNCTIONALITY OF MULTIPLICATION
        if(e.getSource() == multiplication)
        {
            num1=Double.parseDouble(text_field.getText());
            ch='*';
            text_field.setText(" ");
        }
        //FUNCTIONALITY OF DIVISION
        if(e.getSource() == division)
        {
            num1=Double.parseDouble(text_field.getText());
            ch='/';
            text_field.setText(" ");
        }
        //FUNCTIONALITY OF EQUAL
        if(e.getSource() == equal)
        {
            num2=Double.parseDouble(text_field.getText());
            switch(ch)
            {
                case'+':
                    result = num1+num2;
                    break;
                case'-':
                    result = num1-num2;
                    break;
                case'*':
                    result = num1*num2;
                    break;
                case'/':
                    result = num1/num2;
                    break;
            }
            text_field.setText(String.valueOf(result));
            num1=result;
        }
        //FUNCTIONALITY OF CLEAR
        if(e.getSource() == clear)
        {
            text_field.setText(""); 
        }
        //FUNCTIONALITY OF DELETE
        if(e.getSource() == delete)
        {
            String str = text_field.getText();
            text_field.setText(""); 
            for(int i=0; i<str.length()-1; i++)
            {
                text_field.setText(text_field.getText()+str.charAt(i));
            }
        }
        //FUNCTIONALITY OF NEGATIVE
        if(e.getSource() == negative)
        {
            double temp = Double.parseDouble(text_field.getText());
            temp*=-1;
            text_field.setText(String.valueOf(temp)); 
        }
    }
}
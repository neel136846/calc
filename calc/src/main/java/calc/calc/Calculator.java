package calc.calc;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Calculator extends JFrame implements ActionListener{
    private JButton[] buttons; //Array for main buttons
    private JButton clear; //Button for clearing
    private String[] buttonText; //Array for storing main button text
    private GridLayout gridLayout; //Grid for main buttons
    private JTextArea display; //Text area to display input and outputs
    private double num1; //Stores first value user inputs or the solution to the previous calculation
    private double num2; //Stores the second value entered by the user
    private String operator; //Stores the operator that the user selects

    //Constructor sets up GUI and initial values
    private Calculator(){
        super("12-19_Calculator_hard");
        display = new JTextArea(1,10);
        gridLayout = new GridLayout(4,4);
        buttonText = new String[]{"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
        num1 = -1000;
        num2 = 0;
        guiSetup();
    }


    //This method creates the calculator GUI
    private void guiSetup(){
        setSize(250, 300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Set up text area display in a JPanel
        JPanel displayPanel = new JPanel();
        display.setColumns(20);
        display.setEditable(false);
        displayPanel.add(display);
        add(displayPanel, BorderLayout.NORTH);

        //Set up main buttons in a JPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(gridLayout);
        buttons = new JButton[buttonText.length];
        for(int i = 0; i < buttonText.length; i++){
            buttons[i] = new JButton(buttonText[i]);
            buttonPanel.add(buttons[i]);
            buttons[i].addActionListener(this);
        }
        add(buttonPanel, BorderLayout.CENTER);

        //Set up clear button in a JPanel
        JPanel clearPanel = new JPanel();
        clear = new JButton("Clear");
        clear.addActionListener(this);
        clearPanel.add(clear);
        add(clearPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //7 clicked
        if(e.getSource() == buttons[0]){
            display.append("7");
        }
        //8 clicked
        if(e.getSource() == buttons[1]){
            display.append("8");
        }
        //9 clicked
        if(e.getSource() == buttons[2]){
            display.append("9");
        }
        //4 clicked
        if(e.getSource() == buttons[4]){
            display.append("4");
        }
        //5 clicked
        if(e.getSource() == buttons[5]){
            display.append("5");
        }
        //6 clicked
        if(e.getSource() == buttons[6]){
            display.append("6");
        }
        //1 clicked
        if(e.getSource() == buttons[8]){
            display.append("1");
        }
        //2 clicked
        if(e.getSource() == buttons[9]){
            display.append("2");
        }
        //3 clicked
        if(e.getSource() == buttons[10]){
            display.append("3");
        }
        //0 clicked
        if(e.getSource() == buttons[12]){
            display.append("0");
        }
        //decimal clicked
        if(e.getSource() == buttons[13]){
            display.append(".");
        }

        //Divide Operator Clicked
        if(e.getSource() == buttons[3]){
            if(num1 == -1000) {
                num1 = Double.parseDouble(display.getText());
                operator = "/";
            }
            else{
                num2 = Double.parseDouble(display.getText());
                num1 = calculate(operator, num1, num2);
                display.setText(Double.toString(num1));
            }
            display.setText("");
        }

        //Multiply Operator Clicked
        if(e.getSource() == buttons[7]){
            if(num1 == -1000) {
                num1 = Double.parseDouble(display.getText());
                operator = "*";
            }
            else{
                num2 = Double.parseDouble(display.getText());
                num1 = calculate(operator, num1, num2);
                display.setText(Double.toString(num1));
            }
            display.setText("");
        }

        //Subtract Operator Clicked
        if(e.getSource() == buttons[11]){
            if(num1 == -1000) {
                num1 = Double.parseDouble(display.getText());
                operator = "-";
            }
            else{
                num2 = Double.parseDouble(display.getText());
                num1 = calculate(operator, num1, num2);
                display.setText(Double.toString(num1));
            }
            display.setText("");
        }

        //Addition Operator Clicked
        if(e.getSource() == buttons[15]){
            if(num1 == -1000) {
                num1 = Double.parseDouble(display.getText());
                operator = "+";
            }
            else{
                num2 = Double.parseDouble(display.getText());
                num1 = calculate(operator, num1, num2);
                display.setText(Double.toString(num1));
            }
            display.setText("");
        }

        //Equals Clicked
        if(e.getSource() == buttons[14]){
            num2 = Double.parseDouble(display.getText());
            num1 = calculate(operator, num1, num2);
            display.setText(Double.toString(num1));
            num1 = -1000;
            num2 = 0;
        }

        //Clear Clicked
        if(e.getSource() == clear){
            display.setText("");
            num1 = -1000;
            num2 = 0;
        }

    }

    //This method takes in the values stored in the operator, num1, and num2 variables and
    //uses them to perform and return the value for the desired calculation.
    private double calculate(String operator, double num1, double num2){
        double result = 0;
        if(operator == "/"){
            result = num1/num2;
        }
        if(operator == "*"){
            result = num1*num2;
        }
        if(operator == "+"){
            result = num1+num2;
        }
        if(operator == "-"){
            result = num1-num2;
        }
        return result;
    }

    //Main method creates an instance of Calculator
    public static void main(String[] args){
        Calculator x = new Calculator();
    }
}
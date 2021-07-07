import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Create KiloConverter class that convert kilometers into miles

public class KiloConverter extends JFrame {

    private JPanel panel1;
    private JPanel panel2;
    private JLabel instructLabel;
    private JLabel unitsLabel;
    private JTextField inputTextField;
    private JTextField outputTextField;
    private JButton convertButton;
    private JButton exitButton;


    // Create constructor of the kilometer converter window

    public KiloConverter() {

        // Set the window title
        super("Kilometer Converter");

        // Set the border layout to default
        setLayout(new BorderLayout());
        // Set the flow layout to default
        setLayout(new FlowLayout());
        // Set the width (550) and height (200) of window
        setSize(550, 200);
        // Set the windows to close when the close button is pressed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Call the createPanel1 method
        createPanel1();
        // Add the panel to the frame
        add(panel1);

        // Call the createPanel2 method
        createPanel2();
        // Add the panel to the frame
        add(panel2);

        // Make the window visible to the user
        setVisible(true);
    }


    // Create method to allow the user to input kilometer value

    private void createPanel1() {

        // Create a new label, prompting the user to input kilometer value
        instructLabel = new JLabel("Enter a distance in kilometers");

        // Create a new text field, measured at 10 characters long
        inputTextField = new JTextField(10);
        // Create a new action listener, allows program to start calculation
        inputTextField.addActionListener(new ConvertHandler());

        // Create a new button, allows user to start calculation
        convertButton = new JButton("Calculate");
        // Create a new action listener, allows program to start calculation
        convertButton.addActionListener(new ConvertHandler());


        // Create a new panel, using the panel1 reference
        panel1 = new JPanel();

        // Add label, text field, and button to panel1
        panel1.add(instructLabel);
        panel1.add(inputTextField);
        panel1.add(convertButton);
    }


    // Create method to get the mile value and exit program

    private void createPanel2() {

        // Create a new label, showing user the unit after calculation
        unitsLabel = new JLabel("Miles");

        // Create a new text field, measured at 20 characters long
        outputTextField = new JTextField(20);
        // Set attributes to the text field, making it uneditable and gray
        outputTextField.setBackground(Color.LIGHT_GRAY);
        outputTextField.setEditable(false);

        // Create a new button, allows user to start exit program
        exitButton = new JButton("Exit");
        // Create a new action listener, allows program to exit the program
        exitButton.addActionListener(new ExitHandler());


        // Create a new panel, using the panel2 reference
        panel2 = new JPanel();

        // Add text field, label, and button to panel2
        panel2.add(outputTextField);
        panel2.add(unitsLabel);
        panel2.add(exitButton);
    }


    // Create class to handle conversion from kilo to miles

    private class ConvertHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Create values for the user input...
            String input;
            // ... and the end result
            String miles;

            // Place user input from text field into input variable
            input = inputTextField.getText();

            // Converting the input string to double
            // Convert from kilo to miles (mi = .6214 * km)
            // Convert double to string again
            miles = String.valueOf(Double.parseDouble(input) * 0.6214);

            // Set the output text field to the result
            outputTextField.setText(miles);
        }
    }


    // Create class to end the program

    private class ExitHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Exits with status code 0
            System.exit(0);
        }
    }



}

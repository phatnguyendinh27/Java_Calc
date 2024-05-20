import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;

public class Calculator implements ActionListener {
    JFrame frame; // Main frame
    TextFieldPanel textPanel; // Text panel
    ButtonPanel panel; // Button panel
    JPanel masterPanel; // Master panel

    // Variables to store the numbers and the result
    BigDecimal num1 = BigDecimal.ZERO, num2 = BigDecimal.ZERO, result = BigDecimal.ZERO;

    // Variable to store the operator
    char operator;

    // Constructor
    Calculator() {

        // Create the frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 520);

        // Create the text panel and the button panel
        textPanel = new TextFieldPanel();
        ButtonPanel buttonPanel = new ButtonPanel(this);

        // Create the master panel
        masterPanel = new JPanel();
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));
        masterPanel.add(textPanel.getPanel());
        masterPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        masterPanel.add(buttonPanel.getPanel());
        masterPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add the master panel to the frame
        frame.add(masterPanel);
        frame.setVisible(true);
    }

    // Main method
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }

    // Action listener
    public void actionPerformed(ActionEvent e) {

        // Get the command from the button
        String command = e.getActionCommand();

        // Get the text field
        JTextField textField = textPanel.getTextField();
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.charAt(0) == '.') {
            textField.setText(textField.getText() + command);
        } else if (command.charAt(0) == 'C') { // Clear the text field
            textField.setText("");
        } else if (command.charAt(0) == '=') { // Calculate the result
            num2 = new BigDecimal(textField.getText());
            switch (operator) {
                case '+':
                    result = num1.add(num2);
                    break;
                case '-':
                    result = num1.subtract(num2);
                    break;
                case '*':
                    result = num1.multiply(num2);
                    break;
                case '/':
                    result = num1.divide(num2, 2, BigDecimal.ROUND_HALF_UP);
                    break;
            }

            // Check if the result is an integer
            if (result.stripTrailingZeros().scale() <= 0) {
                // If it is, convert it to an integer before displaying
                textField.setText(String.valueOf(result.intValue()));
            } else {
                // If it's not, display it as a decimal number
                textField.setText(String.valueOf(result));
            }
            num1 = result;

        } else if (command.equals("(-)")) { // Change the sign of the number
            double current = Double.parseDouble(textField.getText());
            current *= -1;
            textField.setText(String.valueOf(current));
        } else if (command.equals("DEL")) { // Delete the last character
            String current = textField.getText();
            textField.setText(current.substring(0, current.length() - 1));
        } else {
            if (!textField.getText().equals("")) { // If the text field is not empty
                num1 = new BigDecimal(textField.getText());
                operator = command.charAt(0);
                textField.setText("");
            }
        }
    }
}
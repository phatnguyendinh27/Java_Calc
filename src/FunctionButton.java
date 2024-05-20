import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Create a NumberButton class
public class FunctionButton {
    JButton button; // Create a JButton object

    // Create a constructor that accepts a String and an ActionListener
    FunctionButton(String text, ActionListener actionListener) {

        // Create a new JButton object with the text
        button = new JButton(text);
        button.addActionListener(actionListener);
        button.setFont(new Font("Arial", Font.BOLD, 30));
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.setFocusable(false);

        // Set the background color of the button based on the text
        if (text.equals("CLR")) {
            button.setBackground(Color.RED);
        } else if (text.equals("DEL")) {
            button.setBackground(Color.YELLOW);
        } else if (text.equals("(-)")) {
            button.setBackground(Color.GRAY);
        } else if (text.equals("=")) {
            button.setBackground(Color.GREEN);
        } else if (text.equals(".")) {
            button.setBackground(Color.MAGENTA);
        } else {
            button.setBackground(Color.CYAN);
        }
    }

    // Create a method to return the JButton object
    public JButton getButton() {
        return button;
    }
}

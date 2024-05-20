import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Create a NumberButton class
public class NumberButton {

    // Create a JButton object
    JButton button;

    // Constructor
    NumberButton(int number, ActionListener actionListener) {
        button = new JButton(String.valueOf(number));
        button.addActionListener(actionListener);
        button.setFont(new Font("Arial", Font.BOLD, 30));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.setFocusable(false);
    }

    // Getter method
    public JButton getButton() {
        return button;
    }
}

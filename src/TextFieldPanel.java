import javax.swing.*;
import java.awt.*;

// This class is used to create a panel with a text field
public class TextFieldPanel {
    // Panel that contains the text field
    private JPanel textPanel;
    private JTextField textField;

    // Constructor
    TextFieldPanel() {
        // Create a text field
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 25));
        textField.setEditable(false);

        // Create a panel with a border layout
        textPanel = new JPanel(new BorderLayout());
        // Add the text field to the panel
        textPanel.add(textField, BorderLayout.CENTER);
    }

    // Get the panel
    public JPanel getPanel() {
        return textPanel;
    }

    // Get the text field
    public JTextField getTextField() {
        return textField;
    }
}

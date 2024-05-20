import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// This class is responsible for creating the buttons and adding them to the panel
public class ButtonPanel {

    // JPanel is a container that can store multiple components
    JPanel panel;

    // NumberButton and FunctionButton are custom classes that extend JButton
    NumberButton[] numberButtons = new NumberButton[10]; // Array of NumberButtons
    FunctionButton[] functionButtons = new FunctionButton[9]; // Array of FunctionButtons
    FunctionButton decButton, eqlButton, delButton, clrButton, negButton; // Individual FunctionButtons
    FunctionButton divButton, mulButton, subButton, addButton; // Individual FunctionButtons

    // Constructor that initializes the panel and buttons
    ButtonPanel(ActionListener actionListener) {
        // Create a new panel and set its layout to GridLayout
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        // Initialize numberButtons
        for(int i = 0; i < 10; i++) {
            numberButtons[i] = new NumberButton(i, actionListener);
            panel.add(numberButtons[i].getButton());
        }

        // Initialize functionButtons
        decButton = new FunctionButton(".", actionListener);
        eqlButton = new FunctionButton("=", actionListener);
        delButton = new FunctionButton("DEL", actionListener);
        clrButton = new FunctionButton("CLR", actionListener);
        negButton = new FunctionButton("(-)", actionListener);

        addButton = new FunctionButton("+", actionListener);
        subButton = new FunctionButton("-", actionListener);
        mulButton = new FunctionButton("*", actionListener);
        divButton = new FunctionButton("/", actionListener);

        // Add the buttons to the panel
        panel.add(numberButtons[1].getButton());
        panel.add(numberButtons[2].getButton());
        panel.add(numberButtons[3].getButton());
        panel.add(addButton.getButton());

        panel.add(numberButtons[4].getButton());
        panel.add(numberButtons[5].getButton());
        panel.add(numberButtons[6].getButton());
        panel.add(subButton.getButton());

        panel.add(numberButtons[7].getButton());
        panel.add(numberButtons[8].getButton());
        panel.add(numberButtons[9].getButton());
        panel.add(mulButton.getButton());

        panel.add(negButton.getButton());
        panel.add(numberButtons[0].getButton());
        panel.add(decButton.getButton());
        panel.add(divButton.getButton());

        panel.add(delButton.getButton());
        panel.add(clrButton.getButton());
        panel.add(eqlButton.getButton());
    }

    // Getter method to return the panel
    public JPanel getPanel() {
        return panel;
    }
}

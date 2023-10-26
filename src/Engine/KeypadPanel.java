package Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeypadPanel extends JPanel {
    // Define your keypad components, such as buttons and text fields
    private JButton[] numberButtons;
    private JTextField inputField;
    private JButton closeButton;

    public KeypadPanel() {
        // Set the layout manager for the panel
        setLayout(new GridLayout(4, 3));

        // Create and configure number buttons
        numberButtons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            numberButtons[i] = new JButton(Integer.toString(i + 1));
            numberButtons[i].addActionListener(new NumberButtonListener());
            add(numberButtons[i]);
        }

        // Create and configure the text field
        inputField = new JTextField(10);
        add(inputField);

        // Create and configure the "Close" button
        closeButton = new JButton("Close");
        closeButton.addActionListener(new CloseButtonListener());
        add(closeButton);
    }

    // Implement an ActionListener for the number buttons
    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();
            // Update the input field with the button's value
            inputField.setText(inputField.getText() + buttonText);
        }
    }

    // Implement an ActionListener for the "Close" button
    private class CloseButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Close the keypad panel
            // You can handle the close action here
        }
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class tic_tac_toe implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton[] buttons = new JButton[9];
    private boolean xTurn = true;
    private Random random = new Random();

    public tic_tac_toe() {
        frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setResizable(false);

        // Panel setup
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 5, 5)); // Add spacing between buttons
        panel.setBackground(new Color(50, 50, 50)); // Dark background
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Buttons setup
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40)); // Bold and larger font
            buttons[i].setFocusPainted(false); // Remove focus outline
            buttons[i].setBackground(new Color(200, 200, 200)); // Light gray background
            buttons[i].setForeground(Color.BLACK); // Text color
            buttons[i].addActionListener(this);
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Black border
            panel.add(buttons[i]);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (xTurn) {
            button.setText("X");
            button.setEnabled(false);
            xTurn = false;
            checkForWinner();
        }
        if (!xTurn) {
            computerMove();
        }
    }

    public void checkForWinner() {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (!buttons[i].getText().equals("") &&
                    buttons[i].getText().equals(buttons[i + 1].getText()) &&
                    buttons[i].getText().equals(buttons[i + 2].getText())) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!");
                resetGame();
                return;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (!buttons[i].getText().equals("") &&
                    buttons[i].getText().equals(buttons[i + 3].getText()) &&
                    buttons[i].getText().equals(buttons[i + 6].getText())) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!");
                resetGame();
                return;
            }
        }

        // Check diagonals
        if (!buttons[0].getText().equals("") &&
                buttons[0].getText().equals(buttons[4].getText()) &&
                buttons[0].getText().equals(buttons[8].getText())) {
            JOptionPane.showMessageDialog(frame, buttons[0].getText() + " wins!");
            resetGame();
            return;
        }
        if (!buttons[2].getText().equals("") &&
                buttons[2].getText().equals(buttons[4].getText()) &&
                buttons[2].getText().equals(buttons[6].getText())) {
            JOptionPane.showMessageDialog(frame, buttons[2].getText() + " wins!");
            resetGame();
            return;
        }

        // Check for tie
        boolean tie = true;
        for (JButton button : buttons) {
            if (button.isEnabled()) {
                tie = false;
                break;
            }
        }
        if (tie) {
            JOptionPane.showMessageDialog(frame, "It's a tie!");
            resetGame();
        }
    }

    public void computerMove() {
        int move = random.nextInt(9);
        while (!buttons[move].isEnabled()) {
            move = random.nextInt(9); // Find a random available spot
        }
        buttons[move].setText("O");
        buttons[move].setEnabled(false);
        xTurn = true;
        checkForWinner();
    }

    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        xTurn = true;
    }

    public static void main(String[] args) {
        new tic_tac_toe();
    }
}
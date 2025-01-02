# Tic-Tac-Toe Game

A simple GUI-based Tic-Tac-Toe game built using Java Swing. This game supports two players taking turns to play on a 3x3 grid.

## Features

- **Two-Player Mode**: Alternates turns between Player X and Player O.
- **Winning Detection**: Automatically detects when a player wins or if the game ends in a tie.
- **Graphical Interface**: User-friendly interface with large, clickable buttons.
- **Reset Functionality**: Automatically resets the game board after a win or tie.

## Requirements

- Java Development Kit (JDK) 8 or higher
- Any IDE that supports Java or a terminal to compile and run the program

## How to Play

1. Run the program. A 3x3 grid will appear in a new window.
2. Player X always goes first.
3. Click on an empty square to place your marker (X or O).
4. The game automatically alternates turns between Player X and Player O.
5. The game detects a winner or a tie and displays a message.
6. The board resets automatically after each game.

## How to Run

### Using an IDE:

1. Clone or download the repository.
2. Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans).
3. Compile and run the `TicTacToe` class.

### Using the Terminal:

1. Save the code in a file named `TicTacToe.java`.
2. Open a terminal and navigate to the directory containing `TicTacToe.java`.
3. Compile the program:
   ```bash
   javac TicTacToe.java
   ```
4. Run the program:
   ```bash
   java TicTacToe
   ```

## Code Structure

- **Frame**: The main window that hosts the game.
- **Panel**: A grid layout to organize the 3x3 game buttons.
- **Buttons**: Each button represents a cell in the game grid.

### Key Classes/Methods:

- `TicTacToe`: Main class containing the game logic and GUI.
- `actionPerformed(ActionEvent e)`: Handles button clicks and alternates turns.
- `checkForWinner()`: Checks if a player has won or if the game is tied.
- `resetGame()`: Resets the board for a new game.

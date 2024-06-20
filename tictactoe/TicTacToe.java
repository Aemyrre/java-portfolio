import java.util.Scanner;

public class TicTacToe {

  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("\nLet's play tic tac toe");
    char[][] board = {
        { '_', '_', '_' },
        { '_', '_', '_' },
        { '_', '_', '_' }
    };
    printBoard(board);

    int count = 0;
    for (int i = 0; i < 9; i++) {
      if (i % 2 == 0) {
        System.out.print("Turn: X\n");
        int[] spot = askUser(board);
        board[spot[0]][spot[1]] = 'X';
      } else {
        System.out.print("Turn: O\n");
        int[] spot = askUser(board);
        board[spot[0]][spot[1]] = 'O';
      }
      count = checkWin(board);
      printBoard(board);
      if (count == 3) {
        System.out.println("X wins");
        break;
      } else if (count == -3) {
        System.out.println("O wins!");
        break;
      }
    }
    if (count != -3 && count != 3) {
      System.out.println("It's a tie!");
    }

    scan.close();
  }

  /**
   * Function name - printBoard()
   * 
   * @param board (char[][])
   * 
   *              Inside the function:
   *              1. print a new line.
   *              2. print the board.
   *              • separate each row by two lines.
   *              • each row precedes a tab of space
   *              • each character in the grid has one space from the other
   *              character
   */
  public static void printBoard(char[][] board) {
    System.out.println();
    for (int i = 0; i < board.length; i++) {
      System.out.print("\t");
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  /**
   * Function name – askUser
   * 
   * @param board (char[][] board)
   * @return spot (int[])
   * 
   *         Inside the function
   *         1. Asks the user: - pick a row and column number:
   *         2. Check if the spot is taken. If so, let the user choose again.
   *         3. Return the row and column in an int[] array.
   * 
   */
  public static int[] askUser(char[][] board) {
    System.out.print(" Pick a row and column number: ");
    while (true) {
      int row = scan.nextInt();
      int element = scan.nextInt();
      if (row < board.length && element < board.length) {
        if (board[row][element] == '_') {
          return new int[] { row, element };
        } else {
          System.out.print(" Spot taken, try again: ");
        }
      } else {
        System.out.print(" Invalid selecation, try again: ");
      }
    }
  }

  /**
   * Function name - checkWin
   * 
   * @param board (char[][])
   * @return count (int)
   * 
   *         Inside the function:
   *         1. Make a count variable that starts at 0.
   *         2. Check every row for a straight X or straight O (Task 7).
   *         3. Check every column for a straight X or straight O (Task 8).
   *         4. Check the left diagonal for a straight X or straight O (Task 9).
   *         5. Check the right diagonal for a straight X or straight O (Task 10).
   */
  public static int checkWin(char[][] board) {
    int rows = checkRows(board);
    if (Math.abs(rows) == 3)
      return rows;

    int columns = checkColumns(board);
    if (Math.abs(columns) == 3)
      return columns;

    int leftDiagonal = checkLeft(board);
    if (Math.abs(leftDiagonal) == 3)
      return leftDiagonal;

    int rightDiagonal = checkRight(board);
    if (Math.abs(rightDiagonal) == 3)
      return rightDiagonal;

    return 0;
  }

  public static int checkRows(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'X') {
          count++;
        } else if (board[i][j] == 'O') {
          count--;
        }
      }
      if (count == 3 || count == -3) {
        return count;
      }
    }
    return count;
  }

  public static int checkColumns(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[j][i] == 'X') {
          count++;
        } else if (board[j][i] == 'O') {
          count--;
        }
      }
      if (count == 3 || count == -3) {
        return count;
      }
    }
    return count;
  }

  public static int checkLeft(char[][] board) {

    int count = 0;
    for (int i = 0; i < board.length; i++) {
      if (board[i][i] == 'X') {
        count++;
      } else if (board[i][i] == 'O') {
        count--;
      }
    }
    if (count == 3 || count == -3) {
      return count;
    }
    return count;
  }

  public static int checkRight(char[][] board) {
    int count = 0;
    for (int i = board.length - 1; i >= 0; i--) {
      if (board[2 - i][i] == 'X') {
        count++;
      } else if (board[2 - i][i] == 'O') {
        count--;
      }
    }
    if (count == 3 || count == -3) {
      return count;
    }
    return count;
  }
}

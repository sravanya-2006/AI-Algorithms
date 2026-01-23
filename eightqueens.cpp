#include <iostream>
using namespace std;

int board[8][8];

// Print the chess board
void printBoard()
{
    cout << "\nChess Board:\n";
    for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j < 8; j++)
        {
            if (board[i][j] == 1)
                cout << "Q ";
            else
                cout << ". ";
        }
        cout << endl;
    }
    cout << endl;
}

// Check if queen can be placed safely
bool isSafe(int row, int col)
{
    int i, j;

    // Check column
    for (i = 0; i < row; i++)
        if (board[i][col] == 1)
            return false;

    // Check left diagonal
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
        if (board[i][j] == 1)
            return false;

    // Check right diagonal
    for (i = row, j = col; i >= 0 && j < 8; i--, j++)
        if (board[i][j] == 1)
            return false;

    return true;
}

// Backtracking function
bool solveQueen(int row)
{
    if (row == 8)   // All queens placed
    {
        cout << "Final Solution Found:\n";
        printBoard();
        return true;
    }

    for (int col = 0; col < 8; col++)
    {
        cout << "Trying Queen at Row " << row << ", Column " << col << endl;

        if (isSafe(row, col))
        {
            board[row][col] = 1;   // Place queen
            printBoard();

            if (solveQueen(row + 1))
                return true;

            // Backtrack
            cout << "Backtracking from Row " << row << ", Column " << col << endl;
            board[row][col] = 0;
            printBoard();
        }
    }

    return false;
}

int main()
{
    // Initialize board with 0
    for (int i = 0; i < 8; i++)
        for (int j = 0; j < 8; j++)
            board[i][j] = 0;

    cout << "Solving 8-Queens Problem using Backtracking...\n";

    if (!solveQueen(0))
        cout << "No solution exists.\n";

    return 0;
}

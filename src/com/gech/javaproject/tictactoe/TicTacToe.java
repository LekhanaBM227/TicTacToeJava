package com.gech.javaproject.tictactoe;

import java.util.Scanner;

public class TicTacToe {
	public char[][] board;
	public TicTacToe()
	{
		board =new char[3][3];
		initializeBoard();
		displayBoard();
		//		makemove('X');
		//		displayBoard();
	}
	public void initializeBoard()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				board[i][j]='-';
			}
		}
	}

	public void displayBoard()
	{
		System.out.println("Current board");
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j]=='-')
				{
					System.out.print(" " + ((i * 3 + j) + 1));
				}
				else
				{
					System.out.print(" "+board[i][j]);
				}
				if(j<2)
				{
					System.out.print(" |");
				}
			}
			System.out.println();
			if(i<2)
			{
				System.out.println("----------");
			}
		}
		System.out.println();
	}

	public void makemove(char Player)
	{
		Scanner sc = new Scanner(System.in);
		int pos;

		while(true)
		{
			System.out.println("Player " + Player + ", enter your move (1-9): ");

			// Check if input is integer
			if (!sc.hasNextInt()) {
				System.out.println("Invalid input. Please enter numbers only.");
				sc.nextLine(); // clear the invalid input
				continue;
			}

			pos = sc.nextInt();

			if (pos < 1 || pos > 9) {
				System.out.println("Position out of range. Please choose a number from 1 to 9.");
				continue;
			}
			int row = (pos - 1) / 3;
			int col = (pos - 1) % 3;


			if(board[row][col]=='-') 
			{
				board[row][col]=Player;
				break;
			}
			else
			{
				System.out.println("This is already taken, Try again.");
			}

		}

	}

	public boolean checkWin(char Player)
	{
		//check for row
		for(int i=0;i<3;i++)
		{
			if(board[i][0]==Player && board[i][1]==Player && board[i][2]==Player)
			{
				return true;
			}
		}

		//check for column
		for(int j=0;j<3;j++)
		{
			if(board[0][j]==Player && board[1][j]==Player && board[2][j]==Player)
			{
				return true;
			}
		}

		if(board[0][0]==Player && board[1][1]==Player && board[2][2]==Player)
		{
			return true;
		}

		if(board[0][2]==Player && board[1][1]==Player && board[2][0]==Player)
		{
			return true;
		}

		return false;
	}

	// if the board is full
	public boolean isBoardFull()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j]=='-') 
				{
					return false;
				}
			}
		}
		return true;	
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		TicTacToe t = new TicTacToe();
		
		char player1Symbol;
	    char player2Symbol;

	    // Ask Player 1 to choose X or O
	    while (true) {
	        System.out.print("Player 1, choose your symbol (X/O): ");
	        String input = sc.nextLine().trim().toUpperCase();
	        if (input.equals("X") || input.equals("O")) {
	            player1Symbol = input.charAt(0);
	            player2Symbol = (player1Symbol == 'X') ? 'O' : 'X';
	            break;
	        } else {
	            System.out.println("❌ Invalid choice. Please enter 'X' or 'O'.");
	        }
	    }

	    System.out.println("✅ Player 1 is '" + player1Symbol + "', Player 2 is '" + player2Symbol + "'\n");

	    char currentPlayer = player1Symbol;


		while(true)
		{
			t.makemove(currentPlayer);
			t.displayBoard();

			//check winning
			if(t.checkWin(currentPlayer))
			{
				System.out.println("Player "+currentPlayer+" Won the game!");
				break;
			}

			//check board full
			if(t.isBoardFull())
			{
				System.out.println("It's a draw!, The board is full.");
				break;
			}

			//switch players
			if(currentPlayer=='X')
			{
				currentPlayer='O';// or currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
			}
			else
			{
				currentPlayer='X';
			}
		}

		
		System.out.println("Do you want to play again? (yes/no): ");
		String answer = sc.nextLine().toLowerCase();
		if (answer.equals("yes")) {
			main(null); // restart game
		}




	}


}

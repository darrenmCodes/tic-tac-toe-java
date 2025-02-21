public class GameMethods 
{
    public static char[][] drawBoard()
    {
        final int COLSIZE = 3;
        final int ROWSIZE = 3;
        int i;
        int j;
        char[][] board;

        board = new char[COLSIZE][ROWSIZE];

        for(i = 0; i < COLSIZE; i++)
            {
                for(j = 0; j < ROWSIZE; j++)
                    {
                        board[i][j] = '*';
                    }
            }
        return board;
    }


    public static void printBoard(char[][] theBoard)
    {
        int i;
        int j;

        System.out.println();

        for(i = 0; i < theBoard.length; i++)
            {
                for(j = 0; j < theBoard[i].length; j++)
                    {
                        System.out.print(theBoard[i][j] + " ");
                    }
                System.out.println();
            }
    }


    public static void takeTurn(int theTurnCounter, char[][] theBoard)
    {
        int row;
        int column;
        char symbol;

        if((theTurnCounter % 2) == 0)
            {
                symbol = 'X';
            }
        
            else
            {
                symbol = 'O';
            }

                while(true)
                {
                    System.out.println("\nEnter row and column you would like to play (0-2): ");
                    System.out.print("Row: ");
                    row = EasyIn.getInt();
                    System.out.print("Column: ");
                    column = EasyIn.getInt();

                    if(row >= 0 && row <= 2 && column >= 0 && column <= 2 && theBoard[row][column] == '*')
                            {
                                theBoard[row][column] = symbol;
                                break;
                            }

                        else
                            {
                                System.out.println("Invalid move! Try again!");
                            }
                }
    }

    public static void clearConsole()
        {
            int i;

            for(i = 0; i < 50; i++)
                {
                    System.out.println();
                }
        }


    public static boolean checkWin(char[][] theBoard, int theTurnCounter)
    {
        int i;
        int j;
        boolean emptySpaceFound;

        emptySpaceFound = false;

        for(i = 0; i < theBoard.length; i++)
            {
                if(theBoard[i][0] == theBoard[i][1] && theBoard[i][1] == theBoard[i][2] && theBoard[i][1] != '*')
                    {
                        printWinner(theTurnCounter);
                        return true;
                    }

                else if(theBoard[0][i] == theBoard[1][i] && theBoard[1][i] == theBoard[2][i] && theBoard[1][i] != '*')
                    {
                        printWinner(theTurnCounter);
                        return true;
                    } 
            }
            
        if(theBoard[0][0] == theBoard[1][1] && theBoard[1][1] == theBoard[2][2] && theBoard[1][1] != '*')
            {
                printWinner(theTurnCounter);
                return true;
            }

        else if(theBoard[0][2] == theBoard[1][1] && theBoard[1][1] == theBoard[2][0] && theBoard[1][1] != '*')
            {
                printWinner(theTurnCounter);
                return true;
            }


        for(i = 0; i < theBoard.length; i++)
            {
                for(j = 0; j < theBoard[i].length; j++)
                    {
                        if(theBoard[i][j] == '*')
                            {
                                emptySpaceFound = true;
                                break;
                            }

                        
                    }
                
                if(emptySpaceFound) break;
            }

        if(!emptySpaceFound)
            {
                System.out.println("\nIt's a draw!");
                return true;
            }

        return false;
    }

    private static void printWinner(int theTurnCounter)
        {
            if((theTurnCounter % 2) == 0)
                {
                    System.out.println("\nPlayer 1 Wins!");
                }

            else
                {
                    System.out.println("\nPlayer 2 Wins!");
                }
        }
}

    

public class Jlab84 
{
    public static void main(String[] args) 
    {
        boolean winner;
        int turnCounter;
        char[][] currentGame;
        currentGame = GameMethods.drawBoard();

        winner = false;
        turnCounter = 0;

        System.out.println("Game On!\n");

        do
            {
                GameMethods.clearConsole();
                System.out.println("Next turn!");
                GameMethods.printBoard(currentGame);
                GameMethods.takeTurn(turnCounter, currentGame);
                winner = GameMethods.checkWin(currentGame, turnCounter);
                turnCounter++;
            }
        while(winner == false);
    }       
}

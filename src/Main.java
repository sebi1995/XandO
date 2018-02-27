import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final String BOLD_RED = "\033[1;31m";
    private static final String BOLD_BLUE = "\033[1;34m";
    private static final String BOLD_GREEN = "\033[1;32m";
    private static final String RESET = "\033[0m";

    public static void main(String[] args) {

        boolean mark;
        Table table;
        Player player1, player2;
        Scanner scanner;

        do {
            scanner = new Scanner(System.in);
            mark = new Random().nextBoolean();
            table = new Table(new Random().nextBoolean());
            player1 = new Player(table, getName(scanner), mark);
            player2 = new Player(table, getName(scanner), !mark);

            System.out.println("\nThis is the table:");

            table.printsTable();

            do {
                System.out.println();

                if (table.getTurn()) {
                    playerTurn(player1, scanner);
                } else playerTurn(player2, scanner);

                System.out.println();

                table.printsTable();

            }
            while (table.checksBoardIfGameOver(player1.getMark()) == 0 &&
                    table.checksBoardIfGameOver(player2.getMark()) == 0 &&
                    table.checksBoardIfDraw());

            Player winningPlayer = player1.checksIfWon() ? player1 : player2;
            String winningMark = winningPlayer.getMark().toString().substring(1, 2);
            String winningColour = winningMark.equals("X") ? BOLD_BLUE : BOLD_RED;

            if (table.checksBoardIfDraw()) {
                if (table.checksBoardIfGameOver(winningPlayer.getMark()) != 3) {
                    System.out.println(BOLD_GREEN + "\nCongratulations " +
                            winningColour + winningPlayer.getName() + RESET + BOLD_GREEN +
                            " you have won playing: " + winningColour +  winningMark + RESET + "!\n" + RESET);
                }
            } else {
                System.out.println("It's a draw :(\n");
            }

            System.out.print(winningColour + winningPlayer.getName() + RESET + ", do you wish to play again?\n\n" +
                    "Enter " + BOLD_GREEN + "y/Y" + RESET + " for yes or anything else for no to end the game:");
            String exitOrNot = scanner.next();
            System.out.println();

            if (!exitOrNot.equals("y") && !exitOrNot.equals("Y")) {
                System.out.println("Goodbye!");
                break;
            }
        } while (true);
    }

    private static String getName(Scanner scanner) {
        System.out.print("Player enter your name: ");
        return scanner.next();
    }

    private static void playerTurn(Player player, Scanner scanner) {
        String m = player.getMark().toString().equals("mX") ? "X" : "O";
        String COLOUR = m.equals("X") ? BOLD_BLUE : BOLD_RED;

        System.out.print(COLOUR + m + RESET + ": " + COLOUR + player.getName() + RESET + "'s turn! : ");

        if (!player.playsTurn(scanner.nextInt())) {
            System.out.print(BOLD_RED + "Position is taken, try again!" + RESET);
            playerTurn(player, scanner);
        }
    }
}

//https://github.com/sebi1995/XandO.git



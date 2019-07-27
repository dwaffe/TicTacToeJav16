import java.util.ArrayList;
import java.util.List;

public class TicTacToeController {
    private Board gameState;
    private List<Player> players;
    private Judge judge;

    public TicTacToeController(Player firstPlayer, Player secondPlayer) {
        this.gameState = new Board(3, 3);
        this.gameState.displayBoard();
        this.players = new ArrayList<Player>();
        this.players.add(firstPlayer);
        this.players.add(secondPlayer);
        this.judge = new Judge(this.gameState);
    }

    public void start() {
        Player currentPlayer;
        int moveCounter = 0;
        do {
            currentPlayer = players.get(moveCounter % 2);
            int move = currentPlayer.getMove(gameState);
            if (!MoveValidator.isValid(gameState, move)) {
                System.out.println("Nieprawidłowy ruch");
                continue;
            }
            gameState.putPawn(move, currentPlayer.getPawn());
            gameState.displayBoard();

            judge.setGameState(gameState);
            moveCounter++;
        } while (!judge.isEndGame());

        System.out.println("Koniec gry.");

        if (judge.isWinFor(currentPlayer.getPawn())) {
            System.out.println("Wygrał gracz " + currentPlayer.getPawn().getName());
        } else {
            System.out.println("Remis");
        }

        System.out.println();
    }
}

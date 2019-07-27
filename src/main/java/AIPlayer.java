import java.util.Random;

public class AIPlayer extends Player {
    private Random random = new Random();

    public AIPlayer(Pawn pawn) {
        super(pawn);
    }

    @Override
    public int getMove(Board board) {
        int move;

        do {
            move = random.nextInt(9) + 1;
        } while (!MoveValidator.isValid(board, move));

        return move;
    }
}

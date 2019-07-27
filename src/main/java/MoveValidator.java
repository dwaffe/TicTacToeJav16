public class MoveValidator {
    public static boolean isValid(Board board, int move) {
        try {
            if (board.getPawn(move) != null) {
                return false;
            }
        } catch (InvalidFieldNumberException e) {
            return false;
        }

        return true;
    }
}

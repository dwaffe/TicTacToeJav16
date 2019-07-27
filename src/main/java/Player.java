public abstract class Player {
    private Pawn pawn;

    public Player(Pawn pawn) {
        this.pawn = pawn;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public abstract int getMove(Board board);
}

public class Board {
    private Pawn[][] board;
    private int x;
    private int y;

    public Board(int x, int y) {
        this.x = x;
        this.y = y;
        this.board = new Pawn[x][y];
    }

    public void displayBoard() {
        System.out.println();
        int fieldNumber = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                fieldNumber++;
                System.out.print("[" + getSignOrNumber(i, j, fieldNumber) + "]");
            }
            System.out.println();
        }
    }

    private String getSignOrNumber(int x, int y, int fieldNumber) {
        if (this.board[x][y] == null) {
            return String.valueOf(fieldNumber);
        }

        return this.board[x][y].getSign();
    }

    public void putPawn(int move, Pawn pawn) {
        int fieldNumber = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                fieldNumber++;
                if (fieldNumber == move) {
                    this.board[i][j] = pawn;
                }
            }
        }
    }

    public Pawn getPawn(int move) throws InvalidFieldNumberException {
        Point point = getPointByFieldNumber(move);

        return this.board[point.getX()][point.getY()];
    }

    private Point getPointByFieldNumber(int fieldNumber) throws InvalidFieldNumberException {
        int counter = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                counter++;
                if (counter == fieldNumber) {
                    return new Point(i, j);
                }
            }
        }

        throw new InvalidFieldNumberException();
    }

}

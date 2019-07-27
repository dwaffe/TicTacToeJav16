public class Judge {
    private Board gameState;
    private int[][] winningStates = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9},
            {1, 5, 9},
            {3, 5, 7}
    };

    public Judge(Board gameState) {
        this.gameState = gameState;
    }

    public void setGameState(Board gameState) {
        this.gameState = gameState;
    }

    public boolean isDraw() {
        int i = 1;
        while (true) {
            try {
                if (this.gameState.getPawn(i) == null) {
                    return false;
                }
            } catch (InvalidFieldNumberException e) {
                break;
            }
            i++;
        }

        return true;
    }

    public boolean isWinFor(Pawn pawn) {
        for (int[] winState: winningStates) {
            try {
                if (gameState.getPawn(winState[0]).equals(pawn)
                && gameState.getPawn(winState[1]).equals(pawn)
                && gameState.getPawn(winState[2]).equals(pawn)
                ) {
                    return true;
                }
            } catch (InvalidFieldNumberException e) {
                continue;
            } catch (NullPointerException e) {
                continue;
            }
        }

        return false;
    }

    public boolean isEndGame() {
        return this.isWinFor(new XPawn()) || this.isWinFor(new OPawn()) || this.isDraw();
    }
}

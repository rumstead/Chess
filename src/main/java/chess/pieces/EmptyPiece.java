package chess.pieces;

import chess.board.Box;
import chess.player.Player;

public class EmptyPiece extends Piece {

    private static final Player NO_PLAYER = new Player(Color.NO_COLOR);

    public EmptyPiece() {
        super(NO_PLAYER);
    }

    @Override
    public boolean isValidMove(Box source, Box dest) {
        return true;
    }

    @Override
    public String toString() {
        return "EmptyPiece";
    }
}

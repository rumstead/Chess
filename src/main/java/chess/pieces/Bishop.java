package chess.pieces;

import chess.board.Box;
import chess.player.Player;

public class Bishop extends Piece {
    public Bishop(Player player) {
        super(player);
    }

    @Override
    public boolean isValidMove(Box source, Box dest) {
        return true;
    }

    @Override
    public String toString() {
        return "Bishop";
    }
}

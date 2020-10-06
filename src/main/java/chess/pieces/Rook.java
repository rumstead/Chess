package chess.pieces;

import chess.board.Box;
import chess.player.Player;

public class Rook extends Piece {
    public Rook(Player player) {
        super(player);
    }

    @Override
    public boolean isValidMove(Box source, Box dest) {
        return true;
    }

    @Override
    public String toString() {
        return "Rook";
    }
}

package chess.pieces;

import chess.board.Box;
import chess.player.Player;

public class Knight extends Piece {
    public Knight(Player player) {
        super(player);
    }

    @Override
    public boolean isValidMove(Box source, Box dest) {
        return true;
    }

    @Override
    public String toString() {
        return "Knight";
    }
}

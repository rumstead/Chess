package chess.pieces;

import chess.board.Box;
import chess.player.Player;

import java.util.Objects;

public abstract class Piece {
    private final Player player;

    Piece(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    // TODO: use a strategy here?
    public abstract boolean isValidMove(Box source, Box dest);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return getPlayer().equals(piece.getPlayer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlayer());
    }
}

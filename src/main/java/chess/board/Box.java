package chess.board;

import chess.pieces.EmptyPiece;
import chess.pieces.Piece;

import java.util.Objects;

public class Box {
    public static final EmptyPiece EMPTY_PIECE = new EmptyPiece();

    private Piece piece;
    private final Coordinate coordinate;

    public Box(int row, int col) {
        this.coordinate = new Coordinate(row, col);
        this.piece = EMPTY_PIECE;
    }

    public Box(Piece piece, int row, int col) {
        this.piece = piece;
        this.coordinate = new Coordinate(row, col);
    }

    public Piece setAndRemovePiece(Piece piece) {
        if(piece != null && canMoveToBox(piece)) {
            Piece removedPiece = this.piece;
            this.piece = piece;
            return removedPiece;
        }
        throw new IllegalStateException("Cannot move to this box: " + this);
    }

    public void reset() {
        this.piece = EMPTY_PIECE;
    }

    public Piece getPiece() {
        return piece;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public boolean canMoveToBox(Piece piece) {
        return isEmpty() && !piece.getPlayer().equals(this.piece.getPlayer());
    }

    private boolean isEmpty() {
        return this.piece.equals(EMPTY_PIECE);
    }

    @Override
    public String toString() {
        return "Box{" +
                "piece=" + piece +
                ", coordinate=" + coordinate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return getPiece().equals(box.getPiece()) &&
                getCoordinate().equals(box.getCoordinate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPiece(), getCoordinate());
    }
}

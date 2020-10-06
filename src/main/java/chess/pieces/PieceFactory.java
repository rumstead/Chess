package chess.pieces;

import chess.player.Player;

import java.util.ArrayList;
import java.util.List;

public class PieceFactory {

    public List<List<Piece>> getPiecesForPlayer(Player player) {
        List<List<Piece>> rows = new ArrayList<>();
        List<Piece> firstRow = new ArrayList<>();
        List<Piece> secondRow = new ArrayList<>();
        if(player.getColor().equals(Color.RED)) {
            firstRow.add(new Rook(player));
            firstRow.add(new Knight(player));
            firstRow.add(new Bishop(player));
            firstRow.add(new Queen(player));
            firstRow.add(new King(player));
            firstRow.add(new Bishop(player));
            firstRow.add(new Knight(player));
            firstRow.add(new Rook(player));
            rows.add(firstRow);
            secondRow.add(new Pawn(player));
            secondRow.add(new Pawn(player));
            secondRow.add(new Pawn(player));
            secondRow.add(new Pawn(player));
            secondRow.add(new Pawn(player));
            secondRow.add(new Pawn(player));
            secondRow.add(new Pawn(player));
            secondRow.add(new Pawn(player));
            rows.add(secondRow);
        } else {
            secondRow.add(new Rook(player));
            secondRow.add(new Knight(player));
            secondRow.add(new Bishop(player));
            secondRow.add(new Queen(player));
            secondRow.add(new King(player));
            secondRow.add(new Bishop(player));
            secondRow.add(new Rook(player));
            firstRow.add(new Pawn(player));
            firstRow.add(new Pawn(player));
            firstRow.add(new Pawn(player));
            firstRow.add(new Pawn(player));
            firstRow.add(new Pawn(player));
            firstRow.add(new Pawn(player));
            firstRow.add(new Pawn(player));
            firstRow.add(new Pawn(player));
            rows.add(secondRow);
            rows.add(firstRow);
        }
        return rows;
    }
}

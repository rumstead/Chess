package chess.board;

import chess.pieces.Color;
import chess.pieces.Piece;
import chess.pieces.PieceFactory;
import chess.player.Player;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {
    private final Box[][] boxes;
    private final Map<Player, List<Piece>> takenPieces;

    public Board(int r, int c) {
        boxes = createBoard(r,c);
        takenPieces = new HashMap<>();
    }

    private Box[][] createBoard(int r, int c) {
        Box[][] newBox = new Box[r][c];
        for(int row = 0; row < r; row++) {
            for(int col = 0; col < c; col++) {
                newBox[row][col] = new Box(row, col);
            }
        }
        return newBox;
    }

    public void addPiecesForPlayer(Player player, PieceFactory pieceFactory) {
        List<List<Piece>> pieces = pieceFactory.getPiecesForPlayer(player);
        if(player.getColor().equals(Color.RED)) {
            for(int r = 0; r < pieces.size(); r++) {
                for(int c = 0; c < pieces.get(r).size(); c++) {
                    boxes[r][c].setAndRemovePiece(pieces.get(r).get(c));
                }
            }
        } else {
            for(int r = 0; r < pieces.size(); r++) {
                for(int c = 0; c < pieces.get(r).size(); c++) {
                    int row = boxes.length - r - 1;
                    int col = boxes[0].length - c - 1;
                    boxes[row][col].setAndRemovePiece(pieces.get(r).get(c));
                }
            }
        }
    }

    public void reset() {
        for (Box[] row : boxes) {
            for(Box box : row) {
                box.reset();
            }
        }
    }

    public void movePiece(Piece piece, int rowIndex, int colIndex) {
        try {
            Box source = getBoxForPiece(piece);
            Box dest = boxes[rowIndex][colIndex];
            if(piece.isValidMove(source, dest)) {
                Piece removedPiece = dest.setAndRemovePiece(piece);
                addTakenPiece(removedPiece);
                source.reset();
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {}

        throw new IllegalStateException("Invalid move! Is your piece already there?");
    }

    private void addTakenPiece(Piece removedPiece) {
        if(!removedPiece.equals(Box.EMPTY_PIECE)) {
            if (takenPieces.containsKey(removedPiece.getPlayer())) {
                takenPieces.get(removedPiece.getPlayer()).add(removedPiece);
            } else {
                takenPieces.put(removedPiece.getPlayer(), Stream.of(removedPiece).collect(Collectors.toList()));
            }
        }
    }

    public List<Piece> getValidPiecesForPlayer(Player player) {
        return Arrays.stream(boxes).flatMap(Arrays::stream)
                .filter(box -> box.getPiece().getPlayer().equals(player))
                .map(Box::getPiece)
                .collect(Collectors.toList());
    }

    public Box getBoxForPiece(Piece piece) {
        for(Box[] rows: boxes) {
            for(Box box : rows) {
                if(box.getPiece().equals(piece)) {
                    return box;
                }
            }
        }
        throw new IllegalStateException("This piece has already been removed!");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Box[] rows : boxes) {
            for(Box col : rows) {
                builder.append(col.getPiece());
                builder.append(col.getPiece().getPlayer());
                builder.append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Arrays.equals(boxes, board.boxes) &&
                takenPieces.equals(board.takenPieces);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(takenPieces);
        result = 31 * result + Arrays.hashCode(boxes);
        return result;
    }
}

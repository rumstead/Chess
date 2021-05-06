package chess.game;

import chess.board.Board;
import chess.board.Box;
import chess.pieces.King;
import chess.pieces.Piece;
import chess.pieces.PieceFactory;
import chess.player.Player;

import java.util.*;

public class ChessGame {
    private final Board board;
    private final Set<Player> players;
    private final Map<Player, List<List<Integer>>> moves;

    /**
     * Load a saved chess.game
     * @param board
     * @param players
     * @param moves
     */
    private ChessGame(Board board, Set<Player> players, Map<Player, List<List<Integer>>> moves, PieceFactory pieceFactory) {
        this.board = board;
        this.players = players;
        this.moves = moves;
        for(Player player : players) {
            board.addPiecesForPlayer(player, pieceFactory);
        }
    }

    /**
     * Start a fresh chess.game
     * @param board
     * @param players
     */
    public ChessGame(Board board, Set<Player> players) {
        this(board, players, Collections.emptyMap(), new PieceFactory());
    }

    public ChessGame(Board board, Set<Player> players, Map<Player, List<List<Integer>>> moves) {
        this(board, players, moves, new PieceFactory());
    }

    public static ChessGame loadSavedGame(Board board, Set<Player> players, Map<Player, List<List<Integer>>> moves) {
        return new ChessGame(board, players, moves);
    }

    public static ChessGame createNewGame(Set<Player> players) {
        Board newBoard = new Board(8,8);
        return new ChessGame(newBoard, players);
    }

    public ChessGame rematch() {
        board.reset();
        moves.clear();
        return this;
    }

    public Player getWinner() {
        return null;
    }

    public void start() {
        // do something
        System.out.println("Game started!");
        do {
            System.out.println("Game Playing!");
        } while(!isCheckMate());
        System.out.println("Winner: " + getWinner());
    }

    // Get all the places the king can move, and see if there is a check there
    public boolean isCheckMate() {
        return false;
    }

    // Loop through other players pieces and see if they can move to kings location
    public boolean isCheck(Player player) {
        boolean isCheck;
        final List<Piece> validPiecesForPlayer = board.getValidPiecesForPlayer(player);
        final Box kingBox = board.getBoxForPiece(new King(player));
        for(Piece piece : validPiecesForPlayer) {
            Box sourceBox = board.getBoxForPiece(piece);
            isCheck = piece.isValidMove(sourceBox, kingBox);
            if(isCheck) {
                return true;
            }
        }
        return false;
    }
}
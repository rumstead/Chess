package chess.main;

import chess.game.ChessGame;
import chess.pieces.Color;
import chess.player.Player;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ChessGame game =
                ChessGame.createNewGame(Stream.of(new Player(Color.RED), new Player(Color.WHITE))
                        .collect(Collectors.toSet()));
        System.out.println(game.isCheck(new Player(Color.RED)));
    }
}

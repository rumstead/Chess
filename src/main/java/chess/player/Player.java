package chess.player;

import chess.pieces.Color;

import java.util.Objects;

public class Player {
    private final Color color;
    private int wins;
    private int draws;
    private int loses;

    public Player(Color color) {
        this.color = color;
        this.wins = 0;
        this.draws = 0;
        this.loses = 0;
    }

    public void addWin() {
        wins++;
    }

    public void addDraw() {
        draws++;
    }

    public void addLose() {
        loses++;
    }

    public Color getColor() {
        return color;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLoses() {
        return loses;
    }

    @Override
    public String toString() {
        return "Player{" +
                "color=" + color +
                ", wins=" + wins +
                ", draws=" + draws +
                ", loses=" + loses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return getWins() == player.getWins() &&
                getDraws() == player.getDraws() &&
                getLoses() == player.getLoses() &&
                getColor() == player.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getWins(), getDraws(), getLoses());
    }
}

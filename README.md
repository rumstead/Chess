# Chess
Just a fun project to mess around with design patterns

## TODOs
1. Add a strategy to the pieces, so they can determine how to move

### Board Class
Responsible for holding state of the game. Ie, where the pieces are for each player

### Box
Responsible for a single coordinate on the board. Also, has the logic to determine if a piece can move to its
 coordinate

### Coordinate
An x,y coordinate on the board

### ChessGame
Responsible for interpreting the state of the board to determine check or check mate. It also can set up, reset, and
 create a new game
 
### Pieces
Each piece is responsible for knowing how it can move

### Player
Responsible for keeping player's record and "team"
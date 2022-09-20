import java.util.ArrayList;
import java.util.List;

public class Board{
    private static final char EMPTY_TILE = ' ';
    private static final int FIRST_COLUMN = 0;
    private static final int SECOND_COLUMN = 1;
    private static final int THIRD_COLUMN = 2;
    private static final int NUMBER_OF_COLS = 3;
    private static final int FIRST_ROW = 0;
    private final int NUMBER_OF_ROWS = 3;
    private List<Tile> _plays = new ArrayList<>();

    public Board(){

        for(int row = FIRST_ROW; row < NUMBER_OF_ROWS; row++){
            for(int col = FIRST_COLUMN; col < NUMBER_OF_COLS; col++){
                Tile tile = new Tile();
                tile.position = new Position(row, col);
                tile.Symbol = EMPTY_TILE;
                _plays.add(tile);
            }
        }
    }

    public Tile TileAt(Position position){
        for(Tile tile : _plays){
            if(tile.position.getRow() == position.getRow() && tile.position.getCol() == position.getCol()){
                return tile;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, Position position){
        TileAt(position).Symbol = symbol;
    }

    private boolean rowIsComplete(int row){
        return tileIsNotEmpty(row, FIRST_COLUMN) && tileIsNotEmpty(row, SECOND_COLUMN)
                && tileIsNotEmpty(row, THIRD_COLUMN);
    }

    private boolean tileIsNotEmpty(int row, int col){
        return TileAt(new Position(row, col)).Symbol != EMPTY_TILE;
    }

    private boolean tilesInRowHaveTheSameSymbol(int row){
        return tilesHaveTheSameSymbol(row, FIRST_COLUMN)
                && tilesHaveTheSameSymbol(row, THIRD_COLUMN);
    }

    private boolean tilesHaveTheSameSymbol(int row, int col){
        return TileAt(new Position(row, col)).Symbol == TileAt(new Position(row, SECOND_COLUMN)).Symbol;
    }

    public boolean winnerInRow(int row){
        if(rowIsComplete(row)){
            return tilesInRowHaveTheSameSymbol(row);
        }
        return false;
    }

    public boolean isNotEmptyTile(Position position, Game game){
        return TileAt(position).Symbol != EMPTY_TILE;
    }

    public char winner() {
        for (int row = FIRST_ROW; row < NUMBER_OF_ROWS; row++) {
            if (winnerInRow(row)) {
                return TileAt(new Position(row, FIRST_COLUMN)).Symbol;
            }
        }

        return EMPTY_TILE;
    }
}
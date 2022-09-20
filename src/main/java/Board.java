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

        for(int i = FIRST_ROW; i < NUMBER_OF_ROWS; i++){
            for(int j = FIRST_COLUMN; j < NUMBER_OF_COLS; j++){
                Tile tile = new Tile();
                tile.position = new Position(i, j);
                tile.Symbol = ' ';
                _plays.add(tile);
            }
        }
    }

    public Tile TileAt(Position position){
        for(Tile t : _plays){
            if(t.position.X == position.X && t.position.Y == position.Y){
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, Position position){
        TileAt(position).Symbol = symbol;
    }

    private boolean rowIsComplete(int rowNumber){
        return tileIsNotEmpty(rowNumber, FIRST_COLUMN) && tileIsNotEmpty(rowNumber, SECOND_COLUMN)
                && tileIsNotEmpty(rowNumber, THIRD_COLUMN);
    }

    private boolean tileIsNotEmpty(int rowNumber, int i){
        return TileAt(new Position(rowNumber, i)).Symbol != EMPTY_TILE;
    }

    private boolean tilesInRowHaveTheSameSymbol(int rowNumber){
        return tilesHaveTheSameSymbol(rowNumber, FIRST_COLUMN)
                && tilesHaveTheSameSymbol(rowNumber, THIRD_COLUMN);
    }

    private boolean tilesHaveTheSameSymbol(int rowNumber, int i){
        return TileAt(new Position(rowNumber, i)).Symbol == TileAt(new Position(rowNumber, SECOND_COLUMN)).Symbol;
    }

    public boolean winnerInRow(int rowNumber){
        if(rowIsComplete(rowNumber)){
            return tilesInRowHaveTheSameSymbol(rowNumber);
        }
        return false;
    }

   public boolean isNotEmptyTile(Position position, Game game){
        return TileAt(position).Symbol != EMPTY_TILE;
    }
}
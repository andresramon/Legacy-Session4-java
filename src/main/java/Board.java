import java.util.ArrayList;
import java.util.List;

public class Board{
    private List<Tile> _plays = new ArrayList<>();

    public Board(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
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
        return tileIsNotEmpty(rowNumber, 0) && tileIsNotEmpty(rowNumber, 1)
                && tileIsNotEmpty(rowNumber, 2);
    }

    private boolean tileIsNotEmpty(int rowNumber, int i){
        return TileAt(new Position(rowNumber, i)).Symbol != ' ';
    }

    private boolean tilesInRowHaveTheSameSymbol(int rowNumber){
        return tilesHaveTheSameSymbol(rowNumber, 0)
                && tilesHaveTheSameSymbol(rowNumber, 2);
    }

    private boolean tilesHaveTheSameSymbol(int rowNumber, int i){
        return TileAt(new Position(rowNumber, i)).Symbol == TileAt(new Position(rowNumber, 1)).Symbol;
    }

    public boolean winnerInRow(int rowNumber){
        if(rowIsComplete(rowNumber)){
            return tilesInRowHaveTheSameSymbol(rowNumber);
        }
        return false;
    }

   public boolean isNotEmptyTile(Position position, Game game){
        return TileAt(position).Symbol != ' ';
    }
}
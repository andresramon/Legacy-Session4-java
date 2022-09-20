import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<Tile> _plays = new ArrayList<>();

    public Board()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                Tile tile = new Tile();
                tile.position = new Position();
                tile.position.X = i;
                tile.position.Y = j;
                tile.Symbol = ' ';
                _plays.add(tile);
            }
        }
    }

    public Tile TileAt(Position position)
    {
        for (Tile t : _plays) {
            if (t.position.X == position.X && t.position.Y == position.Y){
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, Position position)
    {
        Tile newTile = new Tile();
        newTile.position = position;
        newTile.Symbol = symbol;

        TileAt(position).Symbol = symbol;
    }

    private boolean rowIsComplete(int rowNumber) {
        Position positionZeroTile = new Position();
        positionZeroTile.X = rowNumber;
        positionZeroTile.Y = 0;

        Position positionFirstTile = new Position();
        positionFirstTile.X = rowNumber;
        positionFirstTile.Y = 1;

        Position positionSecondTile = new Position();
        positionSecondTile.X = rowNumber;
        positionSecondTile.Y = 2;
        return TileAt(positionFirstTile).Symbol != ' ' && TileAt(positionFirstTile).Symbol != ' '
                && TileAt(positionSecondTile).Symbol != ' ';
    }

    private boolean tilesHasTheSameSymbol(int rowNumber) {
        Position positionZeroTile = new Position();
        positionZeroTile.X = rowNumber;
        positionZeroTile.Y = 0;

        Position positionFirstTile = new Position();
        positionFirstTile.X = rowNumber;
        positionFirstTile.Y = 1;

        Position positionSecondTile = new Position();
        positionSecondTile.X = rowNumber;
        positionSecondTile.Y = 2;

        return TileAt(positionZeroTile).Symbol == TileAt(positionFirstTile).Symbol
                && TileAt(positionSecondTile).Symbol == TileAt(positionFirstTile).Symbol;
    }

    public boolean winnerInRow(int rowNumber) {
        if (rowIsComplete(rowNumber)) {
            return tilesHasTheSameSymbol(rowNumber);
        }
        return false;
    }
}
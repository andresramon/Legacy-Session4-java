public class Game{
    public static final char EMPTY_TILE = ' ';
    public static final char ZERO = 'O';
    public static final int FIRST_ROW = 0;
    public static final int SECOND_ROW = 1;
    public static final int THIRD_ROW = 2;
    public static final int FIRST_COLUMN = 0;
    private char _lastSymbol = EMPTY_TILE;
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception{

        Position position = new Position(x, y);

        if(isFirstMove()){
            firstPlayerHaveToBeXSymbol(symbol);
        }

        if(isRepeatedPlayerTurn(symbol)){
            throw new Exception("Invalid next player");
        }

        if(_board.isNotEmptyTile(position, this)){
            throw new Exception("Invalid position");
        }

        updateGameState(symbol, position);
    }

    private boolean isRepeatedPlayerTurn(char symbol){
        return symbol == _lastSymbol;
    }

    private void firstPlayerHaveToBeXSymbol(char symbol) throws Exception{
        if(isZeroSymbol(symbol)){
            throw new Exception("Invalid first player");
        }
    }

    private boolean isZeroSymbol(char symbol){
        return symbol == ZERO;
    }

    private boolean isFirstMove(){
        return _lastSymbol == EMPTY_TILE;
    }

    private void updateGameState(char symbol, Position position){
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, position);
    }

    public char Winner(){
        if(_board.winnerInRow(FIRST_ROW)){
            return _board.TileAt(new Position(FIRST_ROW, FIRST_COLUMN)).Symbol;
        }

        if(_board.winnerInRow(SECOND_ROW)){
            return _board.TileAt(new Position(SECOND_ROW, FIRST_COLUMN)).Symbol;
        }

        if(_board.winnerInRow(THIRD_ROW)){
            return _board.TileAt(new Position(THIRD_ROW, FIRST_COLUMN)).Symbol;
        }

        return EMPTY_TILE;
    }

}


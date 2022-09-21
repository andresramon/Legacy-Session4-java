public class Game{
    private static final char EMPTY_TILE = ' ';
    private static final char ZERO = 'O';
    private char _lastSymbol = EMPTY_TILE;
    private Board _board = new Board();

    public void Play(char symbol, int row, int col) throws Exception{

        Position position = new Position(row, col);

        if(isFirstMove()){
            firstPlayerHaveToBeXSymbol(symbol);
        }

        if(isRepeatedPlayerTurn(symbol)){
            throw new Exception("Invalid next player");
        }

        if(_board.tileIsNotEmpty(position)){
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
        _board.addSymbolToTile(symbol, position);
    }

    public char Winner(){
        return _board.winner();
    }

}


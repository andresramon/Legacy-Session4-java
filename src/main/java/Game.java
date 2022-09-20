public class Game{
    private char _lastSymbol = ' ';
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception{

        Position position = new Position(x, y);

        if(isFirstMove()){
            firstPlayerHaveToBeXSymbol(symbol);
        }

        if(isRepeatedPlayerTurn(symbol)){
            throw new Exception("Invalid next player");
        }

        if(isNotEmptyTile(position)){
            throw new Exception("Invalid position");
        }

        updateGameState(symbol, position);
    }

    private boolean isNotEmptyTile(Position position){
        return _board.TileAt(position).Symbol != ' ';
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
        return symbol == 'O';
    }

    private boolean isFirstMove(){
        return _lastSymbol == ' ';
    }

    private void updateGameState(char symbol, Position position){
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, position);
    }

    public char Winner(){
        //if the positions in first row are taken
        if(_board.winnerInRow(0)){
            return _board.TileAt(new Position(0, 0)).Symbol;
        }
        //if the positions in first row are taken
        if(_board.winnerInRow(1)){
            return _board.TileAt(new Position(1, 0)).Symbol;
        }
        //if the positions in first row are taken
        if(_board.winnerInRow(2)){
            return _board.TileAt(new Position(2, 0)).Symbol;
        }

        return ' ';
    }

}


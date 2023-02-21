public class GameController {

    public static GameController _Instance_ = new GameController();
    private static Player player1;
    private static Player player2;
    private static Player currentPlayer;
    private static Board board;
    private static Player winner;
    private GameController()
    {
        if (_Instance_ == null)
        {
            _Instance_ = this;
        }

    }
    public void BeginGame()
    {
        player1 = new Player(Board.BoardValues.X, "Player 1");
        player2 = new Player(Board.BoardValues.O, "Player 2");
        board = new Board();
        currentPlayer = player1;

    }
    private boolean checkForWinner()
    {
        if(
        CheckCombination(0, 1, 2) ||
        CheckCombination(3, 4, 5) ||
        CheckCombination(6, 7, 8) ||
        CheckCombination(0, 3, 6) ||
        CheckCombination(1, 4, 7) ||
        CheckCombination(2, 5, 8) ||
        CheckCombination(0, 4, 8) ||
        CheckCombination(2, 4, 6))
        {
            return true;
        }
        return false;
    }
    public Player GetWinner()
    {
        if (checkForWinner())
        {
            winner = currentPlayer;
            return currentPlayer;

        }
        if (checkForDraw())
        {
            System.out.println("Draw");
            EndGame();
            return null;
        }
        else
        {
            winner = null;
            return null;
        }
    }
    public void EndGame()
    {

    }

    public void GetNextTurn()
    {
        board.setValue(currentPlayer.GetTurn(board.Board()), currentPlayer.getMarker());
        board.update();

    }
    public boolean CheckCombination(int a, int b, int c)
    {
        if (
                board.Board()[a] == Board.BoardValues.EMPTY ||
                board.Board()[b] == Board.BoardValues.EMPTY ||
                board.Board()[c] == Board.BoardValues.EMPTY)
        {
            return false;
        }

        return (board.Board()[a] == board.Board()[b] && board.Board()[b] == board.Board()[c]);
    }
    public void DeclareWinner()
    {
        System.out.println(winner.Name() + " WINS!");

    }
    private boolean checkForDraw()
    {

        for (Board.BoardValues val : board.Board())
        {
            if (val == Board.BoardValues.EMPTY)
            {
                return false;
            }
        }
        return true;
    }
    public void ChangePlayer()
    {
        if(GameController._Instance_.GetWinner() == null)
        {
            currentPlayer = currentPlayer == player1 ? player2 : player1;
            System.out.println(currentPlayer.Name() + ", your turn!");
        }
    }
}

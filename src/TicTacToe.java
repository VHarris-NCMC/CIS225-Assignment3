public class TicTacToe {

    private static Board board;

    public static void main(String[] args)
    {
        GameController._Instance_.BeginGame();

        while (GameController._Instance_.GetWinner() == null)
        {
            GameController._Instance_.GetNextTurn();
            GameController._Instance_.ChangePlayer();
        }
        GameController._Instance_.DeclareWinner();
    }




}

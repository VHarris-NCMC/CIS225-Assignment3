public class Board {

    private BoardValues[] board;

    public enum BoardValues
    {
        X, O, EMPTY
    };
    public Board()
    {
        board = new BoardValues[9];
        resetBoard();



    }
    private void resetBoard()
    {
        for(int i = 0; i < board.length; i++)
        {
            board[i] = BoardValues.EMPTY;
        }
        draw();
    }
    public void update()
    {
        this.draw();
    }
    private void draw()
    {
        String[] boardStrings = new String[9];
        for(int i = 0; i<board.length; i++)
        {
            if (board[i] == BoardValues.EMPTY)
            {

                boardStrings[i] = Integer.toString(i+1);
            }
            else
            {
                boardStrings[i] = board[i].toString();
            }
        }


        System.out.println("|"+ boardStrings[0] + "|" + boardStrings[1] + "|" + boardStrings[2] + "|");
        System.out.println("_______");
        System.out.println("|"+ boardStrings[3] + "|" + boardStrings[4]+ "|" + boardStrings[5] + "|");
        System.out.println("_______");
        System.out.println("|"+ boardStrings[6] + "|" + boardStrings[7] + "|" + boardStrings[8] + "|");

    }
    public BoardValues[] Board()
    {
        return board;
    }
    public void setValue(int spot, Board.BoardValues value)
    {
        board[spot] = value;
    }


}

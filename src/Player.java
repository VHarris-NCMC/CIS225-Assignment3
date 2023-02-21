import java.util.Scanner;

public class Player {
    private static Scanner scanner;
    private Board.BoardValues marker;

    private  String name;

    public Player(Board.BoardValues marker, String name)
    {
        this.marker = marker;
        this.name = name;
        if (scanner == null)
        {
            scanner = new Scanner(System.in);
        }
    }
    public int GetTurn(Board.BoardValues[] boardValues)
    {


        while(true)
        {
            System.out.println("Select an open Space:");

            int input = scanner.nextInt()-1;
            if (boardValues[input] == Board.BoardValues.EMPTY)
            {

                return input;
            }
            else
            {
                continue;
            }
        }





    }

    public Board.BoardValues getMarker() {
        return marker;
    }

    public String Name() {
        return name;
    }
}

package tiktakto;
import java.util.Scanner;

public class Tiktakto {

    public static int row, col;
    public static Scanner read = new Scanner(System.in);
    public static char[][] board = new char[3][3];
    public static char playerTurn = 'X';

    public static void main(String[] args) {

       for(int i=0; i<3; i++){
           for(int j=0; j<3; j++){
               board[i][j]='-';
           }
       }

       Play();
    }

        public static void Play(){
            boolean playing = true;
            System.out.println("\nPlayer X's turn!");
            PrintBoard();
                while(playing) {
                    System.out.println("\nEnter row and column: ");
                    row = read.nextInt() - 1;
                    col = read.nextInt() - 1;
                    while (board[row][col] != '-') {   //|| ((col)>2 | (row)>2)){
                        System.out.println("invalid move, try again");
                        row = read.nextInt() - 1;
                        col = read.nextInt() - 1;
                    }
                    board[row][col] = playerTurn;
                    if (GameOver(row, col)) {
                        playing = true;
                        System.out.println("Game over! Player " + playerTurn + " wins!");
                    }

                    PrintBoard();

                    if (playerTurn == 'X') {
                        playerTurn = 'O';
                    } else {
                        playerTurn = 'X';
                    }
                    if (playerTurn == 'X') {
                        System.out.println("Players X's turn to play! ");
                    } else if (playerTurn == 'O') {
                        System.out.println("Players O's turn to play! ");
                    }

                }

        }
        public static void PrintBoard(){
            for(int i=0; i<3; i++){
                System.out.println();
                for(int j=0; j<3; j++){
                    if(j==0){
                        System.out.print("|");
                    }
                    System.out.print(board[i][j] + " |");
                }
            }
            System.out.println();

        }
        public static boolean GameOver(int move1, int move2){

            if(board[0][move2] == board[1][move2] && board[0][move2] == board[2][move2])
                return true;
            if(board[move1][0] == board[move1][1] && board[move1][0] == board[move1][2])
                return true;
            if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] !='-')
                return true;
            if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] !='-')
                return true;
            return false;



            //if(board[0][0] == board[0][1] && board[0][1] == board[0][2])
            //    return false;
            //if(board[1][0] == board[1][1] && board[1][1] == board[1][2])
            //    return false;
            //if(board[2][0] == board[2][1] && board[2][1] == board[2][2])
            //    return false;
            //if(board[0][0] == board[1][0] && board[1][0] == board[2][0])
            //    return true;
            //if(board[0][1] == board[1][1] && board[1][1] == board[2][1])
            //    return true;
            //if(board[0][2] == board[1][2] && board[1][2] == board[2][2])
            //    return true;
            //if(board[0][0] == board[1][1] && board[1][1] == board[2][2])
            //    return true;
            //if(board[2][0] == board[2][1] && board[2][1] == board[0][2])
            //    return true;

          // [0][0], [0][1], [0][2]
          // [1][0], [1][1], [1][2]
          // [2][0], [2][1], [2][2]


        }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.pkg4.game;
 import  java.util.Scanner;

public class Connect4Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        player []players = new player[2];
        players[0] = new player();
        players[1]= new player();
        int mainRole = 0;
        System.out.print("Enter players names\nPlayer1: ");
        players[0].name = input.nextLine();
        players[0].text = "X";
        System.out.print("Player2: ");
        players[1].name = input.nextLine();
        players[1].text = "O";
        boolean close = false;
        while (!close) {
            int role = mainRole;
            ground ground1 = new ground();
            ground1.players = players;
            ground1.printGround();
            while(true){
                System.out.printf("The role of player%d\nposition: ", ((role % 2) + 1));
                int position = input.nextInt();
                while(!ground1.changeGround(position - 1, role)){
                    position = input.nextInt();
                }
                ground1.printGround();
                if(ground1.checkEnd(position - 1)){
                    ground1.endGame(role);
                    break;
                }
                role++;
            }
            System.out.print("Play another match 1-yes or 2-no:");
            if(input.nextInt() == 2){
                close = true;
            }
            mainRole++;
        }
    }
    
}

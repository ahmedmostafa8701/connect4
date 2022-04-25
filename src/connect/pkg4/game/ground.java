/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.pkg4.game;

/**
 *
 * @author Dell
 */
public class ground {
    public String [][]p;
    public player []players;
    int []colomnLevel;
    int full = 0;
    public ground(){
        players = new player[2];
        p = new String[6][7];
        colomnLevel = new int []{0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                p[i][j] = " ";
            }
        }
    }
    public void printGround(){
        for (int i = 1; i < 8; i++) {
            System.out.printf(" %d ", i);
        }
        System.out.println();
        for (int i = 5; i > -1; i--) {
            for (int j = 1; j < 8; j++) {
                System.out.printf("|%s|", p[i][j - 1]);
            }
            System.out.println();
        }
    }
    public boolean changeGround(int position, int role){
        if(position < 7 && colomnLevel[position] < 6){
            p[colomnLevel[position]++][position] = players[role % 2].text;
            full++;
            return true;
        }
        System.out.print("Postition: ");
        return false;
    }
    public boolean findTheWay(int position){
        if(checkWinner(position, 1, 0)){
            return true;
        }
        if(checkWinner(position, 0, 1)){
            return true;
        }
        if(checkWinner(position, 1, 1)){
            return true;
        }
        if(checkWinner(position, 1, -1)){
            return true;
        }
        return false;
    }
    public boolean checkWinner(int position, int rowChange, int colomnChange){
        int rowNum = colomnLevel[position] - 1;
        String text = p[rowNum][position];
        int counter = 0;
        for (int j : new int[]{1, 2}) {
            int a = rowNum + rowChange, b = position + colomnChange;
            while( a >= 0 && a < 6 && b >= 0 && b < 7 && p[a][b] == text){
                counter++;
                a += rowChange;
                b += colomnChange;
            }
            rowChange *= -1;
            colomnChange *= -1;
        }
        if(counter >= 3){
            return true;
        }
        return false;
    }
    public boolean checkEnd(int position){
        if(full == 42){
            return  true;
        }
        return findTheWay(position);
    }
    public void endGame(int role){
        System.out.printf("The winner is %s\nCongratulation %s\n",players[role % 2].text,players[role % 2].name);
        players[role % 2].score++;
        System.out.printf("the current result is \n%s: %d\t%s: %d\n",players[0].name, players[0].score, players[1].name, players[1].score);
    }
}

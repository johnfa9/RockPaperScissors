package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String choice;
        String userOneSelected;
        String userTwoSelected;
        String playerType;
        boolean playerValid;
        int player1Counter=0;
        int player2Counter=0;
        List<String> playerOneHistory=new ArrayList<>();
        List<String> playerTwoHistory=new ArrayList<>();

        System.out.println("Do you want to play against a player or computer: type ('player' or 'computer')");
        Scanner myObj=new Scanner(System.in);
        do{
            playerType = myObj.nextLine().toUpperCase();
            if (!playerType.equals("PLAYER") && !playerType.equals("COMPUTER")) {
                playerValid = false;
                System.out.println("Please enter a ('player' or 'computer')");
            }
            else {
                playerValid = true;
                if (playerType.equals("COMPUTER")){
                    playerType="Computer";
                }
                else playerType="Player 2";
            }
        } while (playerValid==false);

        do {
            //print menu
            System.out.println("MAIN MENU");
            System.out.println("=====");
            System.out.println("1. Type 'play' to play.");
            System.out.println("2. Type 'history' to view your game history.");
            System.out.println("3. Type 'quit' to stop playing.\n");
            choice = myObj.nextLine().toUpperCase();
            if (choice.equals("PLAY")) {
                Player humanPlayer=new Player(myObj);

                humanPlayer.printRequest("Player 1");
                choice=humanPlayer.getRequest();

                //check if quit
                if (!choice.equals("QUIT".toUpperCase())) {
                    userOneSelected = choice;
                    //player 2 is human
                    if (playerType.equals("Player 2")) {
                        Player humanPlayer2=new Player(myObj);
                        humanPlayer.printRequest("Player 2");
                        choice=humanPlayer2.getRequest();
                    }
                    //player 2 is the computer
                    else {
                        Computer computerPlayer=new Computer();
                        choice=computerPlayer.getGesture();
                    }
                    if (!choice.equals("QUIT".toUpperCase())) {
                        userTwoSelected = choice;
                        //player one wins
                        if ((userOneSelected.equals("PAPER") && userTwoSelected.equals("ROCK")) ||
                                (userOneSelected.equals("SCISSORS") && userTwoSelected.equals("PAPER"))
                                || (userOneSelected.equals("ROCK") && userTwoSelected.equals("SCISSORS"))) {
                            System.out.println("Player 1 wins!");
                            player1Counter+=1;
                            playerOneHistory.add("Win: "+ "Player one picked: " + userOneSelected.toLowerCase() + ", " +
                                    playerType + " picked " + userTwoSelected.toLowerCase());
                            playerTwoHistory.add("Loss: "+ "Player one picked: " + userOneSelected.toLowerCase()+ ", " +
                                    playerType + " picked " + userTwoSelected.toLowerCase());

                        }
                        //player two wins
                        else if ((userTwoSelected.equals("PAPER") && userOneSelected.equals("ROCK")) ||
                                (userTwoSelected.equals("SCISSORS") && userOneSelected.equals("PAPER")) ||
                                (userTwoSelected.equals("ROCK") && userOneSelected.equals("SCISSORS"))) {
                                System.out.println(playerType + " wins!\n");
                                player2Counter+=1;
                                playerOneHistory.add("Loss: " + "Player one picked: " + userOneSelected.toLowerCase() + ", " +
                                    playerType + " picked " + userTwoSelected.toLowerCase());
                                playerTwoHistory.add("Win: " + "Player one picked: " + userOneSelected.toLowerCase() +
                                    ", " + playerType + " picked " + userTwoSelected.toLowerCase());

                        }
                        //tie
                        else {
                                System.out.println("It was a tie!");
                                playerOneHistory.add("Tie: " + "Player one picked: " + userOneSelected.toLowerCase() +
                                    ", " + playerType + " picked " + userTwoSelected.toLowerCase());
                                playerTwoHistory.add("Tie: "+ "Player one picked: " + userOneSelected.toLowerCase() +
                                    ", " + playerType + " picked " + userTwoSelected.toLowerCase());
                        }
                    }
                }
            }
            //user selected history
            else if (choice.equals("HISTORY")){
                System.out.println("Player 1 points: " + player1Counter);
                for (String s : playerOneHistory) {
                    System.out.println(s);

                }
                System.out.println();

                System.out.println(playerType + " points: " + player2Counter);
                for (String s : playerTwoHistory) {
                    System.out.println(s);
                }
            }
            //check if user quit
        } while (!choice.equals("quit".toUpperCase()));
    }
}

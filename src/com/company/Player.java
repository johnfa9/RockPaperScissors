package com.company;
import java.util.Scanner;

public class Player {
    private Scanner scanner;


    public Player(Scanner scanner){
        this.scanner=scanner;
    }

    public void printRequest(String playerVal) {
        System.out.println(playerVal);
        System.out.println("=====");
        System.out.println("Type 'rock', 'paper', or 'scissors' to play.");
        System.out.println("Type 'quit' to go back to the main menu.\n");
    }

    public String getRequest(){
        boolean flag=false;
        String playerEntered="";
        playerEntered=scanner.nextLine().toUpperCase();

        do{
            if (!playerEntered.equals("ROCK") && (!playerEntered.equals("PAPER")) &&
                (!playerEntered.equals("QUIT")) && (!playerEntered.equals("SCISSORS"))) {
                System.out.println("Please enter a valid entry");
                flag = false;
                playerEntered=scanner.nextLine().toUpperCase();
            }
            else flag=true;


        }while (flag==false);
        return playerEntered;

    }
}

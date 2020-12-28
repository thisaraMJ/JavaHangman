package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        File dictionary = new File("dictionary.txt");

        Scanner textScanner = new Scanner(dictionary);
        Scanner inputReader = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>();

        while (textScanner.hasNext()){
            String word = textScanner.nextLine();
            if(word.length()>6) words.add(textScanner.nextLine());
        }

        String mysteryWord = words.get((int)Math.random() * words.size());

        String input = "";
//        String word = "Windows";
        mysteryWord = mysteryWord.toUpperCase();

        System.out.println("#############################");
        System.out.println("The hangman word has "+ mysteryWord.length() + "letters");

        int lives = 6;

        while (true) {
            System.out.println("#############################");
            System.out.println("Press L to guess a letter\nPress W to guess the word\nPress Q to quit");
            System.out.println("#############################");

            input = Character.toString(inputReader.nextLine().toUpperCase().charAt(0));

            switch (input) {
                case "L":
                    System.out.print("Enter the letter:");
                    System.out.println();
                    input = Character.toString(inputReader.nextLine().toUpperCase().charAt(0));

                    if (mysteryWord.contains(input)) {
                        int numOfLetters = 0;

                        for (int i = 0; i < mysteryWord.length(); i++) {
                            if (mysteryWord.substring(i, i + 1).equals(input)) {
                                numOfLetters++;
                            }else {
                                lives--;

                                if(lives==0) {
                                    System.out.println("Wrong letter!");
                                    System.out.println("Lives left: " + lives);
                                }
                            }
                        }
                        System.out.println("There are " + numOfLetters + " " + input + " /s " + "in this word!");
                    }
                    break;

                case "W":
                    System.out.print("Type your guessing word: ");
                    input = inputReader.next().toUpperCase();
                    inputReader.nextLine();

                    if (input.equals(mysteryWord)) {
                        System.out.println("Congratulations. You Win!");
                    }else{
                        System.out.println("You lost!\n The word is "+mysteryWord);
                    }
                    System.out.println("Wanna play again? (y/n)");
                    input = Character.toString(inputReader.nextLine().toUpperCase().charAt(0));

                    if(input.equals("N")){
                        System.out.println("Thank you for playing!");
                        System.exit(0);
                    }
                    else if(input.equals("Y")){

                    }
                    break;

                case "Q":
                    System.out.println("Thank you for playing!");
                    System.exit(0);
                    break;

                default:

            }
        }
    }
}

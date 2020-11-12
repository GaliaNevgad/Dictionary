package com.company;

import java.util.Scanner;

public class Service {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    Scanner scanner = new Scanner(System.in);
    Dictionary dictionary = new Dictionary();

    public void service(){
        Dictionary dictionary = new Dictionary();
        while(true){
            System.out.println("If you wanna translate existed word - press 1\n" +
                    "If you wanna add a new word - press 2\n" +
                    "If you wanna close the program - press 3");

            switch (scanner.nextLine()){
                case "1" : {
                    this.translate();
                }
                case "2" : {
                    this.addNewWord();
                }
                case "3" : {
                    System.exit(1);
                }
                default:{
                    System.out.println("You write incorrect data. Please enter '1' to translate, " +
                            "'2' to add new word, '3' to exist");
                }
            }
        }
    }

    private void translate(){
        String text;
        while(true){
            System.out.println("\nEnter word in English");
            text = scanner.nextLine();

            if(text.trim().isEmpty()){
                System.out.println("\nThe string is empty, try again");
                continue;
            }
            System.out.println(dictionary.translateWords(text));
            continue;
        }
    }

    private void addNewWord(){
        String englishWord, ukrainianWord;

        while(true){
            try{
                System.out.println("Enter a new chosen English word. It will be added");
                if((englishWord = scanner.nextLine().trim()).isEmpty()) throw new IllegalArgumentException();

                System.out.println("Enter the translation for a previously entered word");
                if((ukrainianWord = scanner.nextLine().trim()).isEmpty()) throw  new IllegalArgumentException();
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Something went wrong." + e.getMessage());
                continue;
            }
        }
        dictionary.addWordToDict(englishWord, ukrainianWord);
    }
}

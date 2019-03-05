/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Kyle's PC
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        String words, hangman;

        boolean allow = true;
        boolean word = false;
        int guesses, randomNum, wordCount, stringEnd;

        String[] tvShows = new String[]{"Spongebob Squarepants", "The Office"};
        String[][] hangmanShape = new String[][]{{" O\n", "/", "|"}, {"\\\n", " |\n", "/"}, {" \\"}};

        int counter = 0;
        int arrayPos = 0;
        randomNum = rand.nextInt(1 - 0 + 1); //max - min + 1
        guesses = 7;
        wordCount = 0;

        words = tvShows[randomNum];
        StringBuilder hidden = new StringBuilder(words);
        stringEnd = words.length() - 1;
        hangman = "";

        for (int i = 0; i < words.length(); i++) {
            if (Character.isLetter(words.charAt(i)) && i != stringEnd) {
                word = true;

            } else if (!Character.isLetter(words.charAt(i)) && word) {
                wordCount += 1;
                word = false;

            } else if (Character.isLetter(words.charAt(i)) && i == stringEnd) {
                wordCount += 1;

            }
        }

        int space = words.indexOf(" ");

        if (allow = true) {
            for (int i = 0; i < hidden.length(); i++) {
                if (i == space) {
                    hidden.setCharAt(i, ' ');
                } else {
                    hidden.setCharAt(i, '-');
                }
            }
            System.out.println("Category: TV SHOWS");
            System.out.println("Number of Words: " + wordCount);
            System.out.println(hidden);

            //System.out.print(randomNum);
            while (guesses > 0) {
                boolean disp;
                String input = JOptionPane.showInputDialog("Number of Guesses Remaining: " + guesses + "\nGuess a letter:");

                
                for (char in : input.toCharArray()) {
                    if (words.toLowerCase().contains(Character.toString(in).toLowerCase())) {
                        for (int i = 0; i < hidden.length(); i++) {

                            if (in == hidden.charAt(i)) {
                                JOptionPane.showMessageDialog(null, "You Already Guessed This. Try Again.");
                                break;
                            }else if (i == words.indexOf(in, i)) {
                                hidden.setCharAt(i, in);
                                disp = true;
                            }
                        }

                    } else {
                        System.out.println(counter);
                        guesses -= 1;

                        if (counter == 3) {
                            counter = 0;
                            arrayPos += 1;
                        }

                        hangman = hangman + hangmanShape[arrayPos][counter];
                        counter += 1;
                        disp = true;
                    }
                }

                if (disp = true) {
                    System.out.println("\n\n\n\n\n\n\n\n\n\nCategory: TV SHOWS");
                    System.out.println("Number of Words: " + wordCount);
                    System.out.println(hidden);
                    System.out.println(hangman);
                    disp = false;
                }
                
                
                
                if (hidden.toString().equalsIgnoreCase(words)) {
                    JOptionPane.showMessageDialog(null, "You Guessed Correctly. You Win!");
                    System.exit(0);
                }

            }

            JOptionPane.showMessageDialog(null, "You are a hanged man!");
            System.exit(0);
        }
    }
}

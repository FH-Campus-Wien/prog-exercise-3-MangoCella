package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Task 1: One Month Calendar
    public static void oneMonthCalendar(int days, int firstDay) {
        int columns = 0;
        int rows = 0;
        for (int j = 1; j <= 7; j++) {
            if (j == firstDay) {
                for (int i = 1; i <= days; i++) {
                    if (i <= 9) {
                        System.out.print(" " + i + " ");
                    } else {
                        System.out.print(i +" ");
                    }
                    columns++;
                    if (columns % 7 == 0) {
                        if (rows <= 4) {
                            System.out.println("");
                        }
                        rows++;
                    }
                }
            } else if (columns < firstDay) {
                System.out.print("   ");
                columns++;
                }
        if (days <= 2) {
            System.out.print(" ");
            }
        if (columns % 7 != 0) {
            System.out.print("");
            }
        }
    }

    // Task 2: Pseudo Random Numbers
    public static long[] lcg(long seed) {
        long[] returnArray = new long[10];
        long m = (long) Math.pow(2, 31);
        long a = 1103515245;
        int c = 12345;

        for (int i = 0; i < 10; i++) {
            returnArray[i] = (a * (i == 0 ? seed : returnArray[i - 1]) + c) % m;
        }
        return returnArray;
    }

    // Task 3: Guessing Game
    public static void guessingGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        int input;

        for (int i = 1; i <= 10; i++) {
            System.out.printf("Guess number %s: ", i);
            input = scanner.nextInt();

            if (input == numberToGuess) {
                System.out.println("You won wisenheimer!");
                break;
            }
            if (i == 10) System.out.println("You lost! Have you ever heard of divide & conquer?");
            else
                System.out.println("The number AI picked is " + (input < numberToGuess ? "higher " : "lower ") + "than your guess.");
        }
    }

    public static int randomNumberBetweenOneAndHundred(){

        System.out.print(Math.random()*100);
        Random rnd = new Random();

        return rnd.nextInt(100) + 1;
    }

    // Task 4: Swap Arrays
    public static boolean swapArrays(int[] a, int[] b) {
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) a[i] += b[i];
        for (int i = 0; i < a.length; i++) b[i] = a[i] - b[i];
        for (int i = 0; i < a.length; i++) a[i] -= b[i];

        return true;
    }

   /*
    public static int[] swapArrays(int[] a, int[] b) {

        int[] swap = new int[a.length+ b.length];
        if (a.length > b.length) {
            for (int i=0; i < swap.length; i++){
                swap[i] = b[i];
                swap[i+b.length] = b[i];
                }
            }
         if (b.length > a.length) {
             for (int i = 0; i < swap.length; i++) {
                 swap[i] = b[i];
                 swap[i + b.length] = b[i];
                }
            }
         return swap;
    }
    */


    // Task 5: Camel Case
    public static String camelCase(String sentence) {
        char[] charArray = sentence.toCharArray();
        String result = "";
        boolean nextSignCaps = true;

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= 65 && charArray[i] <= 90 || charArray[i] >= 97 && charArray[i] <= 122) {
                if (nextSignCaps) {
                    if (charArray[i] >= 97 && charArray[i] <= 122) result += (char) (charArray[i] - 32);
                    else result += (char) charArray[i];
                    nextSignCaps = false;
                } else {
                    if (charArray[i] >= 65 && charArray[i] <= 90) result += (char) (charArray[i] + 32);
                    else result += (char) charArray[i];
                }
            } else if (charArray[i] == 32) nextSignCaps = true;
        }
        return result;
    }

    //Task 6: Check Digit
    public static int checkDigit(int[] inputArray) {
        int productsSum=0;
        int checkDigit;
        for (int i = 0; i < inputArray.length; i++){
            productsSum += inputArray[i] * (i+2);
        }
        checkDigit = 11 - (productsSum % 11);
        if(checkDigit == 10) return 0;
        else if (checkDigit == 11) return 5;
        return checkDigit;
    }


    public static void main(String[] args){
        // test your method implementations here
        // make method calls
        // print their results

        oneMonthCalendar(31,2);
        //parameter 31 tage im Monat; am Dienstag (2) Starten

        guessingGame(42);

        lcg(0);

        randomNumberBetweenOneAndHundred();

        int[] a = {1,2,3,4,5};
        int[] b = {100,99,60,44,2};
        swapArrays(a,b);

        checkDigit(new int[]{3, 9, 1, 5, 8});

        /*
        int[] inputArray = new int[70];
        checkDigit(inputArray);
        for (int i =0; i <= inputArray.length; i++) {
            inputArray[i]= new inputArray();
        }
         */


        // App exercise3 = new App();

        //System.out.println("Task 1: oneMonthCalender");
        //exercise3.oneMonthCalender(31,2);

        // System.out.println("Task 2: lcg");
        // exercise3.lcg();

        }
}
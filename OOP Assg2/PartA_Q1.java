package gr_assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * PartA_Q1.java
 *
 * This program will output a diamond pattern of numbers according to
 * the user input. If the input is 0, the console will
 * print the pattern of 0s. If the input is 1, the console
 * will print a pattern of numbers from 0s to 4s. If the input is
 * 2, the console will print 0s, 2s, 4s, 6s and 8s. Else, if the
 * input is not 0/1/2, the user must input again.
 * An error message will be thrown if the user key in a
 * non-integer input.
 * 
 * @author Abdu Muhaimin
 * @version 1.0
 */
public class PartA_Q1{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userInput = 0;
        String checkInput;
        String tryAgain = "yes";
        
        
        System.out.println("This program will output a diamond pattern of numbers according to the user input");
        
        while(tryAgain.charAt(0)=='y'||tryAgain.charAt(0)=='Y'){
            try {
                do{
                    System.out.print("Please enter integer between 0 and 2: ");
                    userInput = input.nextInt();
                    checkInput = Integer.toString(userInput);
                    if(userInput > 2 || userInput < 0){
                        System.out.println("Try again! Enter integer within the range of 0 and 2.");
                    }
                    
                }while(userInput > 2 || userInput < 0 || checkInput.length() > 1 || checkInput.length() == 0);
                
                int noOfColumns = 1;
                int start;
                int noOfSpaces = 4;

                for(int i = 0; i <= 9; i++){
                    for(int j = 1; j <= noOfSpaces; j++){
                        System.out.print(" ");
                    }
                    if(i < 4){
                        start = i*userInput;
                        noOfSpaces--;
                    }
                    else {
                        start = (8-i)*userInput;
                        noOfSpaces++;
                    }

                    for(int j = 1; j <= noOfColumns; j++){
                        int middleColumn = noOfColumns/2+1;
                        System.out.print(start);
                        if(j < middleColumn){
                            start-=userInput;
                        }
                        else {
                           start+=userInput;
                        }
                    }
                    System.out.println();
                    if(i < 4){
                       noOfColumns+=2;
                    }
                    else {
                        noOfColumns-=2;
                    }
                }
                System.out.println("Do you want to try again? Enter y for Yes and n for No.");
                tryAgain = input.next();
            }
            catch(InputMismatchException e) {
                System.out.print("Please enter an integer! Error: You inputed a non-integer. ");
                System.out.println("Please key in an integer within the range of 0 and 2.");
                input.next();
            }
        }
    }  
}

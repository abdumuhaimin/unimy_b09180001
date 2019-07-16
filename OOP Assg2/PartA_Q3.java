package gr_assignment;

import java.util.Scanner;

/**
 * PartA_Q3.java
 *
 * This program will acquire integer inputs and display the largest
 * and smallest numbers, prime numbers and the summation of prime numbers.
 * 
 * @author Abdu Muhaimin
 * @version 1.x
 */
public class PartA_Q3 {
    public static void main(String[] args) {
        System.out.println("This program will acquire integer inputs and display the largest");
        System.out.println("and smallest numbers and the number and summation of prime numbers.");
        System.out.println("Type 0 to finish.");
        Scanner input = new Scanner(System.in);
        int counter = 0,counterPrime = 0;
        System.out.print("?");
        int largest = input.nextInt();
        int smallest = largest;
        int sumOfPrime = 0;
        
        int user_input = largest;
        while(user_input != 0){
            System.out.print("?");
            if(user_input > largest){
                largest = user_input;
            }
            
            if(user_input < smallest){
                smallest = user_input;
            }
            if(checkPrime(user_input)){
                counterPrime++;
                sumOfPrime += user_input;
            }
            counter++;
            user_input = input.nextInt();
        }
        
        System.out.println("Number of input values: "+counter);
        System.out.println("Largest number : "+largest);
        System.out.println("Smallest number: "+smallest);
        System.out.println("Number of prime number(s): "+counterPrime);
        System.out.println("Total of prime number(s): "+sumOfPrime);
    }
    
    public static boolean checkPrime(int n){
        int remainder;
        boolean isPrime = true;
        
        for(int i = 2; i <= n/2; i++){
            remainder = n%i;
            
            if(remainder == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}

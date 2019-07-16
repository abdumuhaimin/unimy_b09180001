package gr_assignment;

import java.time.LocalDate;
import java.time.Period;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * PartB_Q1.java
 * 
 * This program is a Name Numerology System that acquire the user to
 * input their full name and choose the type of name analysis system
 * using window. The two most popular name analysis systems are
 * Pythagorean and Chaldean Numerology.
 *
 * @author Abdu Muhaimin
 * @version 1.x
 */
public class PartB_Q1 {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "Please input your name:", "Name Numerology", JOptionPane.QUESTION_MESSAGE);
        String[] options = {"Pythagorean","Chaldean"};
        
        String date = JOptionPane.showInputDialog(null, "What is your birth date?", "Name Numerology", JOptionPane.QUESTION_MESSAGE);
        String month = JOptionPane.showInputDialog(null, "What is your birth month?", "Name Numerology", JOptionPane.QUESTION_MESSAGE);
        String year = JOptionPane.showInputDialog(null, "What is your birth year?", "Name Numerology", JOptionPane.QUESTION_MESSAGE);
        int date_ob = Integer.parseInt(date);
        int month_ob = Integer.parseInt(month);
        int year_ob = Integer.parseInt(year);
        
        LocalDate dob = LocalDate.of(year_ob,month_ob,date_ob);
        LocalDate now = LocalDate.now();
        Period difference = Period.between(dob, now);
        
        int sum = 0;
        
        if(difference.getYears() >= 21){
            int choice = JOptionPane.showOptionDialog(null, "What type of name numerology you want to use?", "Name Numerology", 0, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            switch(choice){
                case 0://when user choose Pythagorean Name Numerology
                    for(int i = 0; i < name.length(); i++){
                        String letter = name.substring(i, i+1);
                        switch(letter){
                            case "a":
                            case "A":
                            case "j":
                            case "J":
                            case "s":
                            case "S":
                                sum+=1;
                                break;
                            case "b":
                            case "B":
                            case "k":
                            case "K":
                            case "t":
                            case "T":
                                sum+=2;
                                break;
                            case "c":
                            case "C":
                            case "l":
                            case "L":
                            case "u":
                            case "U":
                                sum+=3;
                                break;
                            case "d":
                            case "D":
                            case "m":
                            case "M":
                            case "v":
                            case "V":
                                sum+=4;
                                break;
                            case "e":
                            case "E":
                            case "n":
                            case "N":
                            case "w":
                            case "W":
                                sum+=5;
                                break;
                            case "f":
                            case "F":
                            case "o":
                            case "O":
                            case "x":
                            case "X":
                                sum+=6;
                                break;
                            case "g":
                            case "G":
                            case "p":
                            case "P":
                            case "y":
                            case "Y":
                                sum+=7;
                                break;
                            case "h":
                            case "H":
                            case "q":
                            case "Q":
                            case "z":
                            case "Z":
                                sum+=8;
                                break;
                            case "i":
                            case "I":
                            case "r":
                            case "R":
                                sum+=9;
                                break;
                        }
                    }
                    break;
                case 1:
                    for(int i = 0; i < name.length(); i++){
                        String letter = name.substring(i, i+1);
                        switch(letter){
                            case "a":
                            case "A":
                            case "i":
                            case "I":
                            case "j":
                            case "J":
                            case "q":
                            case "Q":
                            case "y":
                            case "Y":
                                sum+=1;
                                break;
                            case "b":
                            case "B":
                            case "k":
                            case "K":
                            case "r":
                            case "R":
                                sum+=2;
                                break;
                            case "c":
                            case "C":
                            case "g":
                            case "G":
                            case "l":
                            case "L":
                            case "s":
                            case "S":
                                sum+=3;
                                break;
                            case "d":
                            case "D":
                            case "m":
                            case "M":
                            case "t":
                            case "T":
                                sum+=4;
                                break;
                            case "e":
                            case "E":
                            case "h":
                            case "H":
                            case "n":
                            case "N":
                                sum+=5;
                                break;
                            case "u":
                            case "U":
                            case "v":
                            case "V":
                            case "w":
                            case "W":
                            case "x":
                            case "X":
                                sum+=6;
                                break;
                            case "o":
                            case "O":
                            case "z":
                            case "Z":
                                sum+=7;
                                break;
                            case "f":
                            case "F":
                            case "p":
                            case "P":
                                sum+=8;
                                break;
                        }
                    }
            }
            
            int calc = 0;
            while(sum > 0){
                int remainder = sum % 10;
                calc += remainder;
                sum = (int) Math.floor(sum/10);
                if(calc > 9){
                    sum = calc;
                    calc = 0;
                }
            }
            String desc = "Your lucky number is: "+calc+"\nYour characteristics are:\n"+calc+"- ";
            ImageIcon icon = null;
            switch(calc){
                case 1:
                    icon = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\one.png","One");
                    desc += "Initiating action, pioneering, leading, independent, attaining, individual.";
                    break;
                case 2:
                    icon = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\two.png","Two");
                    desc += "Cooperation, adaptability, consideration of others, partnering, mediating.";
                    break;
                case 3:
                    icon = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\three.png","Three");
                    desc += "Expression, verbalization, socialization, the arts, the joy of living.";
                    break;
                case 4:
                    icon = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\four.png","Four");
                    desc += "A foundation, order, service, strunggle against limits, steady growth.";
                    break;
                case 5:
                    icon = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\five.png","Five");
                    desc += "Expensiveness, visionary, adventure, the constructive use of freedom";
                    break;
                case 6:
                    icon = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\six.png","Six");
                    desc += "Responsibility, protection, nurturing, community, balance, sympathy";
                    break;
                case 7:
                    icon = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\seven.png","Seven");
                    desc += "Analysis, understanding, knowledge, awareness, studious, meditating.";
                    break;
                case 8:
                    icon = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\eight.png","Eight");
                    desc += "Practical endeavors, status oriented, power seeking, high-material goals.";
                    break;
                case 9:
                    icon = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\nine.png","Nine");
                    desc += "Humanitarian, giving nature, selfness, obligations, creative expression.";
                    break;
            }
            
            JOptionPane.showMessageDialog(null, "Hi, "+name.substring(0, 1).toUpperCase()+name.substring(1)+"! \n"+desc, "Name Numerology", JOptionPane.INFORMATION_MESSAGE, icon);
        }
        else {
            JOptionPane.showMessageDialog(null, "You aren't eligible to use this program", "Name Numerology - below 21 y.o.", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}

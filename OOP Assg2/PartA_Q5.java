package gr_assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * PartA_Q5.java
 * 
 * This program is a Zodiac System that will acquire user to input
 * their name, date of birth and the year of birth using window.
 * Can calculate the total number and display the life path number,
 * the zodiac sign and the characteristics via window.
 *
 * @author Abdu Muhaimin
 * @version 1.0
 */
public class PartA_Q5 {
    public static void main(String[] args) {
        int choice = JOptionPane.showOptionDialog(null, "Are you a male?", "Gender", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,null,null);
        String name = JOptionPane.showInputDialog(null, "Please enter your name: ", "Zodiac", JOptionPane.QUESTION_MESSAGE);
        String dob = JOptionPane.showInputDialog(null, "Please enter your date of birth (format: dd/mm/yy): ", "Zodiac", JOptionPane.QUESTION_MESSAGE);
        
        String message = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String gender;
        try {
            Date date = formatter.parse(dob);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int month = cal.get(Calendar.MONTH)+1;
            int day = cal.get(Calendar.DATE);
            int year = cal.get(Calendar.YEAR);
            String sign;
            
            switch(month) {
                case 1:
                    if(day <= 20)
                        sign = "Capricorn";
                    else
                        sign = "Aquarius";
                    break;
                case 2:
                    if(day < 20)
                        sign = "Aquarius";
                    else
                        sign = "Pisces";
                    break;
                case 3:
                    if(day <= 20)
                        sign = "Pisces";
                    else
                        sign = "Aries";
                    break;
                case 4:
                    if(day <= 20)
                        sign = "Aries";
                    else
                        sign = "Taurus";
                    break;
                case 5:
                    if(day <= 21)
                        sign = "Taurus";
                    else
                        sign = "Gemini";
                    break;
                case 6:
                    if(day <= 21)
                        sign = "Gemini";
                    else
                        sign = "Cancer";
                    break;
                case 7:
                    if(day <= 22)
                        sign = "Cancer";
                    else
                        sign = "Leo";
                    break;
                case 8:
                    if(day <= 22)
                        sign = "Leo";
                    else
                        sign = "Virgo";
                    break;
                case 9:
                    if(day <= 22)
                        sign = "Virgo";
                    else
                        sign = "Libra";
                    break;
                case 10:
                    if(day <= 22)
                        sign = "Libra";
                    else
                        sign = "Scorpio";
                    break;
                case 11:
                    if(day <= 21)
                        sign = "Scorpio";
                    else
                        sign = "Sagittaurius";
                    break;
                case 12:
                    if(day <= 21)
                        sign = "Sagittaurius";
                    else
                        sign = "Capricorn";
                    break;
                default:
                    sign = "Invalid month";
                    break;
            }
            if(choice == JOptionPane.YES_OPTION)
                gender = "Mr. ";
            else
                gender = "Ms. ";
            message+= "Hi " + gender + name.substring(0, 1).toUpperCase() + name.substring(1);
            message+= "\nYour Date of Birth: "+day+"/"+month+"/"+year;
            message += "\nSign: " + sign;
            
            int sumOfDOB = day+month+year;
            int calc = 0;
            while(sumOfDOB > 0){
                int remainder = sumOfDOB % 10;
                calc += remainder;
                sumOfDOB = (int) Math.floor(sumOfDOB/10);
                if(calc > 9){
                    sumOfDOB = calc;
                    calc = 0;
                }
            }
            message += "\nYour Life Path Number: "+ calc +"\nYour characteristics: ";
            ImageIcon horoscope_logo = null;
            switch(sign){
                case "Libra":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\libra.png","Libra");
                    message += "\nLibra (September 22 - October 22)\nThe sign of Libra is an Air sign, set between Gemini and Aquarius, giving these individuals"
                            + "\nconstant mental stimuli,"
                            + " strong intellect and a keen mind. They will be inspired by good books,"
                            + "\ninsurmountable discussions and people who have a lot to say.";
                    break;
                case "Taurus":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\taurus.png","Taurus");
                    break;
                case "Sagittaurius":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\sagittaurius.png","Taurus");
                    break;
                case "Aries":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\aries.png","Taurus");
                    break;
                case "Gemini":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\gemini.png","Taurus");
                    break;
                case "Cancer":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\cancer.png","Taurus");
                    break;
                case "Leo":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\leo.png","Taurus");
                    break;
                case "Virgo":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\virgo.png","Taurus");
                    break;
                case "Scorpio":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\scorpio.png","Taurus");
                    break;
                case "Capricorn":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\capricorn.png","Taurus");
                    break;
                case "Aquarius":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\aquarius.png","Taurus");
                    break;
                case "Pisces":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\pisces.png","Taurus");
                    break;
            }
            
            JOptionPane.showMessageDialog(null, message, "ZODIAC RESULTS", JOptionPane.INFORMATION_MESSAGE,horoscope_logo);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        
    }
}

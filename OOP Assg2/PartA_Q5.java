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
                    message += "\nTaurus (April 21 - May 21)\nTaurus is an Earth sign, just like Virgo and Capricorn, and has the ability to see things from a grounded, "
                            + "\npractical and realistic perspective. They find it easy to make money and stay on same projects for years, "
                            + "\nor until they are completed. What we often see as stubbornness can be interpreted as commitment, and their ability to complete tasks "
                            + "\nwhatever it takes is uncanny.";
                    break;
                case "Sagittaurius":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\sagittaurius.png","Taurus");
                    message += "\nSagittaurus (November 22 - December 21)\nCurious and energetic, Sagittarius is one of the biggest travelers among all zodiac signs."
                            + "\nTheir open mind and philosophical view motivates them to wander around the world in search of the meaning of life." 
                            +  "\nSagittarius is extrovert, optimistic and enthusiastic, and likes changes. Sagittarius-born are able to transform their "
                            + "\nthoughts into concrete actions and they will do anything to achieve their goals.";
                    break;
                case "Aries":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\aries.png","Taurus");
                    message += "\nAries (March 21 - April 20)\nAs the first sign in the zodiac, the presence of Aries always marks the beginning of something energetic and turbulent. They are "
                            + "\ncontinuously looking for dynamic, speed and competition, always being the first in everything - from work to social gatherings."
                            + "\nThanks to its ruling planet Mars and the fact it belongs to the element of Fire (just like Leo and Sagittarius), Aries is one of "
                            + "\nthe most active zodiac signs. It is in their nature to take action, sometimes before they think about it well.";
                    break;
                case "Gemini":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\gemini.png","Taurus");
                    message += "\nGemini (May 22 - June 21)\nExpressive and quick-witted, Gemini represents two different personalities in one and you will never be sure which one you will face."
                            + "\nThey are sociable, communicative and ready for fun, with a tendency to suddenly get serious, thoughtful and restless. They are fascinated "
                            + "\nwith the world itself, extremely curious, with a constant feeling that there is not enough time to experience everything they want to see.";
                    break;
                case "Cancer":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\cancer.png","Taurus");
                    message += "\nCancer (June 22 - July 22)\nDeeply intuitive and sentimental, Cancer can be one of the most challenging zodiac signs to get to know. They are very emotional"
                            + "\nand sensitive, and care deeply about matters of the family and their home. Cancer is sympathetic and attached to people they keep close. Those born with their"
                            + "\nSun in Cancer are very loyal and able to empathize with other people's pain and suffering.";
                    break;
                case "Leo":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\leo.png","Taurus");
                    message += "Leo (July 23 - August 22)\nPeople born under the sign of Leo are natural born leaders. They are dramatic, creative, self-confident, dominant and extremely difficult"
                            + "\nto resist, able to achieve anything they want to in any area of life they commit to. There is a specific strength to a Leo and their \"king of the jungle\" status."
                            + "\nLeo often has many friends for they are generous and loyal. Self-confident and attractive, this is a Sun sign capable of uniting different groups of people and leading"
                            + "\nthem as one towards a shared cause, and their healthy sense of humor makes collaboration with other people even easier.";
                    break;
                case "Virgo":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\virgo.png","Taurus");
                    message += "Virgo (August 23 - September 22)\nVirgo is an Earth sign, fitting perfectly between Taurus and Capricorn. This will lead to a strong character, but one that prefers"
                            + "\nconservative, well-organized things and a lot of practicality in their everyday life. These individuals have an organized life, and even when they let go to chaos,"
                            + "\ntheir goals and dreams still have strictly defined borders in their mind. Constantly worried that they missed a detail that will be impossible to fix, they can get"
                            + "\nstuck in details, becoming overly critical and concerned about matters that nobody else seems to care much about.";
                    break;
                case "Scorpio":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\scorpio.png","Taurus");
                    message += "Scorpio (October 23 - November 21)\nScorpio-born are passionate and assertive people. They are determined and decisive, and will research until they find out the truth."
                            + "\nScorpio is a great leader, always aware of the situation and also features prominently in resourcefulness.\n"
                            + "\nScorpio is a Water sign and lives to experience and express emotions. Although emotions are very important for Scorpio, they manifest them differently than other water signs."
                            + "\nIn any case, you can be sure that the Scorpio will keep your secrets, whatever they may be.";
                    break;
                case "Capricorn":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\capricorn.png","Taurus");
                    message += "Capricorn (December 22 - January 20)\nCapricorn is a sign that represents time and responsibility, and its representatives are traditional and often very serious by nature."
                            + "\nThese individuals possess an inner"
                            + "state of independence that enables significant progress both in their personal and professional lives. They are masters of self-control and have the ability to lead the way,"
                            + "\nmake solid and realistic plans, and manage many people who work for them at any time. They will learn from their mistakes and get to the top based solely on their experience and expertise.";
                    break;
                case "Aquarius":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\aquarius.png","Taurus");
                    message += "Aquarius (January 21 - February 19)\nAquarius-born are shy and quiet , but on the other hand they can be eccentric and energetic. However, in both cases, they are deep thinkers and highly"
                            + "\nintellectual people who love helping others."
                            + " They are able to see without prejudice, on both sides, which makes them people who can easily solve problems."
                            + "\nAlthough they can easily adapt to the energy that surrounds them, Aquarius-born have a deep need to be some time alone and away from everything, in order to restore power. People born under the"
                            + "\nAquarius sign, look at the world as a place full of possibilities.";
                    break;
                case "Pisces":
                    horoscope_logo = new ImageIcon("D:\\Documents\\NetBeansProjects\\Abdu Muhaimin bin Hashim\\src\\images\\pisces.png","Taurus");
                    message += "Pisces (February 20 - March 20)\nPisces are very friendly, so they often find themselves in a company of very different people. Pisces are selfless, they are always willing to help others, without hoping"
                            + "\nto get anything back."
                               + " Pisces is a Water sign and as such this zodiac sign is characterized by empathy and expressed emotional capacity.";
                    break;
            }
            
            JOptionPane.showMessageDialog(null, message, "ZODIAC RESULTS", JOptionPane.INFORMATION_MESSAGE,horoscope_logo);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        
    }
}

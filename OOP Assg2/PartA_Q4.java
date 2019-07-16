package gr_assignment;

import javax.swing.JOptionPane;

/**
 * PartA_Q4.java
 * 
 * A calculator program that reads two double values (the side
 * adjacent and the side opposite) from the user which are the
 * sides of a triangle.
 *
 * @author Abdu Muhaimin
 * @version 1.0
 */
public class PartA_Q4 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "Please enter side adjacent: ", "Trigonometry calculator", JOptionPane.QUESTION_MESSAGE);
        double adjacent = Double.parseDouble(input);
        String input1 = JOptionPane.showInputDialog(null, "Please enter side opposite: ", "Trigonometry calculator", JOptionPane.QUESTION_MESSAGE);
        double opposite = Double.parseDouble(input1);
        
        String option = JOptionPane.showInputDialog(null, "Please enter your options of either sin, cos or tan: ", "Trigonometry Calculator", JOptionPane.QUESTION_MESSAGE);
        
        int angle;
        double sin,cos,tan;
        double longestSide = (adjacent*adjacent)+(opposite*opposite);
        double calcHypotenuse = Math.sqrt(longestSide);
        double hypotenuse = (double)Math.round(calcHypotenuse*10d)/10d;
        
        String chosen = "\nTrigonometry function chosen:";
        String message = "\n";
        
        switch(option){
            case "sin":
            case "sinus":
                sin = Math.round((opposite/hypotenuse)*10000d)/10000d;
                angle = (int)Math.round(Math.toDegrees(Math.asin(sin)));
                chosen += " sin Θ";
                message += "Hence the sin Θ = "+sin+"\nThe angle is: "+angle+"°";
                break;
            case "cos":
            case "cosine":
                cos = Math.round((adjacent/hypotenuse)*10000d)/10000d;
                angle = (int)Math.rint(Math.toDegrees(Math.acos(cos)));
                chosen += " cos Θ";
                message += "Hence the cos Θ = "+cos+"\nThe angle is: "+angle+"°";
                break;
            case "tan":
            case "tangent":
                tan = Math.round((opposite/adjacent)*10000d)/10000d;
                angle = (int)Math.rint(Math.toDegrees(Math.atan(tan)));
                chosen += " tan Θ";
                message += "Hence the tan Θ = "+tan+"\nThe angle is: "+angle+"°";
                break;
            default:
                option = "";
                chosen += " Invalid input. Try again";
                System.out.println("Invalid input. Please try again"+option);
                break;
        }
        
        message+= "\nThe type of triangle: ";
        
        
        if(isIsoscelesRightTriangle(adjacent,opposite))
            message+= "Right isosceles triangle";
        else
            message+= "Not a right isosceles triangle";
        JOptionPane.showMessageDialog(null,"Side Adjacent: "+adjacent+"\nSide Opposite: "+opposite+"\nHypotenuse: "+hypotenuse+chosen+message, "Trigonometry calculator", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public static double sin(double n){
        double sin_of_n = Math.sin(n);
        return sin_of_n;
    }
    public static double cos(double n){
        double cos_of_n = Math.cos(n);
        return cos_of_n;
    }
    public static double tan(double n){
        double tan_of_n = Math.tan(n);
        return tan_of_n;
    }
    public static boolean isIsoscelesRightTriangle(double a, double b){
        boolean isIt = false;
        if(a == b)
            isIt = true;
        return isIt;
    }
}

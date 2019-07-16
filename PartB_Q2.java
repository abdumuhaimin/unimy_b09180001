package gr_assignment;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * PartB_Q2.java
 * 
 * Remuneration System for UNIMY HR Department.
 * Firstly, this program will acquire the name of the user's department 
 * and the number of staffs working in the department. Next, the code will get
 * the name of the staff, the ID number, which is restricted to 7 characters
 * maximum compromising 3 letters for characters (example: UMM) and 4 digits
 * numbers (example: UMM0024) and their job designation via drop-down menu.
 * 
 * The system will also ask the user using confirm dialog box to ensure
 * the staff is a part-time and full-time employee. Part time job is only
 * applicable for the Promoters and Telemarketers position.
 * 
 * Once done, the user need to key in the total working hours from week 1
 * until week 4 (in a month) for each staff in the user's department.
 * Working hours per week must be between 40 to 90 hours (only for full time
 * employees) however for part timers cannot exceed more than 25 hours per week.
 *
 * @author Abdu Muhaimin Bin Hashim - B09180001
 * @version 1.0
 */
public class PartB_Q2 {
    public static void main(String[] args) {
        System.out.println("************UNIMY REMUNERATION SYSTEM************");
        String dept_input = JOptionPane.showInputDialog(null, "Enter your department: ", "UNIMY REMUNERATION SYSTEM", JOptionPane.QUESTION_MESSAGE);
        String staffs_number_input = JOptionPane.showInputDialog(null, "How many staffs are there?", "UNIMY REMUNERATION SYSTEM", JOptionPane.QUESTION_MESSAGE);
        System.out.println("Department       : "+dept_input.substring(0, 1).toUpperCase()+dept_input.substring(1));
        System.out.println("Total Staffs     : "+ staffs_number_input);

        int no_of_staffs = Integer.parseInt(staffs_number_input);
        String letters;
        String numbers;
        for(int i = 0; i < no_of_staffs; i++){
            System.out.println("***************PAY SLIP - JULY 2019**************");
            String name_of_staffs = JOptionPane.showInputDialog(null, "What is the name of the staff?", "UNIMY REMUNERATION SYSTEM", JOptionPane.QUESTION_MESSAGE);
            String staff_ID = JOptionPane.showInputDialog(null, "What is the staff ID?", "UNIMY REMUNERATION SYSTEM", JOptionPane.QUESTION_MESSAGE);
            String status[] = {"Full Time","Part Time"};
            Object selectedStatus = JOptionPane.showInputDialog(null, "Please choose the status of the employee", "UNIMY REMUNERATION SYSTEM", JOptionPane.QUESTION_MESSAGE, null, status, status[0]);
            String[] ft_jobs = {"Manager","Assistant Manager","Supervisor","Executive","Promoters","Telemarketers"};
            String[] pt_jobs = new String[2];
            System.arraycopy(ft_jobs, 4, pt_jobs, 0, 2);
            Object selectedJob;
//            String best_employee ="",worst_employee="",temp="";
//            int highest_working_hours = 0,lowest_working_hours = 0;
            if(selectedStatus == status[1])
                selectedJob = JOptionPane.showInputDialog(null, "Please choose the job designation", "UNIMY REMUNERATION SYSTEM", JOptionPane.QUESTION_MESSAGE, null, pt_jobs, pt_jobs[0]);
            else
                selectedJob = JOptionPane.showInputDialog(null, "Please choose the job designation", "UNIMY REMUNERATION SYSTEM", JOptionPane.QUESTION_MESSAGE, null, ft_jobs, ft_jobs[0]);
            
            while(staff_ID.length() != 7){
                JOptionPane.showMessageDialog(null, "Invalid staff ID. Please try again!", "UNIMY REMUNERATION SYSTEM", JOptionPane.ERROR_MESSAGE);
                name_of_staffs = JOptionPane.showInputDialog(null, "What is the name of the staff?", "UNIMY REMUNERATION SYSTEM", JOptionPane.QUESTION_MESSAGE);
                staff_ID = JOptionPane.showInputDialog(null, "What is the staff ID?", "UNIMY REMUNERATION SYSTEM", JOptionPane.QUESTION_MESSAGE);
            }
            letters = staff_ID.substring(0, 3);
            numbers = staff_ID.substring(3, 7);
            for(char c : letters.toCharArray()){
                while(!isLetter(c)){
                    JOptionPane.showMessageDialog(null, "Invalid staff ID. First three characters are not letters. Please try again!", "UNIMY REMUNERATION SYSTEM", JOptionPane.ERROR_MESSAGE);
                    name_of_staffs = JOptionPane.showInputDialog(null, "What is the name of the staff?", "UNIMY REMUNERATION SYSTEM", JOptionPane.QUESTION_MESSAGE);
                    staff_ID = JOptionPane.showInputDialog(null, "What is the staff ID?", "UNIMY REMUNERATION SYSTEM", JOptionPane.QUESTION_MESSAGE);
                    break;
                }
            break;
            }
            for(char d : numbers.toCharArray()){
                while(!isDigit(d)){
                    JOptionPane.showMessageDialog(null, "Invalid staff ID. The last 4 characters are not numbers. Please try again!", "UNIMY REMUNERATION SYSTEM", JOptionPane.ERROR_MESSAGE);
                    name_of_staffs = JOptionPane.showInputDialog(null, "What is the name of the staff?", "UNIMY REMUNERATION SYSTEM", JOptionPane.QUESTION_MESSAGE);
                    staff_ID = JOptionPane.showInputDialog(null, "What is the staff ID?", "UNIMY REMUNERATION SYSTEM", JOptionPane.QUESTION_MESSAGE);
                    break;
                }
            break;
            }
            System.out.println("Name        : "+capitalize(name_of_staffs));
            System.out.println("Staff ID    : "+staff_ID.substring(0, 3).toUpperCase()+staff_ID.substring(3));
            System.out.println("Status      : "+selectedStatus);
            System.out.println("Position    : "+selectedJob);
            
            System.out.println("********************* INCOME *********************");
            System.out.println("Working Hours\tReason\t\tPer-Hour\tTotal");
            int validReason;
            List<String> reason = new ArrayList<>();
            reason.add("AL");
            reason.add("MC");
            reason.add("EL");
            reason.add("Others");
            Object options[] = reason.toArray();
            Object selectedReason;
            double perHourSalary = 0;
            double total = 0;
            int validWorkingHours = 0;
            boolean validWorkHours = true;
            double allowance = 0;
            String extra_bonus;
            int percentage_reward = 0;
            double reward_money = 0;
            String howManyDays = "";
            int deductLate = 0;
            int counterWeeks = 0;
            
            
            for(int week = 1; week <= 4; week++){
                System.out.print("Week "+week+" : ");
                int workHours = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the total working hours for "+capitalize(name_of_staffs)+" on week "+week+"?", "UNIMY REMUNERATION SYSTEM", JOptionPane.QUESTION_MESSAGE));
                if(selectedStatus == status[0]){
                    System.out.print(workHours+"\t");
                    if(selectedJob == ft_jobs[0]){
                        perHourSalary = 58.85;
                        allowance = 1000;
                    }
                    else if(selectedJob == ft_jobs[1]){
                        perHourSalary = 32.45;
                        allowance = 800;
                    }
                    else if(selectedJob == ft_jobs[2]){
                        perHourSalary = 15.39;
                        allowance = 300;
                    }
                    else if(selectedJob == ft_jobs[3]){
                        perHourSalary = 12.67;
                        allowance = 100;
                    }
                    else if(selectedJob == ft_jobs[4]){
                        perHourSalary = 8.89;
                    }
                    else if(selectedJob == ft_jobs[5]){
                        perHourSalary = 5.34;
                    }
                    if(workHours >= 40 && workHours <= 90){
                        System.out.print("-\t\t");
                        counterWeeks++;
                    }
                    else if(workHours < 40 && workHours >=0){
                        validReason = JOptionPane.showConfirmDialog(null, "Any valid reason why the total working hours is less than 40?", "UNIMY REMUNERATION SYSTEM", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(validReason == 0){
                            selectedReason = JOptionPane.showInputDialog(null, "What is your reason?\nAL - Annual Leave\nMC - Medical Leave\nEL - Emergency Leave\nOthers - Other reasons", "UNIMY RENUMERATION SYSTEM", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                            System.out.print(selectedReason+"\t\t");
                            validWorkHours = true;
                        }  
                        else{
                            reason.add("Not Given\t");
                            System.out.print(reason.get(4));
                            validWorkHours = false;
                        }
                    }    
                    else
                        JOptionPane.showMessageDialog(null, "Error. Invalid total working hours. Please try again!", "UNIMY REMUNERATION SYSTEM", JOptionPane.ERROR_MESSAGE);
                    
                    System.out.print(perHourSalary+"\t");

                    if(validWorkHours){
                        System.out.printf("\tRM%.2f",totalIncome(workHours,perHourSalary));
                        validWorkingHours += workHours;
                        total += totalIncome(workHours,perHourSalary);
                    }
                    else {
                        System.out.print("\tIncomplete");
                    }
                    
                    
                }
                else if(selectedStatus == status[1]){
                    if(workHours <= 25)
                        System.out.print(workHours+"\t");
                    else
                        JOptionPane.showMessageDialog(null, "Error. Invalid total working hours. Please try again!", "UNIMY REMUNERATION SYSTEM", JOptionPane.ERROR_MESSAGE);
                }
                System.out.println();
            }
            System.out.println("Total valid working hours: "+validWorkingHours+"\t\t   ----------------");
            System.out.print("\t\t\t\t\t    Total: ");
            System.out.printf("RM%.2f",total);
            
            
            int lateOrNot = JOptionPane.showConfirmDialog(null, "Did you come late this week?", "Late Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
            if(validWorkingHours > 60 && lateOrNot == 1 &&(selectedJob == ft_jobs[2]||selectedJob == ft_jobs[3])){
                double extra_bonus_weekly = 150;
                extra_bonus_weekly *= counterWeeks;
                extra_bonus = Double.toString(extra_bonus_weekly);
            }
            else{
                extra_bonus = "-";
            }
                    
            if(lateOrNot == 0){
                howManyDays = JOptionPane.showInputDialog(null, "How many days does "+name_of_staffs+" comes late?", "Days of latecoming", JOptionPane.QUESTION_MESSAGE);
                int days = Integer.parseInt(howManyDays);
                deductLate = deduct(days);
            }
            
            double gross_pay;
            
            System.out.println();
            System.out.println("***********************ALLOWANCE/REWARDS/B0NUS*******************************");
            System.out.printf("Allowance             :  RM%.2f",allowance);
            System.out.println();
            if(!extra_bonus.equals("-")){
                System.out.printf("Extra Bonus           :  RM%.2f",Double.parseDouble(extra_bonus));
                System.out.println();
            }
            else {
                System.out.println("Extra Bonus           :  RM-");
            }
            
            if(validWorkingHours < 180){
                System.out.println("Reward("+percentage_reward+"%)            :  RM-");
            }
            else if(validWorkingHours >= 180 && validWorkingHours < 220){
                percentage_reward = 1;
                reward_money = reward(percentage_reward,total);
                System.out.printf("Reward("+percentage_reward+"%s)            :  RM%.2f","%",reward_money);
            }
            else if(validWorkingHours >= 220 && validWorkingHours < 280){
                percentage_reward = 3;
                reward_money = reward(percentage_reward,total);
                System.out.printf("Reward("+percentage_reward+"%s)            :  RM%.2f","%",reward_money);
            }
            else if(validWorkingHours >= 280){
                percentage_reward = 8;
                reward_money = reward(percentage_reward, total);
                System.out.printf("Reward("+percentage_reward+"%s)            :  RM%.2f","%",reward_money);
            }
            if(!extra_bonus.equals("-")){
                gross_pay = total + allowance + Double.parseDouble(extra_bonus) + reward_money;
            }
            else {
                gross_pay = total + allowance + reward_money;
            }
            System.out.println();
            System.out.printf("Gross Pay             :  RM%.2f",gross_pay);
            
            System.out.println();
            System.out.println("*********************** PENALTIES ******************************");
            System.out.print((Integer.parseInt(howManyDays)!= 0) ? "Late in: "+howManyDays+" days" : "Late in: 0 days");
            System.out.println("Late-in penalties: RM"+deductLate);
            double newGrossPay = gross_pay-deductLate;
            System.out.printf("New gross pay after penalties : RM%.2f",newGrossPay);
            System.out.println();
            System.out.println("*********************** DEDUCTION *****************************");
            double epf = (double) Math.round((11*newGrossPay/100)*100)/100;
            double socso = (double) Math.round(((0.5/100)*newGrossPay)*100)/100;
            double income_tax = (double) Math.round((3*newGrossPay/100)*100)/100;
            
            double total_deduction = 0;
            if(selectedStatus == status[0]){
                System.out.printf("EPF (11%s)            : RM%.2f","%",epf);
                System.out.println();
                System.out.printf("SOCSO(0.5%s)          : RM%.2f","%",socso);
                System.out.println();
                if(newGrossPay > 2500){
                    System.out.printf("INCOME TAX(3%s)       : RM%.2f","%",income_tax);
                    total_deduction = epf+socso+income_tax;
                }   
                else{
                    System.out.println("INCOME TAX(3%)       : RM-");
                    total_deduction = epf+socso;
                }
                System.out.println();
                System.out.printf("TOTAL DEDUCTION      : RM%.2f",total_deduction);
                System.out.println();
            }
            
            else{
                System.out.println("NOT APPLICABLE");
            }
            System.out.println();
            System.out.println("*********************** NET PAY *****************************");
            double net_pay = newGrossPay - total_deduction;
            System.out.printf("NET PAY                   : RM%.2f",net_pay);
            System.out.println("*************************************************************");
//            temp = name_of_staffs;
//            if(validWorkingHours>highest_working_hours && Integer.parseInt(howManyDays) == 0 && selectedStatus == status[0]){
//                best_employee = name_of_staffs;
//                highest_working_hours = validWorkingHours;
//            }
//            else {
//                best_employee = "None";
//            }
//            
//            if(validWorkingHours < lowest_working_hours && selectedStatus == status[0] && Integer.parseInt(howManyDays) != 0){
//                worst_employee = name_of_staffs;
//                lowest_working_hours = validWorkingHours;
//            }
//            else {
//                worst_employee = "None";
//            }
        }
        
    }
    
    public static String capitalize(String s) {
        if ((s == null) || (s.trim().length() == 0)) {
           return s;
        }
        s = s.toLowerCase();
        char[] charArray = s.trim().toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);
        for (int i = 0; i < charArray.length; i++) {
           if (charArray[i] == ' ' && (i + 1) < charArray.length) {
             charArray[i + 1] = Character.toUpperCase(charArray[i + 1]);
           }
           if (charArray[i] == '-' && (i + 1) < charArray.length) {
             charArray[i + 1] = Character.toUpperCase(charArray[i + 1]);
           }
           if (charArray[i] == '\'' && (i + 1) < charArray.length) {
             charArray[i + 1] = Character.toUpperCase(charArray[i + 1]);
           }
        }
        return new String(charArray);
    }

    private static double totalIncome(int workHours, double perHourSalary) {
        return workHours*perHourSalary;
    }

    private static int deduct(int days) {
        return 30*days;
    }
    private static double reward(int weightage,double total){
        double n = (weightage*total)/100;
        return (double)(n*100)/100;
    }
}
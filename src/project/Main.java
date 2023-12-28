
package project;
import project.model.*;
import java.util.Scanner;
import project.controller.MainExecution;
import project.controller.HelpingMethods;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //creatiung the scanner variable
        
        
        int maxCusterms = Integer.parseInt(in.nextLine());
        int days = Integer.parseInt(in.nextLine());
        
        //creating a variable for the max number of customrs in inLine and reading it
        //reading the number of days 
        
        System.out.println("Welcome to the Car Clean Simulator\n");
        
        for(int i = 1; i<= days; i++)
        {
            //looping over the number of days and printing the day
            
            System.out.printf("**********\n" +
                    "Day %d:\n" +
                    "**********\n\n", i);
            
            CarQueue outLine = new CarQueue();
            CarQueue inLine = new CarQueue();
            Vouchers vouchers = new Vouchers();
        
            //initialising the 2 queues (outline and inline) and the vouchers stack
            
            int wash = in.nextInt();
            int wax = in.nextInt();
            int vac = in.nextInt();
            in.nextLine();
            //reading the time needed to wash wax and vacuum for the day
            //and daving them in the variables 
            
            int commands = Integer.parseInt(in.nextLine());
            //reading the number of commands in the day
            
            for(int j = 0; j< commands; j++)
            {
                //looping over all the comands and adding them into their queues and stakcs using the addCommand method
                //we split the input by pace and send the list of strings
                HelpingMethods.addCommand(in.nextLine().split(" "), outLine);
            }
            
            MainExecution.mainExecution(outLine, inLine, vouchers, wash, wax, vac, maxCusterms);
            //call the method that executes everything 
            
            HelpingMethods.lowlyMinion(360, vouchers);
            //and calling the lowlyMinion methon one for time at the end at 4PM
            
        }
    }

   
    
}


package project.controller;

import project.model.*;

public class HelpingMethods {
    public static void addCommand(String[] line, CarQueue outLine)
    {
        Member newMember = new Member(Integer.parseInt(line[0]), -1,
                Integer.parseInt(line[1]), line[2], line[3], line[4], -1, null);

        //creating a new client object with information from the input
        
        outLine.enqueue(newMember);
        //enqueue ing the new client in the outLine queue

    }
    public static void lowlyMinion(int time, Vouchers vouchers)
    {
        String timeString = numberToTime(time);

        //getting the current time in a string

        System.out.printf("%s:  LOWLY Minion came and collected the following vouchers:\n", timeString);
        //printing the initial message

        while(!vouchers.isEmpty())
        {
            Voucher temp = vouchers.pop();
            //saving the top of the stack in a temp variable

            System.out.printf("           %s %s (%d)\n", temp.getFirstName(), temp.getLastName(), temp.getID());

            //and print the message for the voucher 
        }
        System.out.println("\n");
    }

    public static int timeToBeServiced(Member member, int wash, int wax, int vac)
    {
        //we check the code of the custmoer and return the number of minutes
        //needed to finish the service
        if(member.getCode().equals("W"))
            return wash;
        else if(member.getCode().equals("WW"))
            return wash + wax;
        else
            return wash + wax + vac;
    }

    public static String numberToTime(int nr)
    {
        //this will turn a number into the sepcific time
        int hour = nr / 60;
        int min = nr % 60;

        //saving the hour and minutes past 8AM
        String time;
        //creating the variable that will save the time as a string

        String mins;
        //mins will hold the string of minutes

        if(min > 9)
            mins = "" + min;
        else
            mins = "0" + min;

        //this is for the aragement of the text in the time 

        if(hour == 2)
        {
            //this is the case for 12PM
            time = "12:" + mins + " PM";
        }
        else if(hour > 2)
        {
            time = " " + (hour - 2) + ":" + mins + " PM";
            //this cae if for PM times after 12 PM
        }
        else
            time = "" + (10 + hour) + ":" + mins + " AM";
        //this case is for times in AM

        return time;
    }
}

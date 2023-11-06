//Name: Vladimir Cuc
//ID: 1282672
//Date: 11/03/2023
//FSC honor code: Be honest in all situations, academic and nonacademic, and to respect the rights and the property of others. Live in a manner that brings credit to themselves and to the College.


import java.util.*;


public class Main {
    
    public static void addCommand(String[] line, FSCcarwashQ outLine)
    {
        FSCmember newMember = new FSCmember(Integer.parseInt(line[0]), -1,
                Integer.parseInt(line[1]), line[2], line[3], line[4], -1, null);
        
        //creating a new client object with information from the input
        
        outLine.enqueue(newMember);
        //enqueue ing the new client in the outLine queue 

    }
    
    public static void mainExecution(FSCcarwashQ outLine, FSCcarwashQ inLine, FSCvouchers vouchers, int wash, int wax, int vac, int maxCusterms)
    {
        int i = -1;
        //initializing the timer
        
        int queueTime = 0;
        //creating a queueTime that saves how long is the current queue
        
        FSCmember curentCustomer = null;
        //creating a variable to remeber the customer that is currently serviced 
        
        while(true)
        {
            i++;
            //i increments as another minute passed by
            
            if(queueTime!=0)
                queueTime--;
            //if we have queue time it decrements cause a minute passed 
            
            
            if(outLine.isEmpty() && curentCustomer == null)
            {
                //we break if there in no one else in the outLine and there is no custmoer currently served 
                break;
            }
            
            //if there are no other people to come close the execution
            
            if(curentCustomer != null)
            {
                //if we have a customer that is being served
                if(i == curentCustomer.getTimeStarted() + timeToBeServiced(curentCustomer, wash, wax, vac))
                {
                    //and if the customer just finished being served
                    //we will print the details and get the next customer from inLine
                    int servedTime = timeToBeServiced(curentCustomer, wash, wax, vac);
                    //saving the time it took to serve the car in a variable 
                    
                    String time = numberToTime(i);
                    System.out.printf("%s:  The car for %s %s is now finished.\n" +
                "           Waiting time in line: %d minutes\n" +
                "           Service time: %d minutes\n" +
                "           Total time: %d minutes\n", time, curentCustomer.getFirstName(), curentCustomer.getLastName(),
                curentCustomer.getMinutesRemaining(), servedTime, servedTime + curentCustomer.getMinutesRemaining());
                    //we printed all necesarry details for the car just fiished 
                    if(!inLine.isEmpty())
                    {
                        curentCustomer = inLine.dequeue();
                        //if the inLine is not empty and there is someone waiting in line
                        //change the served customer with the next customer in the inLine
                        //and at the same time we dequeue that customer form the inLine
                        //we also print the details of the next car after
                        System.out.printf("%s:  %s %s has now started Class %s service.\n",
                                time, curentCustomer.getFirstName(), curentCustomer.getLastName(), curentCustomer.getCode());
                        FSCvoucher newVoucher = new FSCvoucher(curentCustomer.getArrivalTime(), curentCustomer.getID(), curentCustomer.getFirstName(), curentCustomer.getLastName(),
                                curentCustomer.getCode(), curentCustomer.getArrivalTime()+ curentCustomer.getMinutesRemaining(),
                                curentCustomer.getArrivalTime()+ curentCustomer.getMinutesRemaining() + timeToBeServiced(curentCustomer, wash, wax, vac), null);

                        //creating a new ticket with the details from this new customer saved in temp

                        vouchers.push(newVoucher);

                        //and pushing the new voucher in the stack of vouchers 
                    }
                    else
                        curentCustomer = null;
                    
                    //if the inLine is empty the current customer becomes null
                }
                
            }

            while(!outLine.isEmpty() && i == outLine.peekArrivalTime())
            {
                if(outLine.peek().getCode().equals("Z"))
                {
                    lowlyMinion(i, vouchers);
                    outLine.dequeue();
                }
                else
                {
                    if(maxCusterms == inLine.getNumCustomers())
                    {
                        //if the number of people in the inLine is already at full we just print the deny message
                        FSCmember temp = outLine.dequeue();
                        String time = numberToTime(i);
                        //we save the person in a varible and dequeue it form the outLine
                        //and print the details
                        System.out.printf("%s:  %s %s arrived at the FSC Car Clean. Unfortunately, "
                                + "the Wash Queue is full, and the customer left disappointed.\n", time, temp.getFirstName(), temp.getLastName());
                    }
                    else
                    {
                        //if the inLine is not already full
                        FSCmember temp = outLine.dequeue();
                        inLine.enqueue(temp);
                        //getting the front from the outLine and putting it in the back of the inLine queue 
                        //saving the member in a temp varibale 

                        



                        if(queueTime == 0)
                        {
                            //if there is no one currently in service
                            //the client will be served a he arrives 
                            temp.setTimeStarted(i);
                            temp.setMinutesRemaining(0);
                            curentCustomer = temp;
                            //setting the time started and the minutes remaming until the client will be served
                            //also seving him in the current Customer variable

                            queueTime += timeToBeServiced(curentCustomer, wash, wax, vac);
                            //incrementing the queue time depending on the service choce by the custmer

                            String time = numberToTime(i);
                            //turning the number of minutes past 8AM to string of time in AM or PM

                            System.out.printf("%s:  %s %s arrived at the FSC Car Clean and immediately"
                                    + " started Class %s service.\n", time, curentCustomer.getFirstName(), curentCustomer.getLastName(),
                                    curentCustomer.getCode());

                            //printing the initial statement that the customer is already being served 

                            inLine.dequeue();

                            //we also dequeue the current customer as it is not in the quese anymore 
                            
                            FSCvoucher newVoucher = new FSCvoucher(temp.getArrivalTime(), temp.getID(), temp.getFirstName(), temp.getLastName(),
                                temp.getCode(), i + queueTime, i + queueTime + timeToBeServiced(temp, wash, wax, vac), null);

                            //creating a new ticket with the details from this new customer saved in temp

                            vouchers.push(newVoucher);

                            //and pushing the new voucher in the stack of vouchers 
                        }
                        else
                        {
                            //in this case the queue is not empty so the new arrival will to in the inquese
                            temp.setTimeStarted(i + queueTime);
                            temp.setMinutesRemaining(queueTime);

                            //setting up the starting time and minutes remaining in queue for the new customer

                            queueTime += timeToBeServiced(temp, wash, wax, vac);

                            //the queue become even larger now 

                            String time = numberToTime(i);
                            //turning the number of minutes past 8AM to string of time in AM or PM

                            System.out.printf("%s:  %s %s arrived at the FSC Car Clean and entered Wash Queue.\n",
                                    time, temp.getFirstName(), temp.getLastName());

                            //printing the initial statement that the customer is already being served 

                        }
                    }
  
                }
            
            }
        }
    }
    
    public static void lowlyMinion(int time, FSCvouchers vouchers)
    {
        String timeString = numberToTime(time);
        
        //getting the current time in a string
        
        System.out.printf("%s:  LOWLY Minion came and collected the following vouchers:\n", timeString);
        //printing the initial message
        
        while(!vouchers.isEmpty())
        {
            FSCvoucher temp = vouchers.pop();
            //saving the top of the stack in a temp variable
            
            System.out.printf("           %s %s (%d)\n", temp.getFirstName(), temp.getLastName(), temp.getID());
            
            //and print the message for the voucher 
        }
        System.out.println("\n");
    }
    
    public static int timeToBeServiced(FSCmember member, int wash, int wax, int vac)
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //creatiung the scanner variable
        
        
        int maxCusterms = Integer.parseInt(in.nextLine());
        int days = Integer.parseInt(in.nextLine());
        
        //creating a variable for the max number of customrs in inLine and reading it
        //reading the number of days 
        
        System.out.println("Welcome to the FSC Car Clean Simulator\n");
        
        for(int i = 1; i<= days; i++)
        {
            //looping over the number of days and printing the day
            
            System.out.printf("**********\n" +
                    "Day %d:\n" +
                    "**********\n\n", i);
            
            FSCcarwashQ outLine = new FSCcarwashQ();
            FSCcarwashQ inLine = new FSCcarwashQ();
            FSCvouchers vouchers = new FSCvouchers();
        
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
                addCommand(in.nextLine().split(" "), outLine);
            }
            
            mainExecution(outLine, inLine, vouchers, wash, wax, vac, maxCusterms);
            //call the method that executes everything 
            
            lowlyMinion(360, vouchers);
            //and calling the lowlyMinion methon one for time at the end at 4PM
            
        }
        
    }
    
}

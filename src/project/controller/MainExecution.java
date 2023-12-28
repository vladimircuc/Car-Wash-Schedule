package project.controller;

import project.model.*;
import project.controller.HelpingMethods;
public class MainExecution {
    
    public static void mainExecution(CarQueue outLine, CarQueue inLine, Vouchers vouchers, int wash, int wax, int vac, int maxCusterms){
        int i = -1;
        //initializing the timer

        int queueTime = 0;
        //creating a queueTime that saves how long is the current queue

        Member curentCustomer = null;
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
                if(i == curentCustomer.getTimeStarted() + HelpingMethods.timeToBeServiced(curentCustomer, wash, wax, vac))
                {
                    //and if the customer just finished being served
                    //we will print the details and get the next customer from inLine
                    int servedTime = HelpingMethods.timeToBeServiced(curentCustomer, wash, wax, vac);
                    //saving the time it took to serve the car in a variable

                    String time = HelpingMethods.numberToTime(i);
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
                        Voucher newVoucher = new Voucher(curentCustomer.getArrivalTime(), curentCustomer.getID(), curentCustomer.getFirstName(), curentCustomer.getLastName(),
                                curentCustomer.getCode(), curentCustomer.getArrivalTime()+ curentCustomer.getMinutesRemaining(),
                                curentCustomer.getArrivalTime()+ curentCustomer.getMinutesRemaining() + HelpingMethods.timeToBeServiced(curentCustomer, wash, wax, vac), null);

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
                    HelpingMethods.lowlyMinion(i, vouchers);
                    outLine.dequeue();
                }
                else
                {
                    if(maxCusterms == inLine.getNumCustomers())
                    {
                        //if the number of people in the inLine is already at full we just print the deny message
                        Member temp = outLine.dequeue();
                        String time = HelpingMethods.numberToTime(i);
                        //we save the person in a varible and dequeue it form the outLine
                        //and print the details
                        System.out.printf("%s:  %s %s arrived at the FSC Car Clean. Unfortunately, "
                                + "the Wash Queue is full, and the customer left disappointed.\n", time, temp.getFirstName(), temp.getLastName());
                    }
                    else
                    {
                        //if the inLine is not already full
                        Member temp = outLine.dequeue();
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

                            queueTime += HelpingMethods.timeToBeServiced(curentCustomer, wash, wax, vac);
                            //incrementing the queue time depending on the service choce by the custmer

                            String time = HelpingMethods.numberToTime(i);
                            //turning the number of minutes past 8AM to string of time in AM or PM

                            System.out.printf("%s:  %s %s arrived at the FSC Car Clean and immediately"
                                            + " started Class %s service.\n", time, curentCustomer.getFirstName(), curentCustomer.getLastName(),
                                    curentCustomer.getCode());

                            //printing the initial statement that the customer is already being served

                            inLine.dequeue();

                            //we also dequeue the current customer as it is not in the quese anymore

                            Voucher newVoucher = new Voucher(temp.getArrivalTime(), temp.getID(), temp.getFirstName(), temp.getLastName(),
                                    temp.getCode(), i + queueTime, i + queueTime + HelpingMethods.timeToBeServiced(temp, wash, wax, vac), null);

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

                            queueTime += HelpingMethods.timeToBeServiced(temp, wash, wax, vac);

                            //the queue become even larger now

                            String time = HelpingMethods.numberToTime(i);
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
    

}

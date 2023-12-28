
package project.model;


public class CarQueue {
    private Member front;
    private Member back;
    private int numCustomers;

    public CarQueue() {
        this.numCustomers = 0;
        front = back = null;
    }

    public Member getFront() {
        return front;
    }

    public Member getBack() {
        return back;
    }

    public int getNumCustomers() {
        return numCustomers;
    }

    public void setFront(Member front) {
        this.front = front;
    }

    public void setBack(Member back) {
        this.back = back;
    }

    public void setNumCustomers(int numCustomers) {
        this.numCustomers = numCustomers;
    }

    public boolean isEmpty()
    {
        return front == null;
    }

    public void enqueue(Member newCustomer)
    {
        if(isEmpty())
        {
            front = back = enqueue(newCustomer, front, back);
            //if the queue is empty both front and back will be the new client
        }
        else
        {
            back = enqueue(newCustomer, front, back);
            //else just the back changes
        }
    }

    private Member enqueue(Member newCustomer, Member front, Member back)
    {
        numCustomers++;
        if(isEmpty())
        {
            return newCustomer;
        }
        //if the queue is empty we return the new added client for both back and front
        else
        {
            back.setNext(newCustomer);
            back = back.getNext();
            return back;
            //set the new customer as the new back and make back point to this new object
            //then return the new back
        }

    }

    public Member dequeue(){
        numCustomers--;
        Member temp = front;
        //saving the front to be retuned
        front = dequeue(front, back);
        if(front == null)
            back = null;
        //setting up the new front and back

        return temp;
    }

    private Member dequeue(Member front, Member back)
    {
        Member temp = front;
        front = front.getNext();
        temp.setNext(null);
        return front;
    }

    public int peekArrivalTime()
    {
        return peerArrivalTime(front);
    }

    private int peerArrivalTime(Member front)
    {
        return front.getArrivalTime();

    }

    public Member peek()
    {
        return peek(front);
    }

    private Member peek(Member front)
    {
        return front;

    }

   
}

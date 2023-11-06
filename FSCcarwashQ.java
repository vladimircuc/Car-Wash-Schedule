
public class FSCcarwashQ {
    private FSCmember front;
    private FSCmember back;
    private int numCustomers;

    public FSCcarwashQ() {
        this.numCustomers = 0;
        front = back = null;
    }

    public FSCmember getFront() {
        return front;
    }

    public FSCmember getBack() {
        return back;
    }

    public int getNumCustomers() {
        return numCustomers;
    }

    public void setFront(FSCmember front) {
        this.front = front;
    }

    public void setBack(FSCmember back) {
        this.back = back;
    }

    public void setNumCustomers(int numCustomers) {
        this.numCustomers = numCustomers;
    }
    
    public boolean isEmpty()
    {
        return front == null;
    }
    
    public void enqueue(FSCmember newCustomer)
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
    
    private FSCmember enqueue(FSCmember newCustomer, FSCmember front, FSCmember back)
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
    
    public FSCmember dequeue(){
        numCustomers--;
        FSCmember temp = front;
        //saving the front to be retuned
        front = dequeue(front, back);
        if(front == null)
            back = null;
        //setting up the new front and back
        
        return temp;
    }
    
    private FSCmember dequeue(FSCmember front, FSCmember back)
    {
        FSCmember temp = front;
        front = front.getNext();
        temp.setNext(null);
        return front;
    }
    
    public int peekArrivalTime()
    {
        return peerArrivalTime(front);
    }
    
    private int peerArrivalTime(FSCmember front)
    {
        return front.getArrivalTime();
        
    }
    
    public FSCmember peek()
    {
        return peek(front);
    }
    
    private FSCmember peek(FSCmember front)
    {
        return front;
        
    }
    
}

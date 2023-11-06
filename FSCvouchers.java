
public class FSCvouchers {
    private FSCvoucher top;
    
    public FSCvouchers(){
        top = null;
    }

    public FSCvoucher getTop() {
        return top;
    }

    public void setTop(FSCvoucher top) {
        this.top = top;
    }
    
    public void push(FSCvoucher voucher)
    {
        top = push(top, voucher);
    }
    private FSCvoucher push(FSCvoucher top, FSCvoucher newVoucher)
    {
        newVoucher.setNext(top);
        top = newVoucher;
        return top;
    }
    
    public boolean isEmpty()
    {
        return top == null;
    }
    
    public FSCvoucher pop()
    {
        FSCvoucher temp = top;
        top = pop(top);
        
        return temp;
    }
    
    private FSCvoucher pop(FSCvoucher top)
    {
        FSCvoucher temp = top;
        top = top.getNext();
        temp.setNext(null);
        return top;
        
        //saving the top in a variable
        //setting its next to null
        //and returning the new top
        
    }
    
    public FSCvoucher peek()
    {
        FSCvoucher temp = peek(top);
        return temp;
    }
    
    private FSCvoucher peek(FSCvoucher top)
    {
        return top;
    }
}

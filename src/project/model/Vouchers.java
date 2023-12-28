package project.model;

public class Vouchers {
    private Voucher top;

    public Vouchers(){
        top = null;
    }

    public Voucher getTop() {
        return top;
    }

    public void setTop(Voucher top) {
        this.top = top;
    }

    public void push(Voucher voucher)
    {
        top = push(top, voucher);
    }
    private Voucher push(Voucher top, Voucher newVoucher)
    {
        newVoucher.setNext(top);
        top = newVoucher;
        return top;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public Voucher pop()
    {
        Voucher temp = top;
        top = pop(top);

        return temp;
    }

    private Voucher pop(Voucher top)
    {
        Voucher temp = top;
        top = top.getNext();
        temp.setNext(null);
        return top;

        //saving the top in a variable
        //setting its next to null
        //and returning the new top

    }

    public Voucher peek()
    {
        Voucher temp = peek(top);
        return temp;
    }

    private Voucher peek(Voucher top)
    {
        return top;
    }
}

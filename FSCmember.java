
public class FSCmember {
    private int arrivalTime;
    private int timeStarted;
    private int ID;
    private String firstName;
    private String lastName;
    private String code;
    private int minutesRemaining;
    private FSCmember next;

    public FSCmember(int arrivalTime, int timeStarted, int ID, String firstName, String lastName, String code, int minutesRemaining, FSCmember next) {
        this.arrivalTime = arrivalTime;
        this.timeStarted = timeStarted;
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.code = code;
        this.minutesRemaining = minutesRemaining;
        this.next = next;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getTimeStarted() {
        return timeStarted;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCode() {
        return code;
    }

    public int getMinutesRemaining() {
        return minutesRemaining;
    }

    public FSCmember getNext() {
        return next;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setTimeStarted(int timeStarted) {
        this.timeStarted = timeStarted;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMinutesRemaining(int minutesRemaining) {
        this.minutesRemaining = minutesRemaining;
    }

    public void setNext(FSCmember next) {
        this.next = next;
    }
    
    
}

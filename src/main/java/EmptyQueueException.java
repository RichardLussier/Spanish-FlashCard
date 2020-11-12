public final class EmptyQueueException extends RuntimeException {

    /**
     * This constructor will call the other constructor with null as its argument
     */
    public EmptyQueueException(){
        this(null);
    } //end of constructor

    /**
     * This constructor alows us to give an queues.EmptyQueueException error with a custom message
     * @param message: the message we would like to output to the user
     */
    public EmptyQueueException(String message){
        super(message);
    } //end of constructor
} //end of EmptyQueueException class

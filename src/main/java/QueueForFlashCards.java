import java.util.Queue;

/**
 * This class will holds the methods needed for our queue, which will
 * hold all of the unanswered flashcards.
 * @param <T>: The abstract data type in our queue
 */
public class QueueForFlashCards<T> implements QueueInterface<T> {

    private Node firstNode;
    private Node lastNode;

    public QueueForFlashCards(){
        firstNode = null;
        lastNode = null;
    } //end of constructor

    /**
     * This method adds a given entry to the end of the queue
     * @param anEntry: the item were putting at the end of the queue
     */
    public void enqueue(T anEntry) {
        Node newNode = new Node(anEntry, null);
        if(lastNode != null){
            lastNode.setNextNode(newNode);
        } //end of if
        else{
            firstNode = newNode;
        } //end of else
        lastNode = newNode;
    } //end of enqueue method

    /**
     * This method removes the item that is at the front of the queue
     * @return: the item that we are removing from the queue
     */
    public T dequeue() {
        T removed = firstNode.getData();
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();
        if(firstNode == null){
            lastNode = null;
        } //end of if
        return removed;
    } //end of dequeue method

    /**
     * This method looks at what is at the front of the queue, but doesn't remove it
     * @return: the item currently at the front of the queue
     */
    public T getFront() {
        if(isEmpty()){
            throw new EmptyQueueException("Tried to get the front of an empty queue.");
        } //end of if
        return firstNode.getData();
    } //end of getFront method

    /**
     * This method will check whether the queue is empty
     * @return: true if the queue is empty
     */
    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    } //end of isEmpty method

    /**
     * This method gets the size of our queue
     * @return: the size of the queue
     */
    public int getSize(){
        int size = 0;
        Node currentNode = firstNode;
        while(currentNode != null){
            size++;
            currentNode = currentNode.getNextNode();
        } //end of while
        return size;
    } //end of getSize method

    /**
     * This inner class is what we use to construct our nodes
     */
    private class Node{

        private T data = getData();
        private Node nextNode = getNextNode();

        /**
         * This constructor will call the other constructor with null as its next node
         * @param data: the data we want to have in our new node
         */
        public Node(T data){
            this(data, null);
        } //end of Node constructor

        /**
         * This constructor makes a new node with the given arguments
         * @param data: the data we want to store in our node
         * @param nextNode: the node that the new node is pointing to
         */
        public Node(T data, Node nextNode){
            setData(data);
            setNextNode(nextNode);
        } //end of Node constructor

        /**
         * This method retrieves the data in a node
         * @return: the data that is in the node
         */
        public T getData() {
            return data;
        } //end of getData method

        /**
         * This method sets the data of a given node to the argument passed
         * @param data: what we want the data portion of our node to be set to
         */
        public void setData(T data) {
            this.data = data;
        } //end of setData method

        /**
         * This method will retrieve the node that were pointing at
         * @return: the node that were pointing at
         */
        public Node getNextNode() {
            return nextNode;
        } //end of getNextNode method

        /**
         * This method will tell a node which node to point to
         * @param nextNode: the node we want to point to
         */
        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        } //end of setNextNode method
    } //end of Node inner class
} //end of QueueForFlashCards class

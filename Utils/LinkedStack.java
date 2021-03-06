package Utils;

public class LinkedStack {
    SinglyLinkedList list;
    int capacity;
    int size;
    public  LinkedStack(int allowedCapacity) {
        capacity = allowedCapacity;
        size=0;
        list = new SinglyLinkedList();
    }

    public int push(int value) throws Exception{
        if(!full()){
            LinkedNode newNode = new LinkedNode(value);
            list.insertBeginning(newNode);
            size++;
            return value;
        }else{
            throw new Exception("Stack capacity is full");
        }

    }

    public int pop() throws Exception {
        if(!this.empty()) {
            LinkedNode top = list.deleteAtBeginning();
            size--;
            return top.getData();
        }else {
            throw new Exception("Empty Stack !!");
        }

    }

    public int peek() throws Exception {
        if(!this.empty()) {
            LinkedNode top = list.getHead().getNext();
            return top.getData();
        }else{
            throw new Exception("Empty Stack !!");
        }

    }

    public boolean empty() {
        return (size == 0);
    }

    public boolean full(){
        return (size == capacity);
    }

    public LinkedNode getTop() {
        return list.getHead();
    }
}
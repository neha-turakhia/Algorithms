package Utils;

public class LinkedStack {
    SinglyLinkedList list;

    LinkedStack() {
        list = new SinglyLinkedList();
    }

    public int push(int value) {
        LinkedNode newNode = new LinkedNode(value);
        list.insertBeginning(newNode);
        return value;
    }

    public int pop() {
        if(!this.empty()) {
            LinkedNode top = list.deleteAtBeginning();
            return top.getData();
        }else {
            return -1;
        }

    }

    public int peek() {
        if(!this.empty()) {
            LinkedNode top = list.getHead().getNext();
            return top.getData();
        }else{
            return -1;
        }

    }

    public boolean empty() {
        return (list.getHead().getNext() == null);
    }
}
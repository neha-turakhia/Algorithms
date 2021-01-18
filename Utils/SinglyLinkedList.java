package Utils;

public class SinglyLinkedList {
    int length;
    LinkedNode head; //this is a dummy head pointer

    public SinglyLinkedList() {
        this.head = new LinkedNode();
        length = 0;
    }

    public void insertBeginning(LinkedNode node) {
       LinkedNode nextHead = head.getNext();
       node.setNext(nextHead);
       head.setNext(node);
       length++;
    }

    public void insetAtIndex(int index,LinkedNode node){
        if(index > length) index = length;
        LinkedNode current = head;
        for(int k=0;k < index && k < length;++k) {
            current = current.getNext();
        }
        LinkedNode nextPtr = current.getNext();
        current.setNext(node);
        node.setNext(nextPtr);
        length++;
    }

    public void insertEnd(LinkedNode node) {
         insetAtIndex(length,node);
    }

    public int getLength() {
        return length;
    }

    public LinkedNode getNodeAtIndex(int index){
        if(index > length) return null;
        LinkedNode current = head;
        int k=0;
        while(k <= index) {
            current = current.getNext();
            k++;
        }
        return current;
    }

    public LinkedNode deleteAtBeginning() {
        LinkedNode delNode = head.getNext();
        head.setNext(delNode.getNext());
        delNode.setNext(null);
        length--;
        return delNode;
    }

    public LinkedNode deleteAtIndex(int index){
        if(index > length) return null;
        LinkedNode current = head;
        int k=0;
        while(k < index) {
            current = current.getNext();
            k++;
        }
        LinkedNode delNode=current.getNext();
        if(delNode != null) {
            LinkedNode nextNode = delNode.getNext();
            current.setNext(nextNode);
            delNode.setNext(null);
            length--;
        }
        return delNode;
    }

    public LinkedNode deleteAtEnd() {
        return deleteAtIndex(length-1);
    }

}


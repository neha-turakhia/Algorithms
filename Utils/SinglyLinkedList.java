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

    public LinkedNode getHead() {
        return head;
    }

    public void insetAtIndex(int index, LinkedNode node){
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

    public int getIndex(LinkedNode node) {
        int index = -1;
        LinkedNode current = head.getNext();
        int k =0;
        while (current != null){
            if(current.equals(node)) {
                index = k;
                break;
            }
            k++;
            current = current.getNext();
        }
        return index;
    }

    public void deleteNextNode(LinkedNode node) {
        if(node != null){
            LinkedNode delNode = node.getNext();
            if(delNode != null){
                node.setNext(delNode.getNext());
                delNode.setNext(null);
            }
         }
    }

    public SinglyLinkedList insertAllAtEnd(LinkedNode head){
        LinkedNode current = head;

        while(current != null) {
            LinkedNode newNode = new LinkedNode(current.getData());
            this.insertEnd(newNode);
            current = current.getNext();
        }
        return this;
    }

    public void reverseList() {
        LinkedNode current = this.getHead().getNext();
        LinkedNode revList = null;

        while(current != null) {
            LinkedNode temp = current.getNext();
            current.setNext(revList);
            revList = current;
            current = temp;
        }

        this.length = 0;
        this.head = new LinkedNode();
        insertAllAtEnd(revList);

    }

}


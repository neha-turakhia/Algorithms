package Utils;

public class LinkedNode {
    private int data;
    private LinkedNode next;

    public LinkedNode() {
        this.data = 0;
        this.next = null;
    }

    public LinkedNode(int _data) {
        this.data = _data;
        this.next = null;
    }

    public LinkedNode(int _data,LinkedNode nextPtr) {
        this.data = _data;
        this.next = nextPtr;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedNode getNext() {
        return this.next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}
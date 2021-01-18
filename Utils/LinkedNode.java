package Utils;

public class LinkedNode {
    private int data;
    private LinkedNode next;
    private LinkedNode prev;

    public LinkedNode() {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    public LinkedNode(int _data) {
        this.data = _data;
        this.next = null;
        this.prev = null;
    }

    public LinkedNode(int _data,LinkedNode nextPtr) {
        this.data = _data;
        this.next = nextPtr;
        this.prev = nextPtr;
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

    public LinkedNode getPrev() {
        return prev;
    }

    public void setPrev(LinkedNode prev) {
        this.prev = prev;
    }
}
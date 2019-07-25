package queue;

//一种循环队列
public class MyCircularQueue {
    private int capacity,tail,head,count;
    private int[] elements;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.tail = 0;
        this.head = 0;
        this.count = 0;
        this.elements = new int[this.capacity];
    }

    public boolean enQueue(int value) {
        if (this.count == this.capacity){
            return false;
        }
        this.elements[tail++] = value;
        this.count ++;
        if (this.tail == this.capacity){
            this.tail = 0;
        }
        return true;
    }

    public boolean deQueue() {
        if (this.count == 0){
            return false;
        }
        this.head++;
        this.count--;
        return true;
    }

    public int Front() {
        if (this.count == 0){
            return -1;
        }
        return this.elements[this.head];
    }

    public int Rear() {
        if (this.count == 0){
            return -1;
        }
        int value = 0;
        this.tail -= 1;
        if (this.tail == this.head && this.count > 0){
            if (this.tail < 0){
                value = this.elements[this.capacity-1];
            }else{
                value = this.elements[this.tail];
            }
        }else{
            if (this.tail < 0){
                value = this.elements[this.capacity-1];
            }else{
                value = this.elements[this.tail];
            }
        }
        this.tail++;
        return value;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean isFull() {
        return this.count == this.capacity;
    }

}

import java.util.Deque;
import java.util.LinkedList;

class MyCircularDeque {
    Deque<Integer> deque;
    int k; 
    
    public MyCircularDeque(int k) {
        this.k = k; 
        deque = new LinkedList<>(); 
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            deque.addFirst(value);
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            deque.addLast(value);
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            deque.pollFirst(); 
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            deque.pollLast(); 
            return true;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1; 
        } else {
            return deque.getFirst();
        }
    }

    public int getRear() {
        if (isEmpty()) {
            return -1; 
        } else {
            return deque.getLast();
        }
    }

    public boolean isEmpty() {
        return deque.size() == 0;
    }

    public boolean isFull() {
        return deque.size() == k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

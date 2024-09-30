class Node{
    
    Node next;
    Node prev;
    int val;
    
    public Node(int val){
        this.val = val;
    }
    
}

class CustomStack {
    int maxSize;
    int size = 0;
    Node head;
    Node tail;
    
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        
        if (isFull()) {
            return;  
        }
        
        if(head==null){
            head = new Node(x);
            tail = head;
        }
        else{
            tail.next = new Node(x);
            tail.next.prev = tail;
            tail = tail.next;
        }
        size++;
    }
    
    public int pop() {
        if (!isEmpty()) {
            int value = tail.val;
            if (tail == head) {  
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
            return value;
        } else {
            return -1;
        }
    }
    
    public void increment(int k, int val) {
        if(size==0){
            return;
        }
        else{
            Node current = head;
            k = Math.min(k, size);
            while(k > 0 && current!=null){
                current.val = current.val + val;
                current = current.next;
                k--;
            }
        }
    }
    
    public boolean isFull(){
        return size==maxSize;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
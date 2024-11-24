class MinStack {
    Stack<Integer> elements;
    Stack<Integer> minElements;
    
    public MinStack() {
        elements = new Stack<>();
        minElements = new Stack<>();
    }
    
    public void push(int val) {
        elements.push(val);
         int minVal = 0;
        if(!minElements.isEmpty()){
             minVal = Math.min(minTop(), val);
        }
        else{
             minVal = val;
        }
        minElements.push(minVal);
    }
    
    public void pop() {
        if(!elements.isEmpty()){
            elements.pop();
            minElements.pop();
        }
    }
    
    public int minTop() {
        return minElements.peek();
    }
    
    public int top() {
        return elements.peek();
    }
    
    public int getMin() {
        return minElements.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
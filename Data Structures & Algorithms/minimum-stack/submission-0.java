class Pair{
    private int value;
    private int minimum;
    public Pair( int value , int minimum ){
        this.value = value;
        this.minimum = minimum;
    }

    public int getValue(){
        return value;
    }

    public int getMinimum(){
        return minimum;
    }

    public void setValue( int value ){
        this.value = value;
    }

    public void setMinimum( int minimum ){
        this.minimum = minimum;
    }

    public String toString(){
        return "("+value+","+minimum+")";
    }
}
class MinStack {

    
    private List<Pair> list;
    
    private int min;
    
    public MinStack() {
        
        list = new ArrayList<>();
        
        min = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        if( value < min ){
            min = value;
        }
        list.add(new Pair(value,min));
        
    }
    
    public void pop() {
        if( list.isEmpty() ) return;
        if(list.get(list.size()-1).getValue() == min ){
            list.remove(list.size()-1);
            if( list.isEmpty() )  min = Integer.MAX_VALUE;
            else min = list.get(list.size()-1).getMinimum();
        }
        else {
            list.remove(list.size()-1);
        }
        
    }

    
    public int top() {
        return list.get(list.size()-1).getValue();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
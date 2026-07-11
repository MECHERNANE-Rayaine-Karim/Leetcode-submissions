class Solution {
    public int evalRPN(String[] tokens) {
        
        List<Integer> operands = new ArrayList<>();
        operands.add( Integer.parseInt( tokens[0] ));
        for( int i = 1 ; i < tokens.length ; i++ ){
           if( isOperator( tokens[i] ) ) {
                int left = operands.remove(operands.size()-2);
                int right = operands.remove(operands.size()-1);
                operands.add(caluculate(left,right,tokens[i]));
           }
           else{
                operands.add(Integer.parseInt( tokens[i] ));
           }
        }
        return operands.remove(operands.size()-1);
    }

    
    private boolean isOperator( String string ){
        return ( string.equals("+") || string.equals("-") || string.equals("/") || string.equals("*") );
    }
    private int caluculate( int leftSide , int rightSide , String op ){
        int result = 0;
        if( op.equals("+") ) result = leftSide + rightSide ;
        else if(op.equals("-") ) result = leftSide - rightSide ;
        else if(op.equals("/") ) result = leftSide / rightSide ;
        else result = leftSide * rightSide ;
        return result;
    }
}
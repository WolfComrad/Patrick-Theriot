class charStack {
    int top;
    char stack[];
   
    public void init() {
      top = -1;
      stack = new char[100];
    }
 
    public boolean isItEmpty() {
     boolean answer = false;
 
      if (top == -1) {
        answer = true;
      }
      return answer;
    }
 
    public char pop() {
      char c;
 
      c = stack[top];
      stack[top] = ' ';
      top--;
      return c;
    }
 
    public void push(char c) {
       top++;
       stack[top] = c;
    }
 
    public void showStack() {
     int k;
 
      for (k=0; k<=top; k++) {
        System.out.print(stack[k]);
      }
    }
  }
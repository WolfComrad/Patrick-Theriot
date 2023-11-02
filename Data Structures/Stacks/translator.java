public class translator {

    public char[] translate(String eq) {
     charStack post;
     charStack op;
     int k;
     char myChar, myOp;
  
     post = new charStack(); 
     post.init();
     op = new charStack();
     op.init();
  
     for (k=0; k<eq.length(); k++) {
  
       myChar = eq.charAt(k);
  
       if ((myChar >= '0') && (myChar <= '9')) {
         post.push(myChar);
       }
  
       else if ((myChar == '+') || (myChar == '-') || (myChar == '*') || (myChar == '/')) {
         op.push(myChar);
       }
  
       else if (myChar == ')') {
         myOp = op.pop();
         post.push(myOp);
       }
     }
  
     while (op.isItEmpty() == false) {
       myOp = op.pop();
       post.push(myOp);
     }
  
     post.showStack();
      return post.stack;
    }
   }
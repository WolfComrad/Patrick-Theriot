public class evaluator {
    public void evaluate(char[] eq) {
    
      charStack a;
      char myChar;
      int x,y,z;
      int k, num;
    
      a = new charStack();
      a.init();
    
      for(k=0; k<eq.length; k++) {
        myChar = eq[k];
    
        if ((myChar >= '0') && (myChar <= '9')) {
          num = myChar - '0';
          a.push((char)num);
        }
    
        else if (myChar == '+') {
          y = (int)a.pop();
          x = (int)a.pop();
          z = x+y;
          a.push((char)z);
        }
    
        else if (myChar == '-') {
          y = (int)a.pop();
          x = (int)a.pop();
          z = x-y;
          a.push((char)z);
        }
    
        else if (myChar == '*') {
          y = (int)a.pop();
          x = (int)a.pop();
          z = x*y;
          a.push((char)z);
        }
    
        else if (myChar == '/') {
          y = (int)a.pop();
          x = (int)a.pop();
          z = x/y;
          a.push((char)z);
        }
      }
    
      System.out.println((int)a.pop());
    }
    }
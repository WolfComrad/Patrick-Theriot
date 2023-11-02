public class validator {
    public boolean validate(String eq) {
  
      charStack s;
      int k;
      char myChar;
      boolean error = false;
  
      s = new charStack();
      s.init();
      
    for (k=0; k<eq.length(); k++) {
      myChar = eq.charAt(k);
  
      if(myChar == '(') {
        s.push(myChar);
      }
  
      else if (myChar == ')') {
        if (s.isItEmpty()) {
          System.out.println("ERROR: 2 many ')'");
          error = true;
        }
  
        else {
          s.pop();
        }
      }
    }
  
    if (!s.isItEmpty()) {
      System.out.println("ERROR: 2 many '('");
      error = true;
    }
  
      return error;
   }
  }
class linked {
    node front;
  
    void init() {
      front = null;
    }
  
    node makeNode(int num) {
      node myNode;
      myNode = new node();
      myNode.data = num;
      myNode.next = null;
      return myNode;
    }
  
     node findTail() {
      node current;
      current = front;
  
      while (current.next != null) {
        current = current.next;
      }
      return current;
    }
  
    void makeList(int len) {
      int k;
      node tail;
      init();
  
      for (k=0; k<len; k++) {
        if (k==0) {
          front = makeNode(k);
        }
          
        else {
          tail = findTail();
          tail.next = makeNode(k);
        }
      }
    }
  
    void showList() {
      node current;
      current = front;
  
      while (current != null) {
       System.out.print(current.data);
       current = current.next;
      }
      System.out.println();
    }
  
    node findNode(int num) {
      node current;
      boolean searching;
  
      if (num == front.data) {
        return front;
      }
  
      else {
        current = front;
        searching = true;
  
        if (front.data > num) {
          System.out.println("there was an error. Node not found.");
          searching = false;
        }
        
        else {
          while (searching) {
  
            if (current == null) {
                System.out.println("there was an error. Node was not found");
                searching = false;
              }
            else if (current.data == num) {
              searching = false;
              return current;
            }
            else {
              current = current.next;
            }
          }
        }
      }
      return null;
    }
  
    void addAfter(int given, int num) {
      node temp, found, current;
      current = front;
      temp = makeNode(num);
      boolean searching = true;
  
        while (searching) {
  
          if (current == null){
            searching = false;
            found = findNode(given);
            if (found == null) {
              System.out.println("Sorry");
            }
            else {
              temp.next = found.next;
              found.next = temp;
            }
          }
          else if (current.data == num) {
            System.out.println("there is a duplicate.");
            searching = false;
          }
         
          else {
            current = current.next;
          }
        }    
    }
  
    void delete(int num) {
      node current, pre;
      boolean searching;
      current = front;
      pre = current;
  
      if (num == front.data) {
        front = front.next;
        current.next = null;
      }
  
      else {
        searching = true;
  
        if (current.data > num) {
          System.out.println("Done searching. Number not found.");
        }
  
        else {
          
          while(searching) {
    
            if (current.data == num) {
              pre.next = current.next;
              current.next = null;
              searching = false;
            }
    
            else if (current.data < num) {
              pre = current;
              current = current.next;
    
              if (current == null) {
                System.out.println("Done searching. Number not found.");
                searching = false;
              }
            }
          }
        }
      }
    }
  }
class list {
  node front;

  void init() {
    front = null;
  }

  node makeNode(String given, int num) {
    node myNode;
    myNode = new node();
    myNode.word = given;
    myNode.intVal = num;
    myNode.next = null;
    return myNode;
  }

  node findTail() {
    node current;
    current = front;
    
    while(current.next != null) {
        current = current.next;
      }
    return current;
  }

  void makeList(int len) {
    int k;
    node tail;
    init();

    for (k=0; k<len; k++) {
      if (k == 0) {
        front = makeNode("test",k);
        
      }
      else {
        tail = findTail();
        tail.next = makeNode("hey",k);
      }
    }
  }

  void showList() {
    node current;
    current = front;

    while (current != null) {
      System.out.println(current.word);
      current = current.next;
    }
    System.out.println();
  }

  void insert(String given) {
    node pre, current, temp;
    boolean searching;
    current = front;
    pre = current;

    if (given == " ") {
      return;
    }

    int num = calculate(given);

    temp = makeNode(given ,num);

    if(front == null){
      front = temp;
    }
    else if (temp.intVal < front.intVal) {
      temp.next = current;
      front = temp;
    }
    else {
      searching = true;

      while (searching) {

        if (!(current.word).equals(given)) {
          if (temp.intVal < current.intVal) {
            pre.next = temp;
            temp.next = current;
            searching = false;
          }
          else if (current.next == null) {
            current.next = temp;
            searching = false;
          }
          else {
            pre = current;
            current = current.next;
          }
        }

        else {
          //System.out.println("There is a duplicate.");
          searching = false;
        }
      }
    }
  }

  void delete(String word) {
    node current, pre;
    current = front;
    pre = current;

    if ((front.word).equals(word)) {
      front = front.next;
      current.next = null;
    }

    else {
        
      while(!(current.word).equals(word)) {
        pre = current;
        current = current.next;
      }
      pre.next = current.next;
      current.next = null;
    }
  }

  int calculate (String word) {
    int val;
    val = 0;
    char c;
    boolean calculating = true;
    //System.out.println("word ="+word);
      c = word.charAt(0);
      
      if (c == ' ') {
        calculating = false;
      }

      while (calculating) {
      if (c >= 'a' && c <= 'z') {
        int a = c - 'a';

        if (word.length() == 1) {
          val = (a*676);
          calculating = false;
        }
  
        else if (word.length() == 2) {
          int b = word.charAt(1) - 'a';
          val = (a*676) + (b*26);
          calculating = false;
        }

        else {
          int b = word.charAt(1) - 'a';
          int z = word.charAt(2) - 'a';

          val = (a*676) + (b*26) + (z);
        }
        //System.out.println(val);
        calculating = false;
        }
      
    }
    return val;
  }

  void makeWord(String given) {
    char c;
    String s = "";

    queue myQueue = new queue();
    myQueue.init();

    for (int j=0; j<given.length(); j++) {
      c = given.charAt(j);

      if (c >= 'A' || c <= 'Z') {
        c = Character.toLowerCase(c);
      }

      if (c != ' ' && c != ',' && c != '.' && c != ';') {
        myQueue.push(c);
      }
      
      if ((c == ' ' || j == given.length() - 1) || s != "") {
        // String s = String.valueOf(myQueue);
        // System.out.println(s);
        
        while (myQueue.isItEmpty() == false) {
          s = s + myQueue.pop();
        }
       // System.out.println(s);
        
       if(s != ""){
        insert(s);
        myQueue.init();
        s = "";
       }
        // String s = readLine();
      }
    }
  }

  void index(char c) {
    node current = front;

    while ((current.word).charAt(0) < c) {
        current = current.next;
      }
    if (c == 'z') {
      front = current;
    }
    else if ((current.word).charAt(0) == c) {
      front = current;
      while ((current.next.word).charAt(0) == c) {
        current = current.next;
      }
      current.next = null;
    }
  }
}
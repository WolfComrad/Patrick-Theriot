class queue {
  int top, bottom;
  char s[] = new char[30];

  void init() {
    top = -1;
    bottom = 0;
  }

  void push(char c) {
    top++;
    s[top] = c;
  }

  char pop() {
    char c;
    c = s[bottom];
    bottom++;
    return c;
  }

  Boolean isItEmpty() {
    boolean answer = false;

    if (bottom > top || top == -1) {
      answer = true;
    }
    return answer;
  }
}
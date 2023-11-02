import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    linked l = new linked();

    //making the first list and printing it out.
    l.makeList(10);
    l.showList();

    //asking user how many nodes they want.
    System.out.println("\nHow many nodes do you want in your list?");

    Scanner given = new Scanner(System.in);
    int g = given.nextInt();

    //making the list with the users number of nodes and printing.
    linked newList = new linked();
    newList.makeList(g);
    newList.showList();

    //asking if they want to add a node.
    System.out.println("\nWould you like to add a node? (yes or no)");

    String answer = System.console().readLine();
    
    if (answer.equals("yes")) {
      System.out.println("Which node would you like to place it after? (number value)");

      g = given.nextInt();
      System.out.println("What is the value of the new node? (number value)");

      int v = given.nextInt();

      newList.addAfter(g, v);

      System.out.println("Here is your new list.");
      newList.showList();
    }
    else if (answer.equals("no")) {
      System.out.println("Ok.");
    }

    //asking if they want to delete a node.
    System.out.println("\nWould you like to delete a node? (yes or no)");

    String answerd = System.console().readLine();
    
    if (answerd.equals("yes")) {
      System.out.println("Which node would you like to delete? (number value)");

      int v = given.nextInt();

      newList.delete(v);

      System.out.println("Here is your new list.");
      newList.showList();
    }
    else if (answerd.equals("no")) {
      System.out.println("Ok.");
    }

    given.close();
  }
}
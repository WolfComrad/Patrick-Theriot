import java.util.Scanner;
// huidfspnfsipvsdbdvsip
class Main {
  public static void main(String[] args) {
    int answer = 0;
    System.out.println("Please give me a list or sentince of words.");

    String given = System.console().readLine();
    list newList = new list();
    
    System.out.println();
    newList.makeWord(given);
    System.out.println("Heres the list");
    newList.showList();
    System.out.println();

    Scanner s = new Scanner(System.in);
    Scanner inPut = new Scanner(System.in);

    while (answer != 5) {
      System.out.println("put 1 to make new list of words.\nput 2 to add a word to list.\nput 3 to delete a word from the list.\nput 4 to print out all words in the list that begin with a certain letter.\nput 5 to stop program.");
      answer = inPut.nextInt();

      if (answer == 1) {
        System.out.println("Please give me a list or sentince of words.");
        given = System.console().readLine();
        newList = new list();
      
        System.out.println();
        newList.makeWord(given);
        System.out.println("Heres the list");
        newList.showList();
        System.out.println();
      }

      if (answer == 2) {
        System.out.println("What word do you want to add?");
        String adding = System.console().readLine();

        newList.makeWord(adding);
        System.out.println("Here is the new list.");
        newList.showList();
        System.out.println();
      }

      else if (answer == 3) {
        System.out.println("What word do you want to delete?");
        String deleting = System.console().readLine();

        newList.delete(deleting);
        System.out.println("Here is the new list.");
        newList.showList();
        System.out.println();
      }

      else if (answer == 4) {
        System.out.println("Give me a letter and I will show you all the words beginning with it.");
        char letter = s.next().charAt(0);
        System.out.println();

        System.out.println("Here are all the words begining with " + letter + ".");
        newList.index(letter);
        newList.showList();
      }
      else if (answer == 5) {
        System.out.println("Exiting...");
      }
    }
    System.out.println("Program finished.");
    s.close();
    inPut.close();
  }
}
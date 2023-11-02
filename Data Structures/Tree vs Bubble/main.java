import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
//import java.io.PrintWriter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("numbers.txt");
        Scanner sc = new Scanner(file);
        int [] numbers = new int [1000];
        int i = 0;
        tree mytree = new tree();

        while (sc.hasNextLine()) {
           numbers[i++] = sc.nextInt();
            //System.out.println(sc.nextLine());
        }
      

        //System.out.println("i = "+i);

        int [] forBubbleSort = numbers;

        mytree.buildSimpleTree(numbers);
        treeNode first = mytree.root;

        //System.out.println("comparisons = "+mytree.comparisons);

        //PrintWriter treeWrite = new PrintWriter("treeList.txt");
        //treeWrite.print("test");
        PrintStream fileOut = new PrintStream("treeList.txt");
        System.setOut(fileOut);
        System.out.println("This is sorting with a tree.");
        mytree.inOrder(first);
        System.out.println("\nThis is the number of comparisons made: " + mytree.comparisons);
        //treeWrite.close();
        sc.close();
        fileOut.close();

        PrintStream fileOut2 = new PrintStream("bubbleList.txt");
        System.setOut(fileOut2);
        System.out.println("This is sorting with bubble sort.");

        bubble b = new bubble();
        b.bubbleSort(forBubbleSort);
        b.printArray(forBubbleSort);
        System.out.println("\nThis is the number of comparisons made: " + b.comp);
        fileOut2.close();
    }
}

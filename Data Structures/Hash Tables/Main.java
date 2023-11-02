import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("names.txt");
        Scanner sc = new Scanner(file);
        String [] names = new String [200];
        int i = 0;
        myTable hash = new myTable(new String[200]);
        myTable hash4 = new myTable(new String[400]);
        String [] names4 = new String [400];
        int j = 0;
        myTable hash7 = new myTable(new String[700]);
        String [] names7 = new String [700];
        int k = 0;
        myTable hash10 = new myTable(new String[1000]);
        String [] names10 = new String [1000];
        int s = 0;

        while (sc.hasNextLine()) {
           names[i++] = sc.nextLine();
        }
        
        //200
        hash.makeIt(names);
        hash.printIt();
        hash.collisionsAndWaste();
        sc.close();
        
        //400
        File file4 = new File("names.txt");
        Scanner sc4 = new Scanner(file4);

        while (sc4.hasNextLine()) {
            names4[j++] = sc4.nextLine();
         }
        hash4.makeIt(names4);
        hash4.printIt();
        hash4.collisionsAndWaste();
        sc4.close();

        //700
        File file7 = new File("names.txt");
        Scanner sc7 = new Scanner(file7);

        while (sc7.hasNextLine()) {
            names7[k++] = sc7.nextLine();
         }
        hash7.makeIt(names7);
        hash7.printIt();
        hash7.collisionsAndWaste();

        sc7.close();

        //1000
        File file10 = new File("names.txt");
        Scanner sc10 = new Scanner(file10);

        while (sc10.hasNextLine()) {
            names10[s++] = sc10.nextLine();
         }
        hash10.makeIt(names10);
        hash10.printIt();
        hash10.collisionsAndWaste();

        sc10.close();
    }
  }
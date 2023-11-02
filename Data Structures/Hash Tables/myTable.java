public class myTable {
    String [] myTable;
    int collisions, waste;

    public myTable(String[] myTable) {
        this.myTable = myTable;
    }

    void makeIt (String n[]) {
        int len = n.length;
        int i;
        String s;
        
        for (i=0; i<len; i++) {
            s = n[i];
            if (s != null) {
                int sVal = calculate(s);
                newHash(s, sVal, len);
            //howmanytimesused++;
            }
        }
    }    

    int calculate (String n) {
       // howmanytimesused++;
        int val, j;
        val = 0;
        char c;
        boolean calculating = true;
       
        for (j=0; j<n.length(); j++) {
        c = n.charAt(j);
        
        if (c == ' ') {
            calculating = false;
        }

        else if (c >= 'A' && c <= 'Z') {
            c = Character.toLowerCase(c);
        }
        while (calculating) {
            if (c >= 'a' && c <= 'z') {
                int a = c - 'a';
                int b = n.charAt(j+1) - 'a';
                int z = n.charAt(j+2) - 'a';

                val = (a*676) + (b*26) + (z);
                //System.out.println(val);
                calculating = false;
                }
            }
        }
        return val;
    }
//int howmanytimesused=0;
    void newHash(String s, int val, int len) {
        int index = (val * len) / 17575;
        //System.out.println(index);
        while (myTable[index] != null) {
           // howmanytimesused++;
            collisions++;
            index++;
        }
       // else {
            myTable[index] = s;
            // howmanytimesused++;
        //}
    }
    
    void printIt() {
        for(int i = 0; i < myTable.length; i++) {
           // howmanytimesused++;
            if (myTable[i] != null) {
               // howmanytimesused++;
                System.out.println(myTable[i]);
            }
        }
        
    }

    void collisionsAndWaste () {

        for(int i = 0; i < myTable.length; i++) {
            if (myTable[i] == null) {
                waste++;
            }
        }
        System.out.println("This is the number of collisions: " + collisions);
        System.out.println("This is how much is wasted: " + waste);
       // System.out.println("how many " + howmanytimesused);
    }
}

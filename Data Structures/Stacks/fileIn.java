import java.util.Scanner;

import java.io.*;

public class fileIn {
	String fname;

    public fileIn() {
    	System.out.println("Constructor");
    	getFileName();
    	readFileContents();
    }
    
    public void readFileContents()
    {
    	boolean looping;
    	DataInputStream in;
    	String line;
    	int j, len;
    	char ch;
      String sectionTitle = "";
    	
    	/* Read input from file and process. */
        try {
            in = new DataInputStream(new FileInputStream(fname));
            
            looping = true;
            while(looping) {
              
                /* Get a line of input from the file. */
                if (null == (line = in.readLine())) {
                    looping = false;
                    /* Close and free up system resource. */
                    in.close();
                }
                else {                  
                	System.out.println("line = "+ line);
                  boolean error = new validator().validate(line);
 
                  if(Character.isLetter(line.charAt(0)) && Character.isLetter(line.charAt(1))){
                    sectionTitle = line;
                  }
                  
                  if(!error && Character.isDigit(line.charAt(0)) || line.charAt(0) == '('){
                    char[] postfixArray = new char[100];
                    if(!sectionTitle.equals("postfix equation solving")) {
                      System.out.println("Postfix:");
                      postfixArray = new translator().translate(line);
                      System.out.println("");
                    }
                      
                    else{
                      postfixArray = line.toCharArray();
                    }
                    System.out.println("the answer is:");
                    new evaluator().evaluate(postfixArray);
                  }
                	j = 0;
                	len = line.length();
                }
            } /* End while. */
                	
        } /* End try. */
        
        catch(IOException e) {
            System.out.println("Error " + e);
        } /* End catch. */
    }
    
    public void getFileName()
    {
    	Scanner in = new Scanner(System.in);
    	
    	System.out.println("Enter file name please.");
    	fname = "Buff.txt";//in.nextLine();
    	System.out.println("You entered "+fname);
    }
}
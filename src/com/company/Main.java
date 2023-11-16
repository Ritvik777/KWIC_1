package com.company;

import com.company.adt.MasterControl;
import com.company.shared.SharedStorageMain;

import java.util.*;

/**
 * Master control class that creates all the objects and invokes all the methods needed to get the KWIC output.
 */
public class Main {

    public static final int INDEX_FIRST_ARGUMENT = 0;
    public static final int INDEX_SECOND_ARGUMENT = 1;
    private static final String FIRST_OPTION = "1";
    private static final String SECOND_OPTION = "2";
    public static final String INVALID_KWIC_ARGS = "No input file specified.\n"
            + "Usage: java com/company/Main <KWIC implementation type> <filename> [word to ignore]...";
    private static final String INVALID_KWIC_OPTION = "Invalid KWIC implementation. Usage:\n" +
            "Use 1 for Shared Storage Implementation.\n" +
            "Use 2 for ADT Implementation\n";

    public static void main(String[] args) throws Exception {
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
   /* 											CODE MODIFICATION FOR CSCI-250 KWIC Modularization 1
    * 
    * This code is for request 3 as per document that only accepts integers as input- uncomment to run the request 3
    *
    */
    /*	int[] inputArgsInt = new int[args.length - INDEX_SECOND_ARGUMENT];
    	for (int i = INDEX_SECOND_ARGUMENT; i < args.length; i++) {
    	    try {
    	    	inputArgsInt[i - INDEX_SECOND_ARGUMENT] = Integer.parseInt(args[i]);
    	    } catch (NumberFormatException e) {
    	        throw new Exception("Only integers are allowed as input.");
    	    }
    	}
    	
    	*/
        String[] inputArgs = Arrays.copyOfRange(args, INDEX_SECOND_ARGUMENT, args.length);
 

        if (args[INDEX_FIRST_ARGUMENT].equals(FIRST_OPTION)) {
            SharedStorageMain sharedStorageMain = new SharedStorageMain();
            
            
            
            
            
            
            
            
            
            /*										CODE MODIFICATION FOR CSCI-250 KWIC Modularization 1
             * 
             * 1 - As we created new method runInt(inputArgsInt) specifically for Integers input (Request 3) , so to run it uncomment it and comment the run(inputArgs) method. 
             */
            sharedStorageMain.run(inputArgs);   
           // sharedStorageMain.runInt(inputArgsInt);
            
            
        } else if (args[INDEX_FIRST_ARGUMENT].equals(SECOND_OPTION)) {
            MasterControl masterControl = new MasterControl();
            masterControl.run(inputArgs);
        } else {
            System.out.println(INVALID_KWIC_OPTION);
        }
    }

}
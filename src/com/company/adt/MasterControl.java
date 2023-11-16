package com.company.adt;

import com.company.adt.input.Input;
import com.company.adt.input.KwicInput;
import com.company.adt.output.KwicOutput;
import com.company.adt.output.Output;
import com.company.adt.shifter.KwicCircularShifter;
import com.company.adt.shifter.Shifter;
import com.company.adt.sorter.KwicAlphabetizer;
import com.company.adt.sorter.Sorter;

import java.util.Arrays;

import static com.company.Main.INDEX_FIRST_ARGUMENT;
import static com.company.Main.INDEX_SECOND_ARGUMENT;

public class MasterControl {
	
										//CODE MODIFICATION FOR CSCI-250 KWIC Modularization 1
    
	//As the whole code is following the Modularization 2 technique we just need to extend the interface and abstract classes rather than modifying of making new , thats the main point of using this technique.

    private Input input;
    private Shifter shifter;
    private Sorter sorter;
    private Output output;

    /**
     * Creates an instance of each of the modules.
     */
    private void initModules() {
        input = new KwicInput();
        shifter = new KwicCircularShifter(input);
        sorter = new KwicAlphabetizer(shifter);
        output = new KwicOutput(sorter);
    }

    public void run(String[] args) throws Exception {
        if (args.length == 0) {
            throw new Exception("No input file specified.\n"
                    + "Usage: java com/company/Main <filename> [word to ignore]...");
        }

        initModules();

        String filename = args[INDEX_FIRST_ARGUMENT];
        String[] keywords = Arrays.copyOfRange(args, INDEX_SECOND_ARGUMENT, args.length);
        
        
        
        //CODE MODIFICATION FOR CSCI-250 KWIC Modularization 2
        //Uncomment to run request 3 - only accepts Integers as Input
        //Here, the regular expression d+, which matches one or more digits, is used to filter out any elements that do not match. The last element is then converted to an integer using the mapToInt() method, and the resulting IntStream is then utilized to generate an int[] array using the toArray() method.
        
       int[] inputint = Arrays.stream(args)
                .skip(INDEX_SECOND_ARGUMENT)
                .filter(s -> s.matches("\\d+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        
        /* 											CODE MODIFICATION FOR CSCI-250 KWIC Modularization 2
         * 
         * This code is commented as it was for previous module 
         *
         */
       // input.processArguments(filename, keywords);
        input.processArgumentspecific(filename, keywords);
        //for request 3 - Integer Input only - comment to run
        //input.processArgumentsInt(filename, inputint);
        shifter.generateCircularShifts();
       // sorter.generateSortedList();
        sorter.reversegenerateSortedList();
        output.showOutput();
    }
}

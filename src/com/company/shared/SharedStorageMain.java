package com.company.shared;

import java.io.File;
import java.util.*;


import static com.company.Main.INDEX_FIRST_ARGUMENT;
import static com.company.Main.INVALID_KWIC_ARGS;

/**
 * Master control class that creates all the objects and invokes all the methods needed to get the KWIC output.
 */
public class SharedStorageMain {

    private List<Line> inputLines;
    private Set<String> wordsToIgnore;
    private List<CircularShift> circularShifts;
    private File inputFile;

    public SharedStorageMain() {
        inputLines = new ArrayList<>();
        wordsToIgnore = new HashSet<>();
        circularShifts = new ArrayList<>();
    }

    
    /* 	CODE MODIFICATION FOR CSCI-250 KWIC
     * 
     * Here to Implement the third request we have made the following changes :
     * 
     * 1 - Creating a new run method that only works when an input is a string to run the part three we need to uncomment the runInt method just right below the run method.
     * 2 - As we can see that everything information is shared we can see that the run method bellow calls the input method which takes string a input so we also have to create a new method for that too and we need to call that method from SharedStorageMain that also needs to be created new.
     * 
     * 
     */
    
   public void run(String[] inputArgs) throws Exception {
        input(inputArgs);
        circularShift();
        alphabetize();
        output();
    }
    /*
    public void runInt(int[] inputArgsInt) throws Exception {
        input(inputArgsInt);
        circularShift();
        alphabetize();
        output();
    }
*/
    
   
    
    /**
     * Reads data lines from input text file and stores them for processing by other modules.
     */
    
    
    public void input(String[] args) throws Exception {
        if (args.length == 0) {
            throw new Exception(INVALID_KWIC_ARGS);
        }

        inputFile = new File(args[INDEX_FIRST_ARGUMENT]);

        // Remaining args are the keywords that should be ignored.
        setWordsToIgnore(args);

        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            inputLines.add(new Line(line));
        }
    }
    
    
    /*												CODE MODIFICATION FOR CSCI-250 KWIC
     
     * Here as input method that was already defined takes string as input so we have to create a new input method that accepts only strings as input.
     * Uncomment to run Request 3 - Modularization 1 and comment other run method for string.
     * */

   /*
    public void input(int[] args) throws Exception {
        if (args.length == 0) {
            throw new Exception(INVALID_KWIC_ARGS);
        }

        inputFile = new File(Integer.toString(args[INDEX_FIRST_ARGUMENT]));

        // Remaining args are the keywords that should be ignored.
       // setWordsToIgnore(args);

        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            inputLines.add(new Line(line));
        }
    }
    */
    
    
    /* 												CODE MODIFICATION FOR CSCI-250 KWIC
     * 
     * setWordsToIgnore method was predefined for Modularization 1, Here we did the following steps:\
     * 
     * 1 - Removed the source code for the manual input of the words to ignore 
     * 2 - Modified and added the new method and code for noise elimination in KWIC for “a”, “an”, “the”, “and”, “or” (both upper and lower cases).
     * 3 - * Uncomment to run Request 3 - Modularization 1 and comment other run method for string.
	*/
    
    
    
    private void setWordsToIgnore(String[] Args) {
        String[] words = {"a", "an", "the", "and", "or"};
        for (String word : words) {
            wordsToIgnore.add(word);
            wordsToIgnore.add(word.toUpperCase()); //this takes care of upper case as well as lower case
        }
    }
    
    /*
    private void setWordsToIgnore(String[] args) {
        int numberOfArguments = args.length;
        if (numberOfArguments > 1) {
        	
            for (int i = INDEX_FIRST_ARGUMENT + 1; i < numberOfArguments; i++) {
                wordsToIgnore.add(args[i].toLowerCase());
            }
            
     }
     }
   
    */

    public void circularShift() {
        inputLines.forEach(line -> {
            int numberOfWords = line.getNumberOfWords();

            for (int wordIndex = 0; wordIndex < numberOfWords; wordIndex++) {
                String startWord = line.getWord(wordIndex);
                startWord = strip(startWord);
                if (!wordsToIgnore.contains(startWord.toLowerCase())) {
                    circularShifts.add(new CircularShift(line, wordIndex));
                }
            }
        });
    }

    /**
     * Remove first and/or last characters, if they are not letters or digits.
     * @param word String from which the characters are to be removed.
     * @return String which only consists of letters or digits.
     */
    private String strip(String word) {
        char firstChar = word.charAt(INDEX_FIRST_ARGUMENT);
        char lastChar = word.charAt(word.length() - 1);

        if (!Character.isDigit(firstChar) && !Character.isAlphabetic(firstChar)) {
            word = word.substring(INDEX_FIRST_ARGUMENT + 1);
        }

        if (word.length() > 0 && !Character.isDigit(lastChar) && !Character.isAlphabetic(lastChar)) {
            word = word.substring(INDEX_FIRST_ARGUMENT, word.length() - 1);
        }

        return word;
    }
    
    
    /* 															CODE MODIFICATION FOR CSCI-250 KWIC
     * 
     * alphabetize() method was predefined for Modularization 1 , Here we did the following steps:\
     * 
     * 1 - Removed the original alphabetize() method functioning.
     * 2 - Creating a new alphabetize() method that sorts the circular-shifts output in descending order.
     * 
     */

    /**
     * Sorts all the circular shifts in lexicographical order.
     */
   /* public void alphabetize() {
        Collections.sort(circularShifts);
    }
    */
    /**
     * Sorts all the circular shifts in reverse order.
     */
    public void alphabetize() {
        Collections.sort(circularShifts, Collections.reverseOrder());
    }

    /**
     * Outputs the list of all valid circular shifts of all lines in lexicographical order.
     */
    public void output() {
        circularShifts.forEach(System.out::println);
    }
}

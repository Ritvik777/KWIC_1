package com.company.adt.input;

import java.io.*;
import java.util.*;

/**
 * Processes the arguments and stores the KWIC input for processing by other modules.
 */
public class KwicInput implements Input{

    private List<Line> lines;

    /**
     * Collection of unique lowercase words that are to be ignored during the circular shifter process.
     */
    private Set<String> keywordsToIgnore;
    private Set<String> keywordsToIgnorespecific;

    public KwicInput() {
        lines = new ArrayList<>();
        keywordsToIgnore = new HashSet<>();
        keywordsToIgnorespecific = new HashSet<>();
    }

    private boolean isFileExists(File file) {
        return file.exists() && file.isFile();
    }

    /**
     * Reads data lines from input text file and stores them for processing by other modules.
     */
    private void readFile(String filePath) throws FileNotFoundException, IOException {
        File inputFile = new File(filePath);

        if (!isFileExists(inputFile)) {
            throw new FileNotFoundException();
        }

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                lines.add(new Line(inputLine));
            }
        } catch (IOException ioe) {
            System.out.println("IOException while reading file." + ioe.getStackTrace());
            throw ioe;
        }
    }

    private void readWordsToIgnore(String[] keywords) {
        for (String keyword: keywords) {
            keywordsToIgnore.add(keyword.toLowerCase());
        }
    
    }
    
    
    
    
    
    
    
    
    
    /*											CODE MODIFICATION FOR CSCI-250 KWIC	Modularization 2	
     * 1 -  Newly added for Modularization 2
     * 2 - Addition of new method readWordsToIgnorespecific() for sorting the noise elimination in KWIC that eliminates “a”, “an”, “the”, “and”, “or” (both upper and lower cases).
     */
    
    private void readWordsToIgnorespecific(Set<String> keywordsToIgnorespecific) {
        String[] words = {"a", "an", "the", "and", "or"};
        for (String word : words) {
        	keywordsToIgnore.add(word);
        	keywordsToIgnore.add(word.toUpperCase()); //this takes care of upper case as well as lower case
        }
    }
    
    
    
    @Override
    public void processArguments(String fileName, String[] keywordsToIgnore) throws FileNotFoundException, IOException {
        readFile(fileName);
        readWordsToIgnore(keywordsToIgnore);
    }

    @Override
    public List<Line> getInputLines() {
        return new ArrayList<>(lines);
    }

    @Override
    public Set<String> getKeywords() {
        return new HashSet<>(keywordsToIgnore);
    }
    
    
    
    
    
    

    
    /*											CODE MODIFICATION FOR CSCI-250 KWIC	Modularization 2	
     * 1 -  Newly added for Modularization 2
     * 2 - Addition of new method processArgumentspecific() for sorting the noise elimination in KWIC that eliminates “a”, “an”, “the”, “and”, “or” (both upper and lower cases).
     * 3 - As we are using interface and abstraction we are avoiding the data sharing among all modules.
     */
    
	@Override
	public void processArgumentspecific(String fileName, String[] keywordsToIgnoreSpecific) throws Exception {
		 readFile(fileName);
	     readWordsToIgnorespecific(keywordsToIgnorespecific);
	}
	
	//Request 3 - accept only Integer Arguments
/*
	public void processArgumentsInt(String fileName, int[] keywordsToIgnoreSpecific) throws Exception {
		 readFile(fileName);
	     readWordsToIgnorespecific(keywordsToIgnorespecific);
	}
*/	
}


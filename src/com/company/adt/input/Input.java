package com.company.adt.input;

import java.util.List;
import java.util.Set;

/**
 * Module that reads and stores the input to the program for processing by other modules.
 */
public interface Input {

    void processArguments(String fileName, String[] keywordsToIgnore) throws Exception;
    
    
    
    
    
    
    
    /*											CODE MODIFICATION FOR CSCI-250 KWIC	Modularization 2	
     * 1 -  Newly added for Modularization 2
     * 2 - Use of interface for data getters and setters.
     * 3 - Addition of new interface method processArgumentspecific() for sorting the noise elimination in KWIC that eliminates “a”, “an”, “the”, “and”, “or” (both upper and lower cases).
     */
    
    void processArgumentspecific(String fileName, String[] keywordsToIgnoreSpecific) throws Exception;
    
    
    //Request 3 - for processing only Integers , uncomment below to run request 3.
    
  //  void processArgumentsInt(String filename, int[] ignoredKeywordIndexes) throws Exception;
    
    
    List<Line> getInputLines();
    Set<String> getKeywords();
}

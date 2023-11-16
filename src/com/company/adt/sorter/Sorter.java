package com.company.adt.sorter;

import java.util.List;

public interface Sorter {

    void generateSortedList();
    
    
    
    
    
    
    
    
    
    /*											CODE MODIFICATION FOR CSCI-250 KWIC	Modularization 2	
     *  Newly added interface module reversegenerateSortedList() that will handle the information to other classes Modularization 2.
     */
    void reversegenerateSortedList();

    List<?> getSortedList();

}

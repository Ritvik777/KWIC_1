package com.company.adt.sorter;

import com.company.adt.input.Input;
import com.company.adt.shifter.CircularShift;
import com.company.adt.shifter.Shifter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KwicAlphabetizer implements Sorter {

    private final Shifter shifter;
    private List<CircularShift> sortedCircularShifts;

    public KwicAlphabetizer(Shifter shifter) {
        this.shifter = shifter;
    }

    		
    public void generateSortedList() {
        sortedCircularShifts = shifter.getCircularShifts();
       Collections.sort(sortedCircularShifts);
    }
    
    
    /*
	 * 					CODE MODIFICATION FOR CSCI-250 KWIC Modularization 2
	 * 
	 * 1 - New method reversegenerateSortedList() that perform list of all output valid circular shifts of all lines in descending order.
     */

    public void reversegenerateSortedList() {
        sortedCircularShifts = shifter.getCircularShifts();
        Collections.sort(sortedCircularShifts, Collections.reverseOrder());
    }
    
    public List<?> getSortedList() {
        return new ArrayList<>(this.sortedCircularShifts);
    }

}

package com.epam.mjc.collections.list;

import java.util.Comparator;
import java.util.List;

public class ListSorter {
    public void sort(List<String> sourceList) {
        ListComparator comparator = new ListComparator();

        for (int i = 0; i < sourceList.size()-1; i++) {
            for(int j = i+1; j < sourceList.size(); j++){
                String a = sourceList.get(i);
                String b = sourceList.get(j);
                int compareResult = comparator.compare(a, b);

                if( compareResult > 0){
                    sourceList.set(i, b);
                    sourceList.set(j, a);
                }
            }
        }
    }
}

class ListComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        Integer aIntValue = Integer.parseInt(a);
        Integer bIntValue = Integer.parseInt(b);
        Integer aFuncResult = orderFunction(aIntValue);
        Integer bFuncResult = orderFunction(bIntValue);

        if(aFuncResult < bFuncResult){
            //f(a) < f(b) => -1
            return  -1;
        }else if(aFuncResult > bFuncResult){
            //f(a) > f(b) => 1
            return 1;
        }
        // f(a) == f(b) -> a>b? 1: 0;
        return (aIntValue > bIntValue)? 1 : 0;
    }

    private Integer orderFunction(Integer x){
        return 5 *( x * x )+ 3;
    }
}

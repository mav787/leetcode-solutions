package Z2025.T100_999;

import java.util.*;

public class T284 {
    // Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

    static class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> iter;
        Integer cache;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            iter = iterator;
            cache = null;

            if(iterator.hasNext()){
                cache = iterator.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return cache;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            int res = cache;
            if(iter.hasNext()){
                cache = iter.next();
            }
            else{
                cache = null;
            }
            return res;
        }

        @Override
        public boolean hasNext() {
            return cache != null;
        }
    }

}

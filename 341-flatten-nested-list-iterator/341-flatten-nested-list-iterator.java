/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> list = new LinkedList<>();
    int pointer;
    /*public NestedIterator(List<NestedInteger> nestedList) {
        pointer = 0;
        NestedIteratorUtil(nestedList);
        //do not flatten the list in initialisation
        //do lazy loading
        //hasNext should not recompute if called multiple times
        //next should not take time
        
        //approach
        //flat some elements, more elements when next method requires threshold
        
    }
    
    public void NestedIteratorUtil(List<NestedInteger> nestedList){
        for(NestedInteger element : nestedList){
            if(element.isInteger()){
                list.add(element.getInteger());
                if(list.)
            } else {
                NestedIteratorUtil(element.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(pointer++);
    }

    @Override
    public boolean hasNext() {
        return pointer<list.size();
    }*/
    
    Deque<NestedInteger> stack = new ArrayDeque<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        prepareStack(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            prepareStack(list);
        }
        return !stack.isEmpty();
    }
    
    private void prepareStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
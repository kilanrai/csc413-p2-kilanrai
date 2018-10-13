package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack; // we modified with <Integer>
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0); //Note framePointer starts with 0
    }

    /**
     * Void function used to dump the current state of the
     * RuntimeStack. When printing the runtime stack make sure
     * to include divisions between frames. If a frame is empty, this must be shown as well.
     */
    public void dump(){

        ArrayList<StringBuffer> dumpData = new ArrayList<>();

        for (int i = 0; i < framePointer.size(); i++) {
            int start = framePointer.get(i);
            int end = i < framePointer.size() - 1 ? framePointer.get(i + 1) : runTimeStack.size();
            StringBuffer str = new StringBuffer("");
            str.append("[");
            if (end - start > 0) {
                str.append(runTimeStack.get(start)); // add first element
                for (int j = start + 1; j < end; j++) {
                    str.append(",");
                    str.append(runTimeStack.get(j)); // now the rest
                }
            }
            str.append("]");
            dumpData.add(str);
        }

        System.out.print(dumpData.get(0)); // print first stack

        for (int i = 1; i < dumpData.size(); i++) {
            System.out.printf(" %s", dumpData.get(i)); // now the rest
        }

        System.out.println();

    }
    /**
     *
     * @return the top of the stack without removing the item.
     */
    public int peek() {
        return runTimeStack.get(runTimeStack.size()-1); //return the top stack
    }

    /**
     * removes an item to the top of the RuntimeStack and
     * @return it.
     */
    public int pop() {
        int i = peek(); // call peek to get last item
        runTimeStack.remove(runTimeStack.size()-1);// remove the last item
        return i;
    }

    /**
     *
     * @param i used to add an item to the top of the RuntimeStack.
     * @return item added is also returned.
     */
    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    /**
     * creates a new frame in the RuntimeStack class. The
     * @param offset is used to denote how many slots down
     * from the top of RunTimeStack for starting a new frame.
     */
    public void newFrameAt(int offset){
        framePointer.push(runTimeStack.size()-offset);
    }

    /**
     * We pop the top frame when we return a function.
     *Before popping, the function's return value is at the
     * top of the stack, so we'll save the value, then pop the
     * top frame and then push the return value back onto the
     * stack. It is assumed return values are at the top of
     * the stack.
     */
    public void popFrame() {
        int fp = framePointer.pop();
        int top = peek();

        for (int i = runTimeStack.size() - 1; i >= fp; i--) {
            runTimeStack.remove(i);
        }
        push(top);
    }

    /**
     *
     * @param offset used to store values into variables. Store will pop the
     * top value of the stack and replace the value at the given offset in the current frame.
     * @return The value stored  is returned.
     */
    public int store(int offset){
        int top = pop();
        runTimeStack.set(peek() + offset, top);
        return top;
    }

    /**
     * used to load variables onto the RuntimeStack from a given
     * @param offset within the current frame. This means we will
     * go to the offset in the current frame, copy the value and
     * push it to the top of the stack. No values should be
     * removed with load.
     * @return val
     */
    public int load(int offset){
        int val = runTimeStack.get(peek() + offset); //check
        push(val);
        return val;
    }

    /**
     *
     * @param val used to load liters onto the RuntimeStack. For example,
     * LIT 5 or LIT 0 will call push with val being 5 or val being 0.
     * @return val
     */
    public Integer push (Integer val){
        push(val.intValue());
        return val;
    }
}








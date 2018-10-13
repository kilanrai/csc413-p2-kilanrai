package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc; // the program counter (current bytecote being executed)
    private boolean isRunning;
    private boolean dumpStack;

    protected VirtualMachine(Program program) {
        this.program = program;
    }
    /**
     * Initializes members (lazy-loading) and interprets the program.
     * At this point all addresses have been resolved and LABELs are not part of the program.
     * Will have to refactor into step for debugger.
     */
    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        dumpStack = false;
        isRunning = true;
        while(isRunning){
            ByteCode code = program.getCode(pc);
            pc++;
            System.out.println(code.getLine());
            code.execute(this);

            if (dumpStack) {
                runStack.dump();
            }
        }
    }

    public void push(int value) {
        runStack.push(value);
    }
    public int pop() {
        return runStack.pop(); }
    public int peek() {
        return runStack.peek();
    }
    public void store(int offset) {
        runStack.store(offset);
    }
    public void load(int offset) {
        runStack.load(offset);
    }
    public void initStackFrame(int nArgs) {
        runStack.newFrameAt(nArgs);
    }
    public void jump(int newPC) { pc = newPC; }
    public void call(int address) {
        returnAddrs.push(pc);
        pc = address;
    }
    /**
     * Kills the virtual machine. It will no longer be able to execute instructions.
     */
    public void kill() {
        isRunning = false;
    }
    /**
     * Function return, cleans up the current function's stack frame and pushes the
     * return value onto the stack. Control is restored to the caller.
     */
    public void ret() {
        runStack.popFrame();
       // pc = returnAddrs.pop();
    }
    /**
     * For DUMP instruction. This function will dump the stack after executing every instruction if true.
     * @param newDumpStack whether or not to dump the stack
     */
    public void setDumpStack(boolean newDumpStack) {
        dumpStack = newDumpStack;
    }

}

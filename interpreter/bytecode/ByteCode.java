package interpreter.bytecode;
import interpreter.VirtualMachine;

//public class ByteCode {

abstract public class ByteCode {
//protected class ByteCode{
    private String instruction;

    public void setLine(String line) {

        instruction = line;
    }

    public String getLine() {

        return instruction;
    }

    abstract public void init(String[] args);
    abstract public void execute(VirtualMachine vm);

}

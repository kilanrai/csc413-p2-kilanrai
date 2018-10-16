package interpreter.bytecode;
import interpreter.VirtualMachine;

 public  abstract class ByteCode {
    private String instruction;
    public void setLine(String line) {
        this.instruction = line;
    }
    public String getLine() {
        return instruction;
    }
    abstract public void init(String[] args);
    abstract public void execute(VirtualMachine vm);
}

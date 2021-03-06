package interpreter.bytecode;
import interpreter.VirtualMachine;

public class LoadCode extends ByteCode {
    private int n;
    public void init(String[] args) {
        n = Integer.parseInt(args[1]);
    }
    public void execute(VirtualMachine vm) {
        vm.load(n);
    }
    public boolean isLabel() {
        return false;
    }
    public boolean isJumpCode() {
        return false;
    }
}






















package interpreter.bytecode;
import interpreter.VirtualMachine;

public class LitCode extends ByteCode{
    private int n;

    public void init(String[] args) {
        n = Integer.parseInt(args[1]);
    }
    public void execute(VirtualMachine vm) {
        vm.push(n);
    }
    public boolean isLabel() {
        return false;
    }
    public boolean isBranch() {
        return false;
    }
}

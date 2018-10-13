package interpreter.bytecode;
import interpreter.VirtualMachine;

public abstract class ReturnCode extends ByteCode {
    public void init(String[] args) {
    }
    public void execute(VirtualMachine vm) {
        vm.ret();
    }
    public boolean isLabel() {
        return false;
    }
    public boolean isBranch() {
        return false; // technically it's a branch but it doesn't contain address info
    }
}


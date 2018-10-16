package interpreter.bytecode;
import interpreter.VirtualMachine;

public class StoreCode extends ByteCode {
    private int k;
    public void init(String[] args) {
        k = Integer.parseInt(args[1]);
    }
    public void execute(VirtualMachine vm) {
        vm.store(k);
    }
    public boolean isLabel() {
        return false;
    }
    public boolean isJumpCode() {
        return false;
    }
}

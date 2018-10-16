package interpreter.bytecode;
import interpreter.VirtualMachine;

public class HaltCode extends ByteCode {
    public void init(String[] args) {
    }
    public void execute(VirtualMachine vm) {
        vm.kill();
    }
    public boolean isLabel() {
        return false;
    }
    public boolean isJumpCode() {
            return false;
        }


}


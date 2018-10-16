package interpreter.bytecode;
import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {
    public void init(String[] args) {
    }
    public void execute(VirtualMachine vm) {
        vm.ret();
    }
}

package interpreter.bytecode;
import interpreter.VirtualMachine;

public class WriteCode extends ByteCode{
    public void init(String[] args) {
    }
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peek());
    }
    public boolean isLabel()
    {
        return false;
    }
    public boolean isJumpcode() {
        return false;
    }
}

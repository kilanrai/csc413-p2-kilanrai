package interpreter.bytecode;
import interpreter.VirtualMachine;

public class GotoCode extends JumpCode {
    public void execute(VirtualMachine vm) {
        vm.jump(address);
    }
}




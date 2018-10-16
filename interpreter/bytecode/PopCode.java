package interpreter.bytecode;
import interpreter.VirtualMachine;

public class PopCode extends ByteCode {
    private int i;
    public void init(String[] args) {
        i = Integer.parseInt(args[1]);
    }
    public void execute(VirtualMachine vm) {
        for (int idx = 0; idx < i; idx++) {
            vm.pop();
        }
    }
}




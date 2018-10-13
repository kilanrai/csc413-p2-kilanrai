package interpreter.bytecode;
import interpreter.VirtualMachine;
public class PopCode {
    private int i;

    public void init(String[] args) {
        i = Integer.parseInt(args[1]);
    }
    public void execute(VirtualMachine vm) {
        for (int idx = 0; idx < i; idx++) {
            vm.pop();
        }
    }
    public boolean isLabel() {
        return false;
    }
    public boolean isBranch() {
        return false;
    }

}

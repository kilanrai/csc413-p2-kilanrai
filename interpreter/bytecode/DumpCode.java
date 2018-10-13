package interpreter.bytecode;
import interpreter.VirtualMachine;

public class DumpCode extends ByteCode {
    private Boolean state;

    public void init(String[] args) {
        state = args[1].equals("ON");
    }

    public void execute(VirtualMachine vm) {
        vm.setDumpStack(state);
    }

    public boolean isLabel() {
        return false;
    }

    public boolean isBranch() {
        return false;
    }
}

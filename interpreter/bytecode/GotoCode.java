package interpreter.bytecode;

import interpreter.VirtualMachine;

public class GotoCode extends ByteCode {
    private String label;
    private int address;

    public void init(String[] args) {
        label = args[1];
    }

    public void execute(VirtualMachine vm) {
        vm.jump(address);
    }

    public String getLabel() {
        return label;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int newAddress) {
        address = newAddress;
    }
}

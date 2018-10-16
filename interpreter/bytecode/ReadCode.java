package interpreter.bytecode;
import interpreter.VirtualMachine;
import java.util.*;

public class ReadCode extends ByteCode {
    private static Scanner scanner = new Scanner(System.in);
    public void init(String[] args) {
    }
    public void execute(VirtualMachine vm) {
        vm.push(scanner.nextInt());
    }
    public boolean isLabel() {
        return false;
    }
    public boolean isJumpCode() {
        return false;
    }
}

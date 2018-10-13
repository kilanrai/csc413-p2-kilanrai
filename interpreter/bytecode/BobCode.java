package interpreter.bytecode;
import interpreter.VirtualMachine;

public class BobCode extends ByteCode {
    private String op;

    public void init(String[] args) {
        try {
            op = args[1];
        } catch (Exception e) { // bad operator
            System.out.println("**** bad operator: " + args[1]);
            System.exit(1);
        }
    }

    public void execute(VirtualMachine vm) {
        int j = vm.pop();
        int i = vm.pop();
        int r = 0;

        switch (op) {
            case "+":
                r  = i + j;
                break;
            case "-":
                r  = i - j;
                break;
            case "/":
                r  = i / j;
                break;
            case "*":
                r  = i * j;
                break;
            case "==":
                r  = i == j ? 1 : 0;
                break;
            case "!=":
                r  = i != j ? 1 : 0;
                break;
            case "<=":
                r  = i <= j ? 1 : 0;
                break;
            case ">":
                r  = i > j ? 1 : 0;
                break;
            case ">=":
                r  = i >= j ? 1: 0;
                break;
            case "<":
                r  = i < j ? 1 : 0;
                break;
            case "|":
                r  = i | j;
                break;
            case "&":
                r  = i & j;
                break;
            default:
                break;
        }
        vm.push(r);
    }
}

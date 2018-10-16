
package interpreter;
import java.util.HashMap;
import java.util.ArrayList;
import interpreter.bytecode.*;

/**
 * This Program Class will be responsible for storing all the bytecodes read from the source file.
 * This will store in an ArrayList which has a designated type of ByteCode. This will ensure only
 * ByteCodes and its subclass can only be added to the ArrayList. This class holds all instructions
 * and resolve the label addresses.
 */
public class Program {
    private ArrayList<ByteCode> program;
    private ArrayList<ByteCode> branches;
    private HashMap<String, Integer> labels;
    private int address;

    public Program() {
        program = new ArrayList<>();
        branches = new ArrayList<>();
        labels = new HashMap<>();
    }
    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }
    public void addBytecode(ByteCode bytecode) {
        if (bytecode instanceof LabelCode) {
            LabelCode label = (LabelCode)bytecode;
            labels.put(label.getLabel(), address);
        } else {
            if (bytecode instanceof FalseBranchCode || bytecode instanceof GotoCode || bytecode instanceof CallCode) {
                branches.add(bytecode);
            }
        }
        program.add(bytecode);
        address++;
    }
    public int getSize() {
        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     */
    public void resolveAddrs() {
        for (ByteCode branch : branches) {
            String label = "<none>";
            try {
                if (branch instanceof FalseBranchCode) {
                    FalseBranchCode br = (FalseBranchCode) branch;
                    int address = labels.get(br.getLabel());
                    label = br.getLabel();
                    br.setAddress(address);
                } else if (branch instanceof GotoCode) {
                    GotoCode br = (GotoCode) branch;
                    int address = labels.get(br.getLabel());
                    label = br.getLabel();
                    br.setAddress(address);
                } else if (branch instanceof CallCode) {
                    CallCode br = (CallCode) branch;
                    int address = labels.get(br.getLabel());
                    label = br.getLabel();
                    br.setAddress(address);
                }
            } catch(NullPointerException e) { // bad label
                System.out.println("*** bad label: " + label);
                e.printStackTrace();
                System.exit(1);
            }
        }
        branches.clear();
        labels.clear();
        address = 0;
    }
}
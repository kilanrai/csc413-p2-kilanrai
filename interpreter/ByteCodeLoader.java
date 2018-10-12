
package interpreter;

import interpreter.bytecode.ByteCode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The bytecode loader class is responsible for loading bytecodes from the source
 * file into a data-structure that stores the entire program. We will use an ArrayList to
 * store our bytecodes. This ArrayList will be contained inside of a Program object.
 * Adding and Getting bytecodes will go through the Program class.
 */


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    
    /**;
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        Program program = new Program();
        String line;
        String code = "";

        try {
            while ((line = byteSource.readLine()) != null) {
                String[] args = line.split("\\s+");

                if (args[0].length() > 0) { // not an empty line
                    code = args[0];
                    Class c = Class.forName("interpreter.bytecode." + CodeTable.getClassName(code));
                    ByteCode bytecode = (ByteCode)c.getDeclaredConstructor().newInstance();

                    bytecode.setLine(line);
                    bytecode.init(args);
                    program.addBytecode(bytecode);
                }
            }

            program.resolveAddrs();
        } catch(IOException e) { // io read error
            e.printStackTrace();
            System.exit(1);
        } catch(Exception e) { // bad bytecode
            System.out.println("**** bad instruction: " + code);
            e.printStackTrace();
            System.exit(1);
        } finally {
            try {
                this.byteSource.close();
            } catch (IOException e) { // could not close file
            }
        }

        return program;
       //return null;
    }
}

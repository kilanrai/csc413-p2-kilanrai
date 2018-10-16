package interpreter.bytecode;

    abstract public class JumpCode extends ByteCode {
        protected String label;
        protected int address;
        public void init(String[] args) {
            label = args[1];
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
        public boolean isLabel() {
            return false;
        }
        public boolean isJumpCode() {
            return true;
        }
    }


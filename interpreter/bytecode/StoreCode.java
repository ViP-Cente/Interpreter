package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private int offset;
    private String variable;
    private int value;

    @Override
    public void init(ArrayList<String> args) {
        this.offset = Integer.parseInt(args.get(1));
        if (args.size() > 2) {
            this.variable = args.get(2);
        }
    }

    @Override
    public void dump(VirtualMachine virtualMachine) {
        System.out.println("STORE " + offset + " " + variable + "\t" + variable + " = " + value);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        value = virtualMachine.peekRunStack();
        virtualMachine.storeRunStack(offset);
    }
}

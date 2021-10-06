package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    private int offset;
    private String variable;

    @Override
    public void init(ArrayList<String> args) {
        this.offset = Integer.parseInt(args.get(1));
        if (args.size() > 2) {
            this.variable = args.get(2);
        }

    }

    @Override
    public void dump(VirtualMachine virtualMachine) {
        System.out.print("LOAD " + offset);
        if (!variable.equals("")) {
            System.out.print(" " + variable + "\t" + "<load " + variable + ">");
        }
        System.out.println();
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

        virtualMachine.loadRunStack(this.offset);
    }
}

package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode implements AddressLabel {
    private String label;
    private int resolvedAddress;


    @Override
    public void init(ArrayList<String> args) {
        label = args.get(1);
    }

    @Override
    public void dump(VirtualMachine virtualMachine) {
        System.out.println("GOTO " + label);
    }
    //This will set the PC to the address of the label that we resolved before running the program
    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.setProgramCounter(resolvedAddress-1);

    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setAddress(int newAddress) {
        resolvedAddress = newAddress;
    }
}

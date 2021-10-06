package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode implements AddressLabel{
    private String label;
    private int resolvedAddress;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(1);
    }

    @Override
    public void dump(VirtualMachine virtualMachine) {
        System.out.println("FALSEBRANCH " + label);
    }
//This will execute if the value is 0, then it will set the PC to the address of the label that
    // we resolved before running the program
    @Override
    public void execute(VirtualMachine virtualMachine) {
        if (virtualMachine.popRunStack() == 0){
            virtualMachine.setProgramCounter(resolvedAddress - 1);
        }


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

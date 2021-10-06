package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode implements AddressLabel{
    private String  label;
    private int address;
    private String id;

    @Override
    public void init(ArrayList<String> args) {
        this.label = args.get(1);
        id = args.get(1).split("<<", 2)[0];
    }

    @Override
    public void dump(VirtualMachine virtualMachine) {
        System.out.print("CALL " + label + "\t" + id + "(");
        virtualMachine.printArgs(); //This uses the virtual machine to tell the runStack to print the arguments for this function
        System.out.println(")");
    }
    //This will push the current programCounter into the return address stack so that we can return to later
    // then it will set the PC to the address of the label that we resolved before running the program
    @Override
    public void execute(VirtualMachine virtualMachine) {
        //This pushes the current programCounter into the return address stack
        virtualMachine.pushProgramCounter();

        //Set the current program counter to the label of the CALL<<Label>>
        virtualMachine.setProgramCounter(address - 1);
    }

    @Override
    public String getLabel() {
        return this.label;

    }

    @Override
    public void setAddress(int newAddress) {
        this.address = newAddress;
    }
}
package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode{
    private int numberOfArguments;

    @Override
    public void init(ArrayList<String> args) {
        this.numberOfArguments = Integer.parseInt(args.get(1));
    }

    @Override
    public void dump(VirtualMachine virtualMachine) {
        System.out.println("ARGS " + numberOfArguments);
        virtualMachine.setArgsCount(numberOfArguments); // Only used for dumping CallCode
    }
    //This creates a new frame for a function that has a certain number of arguments.
    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.newFrameAtOffset(numberOfArguments);
    }
}

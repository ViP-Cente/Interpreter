package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    private int numberToRemove;

    @Override
    public void init(ArrayList<String> args) {
        numberToRemove = Integer.parseInt(args.get(1));
    }

    @Override
    public void dump(VirtualMachine virtualMachine) {
        System.out.println("POP " + numberToRemove);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        // Pop the stack a given number of times
        //This does not execute past frame boundaries and when the runStack is empty
        for (int i = 0; i < numberToRemove; i++){
            virtualMachine.popRunStack();
        }
    }
}

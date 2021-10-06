package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode{
    private int value;
    private String variable = "";


    @Override
    public void init(ArrayList<String> args){
        this.value = Integer.parseInt(args.get(1));
        if (args.size() > 2 ){
            this.variable = args.get(2);
        }
    }

    @Override
    public void dump(VirtualMachine virtualMachine) {
        System.out.print("LIT " + value);
        if (!variable.equals("")) {
            System.out.print(" " + variable + "\t" + "int " + variable);
        }
        System.out.println();
    }
//This pushes the value to the runTimeStack
    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.pushRunStack(value);
    }
}

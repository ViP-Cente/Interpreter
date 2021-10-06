package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode{
    private String label;

    @Override
    public void init(ArrayList<String> args) {
        this.label = args.get(1);
    }

    @Override
    public void dump(VirtualMachine virtualMachine) {
        System.out.println("Label " + label);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

    }

    public String getLabel(){
        return label;
    }
}

package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public abstract class ByteCode {


    public void init(ArrayList<String> args) {

    }

    public abstract void dump(VirtualMachine virtualMachine);


    public abstract void execute(VirtualMachine virtualMachine);
}

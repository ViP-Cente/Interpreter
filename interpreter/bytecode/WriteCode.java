package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode{
    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void dump(VirtualMachine virtualMachine) {
        System.out.println("WRITE");
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println(virtualMachine.peekRunStack());
    }
}

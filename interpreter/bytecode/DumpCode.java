package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode{
    private boolean dump;

    @Override
    public void init(ArrayList<String> args) {
        dump = args.get(1).equals("ON");
    }

    //NO DUMP FOR dumpCode
    @Override
    public void dump(VirtualMachine virtualMachine) { }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.setDump(dump);
    }
}

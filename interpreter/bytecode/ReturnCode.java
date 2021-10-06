package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    private String function = "";
    private String id = "";

    @Override
    public void init(ArrayList<String> args) {
        if (args.size() > 1) {
            function = args.get(1);
            id = args.get(1).split("<<", 2)[0];
        }
    }

    @Override
    public void dump(VirtualMachine virtualMachine) {
        // Return should print only one value when dumping
        if (!"".equals(function)) {
            System.out.print("RETURN " + function + "\t" + "exit " + id + ":");
            virtualMachine.printArgs();
            System.out.println();
        }
        else {
            System.out.println("RETURN");
        }
        virtualMachine.setArgsCount(1); // Return should print only one value when dumping


    }

    //So this function pops the current frame and then returns back to the return address that CallCode saved
    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.popFrame();
        virtualMachine.returnBack();
    }


}

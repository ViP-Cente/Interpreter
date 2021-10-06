package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode{

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void dump(VirtualMachine virtualMachine) {
        System.out.println("READ");
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        Scanner input = new Scanner(System.in);
        Integer readInput = null;

        do {
            try {
                System.out.print("Please enter an Integer: ");
                readInput = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Invalid input.");
            }
        } while (readInput == null);

        virtualMachine.pushRunStack(readInput);
    }
}

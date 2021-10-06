package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode{
    private String operator;
    @Override
    public void init(ArrayList<String> args) {
        operator = args.get(1);
    }

    @Override
    public void dump(VirtualMachine virtualMachine) {
        System.out.println("BOP " + operator);
    }
// I want to clean this function up later
    @Override
    public void execute(VirtualMachine virtualMachine) {
        int pop1 = virtualMachine.popRunStack();
        int pop2 = virtualMachine.popRunStack();
        int result = 0;

        switch (operator)
        {
            case "+":
                result = pop1 + pop2;
                break;
            case "-":
                result = pop2 - pop1;
                break;
            case "*":
                result = pop1 * pop2;
                break;
            case "/":
                result = pop2 / pop1;
                break;
            case "==":
                if(pop2 == pop1)
                {
                    result = 1;
                }
                else
                {
                    result = 0;
                }
                break;
            case "!=":
                if(pop2 != pop1)
                {
                    result = 1;
                }
                else
                {
                    result = 0;
                }
                break;
            case "<":
                if(pop2 < pop1)
                {
                    result = 1;
                }
                else
                {
                    result = 0;
                }
                break;
            case ">":
                if(pop2 > pop1)
                {
                    result = 1;
                }
                else
                {
                    result = 0;
                }
                break;
            case "<=":
                if(pop2 <= pop1)
                {
                    result = 1;
                }
                else
                {
                    result = 0;
                }
                break;
            case ">=":
                if(pop2 >= pop1)
                {
                    result = 1;
                }
                else
                {
                    result = 0;
                }
                break;
            case "&":
                if(pop2 == 1 && pop1 == 1)
                {
                    result = 1;
                }
                else
                {
                    result = 0;
                }
                break;
            case "|":
                if(pop2 == 1 || pop1 == 1)
                {
                    result = 1;
                }
                else
                {
                    result = 0;
                }
                break;
            default:
                break;
        }
        virtualMachine.pushRunStack(result);
    }
}

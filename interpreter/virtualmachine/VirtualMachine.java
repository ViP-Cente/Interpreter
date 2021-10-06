package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;

import java.util.Scanner;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runTimeStack;
    private Stack<Integer> returnAddress;
    private final Program program;
    private int programCounter;
    private boolean isRunning;
    private boolean dumpFlag;   //Used for knowing when to dump


    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;
        dumpFlag = false;

        while (isRunning) {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);

            //DumpCode is not being dumped and neither is the RunTimeStack
            if (dumpFlag && !(code instanceof DumpCode)) {
                code.dump(this);
                runTimeStack.dump();
            }
            programCounter++;
        }
    }

    public void halt() {
        this.isRunning = false;
    }

    public int popRunStack() {
        return this.runTimeStack.pop();
    }

    public int peekRunStack(){
        return this.runTimeStack.peek();
    }

    public void pushRunStack(int value) {
        this.runTimeStack.push(value);
    }

    public void storeRunStack(int offset) {
        setProgramCounter(programCounter - 1);
        this.runTimeStack.store(offset);
    }

    public void loadRunStack(int offset) {

        this.runTimeStack.load(offset);
    }

    //Creates a new frame at the offset from the top of the runTimeStack
    public void newFrameAtOffset(int offset) {
        runTimeStack.newFrameAt(offset);
    }

    public void popFrame() {
        this.runTimeStack.popFrame();
    }

    //This function set the ProgramCounter to the last address in the addressStack.
    //This address should be the address that CallCode is called at and needs to return to after executing returnCode
    public void returnBack() {
        if (!returnAddress.isEmpty()) {
            setProgramCounter(returnAddress.pop());
        }
        //Increase the PC by one so we dont call the same function we just went to
        //programCounter++;
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }


    //This function pushes the PC to the return address stack
    public void pushProgramCounter() {
        returnAddress.push(programCounter);
    }

    // Function to see if the PC is at a frame boundary
    public boolean atFrameBoundary() {
        return runTimeStack.atFrameBoundary(programCounter);
    }

    public void setDump(boolean dump) {
        this.dumpFlag = dump;
    }


    public void setArgsCount(int argsCount) {
        runTimeStack.setArgsCount(argsCount);
    }

    public void printArgs(){
        runTimeStack.printArgs();
    }
}

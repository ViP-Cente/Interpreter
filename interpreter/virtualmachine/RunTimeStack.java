package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.Stack;

class RunTimeStack {

    private final ArrayList<Integer> runTimeStack;
    private final Stack<Integer> framePointer;
    //This will be used for dumping CallCode and ReturnCode
    private int argsCount;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    //function to get the last index
    private int getLastIndex() {
        return this.runTimeStack.size() - 1;
    }

    public int peek() {
        //If statement for null pointer exceptions
        if (!runTimeStack.isEmpty()) {
            return runTimeStack.get(runTimeStack.size() - 1);
        }

        return 0;
    }

    public int push(int valueToPush) {
        runTimeStack.add(valueToPush);
        return this.peek();
    }

    public int pop() {
        //If the stack is not empty and it is not past a frame boundary, then it pops.
        if (!runTimeStack.isEmpty() && framePointer.peek() < runTimeStack.size()) {
            return runTimeStack.remove(runTimeStack.size() - 1);
        }

        return 0;
    }

    //Prints the current state of the runTimeStack.
    // This function should not be used for the ByteCodes
    public void dump() {
        int index = 0;
        if (framePointer.size() > 1) {
            for (int i = 1; i < framePointer.size(); i++) {
                System.out.print(runTimeStack.subList(index, framePointer.get(i)) + " ");
                index = framePointer.get(i);
            }
        }
        if (runTimeStack.size() > 0){
            System.out.print(runTimeStack.subList(index, runTimeStack.size()) + "\n");
        }
        if (runTimeStack.size() == 0) {
            System.out.println("[]");
        }

    }

    //Takes the top item of the stack and places it at a given offset from the current framePointer
    public int store(int offset) {
        int item = pop();
        runTimeStack.set(offset + framePointer.peek() - 1, item);
        return item;
    }

    //Takes the item at a given offset and places it at the top of the RTS
    public int load(int offset) {
        int item = runTimeStack.get(framePointer.peek() + offset);

        return push(item);
    }

    //Creates a new frame at a given offset from the top of the rts
    public void newFrameAt(int offset) {
        framePointer.push(runTimeStack.size() - offset);

    }

    //Continues to pop the rts fir the current frame
    public void popFrame() {
        int top = pop();
        int frameIndex = framePointer.pop();

        for (int x = this.getLastIndex(); x > frameIndex - 1; x--) {
            this.pop();
        }
        push(top);
    }

    public int getCurrentFrameIndex() {
        return framePointer.peek();
    }

    //This function is to return if the current code is at a frame boundary
    //by checking if the line is in the framePointer stack
    public boolean atFrameBoundary(int programCounter) {
        boolean atFrameBoundary = framePointer.contains(programCounter);

        return atFrameBoundary;
    }
    //This is used for dumping CallCode
    public void setArgsCount(int argsCount) {
        this.argsCount = argsCount;
    }

    //This function will either print the arguments in CallCode
    // OR it will print the result calculated in returnCode
    public void printArgs() {
        if (!runTimeStack.isEmpty()) {
            for (int i = 0; i < argsCount; i++) {
                System.out.print(runTimeStack.get(runTimeStack.size() - argsCount + i));
                if (i != argsCount - 1) {
                    System.out.print(", ");
                }
            }
        }
    }


}

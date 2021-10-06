package interpreter.virtualmachine;

import interpreter.bytecode.AddressLabel;
import interpreter.bytecode.ByteCode;
import interpreter.bytecode.LabelCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    public Program(ArrayList<ByteCode> loadedByteCodes) {
        program = loadedByteCodes;
    }

    public ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    public void addByteCode(ByteCode byteCode){
        program.add(byteCode);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    public void resolveAddress() {
        HashMap<String, Integer> addresses = new HashMap<>();
        //1 pass through the arraylist keeping track if label codes and their labels
        // Stores the addresses of labels in a hashmap
        for ( int i = 0; i < program.size(); i++) {
            if (program.get(i) instanceof LabelCode){
                addresses.put(((LabelCode) program.get(i)).getLabel(), i);
            }
        }
        //2nd pass through the arrayList look for call, goto and falseBranch code and do the following:
        //look at stored label codes and find the 1 as the match label value;
        for (ByteCode byteCode : program){
            if (byteCode instanceof AddressLabel) {
                // Matches the label in bc with the label in the hashmap and sets the same address
                ((AddressLabel) byteCode).setAddress(addresses.get(((AddressLabel) byteCode).getLabel()));
            }
        }


    }




}

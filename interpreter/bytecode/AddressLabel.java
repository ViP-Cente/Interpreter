package interpreter.bytecode;

public interface AddressLabel {
/*
This interface is to help convert the Goto, falseBranch, and Calls label's to the correct address that they are
supposed to jump to
 */

    String getLabel();
    //This function is used to set their labels to the new correct addresses
    void setAddress(int newAddress);
}

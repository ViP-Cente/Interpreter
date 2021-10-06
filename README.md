# Interpreter
1 Introduction

1.1 Project Overview
So, this project is an interpreter for the mock coding language X. This interpreter project has a 
virtual machine where it will execute functions written on files that are in the mock language X.

1.2 Technical Overview
So we have the classes runTimeStack, VirtualMachine, Interpreter, ByteCodeLoader, and all the 
ByteCode classes. The runTimeStack is essentially the core of this project. The runtimestack class 
has an ArrayList that acts as the runtimestack for the mock language we’ll be computing. Then 
there is a stack that stores pointers to different frames inside the runtimestack. These frames act 
as boundaries for methods that we’ll call using the mock language. This runtimestack class also
has a dump() function that displays the current state of the runtimestack. There are a lot of 
dump() functions within this project but each of them prints something different based on who is 
calling that function.
The VirtualMachine class acts as a controller that interacts with the runtimestack. The 
VirtualMachine has a variety of functions that the ByteCode classes use to do their designed 
functions. The VirtualMachine will take a ByteCode and call the execute() method to do its 
function. The VirtualMachine will also run the Bytecodes dump() function if the dumpFlag is “ON”. 
There is a abstract class called ByteCode that has the functions init(), dump(), execute(). The init 
function for each class will initialize the data fields for the ByteCode class depending on the type 
of ByteCode. Dump() will print something based on the ByteCode. Execute() will do a function 
based on the ByteCode.
The Program class is essentially the entire program the user imports using the mock language. 
This class has an ArrayList of ByteCodes that is the program we’ll be interpreting. There are 
functions addByteCode() and getByteCode() that adds bytecodes and gets the bytecode at the 
current counter for the program respectfully. There is also a function resolveAddress() that 
matches all the Call, FalseBranch, Goto to their respective LabelCode address before the program 
is actually run. This class work with the ByteCodeLoader which is responsible for reading a .cod 
files and adding the ByteCodes to the Program ArrayList. It uses the CodeTable class to match the 
ByteCode names to their respective class names.

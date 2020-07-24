import Operations.DoubleStack;

public class Run {
    public static void main(String[] args) {
        DoubleStack ds = new DoubleStack(6);
        ds.pushStack1(0);//Position in array:0; Stack 1
        ds.pushStack2(4);//Position in array:4; Stack 2
        ds.pushStack2(3);//Position in array:3; Stack 2
        ds.pushStack1(1);//Position in array:1; Stack 1
        ds.pushStack2(2);//Position in array:2; Stack 2
        ds.pushStack1(5);//Position in array:5; Stack 1; Array is full after this executes.

        //Popping will show the element in the last position of the stack
        System.out.println("Elements in stack 1:["+ds.pop1()+","+ds.pop1()+","+ds.pop1()+"]");
        System.out.println("Elements in stack 2:["+ds.pop2()+","+ds.pop2()+","+ds.pop2()+"]");
        //Trying to pop again must display the stack is empty message
        /*This will cause a system.exit so must be commented out once
          test screen shots are done so the code below it will run*/
        ds.pop1();
        //ds.pop2();

        //Because popping removes the elements as they are called they must be re-added
        ds.pushStack1(0);
        ds.pushStack2(4);
        ds.pushStack2(3);
        ds.pushStack1(1);
        ds.pushStack2(2);
        ds.pushStack1(5);//Position in array:5; Stack 1; Array is full after this executes.
        ds.pushStack1(6);//Must cause overflow message as coded in the DoubleStack file
    }
}

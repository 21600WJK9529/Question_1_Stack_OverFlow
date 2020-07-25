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
        //ds.pop1();
        //ds.pop2();

        //Because popping removed the elements as they were called they must be re-added
        ds.pushStack1(0);
        ds.pushStack2(4);
        ds.pushStack2(3);
        ds.pushStack1(1);
        ds.pushStack2(2);
        ds.pushStack1(5);//Position in array:5; Stack 1; Array is full after this executes.
        ds.pushStack1(6);//Must cause overflow message as coded in the DoubleStack file
    }
    public static class DoubleStack {

        int arrSize, //n
                head,tail,//For populating head(where n is 6, head is position 0,1,2. Tail is 3,4,5
                array[]; //array to be used for the int's that will populate it

        //This constructor will receive its n from the Run file
        public DoubleStack(int n){
            array=new int[n];
            arrSize=n;
            head=-1;
            tail=arrSize;
        }

        //This method pushes a value to the first stack
        public void pushStack1(int x){
            //Head=-1 tail=6
            //We check that the head value is not less than the tail value-1
            //By doing this check we can see that at least 1 space is remaining in the array
            if (head<tail-1){
            /*      We increment the head value by 1, giving it a value of 0
                    which is where the first element will go for the head   */
                //      array[head] or array[0] will be assigned the value x provided in the Run file
                head++;
                array[head]=x;
            }
            else{
                /*  Should there not be at least 1 space or in other words
                    if the elements in both stacks have a total greater than
                    the size of the array/n then this message must show and
                    the program must stop                                   */
                System.out.println("Stack Overflow");
                System.exit(1);
            }
        }

        //Method for pushing to stack 2
        public void pushStack2(int x){
            //  Same check as in previous method
            if (head<tail-1){
           /*   Only difference between this and the above method occurs here,
                the tail value is decremented as its base value is the value of
                the array size/n(which is 6)
            */
                tail--;//the 6 is made into a 5 so that it does not exceed the array positions available
                array[tail]=x;// the tail's first value gets added to last position and will work backwards
            }
            else{
                System.out.println("Stack Overflow");
                System.exit(1);
            }
        }

        // This method will remove the last element in stack 1, used for display purposes.
        public int pop1(){
            if (head>=0) {//Checking if head value is 0 or higher. The value should never be negative
                int x = array[head];//Retrieve the int in the array at the position of the head value
                head--;//head value will start at 2 and be decremented to 0 as more pops occur
                return x;//return the value
            }
            else{
                System.out.println("Stack one is empty");
                System.exit(1);//exit if no values are found in the stack
            }
            return 0;
        }

        //This method will remove the last element in stack 2, used for display purposes.
        public int pop2(){
            if(tail<arrSize){/* because the tail functions in the 2nd half of the array,
                                it will remove values from its start position at 3
                                and check that its position value never exceeds the array size,
                                this will ensure once the last value is popped it will stop*/
                int x=array[tail];
                tail++;//tail values are taken from its start position at 3 and will increment to 5
                return x;
            }
            else{
                System.out.println("Stack two is empty");
                System.exit(1);

            }
            return 0;
        }
    }
}
/*
Authors:
Surname, initals : Student number
Ammo, M     : 216022002
Booysen, M  : 216062241
Kruger, W   : 216009529
*/
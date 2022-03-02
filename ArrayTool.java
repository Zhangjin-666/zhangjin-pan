import java.lang.Override;
/**
 * [40 pts]
 * Design and implement an ArrayTool.class
 * - You will have an int array in this class, and this array CANNOT be visited by other class directly.
 * - You could construct this class with TWO options:
 *     - Construct without parameters -> the class will create an array of length 5
 *     - Construct with an int value -> the class will create an array of that length
 *         - If the parameter is invalid, then use 5 instead.
 * - Implement a method reverse(), which will reverse the numbers in the array.
 *     - You don't have to return anything.
 *     - For example, [1,2,3,4,5] -> [5,4,3,2,1]
 * - Implement a method set(), which allows user to modify the numbers in the array.
 *     - You don't have to return anything.
 *     - Two int parameters -- index and value.
 *     - Check the parameters, if they are invalid, then don't change anything.
 * - Implement methods decrease()
 *     - You don't have to return anything.
 *     - Without parameter -> decrease all numbers in the array by 1.
 *     - With an int value -> decrease all numbers in the array by that parameter.
 *     - Try to avoid duplicate code
 * - Implement a static method numOfTools(), return the number of ArrayTool we have created.
 *     - public static int numOfTools()
 *     - Tip: Maybe you need to declare something to count the number.
 * - Override toString()
 *     - Should return the size of the array and the numbers in it.
 *     - Format: "size: 5, [1,2,3,4,5]"
 */

class ArrayTool{
    private int[] arr;
    public static int num = 0;
 
    public ArrayTool(int len){          
        if (len < 0) len = 5;
        this.arr = new int[len];
        num ++;
    }

    public ArrayTool(){                   
        this(5);     
    }

    public void reverse(){   
        for(int i = 0, j = arr.length - 1; i < arr.length / 2; i ++, j --){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    public void set(int idx, int val){
        if (idx < 0) return;
        arr[idx] = val;
    }

    public void decrease(int n){
        for(int i = 0; i < arr.length; i ++) arr[i] -= n;
    }

    public void decrease(){
        decrease(1);   //- Try to avoid duplicate code
    }

    public static int numOfTools(){
        return num;
    }

    @Override
    public String toString(){
        int size = arr.length;
        String res = "";
        for(int i : arr) res = res + i + ',';
        res = res.substring(0, res.length() - 1);

        return "size: " + size + ", [" + res + "]";
    }    

// test case
    public static void main(String[] args) {
        ArrayTool arr1 = new ArrayTool();
        arr1.set(0,0);
        arr1.set(1,2);
        arr1.set(2,4);
        arr1.set(3,6);
        arr1.set(4,8);
        String s = arr1.toString();
        System.out.println(s);

        arr1.reverse();
        String s3 = arr1.toString();
        System.out.println(s3);

        arr1.decrease(2);
        String s2 = arr1.toString();
        System.out.println(s2);

    }
}



    



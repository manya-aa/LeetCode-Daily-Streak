/* Given two numbers num1, num2. You subtract num2 from num1 if num1>=num2, otherwise num1 from num2. Give the min no of operations to make either one of them 0.

Approach -- can use Euclidean */

class Solution {

    public int countOperations(int num1, int num2) {
        int res = 0; 
        while (num1 != 0 && num2 != 0) {
            
            res += num1 / num2;
            num1 %= num2;
           
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        return res;
    }
}


/* Minimum operations to convert all array to zero.
In one operation, u can choose a subarray and make all the minimum element to zero.

[0,2] => 1, [3,1,2,1] => 3

Approach used -- Monotonic Increasing Stack.

keep popping until the element is smaller than stack top, as u have to start the subarray for the elements at stack top, which would lead to another operation.
if it's zero skip.
if element is greater than stack top, then push it, increment ans, as it's minimum for the subarray starting from it's point. */


class Solution {
public int minOperations(int[] nums) {
        
Stack<Integer> st=new Stack<>();
int ans=0;

for(int i=0;i<nums.length;i++){
int a=nums[i];

while(!st.isEmpty() && a<st.peek())st.pop();
if(a==0 )continue;
if(st.isEmpty() || a>st.peek()){
    st.push(a);
    ans++;
}

}

return ans;
    }
}
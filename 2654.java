/* Problem -- You are given an integer array nums.
In one operation, you can replace any element nums[i] with gcd(nums[i], nums[j]) for any j.
The goal is to make all elements equal to 1 using the minimum number of such operations.
If it’s impossible to make all elements 1, return -1.
Otherwise, return the minimum number of operations needed.

Ex -- [2,6,3,4] => 4

Approach -- Count existing 1s:
If the array already contains some 1s, we just need to make the remaining elements equal to 1.
So answer = n - count(1s).

Find smallest subarray with GCD = 1:
Traverse all subarrays and compute their GCD.
The smallest subarray length m that has GCD = 1 tells us the minimum steps needed to create one 1.

Compute total operations:
(m - 1) operations to create one 1.
(n - 1) operations to spread that 1 to all elements.
Total = (m - 1) + (n - 1).
If no subarray has GCD = 1 → return -1. */

class Solution {

int gcd(int num, int div){
if(num < div) return gcd(div, num);   
if(div==0)return num;
return gcd(div,num%div);

}

public int minOperations(int[] nums) {
        int cnt=0;
for(int i=0;i<nums.length;i++){
    if(nums[i]==1)cnt++;
}
if(cnt>0)return nums.length-cnt;
int m=Integer.MAX_VALUE;
for(int i=0;i<nums.length-1;i++){
int g=nums[i];
for(int j=i+1;j<nums.length;j++){

g=gcd(g,nums[j]);
if(g==1){m=Math.min(m,j-i+1); break;}

}
if(m==2)break;
}

return (m==Integer.MAX_VALUE)?-1:nums.length-1+m-1;

    }
}




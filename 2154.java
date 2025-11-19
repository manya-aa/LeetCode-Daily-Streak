class Solution {
    public int findFinalValue(int[] nums, int original) {
boolean ans=false;
for(int i=0;i<nums.length;i++){
if(nums[i]==original){ans=true; break;}
}

if(ans==false)return original;

return findFinalValue(nums,original*2);

    }
}
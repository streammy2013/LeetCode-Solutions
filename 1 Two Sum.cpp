class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> hash;
        vector<int> res;
        for(int i=0;i<nums.size();++i)
        {
            int num = target - nums[i];
            if(hash.find(num)!=hash.end())
            {
                res.push_back(i);
                res.push_back(hash[num]);
                break;
            }
            hash[nums[i]]=i;
        }
        return res;
    }
};
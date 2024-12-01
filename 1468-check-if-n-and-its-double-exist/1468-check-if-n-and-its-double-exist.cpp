class Solution {
public:
    bool checkIfExist(vector<int>& arr) {
        set<int> check;
        for(int ele:arr){
            if(check.count(2*ele)>0 || (ele%2==0 && check.count(ele/2)>0 )){
                return true;
            }
            check.insert(ele);            
        }
        return false;
    }
};
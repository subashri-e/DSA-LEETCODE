class Solution {
public:
    int minimumLength(string s) {
        vector <int> freq(26);
        for(int i=0;s[i];i++){
            freq[s[i]-'a']++;
        }
        int len=0;
        for(int i=0;i<26;i++){
            if(freq[i]&1)
                len+=1;
            else
                len+=min(2,freq[i]);
        }
        return len;    
    }
};
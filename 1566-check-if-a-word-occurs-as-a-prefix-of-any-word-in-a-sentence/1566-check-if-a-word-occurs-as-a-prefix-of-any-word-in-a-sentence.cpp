class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
        int pos=1;
        string temp;
        int n=searchWord.size();
        for(char c : sentence){
            if(c==' '){
                if(temp.size()>=n and temp.substr(0,n)==searchWord){
                    return pos;
                }
                temp= "";
                pos+=1;
            }
            else{
                temp+=c;
            }
        }
        if(temp.size() >= n and temp.substr(0,n)== searchWord){
            return pos;
        }
        return -1;
    }
};
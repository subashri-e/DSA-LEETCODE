class Solution {
    public boolean rotateString(String s, String goal) {
        int a = s.length();
        int b = goal.length();

        if (a != b){
            return false; 
        }
        if((a==b) && ((s+s).contains(goal))){
            return true;
        }
        else{
            return false;
        }
    }
}

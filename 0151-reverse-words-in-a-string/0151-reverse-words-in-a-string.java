class Solution {
    public String reverseWords(String s) {
        char[] arr=s.toCharArray();
        int n=arr.length;
        int i=0,l=0,r=0;

        reverse(arr,0,n-1);

        while(i<n){
            while(i<n && arr[i] != ' '){
                arr[r++]=arr[i++];
            }
            if(l<r){
                reverse(arr,l,r-1);
                if (r < n) 
                    arr[r++] = ' '; 
                l=r;
            }
            i++;
        }
        if (r > 0 && arr[r - 1] == ' ') 
            r--;
        return new String(arr,0,r);   
    }

    private void reverse(char[] arr, int l, int r){
        while(l<r){
            char temp=arr[l];
            arr[l++]=arr[r];
            arr[r--]=temp;
        }
    }
    
}
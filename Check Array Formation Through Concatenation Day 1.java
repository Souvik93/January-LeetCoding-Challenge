// Day 1
/*
You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order. However, you are not allowed to reorder the integers in each array pieces[i].

Return true if it is possible to form the array arr from pieces. Otherwise, return false.

 

Example 1:

Input: arr = [85], pieces = [[85]]
Output: true
Example 2:

Input: arr = [15,88], pieces = [[88],[15]]
Output: true
Explanation: Concatenate [15] then [88]
Example 3:

Input: arr = [49,18,16], pieces = [[16,18,49]]
Output: false
Explanation: Even though the numbers match, we cannot reorder pieces[0].
Example 4:

Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
Output: true
Explanation: Concatenate [91] then [4,64] then [78]
Example 5:

Input: arr = [1,3,5,7], pieces = [[2,4,6,8]]
Output: false
 

Constraints:

1 <= pieces.length <= arr.length <= 100
sum(pieces[i].length) == arr.length
1 <= pieces[i].length <= arr.length
1 <= arr[i], pieces[i][j] <= 100
The integers in arr are distinct.
The integers in pieces are distinct (i.e., If we flatten pieces in a 1D array, all the integers in this array are distinct).
   Hide Hint #1  
Note that the distinct part means that every position in the array belongs to only one piece
   Hide Hint #2  
Note that you can get the piece every position belongs to naively

*/

class Solution {

    // Approach Brute Force .
    public boolean canFormArray1(int[] arr, int[][] pieces) {
        
        for(int i=0;i<pieces.length;i++) {
            
         int tempArr[] = pieces[i];
   
        for(int j=0;j<tempArr.length;j++) {
                
            int index = -1;
            for(int z=0;z<arr.length;z++) {
                
                if(arr[z]== tempArr[0]) {
                    if(tempArr.length+z>arr.length) {
                        return false;
                    }
                    index = z;
                    break;
                }
            }     
            
            if(index==-1 || !matchArrays(pieces[i],arr,index+1)) {
                return false;
            }       
            
        }   
    }      
        return true;
    }
    
    private boolean matchArrays(int arr1[],int arr2[],int index) {
       
        for(int i=1;i<arr1.length;i++) {
            if(arr1[i]!=arr2[index++]) {
                return false;
            }
        }
        
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Approach 2:- Used mentioned properties of given array like unique 100 elements can be there.
    public boolean canFormArray(int[] arr, int[][] pieces) { 

        int indexes[] = new int[101];
        
        for(int i=0;i<arr.length;i++) {
                 
            indexes[arr[i]]=i+1;
        }
        
        for(int piece[]:pieces) {
            
            if(indexes[piece[0]]==0) {
                return false;
            }
            for(int i=1;i<piece.length;i++) {
                if(indexes[piece[i-1]]!=indexes[piece[i]]-1) {
                    return false;
                }
            }
        }
        return true;
    
    }
    
}

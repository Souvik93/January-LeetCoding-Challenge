/*
Given two words beginWord and endWord, and a dictionary wordList, return the length of the shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Return 0 if there is no such transformation sequence.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 

Constraints:

1 <= beginWord.length <= 100
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the strings in wordList are unique.
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) {
            return 0;
        }
        words.remove(beginWord);
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for(int i=0;i<size;i++) {
                String currentWord = queue.poll();
                if(currentWord.equals(endWord)) {
                    return level;
                }
                
                List<String> neighbours = getNeighbours(currentWord);
                for(String neighbour: neighbours) {
                    if(words.contains(neighbour)) {
                        words.remove(neighbour);
                        queue.offer(neighbour);
                    }
                }
                
            }
        }
        return 0;
    }
    
    private List<String> getNeighbours(String word) {
        char chars[] = word.toCharArray();
        List result = new LinkedList<>();
        for(int i=0;i<chars.length;i++) {
            char tempChar = chars[i];
            for(char c='a';c<='z';c++) {
                chars[i] = c;
                String neighbour = new String(chars);
                result.add(neighbour);
            }
            chars[i] = tempChar;
        }
        return result;
    } 
}

// Time Complexity :: O(m^2n);
// Space Complexity :: O(m*n);

  /*
  You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length==0) {
            return null;
        }
        
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>((s1,s2)->s1.val-s2.val);
        
        
        
        
        for(ListNode list: lists) {
            
            if(list!=null) {
                priorityQueue.offer(list);    
            }
        }
        
        ListNode head = null;
        
        ListNode next = null;
        
        
        while(!priorityQueue.isEmpty()) {
                    
            ListNode li = priorityQueue.poll();
            
            if(li.next != null) {
                priorityQueue.offer(li.next);   
            }
            
            if(head==null) {
                // head = li;
                next = li;
                head = next;
            } else {
                next.next = li;
                next = li;
            }
                
            
        }
        
        // next.next = null;
        
        return head;
        
        
        
    }
}

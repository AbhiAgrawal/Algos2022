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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode sumHead = null;
        ListNode sumNode = null;
        int carryOver = 0;
        
        while (l1 != null || l2 != null) {
            
            int l1Value = nodeValue(l1);
            int l2Value = nodeValue(l2);
            int sum = l1Value + l2Value + carryOver;
            
            if (sum >= 10) {
                carryOver = sum / 10;
                sum = sum % 10;
            }
            else {
                carryOver = 0;
            }
            
            if (sumHead == null) {
                sumHead = new ListNode(sum);
                sumNode = sumHead;
            }
            else {
                sumNode.next = new ListNode(sum);
                sumNode = sumNode.next;
            }
            
            l1 = nextNode(l1);
            l2 = nextNode(l2);
        }
        
        if (carryOver > 0) {
            sumNode.next = new ListNode(carryOver);
        }
        
        return sumHead;
    }
    
    public static ListNode nextNode(ListNode node) {
        if (node == null) {
            return null;
        }
        return node.next;
    } 
    
    public static int nodeValue(ListNode node) {
        if (node == null) {
            return 0;
        }
        return node.val;
    }
}

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
       if (l1 == NULL) return l2;
        if (l2 == NULL) return l1;
        
        int temp = l1 -> val + l2 -> val;
        ListNode* cur = new ListNode(temp % 10);
        cur->next = addTwoNumbers(l1->next, l2->next);
        if (temp > 9) cur->next = addTwoNumbers(cur->next, new ListNode(1));
        return cur;
    }
};
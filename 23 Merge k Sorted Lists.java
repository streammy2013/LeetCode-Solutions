/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null) return null;
        int n = lists.length;
        if(n==0) return null;
        
        for(int i=0;i<n;i++){
            if(lists[i]!=null) break;
            if(i==n-1) return null;
        }
        Queue<Node> prQueue = new PriorityQueue<Node>(n,numComparator);
        for(int i=0;i<n;i++){
            if(lists[i]!=null){
                prQueue.add(new Node(lists[i].val,i));
                lists[i] = lists[i].next;
            }
            
        }
        ListNode head = new ListNode (0);
        ListNode current = head;
        while(prQueue.isEmpty()==false){
            Node temp = prQueue.poll();
            int value = temp.getval();
            int id = temp.getlistID();
            ListNode newNode = new ListNode(value);
            current.next = newNode;
            current = current.next;
            if(lists[id]!=null){
                
                prQueue.add(new Node(lists[id].val,id));
                lists[id] = lists[id].next;
            }
        }
        head = head.next;
        return head;
    }
    
    class Node{
        private int val;
        private int listID;
        
        Node(int value, int id){
            val=value;
            listID=id;
        }
        
        public int getval(){return val;}
        public int getlistID(){return listID;}
    }
    
    public Comparator<Node> numComparator = new Comparator<Node>(){
        public int compare(Node n1, Node n2){
            return n1.val-n2.val;
        }
    };
}
package list;

/**
 * @author yangyong
 * @create 2020-10-06-14:59
 */
public class TestPalindrome {
    /*
        思想:使用快慢指针进行遍历，快指针每次走两步，慢指针每次走一步，遍历的同时，慢指针逆序链表，直到快指针走到单链表
        最后一个结点时，此时慢指针恰好走到字符串的中间位置，之后依次比较中间位置两边的每个字符是否相等即可。
     */
    public boolean isPalindrome(Node head){
        //如果链表为空或者长度为1，则直接返回true
        if(head == null && head.next == null){
            return true;
        }else if(head.next.next == null){//长度为2时，需要单独判断
            if(head.next.data != head.data){
                return false;
            }
        }
        //之后，定义快慢指针，快指针每次移动两步，慢指针每次移动一步
        Node slow = head;
        Node fast = head;
        Node pre = null;
        //遍历，与此同时，慢指针边走边反转链表
        while(fast != null && fast.next != null){
            //移动快指针
            fast = fast.next.next;
            //慢指针边反转边走
            //cur备份slow的下一个结点，防止改变方向后链表丢失。
            Node cur = slow.next;
            //将slow的next指针指向pre;
            slow.next = pre;
            //pre后移指向slow
            pre = slow;
            //slow后移指向cur
            slow = cur;
        }
        //当字符串中字符个数为偶数时，这一步不会执行。
        if(fast != null){
            slow = slow.next;
        }
        //之后进行比对
        while(slow!=null){
            if(slow.data != pre.data){
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}

    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
}

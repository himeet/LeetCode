//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表 
// 👍 209 👎 0

package com.glj.leetcode.editor.cn;

public class DesignLinkedList{
    public static void main(String[] args) {
        Solution solution = new DesignLinkedList().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
// 法二：双链表法-虚拟头尾节点法
// 算法思想：
// 时间复杂度：addAtHead()和addAtTail()都是O(1) get()、addAtIndex()、deleteAtIndex()是O(min(index, size-index))
// 空间复杂度：全部都是O(1)
// 时间复杂度说明：无
// 空间复杂度说明：无
// 参考资料1：https://leetcode-cn.com/problems/design-linked-list/solution/she-ji-lian-biao-by-leetcode/(官方解)
// 备注1：关于代码中的index该不该+1的问题，画个简单的链表试试就知道了
// 备注2：代码与官方解并不完全一致，按照自己的理解写的，但是算法思想可以参照官方解

    public class ListNode {  // 定义链表中一个节点的数据结构
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    class MyLinkedList {
        int size;  // 链表的长度
        ListNode dummyHead;  // 链表的虚拟头节点
        ListNode dummyTail;  // 链表的虚拟尾节点

        /** Initialize your data structure here. */
        public MyLinkedList() {
            size = 0;
            dummyHead = new ListNode(0);
            dummyTail = new ListNode(0);
            dummyHead.next = dummyTail;  // 不要忘了要初始化dummyHead的next指针和dummyTai的prev指针
            dummyTail.prev = dummyHead;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (index < 0 || index > size - 1) {
                return -1;
            }
            // 选择最快的路径get节点
            if (index < size / 2) {  // 从头部开始遍历get元素
                ListNode curr = dummyHead;
                for (int i = 0; i < index + 1; i++) {  // 遍历index+1次
                    curr = curr.next;
                }
                return curr.val;
            } else {  // 从尾部开始遍历插入
                ListNode curr = dummyTail;
                for (int i = 0; i < size - index; i++) {  // 遍历size - index次
                    curr = curr.prev;
                }
                return curr.val;
            }
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            node.next = dummyHead.next;
            dummyHead.next.prev = node;
            dummyHead.next = node;
            node.prev = dummyHead;
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            dummyTail.prev.next = node;
            node.prev = dummyTail.prev;
            node.next = dummyTail;
            dummyTail.prev = node;
            size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index >= 0 && index <= size) {
                ListNode node = new ListNode(val);
                // 选择最快的路径插入节点
                if (index < size / 2) {  // 从头部开始遍历插入
                    ListNode curr = dummyHead;
                    for (int i = 0; i < index; i++) {  // 需要循环index次
                        curr = curr.next;
                    }
                    node.next = curr.next;
                    curr.next.prev = node;
                    curr.next = node;
                    node.prev = curr;
                    size++;
                } else {  // 从尾部开始遍历插入
                    ListNode curr = dummyTail;
                    for (int i = 0; i < size - index; i++) {  // 这里是循环size-index次
                        curr = curr.prev;
                    }
                    curr.prev.next = node;
                    node.prev = curr.prev;
                    node.next = curr;
                    curr.prev = node;
                    size++;
                }
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index >= 0 && index <= size - 1) {
                // 选择最快的路径删除节点
                if (index < size / 2) {  // 从头部开始遍历删除
                    ListNode curr = dummyHead;
                    for (int i = 0; i < index; i++) {
                        curr = curr.next;
                    }
                    curr.next = curr.next.next;
                    curr.next.prev = curr;
                    size--;
                } else {  // 从尾部开始遍历删除
                    ListNode curr = dummyTail;
                    for (int i = 0; i < size - index - 1; i++) {  // 这里是循环size-index-1 次
                        curr = curr.prev;
                    }
                    curr.prev = curr.prev.prev;
                    curr.prev.next = curr;
                    size--;
                }
            }
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
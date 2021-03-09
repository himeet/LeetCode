//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1220 👎 0

package com.glj.leetcode.editor.cn;

import java.util.HashMap;

public class LruCache{
    public static void main(String[] args) {
//        Solution solution = new LruCache().new Solution();
    }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // 法一：哈希表+双向链表
    // 算法思想：对于双向链表而言，删除和添加节点是O(1)，但是查找节点是O(n)
    //         对于HashMap而言，查找、删除和添加节点是O(1)，但是不能保持节点的先后的顺序
    //         所以可以将两者结合。但是结合的话，需要注意二者应该有个相同点来保持二者的同步，
    //         那就是使用key来连接二者：HashMap中的key就是链表中节点中的key。
    //         HashMap<key, Node> 这里的Node为内存地址，不能是Integer！
    //         （1）在查找节点的时候（也就是get的时候），若节点存在，使用hashMap找节点，同时
    //             在双向链表中，将该访问到的节点删除，然后添加到链表的头部；若不存在返回-1；
    //         （2）在添加节点的时候（也就是put的时候），通过hashMap快速判断节点是否已经存在。
    //             若节点已经存在，则更新节点：在链表中删除该节点，然后在链表的头部添加该节点；
    //             若节点不存在，则添加节点：首先判断容量是否满，若满则删除链表的最后一个节点，
    //             同时删除HashMap中的对应节点。然后向HashMap中添加该节点，并向链表的头部添加
    //             该节点。
    // 时间复杂度：O(1)，空间复杂度：O(capacity)  其中n是数组的长度
    // 时间复杂度说明：put和get均为O(1)的时间复杂度
    // 空间复杂度说明：因为哈希表和双向链表最多存储capacity+1个元素
    // 参考资料1：https://leetcode-cn.com/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/(官方解)
    // 参考资料2：https://www.bilibili.com/video/BV1hp4y1x7MH(B站视频讲解)
    // 备注1:双向链表添加一个伪头部和一个伪尾部，在删除节点和添加节点的时候更加方便
    // 备注2：参考资料2讲解较为详细，优于官方解
    class LRUCache {
        HashMap<Integer,Node> map;
        DoubleLinkedList cache;
        int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            cache = new DoubleLinkedList();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            int value = map.get(key).value;
            put(key, value);  // 更新LRU缓存  代码复用

            return value;
        }

        public void put(int key, int value) {
            Node newNode = new Node(key, value);

            if (map.containsKey(key)) {
                cache.delete(map.get(key));
                cache.addFirst(newNode);
                map.put(key, newNode);
            } else {
                if (map.size()  == capacity) {
                    int delKey = cache.deleteLast();
                    map.remove(delKey);
                }
                cache.addFirst(newNode);
                map.put(key, newNode);
            }
        }
    }

    /**
     * 双向链表的节点类
     */
    class Node {
        public int key;
        public int value;
        public Node next;
        public Node prev;

        public Node () {}
        public Node (int key, int value) { this.key = key; this.value = value; }
        public Node (int key, int value, Node next, Node prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * 双向链表类
     */
    class DoubleLinkedList {
        public Node dummyHead;
        public Node dummyTail;

        // 构造函数，初始化一个双向链表
        public DoubleLinkedList () {
            dummyHead = new Node(0, 0);
            dummyTail = new Node(0, 0);

            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        // 向链表头部添加一个节点
        public void addFirst(Node node) {
            node.prev = dummyHead;
            node.next = dummyHead.next;

            dummyHead.next.prev = node;
            dummyHead.next = node;
        }

        // 删除某个节点
        public int delete(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node.key;  // 返回删除的节点的key
        }

        // 在链表尾部删除一个节点
        public int deleteLast () {
            // 若链表中没有节点，则返回
            if (dummyHead.next == dummyTail) {
                return -1;
            }
            return delete(dummyTail.prev);  // 代码复用，就不用写下面的两行代码了
//            dummyTail.prev.prev.next = dummyTail;
//            dummyTail.prev = dummyTail.prev.prev;
        }
    }
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
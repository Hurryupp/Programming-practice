package MiroSoftTest;

import java.util.HashMap;

class LRUCache {

    HashMap<Integer,DLinkedNode> cache = new HashMap<Integer,DLinkedNode>();
    int size; //记录数目
    int cap;//记录限制
    DLinkedNode head,tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.cap = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;

        shuchu();
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        else {
            //移到头部
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            //如果没有
            DLinkedNode dLinkedNode = new DLinkedNode(key, value);
            cache.put(key,dLinkedNode);
            addToHead(dLinkedNode);
            ++size;
            if (size > cap) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            //如果有的话
            node.value = value;
            moveToHead(node);
            return;
        }
    }
    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    public void addToHead(DLinkedNode node){
        node.next = head.next;
        node.pre = head;
        head.next = node;
        node.next.pre = node;
        System.out.println("移到头部："+node.key);
    }
    public DLinkedNode removeTail(){
        DLinkedNode node = tail.pre;
        removeNode(node);
        System.out.println("移除："+node.key);
        return node;
    }
    public void removeNode(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    public void shuchu(){
        DLinkedNode tmp = head;
        while (tmp!=null){
            System.out.println(tmp.key+" "+tmp.value);
            tmp = tmp.next;
        }
    }
}
class DLinkedNode{
    int key;
    int value;

    DLinkedNode pre;
    DLinkedNode next;
    DLinkedNode(){

    }

    public DLinkedNode(int key,int value ) {
        this.value = value;
        this.key = key;
    }
}


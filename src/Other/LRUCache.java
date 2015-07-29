package Other;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by myho on 7/26/15.
 *
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {

    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        /* A->B->C , B is this */
        private void detach() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
    }

    private Map<Integer, Node> map;
    private LinkedList<Node> cache;
    private int capacity;
    private int count;
    private Node head;          // head contains least recently used item
    private Node tail;          // tail contains most recently used item

    public LRUCache(int capacity) {
        this.cache = new LinkedList<>();
        this.map = new HashMap<>();

        this.capacity = capacity;
        this.count = 0;

        // use dummy head and tail to make update easier
        head = new Node();
        tail = new Node();

        head.prev = null;
        head.next = tail;

        tail.prev = head;
        tail.next = null;
    }

    public int get(int key) {

        if (map.containsKey(key)) {

            // move node to tail;
            Node node = map.get(key);
            node.detach();

            moveToTail(node);

            return node.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {

        // if key is not in cache, create new node
        Node node = map.get(key);

        if (node == null) {

            node = new Node(key, value);
            moveToTail(node);
            map.put(key, node);
            count++;

            if (count > capacity) {

                // remove LRU node
                Node lruNode = removeFront();
                map.remove(lruNode.key);

                count--;
            }
        } else {
            node.value = value;
            node.detach();
            moveToTail(node);
        }
    }

    private Node removeFront() {
        Node node = head.next;
        node.detach();

        return node;
    }

    private void moveToTail(Node node) {

        // current last node
        Node last = tail.prev;

        last.next = node;
        node.prev = last;

        tail.prev = node;
        node.next = tail;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
        System.out.println(cache.get(2));
    }
}


package com.example.basic.structure.list;

import java.util.Random;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2019/3/30
 */
public class SkipList{

    private Node top;
    private int level;
    private long size;
    private Random random = new Random();

    public SkipList() {
        this(2);
    }

    public SkipList(int level) {
        this.level = level;
        Node start;
        Node temp = null;
        while(level-- != 0 ) {
            start = createNode(Integer.MIN_VALUE); // 开头设置最小数
            start.setNext(createNode(Integer.MAX_VALUE)); // 结尾设置最大数
            if(temp != null) {
                start.setDown(temp);
                start.next.setDown(temp.down);
            }
            temp = start;
        }
        top = temp;
    }

    public static void main(String[] args) {
        SkipList list = new SkipList();
        int n = 10;
        while (n-- != 0) {
            list.add(n);
        }
        System.out.println(list.size);
        list.delete(9);
        System.out.println(list.size);
        list.delete(8);
        System.out.println(list.size);
//        while (n-- != 0) {
//            list.add(new Random().nextInt(1000));
//        }
        System.out.println(list.exsit(9));
        list.print();

    }

    /**
     * 判断元素是否存在
     * @param value
     * @return
     */
    public boolean exsit(Integer value){
        int tempLevel = level;
        Node tempNode = top;
        // 从最顶层开始
        while(tempLevel -- != 0) {
            // 遇到比value大的值则继续往下层找
            while (tempNode.getNext().getValue() < value) {
                tempNode = tempNode.getNext();
            }
            // 如果刚好相等则直接判定
            if(tempNode.getNext().getValue() == value) {
                return true;
            }
            // 取下一层数据
            tempNode = tempNode.getDown();
        }
        return false;
    }

    /**
     *  新增元素
     * @param value
     */
    public void add(Integer value) {
        if(exsit(value)) {
            return;
        }
        // 计算出来元素所在的层数
        int calcLevel = getLevel();
        // 如果大于当前最大层数，则大层数
        if(calcLevel > level) {
            expandLevel(calcLevel);
        }
        int tempLevel = level;
        Node tempNode = top;
        while (tempLevel -- != calcLevel) {
            // 找到元素所在最顶层对应的node节点
            tempNode = tempNode.getDown();
        }
        tempLevel ++;
        Node inserNode; // 插入节点
        Node currentNode = null;
        while (tempLevel -- != 0 ) {
            while(tempNode.getNext().getValue() < value) {
                tempNode = tempNode.getNext();
            }
            // 找到在当前层的位置，然后插入
            inserNode = createNode(value);
            inserNode.setNext(tempNode.getNext());
            if(currentNode != null) {
                // 不是顶层节点需要设置上下层关系
                currentNode.setDown(inserNode);
            }
            currentNode = inserNode;
            tempNode.setNext(inserNode);
            tempNode = tempNode.getDown();
        }
        size ++;
    }

    /**
     * 扩展层数
     * @param calcLevel
     */
    private void expandLevel(int calcLevel) {
        Node start,tempEnd;
        Node temp = top;
        while (level < calcLevel) {
            level ++;
            start = createNode(Integer.MIN_VALUE);
            start.setNext(createNode(Integer.MAX_VALUE));
            start.setDown(temp);
            tempEnd = temp;
            while (tempEnd.next != null) {
                tempEnd = tempEnd.next;
            }
            start.next.setDown(tempEnd);
            temp = start;
        }
        top = temp;
    }

    /**
     * 删除指定元素
     * @param value
     * @return
     */
    public boolean delete(Integer value) {
        Node tempNode = top;
        int tempLevel = level;
        boolean flag = false;
        while (tempLevel -- != 0) {
            while (tempNode.getNext().getValue() < value) {
                tempNode = tempNode.getNext();
            }
            if(tempNode.getNext().getValue() == value) {
                tempNode.setNext(tempNode.getNext().getNext());
                flag = true;
            }
            tempNode = tempNode.getDown();
        }
        if(flag) {
            size --;
        }
        return flag;
    }

    /**
     * 获取元素所在层级
     * @return
     */
    private int getLevel() {
        int level = 1;
        while(random.nextInt() % 2 == 0) {
            level ++;
        }
        return level;
    }

    private Node createNode(int value) {
        return new Node(value);
    }

    /**
     * 存储元素的节点
     */
    class Node implements Comparable<Node> {

        private Integer value;
        private Node next;
        private Node down;

        public Node(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getDown() {
            return down;
        }

        public void setDown(Node down) {
            this.down = down;
        }

        @Override
        public int compareTo(Node node) {
            return this.compareTo(node);
        }
    }

    /**
     * 打印跳跃表结构
     */
    private void print() {

        Node temp = top;
        while (temp != null) {
            Node printNode = temp;
            while (printNode != null) {
                System.out.print(printNode.value + "-");
                printNode = printNode.next;
            }
            System.out.println();
            temp = temp.down;
        }
    }
}

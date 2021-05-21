package com.lga.structure;

/**
 * @Description   :  双向链表
 * @Author        :  gaoan.liu
 * @Date          :  2021/4/7 11:19
 */
public class DoubleLinkedList<T>{

    private Node headNode;

    private int length;


    /**
     * 添加头结点
     * @param data
     */
    public void addHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (length == 0) {
            headNode = newNode;
            return;
        }
        newNode.next = headNode;
        newNode.previous = null;
        headNode.previous = newNode;
        length++;
    }

    /**
     * 添加尾结点
     * @param data
     */
    public void addTail(T data) {
        Node<T> newNode = new Node<>(data);
        Node tempNode = headNode;
        if (tempNode == null) {
            headNode = newNode;
            length++;
            return;
        }

        while (tempNode != null && tempNode.next !=null) {
            tempNode = tempNode.next;
        }
        tempNode.next = newNode;
        newNode.previous = tempNode;
        length++;
    }


    /**
     * 添加某个节点到指定的index位置
     * @param index
     * @param data
     */
    public void add(int index,T data) {
        if (index + 1 > length) {
            return;
        }
        Node<T> newNode = new Node<>(data);

        Node tempNode = headNode;
        int tempIndex = 0;
        while (tempNode != null && tempIndex < index) {
            tempNode = tempNode.next;
            tempIndex++;
        }
        Node preNode = tempNode.previous;
        newNode.next = tempNode;
        tempNode.previous = newNode;
        preNode.next = newNode;
        newNode.previous = preNode;
        length++;
    }


    /**
     * 打印链表情况
     */
    public void printLinkedList() {
        StringBuilder str = new StringBuilder("");
        Node tempNode = headNode;

        while (tempNode != null) {
            str.append(tempNode.data + "->");
            tempNode = tempNode.next;
        }

        System.out.println("打印结果 = " + str);
    }

    /**
     * 双链表节点
     * @param <T>
     */
    class Node<T> {
        Node previous;
        Node next;
        T data;
        public Node(T data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

        doubleLinkedList.addHead(1);
        doubleLinkedList.addTail(2);
        doubleLinkedList.addTail(3);
        doubleLinkedList.addTail(4);
        doubleLinkedList.addTail(5);
        doubleLinkedList.addTail(6);
        doubleLinkedList.addTail(7);

        doubleLinkedList.printLinkedList();

        doubleLinkedList.add(3,999);
        doubleLinkedList.printLinkedList();






    }


}


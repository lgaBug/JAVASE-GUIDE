import org.w3c.dom.Node;

/**
 * @Description :  单链表的实现
 * @Author :  gaoan.liu
 * @Date :  2021/4/7 9:15
 */
public class SingleLinkedList<T> {

    private Node<T> head = null;

    private int length = 0;

    /**
     * 添加头节点
     *
     * @param data
     */
    public void addHead(T data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
        length++;
    }

    /**
     * 添加尾节点
     *
     * @param data
     */
    public void addTail(T data) {
        Node newTail = new Node(data);
        Node tempNode = head;
        if (tempNode == null) {
            head = newTail;
            length++;
            return;
        }
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = newTail;
        length++;
    }

    /**
     * 添加元素到某一个index位置
     *
     * @param index
     * @param data
     */
    public void add(int index, T data) {
        if (index > length) {
            return;
        }

        Node newNode = new Node(data);

        Node currentNode = head;
        Node nextNode = head.next;
        int tempIndex = 0;

        while (tempIndex + 1 < index) {
            tempIndex++;
            currentNode = currentNode.next;
            nextNode = nextNode.next;
        }
        newNode.next = nextNode;
        currentNode.next = newNode;
        length++;
    }


    /**
     * 删除某一个index位置的元素
     *
     * @param index
     */
    public void deleteByIndex(int index) {
        if (index + 1 > length) {
            return;
        }
        Node tempNode = head;
        int tempIndex = 0;
        while (tempNode != null && tempIndex < index) {
            tempNode = tempNode.next;
            tempIndex++;
        }
        tempNode.next = tempNode.next.next;
        length--;
    }

    /**
     * 删除第一个元素为data的数据
     *
     * @param data
     * @return
     */
    public boolean delete(T data) {
        Node currentNode = head;
        Node nextNode = head.next;
        while (currentNode != null && nextNode != null) {
            if (data.equals(nextNode.data)) {
                currentNode.next = currentNode.next.next;
                length--;
                return true;
            }
            currentNode = currentNode.next;
            nextNode = nextNode.next;
        }
        return false;
    }

    /**
     * 更新某个下标的元素值
     *
     * @param index
     * @param newData
     * @return
     */
    public boolean update(int index, T newData) {
        if (index + 1 > length) {
            return false;
        }

        Node tempNode = head;
        int tempIndex = 0;
        while (tempNode != null && tempIndex < index) {
            tempIndex++;
            tempNode = tempNode.next;
        }
        tempNode.data = newData;
        return true;


    }


    /**
     * 获取第index元素值
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index + 1 > length) {
            return null;
        }
        Node tempNode = head;
        int tempIndex = 0;
        while (tempNode != null && tempIndex < index) {
            tempIndex++;
            tempNode = tempNode.next;
        }
        return (T) tempNode.data;
    }

    /**
     * 打印链表情况
     */
    public void printLinkedList() {
        StringBuilder str = new StringBuilder("");
        Node tempNode = head;

        while (tempNode != null) {
            str.append(tempNode.data + "->");
            tempNode = tempNode.next;
        }

        System.out.println("打印结果 = " + str);
    }

    /**
     * 获取单链表长度
     *
     * @return
     */
    public int getLength() {
        int length = 0;
        Node tempNode = head;
        while (tempNode != null) {
            length++;
            tempNode = tempNode.next;
        }
        return length;
    }


    class Node<T> {
        Node next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {

        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList();

        System.out.println("第一次打印。。。");
        singleLinkedList.printLinkedList();

        singleLinkedList.addHead(1);
        System.out.println("第二次打印。。。");
        singleLinkedList.printLinkedList();

        singleLinkedList.addTail(2);
        singleLinkedList.addTail(3);
        singleLinkedList.addTail(4);
        singleLinkedList.addTail(5);
        singleLinkedList.addTail(6);
        singleLinkedList.addTail(7);
        singleLinkedList.addTail(8);

        System.out.println("第三次打印。。。");
        singleLinkedList.printLinkedList();


        singleLinkedList.add(2, 99);
        System.out.println("第四次打印。。。");
        singleLinkedList.printLinkedList();


        singleLinkedList.delete(2);
        System.out.println("第五次打印。。。");
        singleLinkedList.printLinkedList();


        singleLinkedList.update(2,88);
        System.out.println("第五次打印。。。");
        singleLinkedList.printLinkedList();

    }


}

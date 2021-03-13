package com.qiuhaoyang;

public class MyList {
    //结点
    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    //创建一个结点
    public static Node creatList(){
        Node head = new Node(0);
        Node node = head;
        Node nNode;//nNode为node的下一个节点
        for(int i = 1; i<=10; i++){
            nNode = new Node(i);
            node.next = nNode;
            node = nNode;
        }
        return head;
    }
    //区间反转链表
    public static Node reverseList(Node head, int begin, int end){
        Node beforeSection = null; //beforeSection为区间的第一个节点的，前一个节点
        Node eNode; //反转前,eNode为在反转区间的第一个节点，在反转后，是在反转区间的最后一个节点
        Node node = head;
        Node nNode; //nNode为node的下一个节点
        Node bNode; //bNode为node的上一个节点

        for(int i = 1;i < begin; i++){
            beforeSection = node;
            node = node.next;
        }

        eNode = node;
        bNode = node;
        nNode = node.next;
        for(int i = 0;i < end - begin;i++){
            node = nNode; //此时的node为反转区间的第二个
            nNode = node.next;
            node.next = bNode;
            bNode = node;
            if(nNode == null){
                break;
            }
        }
        if(begin == 1){
            head = node; //因为没有头节点，需要讨论
        }else beforeSection.next = node;
        eNode.next = nNode;
        return head;
    }
    //打印链表
    public static void printList(Node head){
        while(head != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
    }
    //头插
    public static Node headInsert(Node head, int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
        return head;
    }
    //尾插
    public static Node tailInsert(Node head, int data){
        Node node = head;
        while(node.next != null){
            node = node.next;
        }
        node.next = new Node(data);
        return head;

    }
    //查找
    public static void findByNum(Node head, int number){
        for(int i = number;i > 1; i--){
            head = head.next;
            if(head == null){
                System.out.println("查找超出链表范围");
                return;
            }
        }
        System.out.println(head.data);
    }
    //尾删
    public static Node tailDeL(Node head){
        Node node = head;
        while(node.next.next != null){
            node = node.next;
        }
        node.next = null;
        return head;
    }
    //头删
    public static Node headDeL(Node head){
         return head.next;
    }
    //查找倒数第K个、、、
    public static void printLastK(Node head, int k){
        Node node = head;
        Node bNode = head;
        for(int i = 1;i < k;i++){
            node = node.next;
        }
        while(node != null){
            node = node.next;
            if(node != null){
                bNode = bNode.next;
            }
        }
        System.out.println(bNode.data);
    }
    //找到并输出中间结点
    public static void findMid(Node head){
        Node node = head;
        Node bNode = head;
        while(node.next != null && node.next.next != null){
            node = node.next.next;
            bNode = bNode.next;
        }
        System.out.println(bNode.data);
    }
    //判断是否为环形链表
    public static void isCircleList(Node head){
        Node stepOne = head;
        Node stepTwo = head;
        while(stepTwo != null && stepTwo.next != null){
            stepTwo = stepTwo.next.next;
            stepOne = stepOne.next;
            if(stepOne == stepTwo){
                System.out.println("链表成环");
                return;
            }
        }
        System.out.println("链表不成环");


    }
    public static void main(String[] args) {
        Node head = creatList();
        printList(head);
        System.out.println();

        head = reverseList(head, 1, 11);
        printList(head);
        System.out.println();

        head = headInsert(head,13);
        printList(head);
        System.out.println();

        head = tailInsert(head,33);
        printList(head);
        System.out.println();

        findByNum(head, 3);

        head = tailDeL(head);
        printList(head);
        System.out.println();

        head = headDeL(head);
        printList(head);
        System.out.println();

        printLastK(head, 8);

        findMid(head);
        isCircleList(head);

        System.out.println("asasasas");
        System.out.println("asasas");
        System.out.println("阿三十大");
        System.out.println("asasasaddd");
        System.out.println("wo爱你");
        System.out.println("woxihuanni");
        System.out.println("gg");
        System.out.println("sdaaassssss");

    }
}

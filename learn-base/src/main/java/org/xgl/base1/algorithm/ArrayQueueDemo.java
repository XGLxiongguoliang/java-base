package org.xgl.base1.algorithm;

import java.util.Scanner;

/**
 * @program algorithm
 * @description 数组实现队列
 * @auther Mr.Xiong
 * @create 2024-02-26 22:27:15
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("s->显示队列");
            System.out.println("e->退出程序");
            System.out.println("a->添加数据到队列");
            System.out.println("o->从队列取数据");
            System.out.println("q->查询队列头部数据");

            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showArrayQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    arrayQueue.add(value);
                    break;
                case 'o':
                    int out = arrayQueue.out();
                    System.out.println("取出的数字是---" + out);
                    break;
                case 'q':
                    int head = arrayQueue.queryHeadValue();
                    System.out.println("查询的头部数字是---" + head);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出");
    }

    static class ArrayQueue {
        private int maxSize;
        private int rear;
        private int front;
        private int[] arr;

        //构造方法
        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
            this.front =  -1;
            this.rear = -1;
        }

        //判断元素是否已满
        public boolean isFull() {
            return rear == maxSize - 1;
        }

        //判断元素是否为空
        public boolean isEmpty() {
            return rear == front;
        }

        //添加一个元素
        public void add(int value) {
            if (isFull()) {
                throw new RuntimeException("队列满了，暂时无法添加元素");
            }
            rear++;
            arr[rear] = value;
        }

        //取出一个元素
        public int out() {
            if (isEmpty()) {
                throw new RuntimeException("队列空了，暂时无法取出元素");
            }
            front++;
            return arr[front];
        }

        //查询队列头部首个数据
        public void showArrayQueue() {
            if (isEmpty()) {
                System.out.println("队列为空");
            }
            for (int i = 0; i < maxSize; i++) {
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
            }
        }

        //查询整个队列
        public int queryHeadValue() {
            if (isEmpty()) {
                System.out.println("队列为空，没有数据");
                throw new RuntimeException("队列为空，没有数据");
            }
            return arr[front +1];
        }
    }
}

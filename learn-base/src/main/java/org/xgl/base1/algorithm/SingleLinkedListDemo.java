package org.xgl.base1.algorithm;

/**
 * @program algorithm
 * @description 单链表
 * @auther Mr.Xiong
 * @create 2024-02-29 21:58:55
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode h1 = new HeroNode(1, "宋江");
        HeroNode h2 = new HeroNode(2, "卢俊义");
        HeroNode h3 = new HeroNode(3, "吴用");
        HeroNode h4 = new HeroNode(4, "林冲");
        singleLinkedList.add(h1);
        singleLinkedList.add(h2);
        singleLinkedList.add(h3);
        singleLinkedList.add(h4);
        singleLinkedList.selectAll();
        System.out.println("aLL-----");

        singleLinkedList.delete(3);
        singleLinkedList.selectAll();
        System.out.println("删除3-----");

        singleLinkedList.update(new HeroNode(1, "刘备"));
        singleLinkedList.selectAll();
        System.out.println("更改1-----");
    }

    static class HeroNode {
        private int no;
        private String name;
        private HeroNode next;

        public HeroNode(int no, String name) {
            this.no = no;
            this.name = name;
        }

        @Override
        public String toString() {
            return "HeroNode：【no=" + no +", name=" + name + "】";
        }
    }

    static class SingleLinkedList {
        private HeroNode head = new HeroNode(0, "");

        public void add(HeroNode heroNode) {
            HeroNode temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            temp.next = heroNode;
        }

        public void delete(int no) {
            HeroNode temp = head;
            boolean flag = false;
            while (true) {
                if (head.next == null) {
                    break;
                }

                //当删除的元素和遍历中的某个元素no相同，则删除该元素
                if (temp.next.no == no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.next = temp.next.next;
            }
        }

        public void update(HeroNode heroNode) {
            HeroNode temp = head;
            boolean flag = false;
            while (true) {
                if (temp.next == null) {
                    break;
                }

                //当删除的元素和遍历中的某个元素no相同，则删除该元素
                if (temp.next.no == heroNode.no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.next.name = heroNode.name;
            }
        }

        public void selectAll() {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }

            HeroNode temp = head.next;
            while (true) {
                if (temp == null) {
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }
}

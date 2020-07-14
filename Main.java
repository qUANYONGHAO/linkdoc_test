package Main;


public final class Main {


    class Stack<Item> { //声明为泛型
        /*----------循环实现-----------*/
        private Item[] data;
        private int top;

        public Stack(int n) {
            data = (Item[]) new Object[n];//数组转换为泛型,初始化栈容量为n
            top = -1; //作为栈顶，-1表示栈空
        }

        public void push(Item item) {//入栈
            if (top == data.length - 1) {//top的值和数组的下标一致，如过top值和数组的最大容量相等,栈满
                resize(2 * data.length);
                data[++top] = item;
            } else {
                top = top + 1; //栈顶+1
                data[top] = item;//元素入栈
            }
        }

        public Item pop() {//出栈
            if (top == -1) {
                System.out.println("栈为空！没有元素可出栈");
                return null; //如果栈为空返回null
            } else {
                Item item = data[top]; //如果栈不空，返回栈顶元素，然后栈顶-1
                data[top] = null;//避免对象游离
                top = top - 1;
                if (top > 0 && top == (data.length - 1) / 4) {
                    resize(data.length / 2);
                }
                return item;
            }

        }

        public boolean isEmpty() {//判断是否栈空
            return top == -1 ? true : false;
        }

        public int size() { //返回栈的长度
            return top + 1;
        }

        public void clear() {//清空栈
            top = -1;
        }

        public void resize(int max) {
            //将大小为top<=max的栈移动到新的大小为max的数组中
            Item[] temp = (Item[]) new Object[max];
            for (int i = 0; i <= top; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
    }

    class Queue {
        private String[] arr;   //队列数组
        private int end = 0;  //队尾标志

        //向队列中添加元素
        public void push(String[] arr, String value) {
            if (end < arr.length) {
                arr[end] = value;
                end++;
                return;
            } else {
                System.out.println("队列已经满了");
                return;
            }
        }

        //取出队列元素
        public String pop(String[] arr) {
            String rs;
            if (arr[0] == null) {
                System.out.println("队列为空，请先向队列中添加元素");
                return null;
            } else {
                rs = arr[0];
                arr[0] = null;
                return rs;
            }

        }
    }
}
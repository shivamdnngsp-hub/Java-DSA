public class random {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    static Node aaaToll(int[] arr) {
        Node head = new Node(arr[0]);

        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newnode = new Node(arr[i]);
            temp.next = newnode;
            temp = temp.next;
        }
        return head;
    }


    static Node revrseLL(Node head){

       Node temp = head;
       Node prev = null;
       Node front = null;
       while(temp != null){
           front = temp.next;
           temp.next = prev;
           prev = temp;
           temp = front;
       }

return prev;
    }


    static void print(Node head){

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data);
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        print(revrseLL(aaaToll(arr)));

    }

}


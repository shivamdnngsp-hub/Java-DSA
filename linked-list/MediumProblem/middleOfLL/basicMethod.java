public class random {

    static class  Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }



    static Node  aaaToll(int[] arr){
        Node head = new Node(arr[0]);

        Node temp = head;
        for(int i = 1;i< arr.length;i++){
            Node newnode = new Node(arr[i]);
            temp.next = newnode;
            temp = temp.next;
        }
        return head;
    }


    static int printMiddle(Node head){

        if(head.next == null) return head.data;
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        int middleIndex = (count/2) +1;
        Node temp2 = head;
        for(int i = 1;i< middleIndex;i++){
            temp2 = temp2.next;
        }

        return temp2.data;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(printMiddle(aaaToll(arr)));

    }

}

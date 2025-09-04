package CLASE4;
public class LinkedList {
    private Node head;  
    public Node getHead() {
        return head;
    }
    public void setHead(Node head) {
        this.head = head;   
    }

    public void add(Object data) {
        Node newNode = new Node();
        newNode.setData(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
        }
    }
    public String toString() {
        Node iter = head;
        String returnString = "";
        while (iter != null) {
            returnString = returnString + ", " + iter.getData();
          iter = iter.getNextNode();
        }
        return returnString;
    }
    public int size() {
        int size = 0;
        Node iter = head;
        while (iter != null) {
            size++;
            iter = iter.getNextNode();
        }
        return size;
    }

    public void delete(int index) {
        Node iter = head;
        int i=0;
        while(iter != null){
            if (i+1==index){
                iter.setNextNode(iter.getNextNode().getNextNode());
            }else{
                i++;
                iter = iter.getNextNode();
        }
       
        }
    
    }

}

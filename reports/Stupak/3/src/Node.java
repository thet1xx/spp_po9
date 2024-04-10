package Lab3_2;

public class Node{
    Train train;
    Node left, right;

    public Node(Train train) {
        this.train = train;
        left = right = null;
    }
}

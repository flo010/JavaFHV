package BoundQueueArr;


public class Node {
    private Job _job;

    private Node _nextNode;

    public Node getNextNode() {
        return _nextNode;
    }

    public Job getJob() {
        return _job;
    }

    public void setJob(Job job) {
        _job = job;
    }

    public void setNextNode(Node nextNode) {
        _nextNode = nextNode;
    }

    public boolean hasNextNode(){
        return _nextNode != null;
    }
}

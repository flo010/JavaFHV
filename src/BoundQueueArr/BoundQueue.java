package BoundQueueArr;


import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BoundQueue {
    private Node _firstNode;

    private Node _lastNode;
    private int _maxlength;

    private int _length;

    public BoundQueue(int length){
        _maxlength = length;
    }

    public boolean isFull(){
        return _maxlength <= _length;
    }
    public boolean isEmpty(){
        return _lastNode == null;
    }

    public void enqueue(Node node){
        if(isFull()){
            throw new RuntimeException("MaxLength has been Reached");
        }
        if(isEmpty()){
            _firstNode = node;
            _lastNode = node;
        }
        else {
            _firstNode.setNextNode(node);
            _firstNode = node;
        }
        _length++;
    }

    public Node dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        Node returnNode = _lastNode;
        _lastNode = returnNode.getNextNode();
        _length--;
        return returnNode;
    }

    public QueueItr queueItr(){
        return new QueueItr();
    }

    private class QueueItr implements Iterator {
        private Node _itr;

        public QueueItr(){
            _itr = _lastNode;
        }
        @Override
        public boolean hasNext() {
            return _itr.hasNextNode();
        }

        @Override
        public Job next() {
             if(!hasNext()){
                throw new NoSuchElementException();
             }
             _itr = _itr.getNextNode();
             return _itr.getJob();
        }
    }
}

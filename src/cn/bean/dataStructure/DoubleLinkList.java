package cn.bean.dataStructure;

public class DoubleLinkList<T> extends SingleLinkList<T> {
	//链表中的最后一个节点
    protected Node lastNode=null;
     /**
     * 添加到链表的最后
     * @param element
     */
    public void addLast(T element){
        Node node=new Node();
        node.setData(element);
        
        if(size==0){//说明没有任何元素，说明第一个元素
            firstNode=node;
        }else{//如果有元素，将最后一个节点的next指向新的节点即可
            /*这里有一个要注意的地方：
                当size=1的时候，firstNode和lastNode指向同一个引用
                因此lastNode.setNext时，fisrtNode的next引用也会改变;
                当size!=1的时候，lastNode的next的改变与firstNode无关*/
            lastNode.setNext(node);
        }
        
        //将lastNode引用指向新node
        lastNode=node;
        size++;
        
    }
    
    /**
     * 当链表中没有元素时，清空lastNode引用
     */
    @Override
    public boolean remove(T element) {
        boolean result=super.remove(element);
        if(size==0){
            lastNode=null;
        }
        return result;
    }
 
    /**
     * 因为在SingleLinkList中并没有维护lastNode的信息，我们要自己维护
     */
    @Override
    public Node addFirst(T element) {
        Node node=super.addFirst(element);
        if(size==1){//如果链表为size为1，将lastNode指向当前节点
            lastNode=node;
        }
        return node;
    }
    
    
}

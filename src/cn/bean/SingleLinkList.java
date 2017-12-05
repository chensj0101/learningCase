package cn.bean;

public class SingleLinkList<T> {
	//链表中第一个节点
    protected Node firstNode=null;
 
    //链表中维护的节点总量
    protected int size;
 
    /**
     * 添加到链表的最前面
     * @param element
     */
    public Node addFirst(T element){
        Node node=new Node();
        node.setData(element);
        Node currentFirst=firstNode;
        node.setNext(currentFirst);
        firstNode=node;
        size++;
        return node;
    }
 
    /**
     * 如果链表中包含要删除的元素，删除第一个匹配上的要删除的元素，并且返回true;
     * 如果没有找到要删除的元素，返回false
     * @param element
     */
    public boolean remove(T element){
        if(size==0){
            return false;
        }
        if(size==1){
            firstNode=null;
            size--;
        }
 
        Node pre=firstNode;
        Node current=firstNode.getNext();
        while(current!=null){
            /*如果当前节点中维护的值就是要删除的值，
            直接将上一个节点pre的next应用指向当前节点current的下一个节点接口*/
            if((current.getData()==null&&element==null)
                    ||(current.getData().equals(element))){
                pre.setNext(current.getNext());
                size--;
                return true;
            }
 
            //如果当前元素不是要删除的元素，继续循环
            pre=current;
            current=current.getNext();
        }
        return false;
    }
 
    /**
     * 如果包含返回true，如果不包含，返回false
     * @param element
     * @return
     */
    public boolean contains(Object element){
        if(size==0){
            return false;
        }
        Node current=firstNode;
        while(current!=null){
            if((current.getData()==null&&element==null)
                    ||(current.getData().equals(element))){
                return true;
            }
 
            //如果当前元素不是要删除的元素，继续循环
            current=current.getNext();
        }
        return false;
    }
 
    public boolean isEmpty(){
        return size==0;
    }
 
    public int size(){
        return size;
    }
 
    /**
     * 打印出所有的元素
     */
    public void display(){
        if(!isEmpty()){
            Node current=firstNode;
            while(current!=null){
                System.out.print(current.getData()+"\t");
                current=current.getNext();
            }
        }
    }
    /**
     * 删除第一个元素
     */
    @SuppressWarnings("unchecked")
	public T removeFisrt() {
        Node result=null;
        if(size!=0) {
            result = firstNode.getNext();
            firstNode= result;
            return (T) result.getData();
        }
       return null;
    }
 
    @SuppressWarnings("unchecked")
	public T getFirst() {
        return (T) firstNode.getData();
    }
    
    /*
     * 测试用的代码
     */
    /*@Test
    public void testAddFisrt() {
        SingleLinkList<Integer> linkList=new SingleLinkList<Integer>();
        for (int i = 0; i < 10; i++) {
            linkList.addFirst(i);
        }
        linkList.display();
    }
    @Test
    public void testRemove() {
        SingleLinkList<Integer> linkList=new SingleLinkList<Integer>();
        for (int i = 0; i < 10; i++) {
            linkList.addFirst(i);
        }
        if(!linkList.isEmpty()){
            linkList.remove(5);
        }
        linkList.display();
    }
    @Test
    public void testRemoveFisrt() {
        SingleLinkList<Integer> linkList=new SingleLinkList<Integer>();
        for (int i = 0; i < 10; i++) {
            linkList.addFirst(i);
        }
        linkList.removeFisrt();
        linkList.display();
    }
    @Test
    public void testContains() {
        SingleLinkList<Integer> linkList=new SingleLinkList<Integer>();
        for (int i = 0; i < 10; i++) {
            linkList.addFirst(i);
        }
        System.out.println(linkList.contains(5));
        System.out.println(linkList.contains(10));
    }*/
}

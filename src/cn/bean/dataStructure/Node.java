package cn.bean.dataStructure;

public class Node {
	//Node中维护的数据
    private Object data;
    //下一个元素的引用
    private Node next;
    // setters and getters
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}

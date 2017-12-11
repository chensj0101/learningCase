package cn.bean.dataStructure;

public class Array<V> {
    private Object[] elements;
    private int size = 0; //数组中元素的数量；
    private int capacity; //数组的容量；
    
    /** 设置数组的容量
     * @param capacity
     */
    public Array(int capacity) {
    	this.capacity = capacity;
    	if(capacity <=0) {
    		throw new IllegalArgumentException("capacity must > 0");
    	}
    	elements = new Object[capacity];
    }
    
    /** 数组中插入一个元素
     * @param v
     */
    public void insert(V v) {
    	if(size == capacity-1) {//达到容量限制
    		throw new IndexOutOfBoundsException();
    	}
    	elements[size++] = v; 
    }
    
    /** 删除数组中一个元素
     * @param v
     * @return
     */
    public boolean remove(V v) {
    	for(int i = 0; i < size; i++) {
    		if(elements[i].equals(v)) {
    			elements[i] = null;//删除
    			moveUp(i,size);//将后面的所有数据项都向前移动一个位置；
    			size--;//元素数量自减一
    			return true;//找到第一个要删除的项，返回true；
    		}
    	}
    	return false;//当所有元素都查找过了，依然没有找到要删除的项，返回false;
    }

	/** 删除数组中一个元素后，将该元素后面的元素前移一位；
	 * @param i
	 * @param size
	 */
	private void moveUp(int i, int size) {
		while(i < size-1) {
			elements[i] = elements[++i];
		}
		elements[size-1] = null;//最后一个元素置为null；
	}
	
	/** 查询数组中是否有该元素
	 * @param v
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public V find(V v) {
		for(int i = 0; i < size; i++) {
			if(elements[i].equals(v)) {
				return (V) elements[i];
			}
		}
		return null;
	}
	
	/** 返回指定下标的元素
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public V get(int index) {
		if(index > capacity-1) {
			throw new IndexOutOfBoundsException();
		}
		return (V) elements[index];
	}
	
	/** 返回数组中元素的数量
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/** 展示所有数组中的元素
	 * @param prefix
	 */
	public void display(String prefix) {
		System.out.print(prefix);
		for(int i = 0; i < elements.length; i++) {
			if(i < size) {
				System.out.print(elements[i] + "   ");
			}else {
				System.out.print("null" + "   ");
			}
		}
		System.out.println();
	}
//测试用的代码	
//	public static void main(String[] args) {
//		Array<Integer> array = new Array<Integer>(5);
//		array.insert(1);
//		array.insert(5);
//		array.insert(3);
//		array.display("初始 1、5、3 ： ");
//		array.insert(4);
//		array.display("添加 4      ：");
//		array.remove(3);
//		array.display("删除 3      ：");
//		System.out.println("查找 4 ：" + array.find(4));
//		System.out.println("查找 3 ：" + array.find(3));
//	}
}

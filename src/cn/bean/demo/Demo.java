package cn.bean;

import org.junit.Test;

public class Demo {
    @Test
    public void test01() {
    	Array<Integer> a= new Array<Integer>(5); 
    }
    /**
     * 测试插入，注意我们使用的无参构造方法，因此默认容量大小是16 而我们插入的是20个元素，
     因此我们的SimpleArrayList会自动扩容
     */
    @Test
    public void testInsert() {
        SimpleArrayList<Integer> list = new SimpleArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        System.out.println("size:" + list.size() + ",capacity:" + list.capacity());
    }
    
    /**
* 测试遍历
*/
@Test
public void testTraverse() {
   // 准备数组
   SimpleArrayList<Integer> list = new SimpleArrayList<Integer>();
   for (int i = 0; i < 20; i++) {
       list.add(i);
   }

   for (int i = 0; i < list.size(); i++) {
       System.out.print(list.get(i)+" ");
   }
}
/**
 * 测试删除
 */
@Test
public void testDelete() {
    // 准备数组
    SimpleArrayList<Integer> list = new SimpleArrayList<Integer>();
    for (int i = 0; i <20; i++) {
        list.add(i);
    }
    
    //删除index为10的元素
    list.remove(10);
    
    for (int i = 0; i < list.size(); i++) {
        System.out.println("index:"+i+";value:"+list.get(i));
    }
    System.out.println("size:" + list.size() + ",capacity:" + list.capacity());
}
	@Test
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
    }
    @Test
    public void testDoubleLinkAddFisrt() {
        DoubleLinkList<Integer> linkList=new DoubleLinkList<Integer>();
        for (int i = 0; i < 5; i++) {
            linkList.addFirst(i);
        }
        for (int i = 0; i < 5; i++) {
            linkList.addLast(i);
        }
        linkList.display();
    }
    @Test
    public void test() {
    
    	int[] arr = new int[]{9,8,7,6,5,4,3,2,1,0};
    	int orderLastIndex = 0;
    	int num = 0;
    	for(int i = orderLastIndex + 1; i < arr.length; i++) {
    		int temp = arr[i];
    		int insertPlaceIndex = i;
    		for(int j = orderLastIndex; j >=0; j--) {
    			if(arr[j] > temp) {
    				arr[insertPlaceIndex] = arr[j];
    				insertPlaceIndex--;
    			}else {
					break;
				}
    			num++;
    		}
    		arr[insertPlaceIndex] = temp;
    		orderLastIndex++;
    	}
    	for(int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i]+"\t");
    	}
    	System.out.println();
    	System.out.println(num);
    }
}

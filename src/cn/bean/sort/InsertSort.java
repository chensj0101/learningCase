package cn.bean.sort;

import java.util.Arrays;

import org.junit.Test;

public class InsertSort {
	public static void sort(int[] arr, boolean asc) {
		int lastIndexOfOrder = 0; //设置有序区的最后一个元素的位置，刚开始排序时设置为0；
		for(int i=lastIndexOfOrder+1; i<arr.length; i++) {//对无序区的元素进行迭代，无序区第一个元素即为有序区最后元素的下一个，位置随着有序区最后一个元素的右移而随之右移
			int temp =arr[i];//临时保存无序区的第一个元素
			int insertOrder = i;//迭代有序区元素开始前，元素即将被插入的位置（该位置随着与有序区元素的大小比较的结果而变化）；
			for(int j=lastIndexOfOrder; j>=0; j--) {//迭代有序区的元素，从最后一个元素开始逐一与无序区第一个元素进行比较；
				if(asc) {//升序
					if(arr[j] > temp) {//如果有序区的元素大于无序区第一个元素，则将其右移一个位置，随之，元素插入的位置发生变化，左移一个位置；然后继续进行下一个比较
						arr[j+1] = arr[j];
						insertOrder--;
					}else {
						break;//如果有序区的元素小于要插入的这个元素，由于有序区的有序性，不需要继续进行下面的比较
					}
				}else {//降序
					if(arr[j] < temp) {//如果有序区的元素小于无序区第一个元素，则将其右移一个位置，随之，元素插入的位置发生变化，左移一个位置；然后继续进行下一个比较
						arr[j+1] = arr[j];
						insertOrder--;
					}else {
						break;////如果有序区的元素大于要插入的这个元素，由于有序区的有序性，不需要继续进行下面的比较
					}
				}
			}
			arr[insertOrder] = temp;//完成对有序区元素的迭代比较后，将要插入的元素插入对应的位置
			lastIndexOfOrder++;//完成将无序区的一个元素插入有序区后，将有序区的最后一个元素位置右移加一；
		}
	}
	//测试代码
	@Test
	public void testInsertSort() {
		int[] arr =new int[]{1,2,2,4,8,5,3,7,9,6};
		System.out.println("排序前：" + Arrays.toString(arr));
		sort(arr, true);
		System.out.println("升序后：" + Arrays.toString(arr));
		sort(arr, false);
		System.out.println("降序后：" + Arrays.toString(arr));
	}
//   出处：田守枝Java技术博客
//	 2.3 插入排序
//	 2017-02-09 23:44:39 361 0
//
//	    插入排序(Insert Sort)将待排序的数组分为2部分：有序区，无序区。其核心思想是每次取出无序区中的第一个元素，插入到有序区中。 有序与无序区划分，就是通过一个变量标记当前数组中，前多少个元素已经是局部有序了。
//
//	   在排序开始的时候，把数组的第1个元素当成有序区(即有序区只有一个元素)，其余的所有元素当做无序区。
//
//	    之后在往有序区插入无序区第一个元素值时，有序区中比这个值小(或者大)的元素都要右移一个位置。右移并不会覆盖的数组中已有的数据项值，因为我们总是取无序区中的第一个元素插入，右移也只是覆盖了我们取出的这个元素的位置而已。当无序区为空时，排序完成。
//
//	   插入排序根据具体实现方式又分为：直接插入排序，二分插入排序（又称折半插入排序），链表插入排序，希尔排序（又称缩小增量排序）。属于稳定排序的一种（通俗地讲，就是两个相等的数不会交换位置） 。
//
//	 直接插入排序
//
//	 代码实现：
//
//	     public class InsertSort {
//	         public static void sort(int[] arr,boolean asc){
//	                 //有序区最后一个元素位置
//	             int orderedLastIndex=0;//开始排序时，将有序区结束位置设为0 (开始位置总是0)，对应的无序区范围就是 1-arr.length
//	             for (int i = orderedLastIndex+1; i < arr.length; i++) { //迭代无序区中的每一个元素，依次插入有序区中
//	                 int temp=arr[i];//记录无序区中的第一个元素值
//	                 int insertIndex=i;//在有序区中插入的索引的位置，刚开始就设置为自己的位置
//	                 for (int j = orderedLastIndex; j >= 0; j--) { //从有序区从后往前开始比较
//	                     if(asc){//升序，有序区中比当前无序区中元素大的都右移一个位置
//	                         if(arr[j]>temp){
//	                             arr[j+1]=arr[j];
//	                             insertIndex--;//有序区每移动一次，将插入位置-1
//	                         }else{
//	                             break;//有序区当前位置元素<=无序区第一个元素，那么之前的元素都会<=，不需要继续比较
//	                         }
//	                     }else{//升序，有序区中比当前无序区中元素小的都右移一个位置
//	                         if(arr[j]<temp){
//	                             arr[j+1]=arr[j];
//	                             insertIndex--;
//	                         }else{
//	                             break;
//	                         }
//	                     }
//	                 }
//	                 arr[insertIndex]=temp;
//	                 orderedLastIndex++;
//	             }
//	         }
//	      
//	         public static void main(String[] args) {
//	             int[] arr=new int[]{1,5,6,8,9,4,3,3};
//	             System.out.println("排序数组："+ Arrays.toString(arr));
//	             sort(arr,true);
//	             System.out.println("升序排列："+Arrays.toString(arr));
//	             sort(arr,false);
//	             System.out.println("降序排列："+Arrays.toString(arr));
//	         }
//	     }
//
//	 运行程序：
//
//	 排序数组：[1, 5, 6, 8, 9, 4, 3, 3]
//
//	 升序排列：[1, 3, 3, 4, 5, 6, 8, 9]
//
//	 降序排列：[9, 8, 6, 5, 4, 3, 3, 1]
//
//	 直接插入排序的效率：
//
//	     在第1趟排序中，最多需要比较1次
//
//	     在第2趟排序中，最多需要比较2次
//
//	     .....
//
//	     在第n-1趟排序中，最多需要比较n-1次
//
//	     因此最多需要比较n*(n-1)/2次
//
//	    冒泡排序也是需要比较n*(n-1)/2次，但是二者不同之处在于，冒泡排序肯定是需要比较n*(n-1)/2次，插入排序只有在最坏的情况下才会需要n*(n-1)/2次，回顾上例中的出现的break，当我们发现某个元素不符合时，就直接跳出，有序区之前的元素都不会再比较了，从概率的角度来说，实际上只需要和有序区中一半的元素进行比较，因此需要除以2，即插入排序比较的平均时间复杂度是n*(n-1)/4，所以有的时候我们会看到 插入排序比冒泡排序效率高一倍 的说法
//
//	 二分插入排序
//
//	   二分插入排序与直接插入排序的区别是，直接插入排序是迭代有序区中的每一个数据项与无序区中的第一个元素进行比较，二分插入排序实际上是充分利用了有序区的特定，我们知道，对于一个有序的数组，我们可以利用二分查找快速定位某个数字应该插入的位置，在定位了这个位置之后，只需要将这个位置以及之后的元素右移一位，将腾出来的位置直接插入无序区中的第一个元素即可，减少了比较次数。
}


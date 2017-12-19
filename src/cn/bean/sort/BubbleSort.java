package cn.bean.sort;

import java.util.Arrays;

import org.junit.Test;

/** 冒泡排序
 * @author chensj
 * 
 */
public class BubbleSort {

	/** 对数组元素进行升序或降序
	 * @param arr 需要排序的数组
	 * @param asc 是否升序
	 */
	public static void sort(int[] arr, boolean asc) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(asc) {
					if(arr[i] > arr[j]) {//升序
						swap(arr,i, j);
					}
				}else {
					if(arr[i] < arr[j]) {//降序
						swap(arr, i, j);
					}
						
				}
			}
		}
	}
	/** 交换数组中的两个元素的位置
	 * @param arr 数组
	 * @param i 交换的数组元素下标
	 * @param j 交换的数组元素下标
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	//测试代码
	@Test
	public void testBubbleSort() {
		int[] arr = {1,2,8,4,7,9};
		System.out.println("原数组：" + Arrays.toString(arr));
		sort(arr, true);
		System.out.println("升序后：" + Arrays.toString(arr));
		sort(arr, false);
		System.out.println("降序后：" + Arrays.toString(arr));
	}
	
//  出处：田守枝Java技术博客	
//	 2.1 冒泡排序
//	 2017-01-18 20:25:44 548 0
//
//	 冒泡排序（Bubble Sort），是一种计算机科学领域的较简单的排序算法。
//
//	    其核心思想是：对于一组需要排序的数字，依次将一个位置上的数字逐一与其之后的数字进行比较，如果他们的顺序错误就把他们交换过来。 这个算法的名字由来是因为越大的元素会经由交换慢慢“浮”到数列的顶端，故名。
//
//	 算法原理
//
//	 以降序排列为例， 假设有一个n个元素的数组，那么需要进行n-1轮排序，每一轮排序都确定一个数字的最终位置：
//
//	    第1轮 将下标为0的数字 与 下标在 [1,n-1]之间的数字逐一进行比较，每次遇到比下标为0大的数字，都将位置交换，当第一轮排序完成，最大的数字就是数组第0个位置上的数字
//
//	    第2轮， 将下标为1的数字 与 下标在 [2,n-1]之间的数字逐一进行比较，类似第一轮的交换规则，完成之后，第二大的数字就会在下标为1的位置上
//
//	 ...，
//
//	    第N-1轮，将下标为n-2的数字 与 [n-1,n-1](只剩1个数字)之间的数字逐一进行比较，将较大大的数字放在第n-2个位置上的数字，此时剩下的最后一个数字就是在n-1位置上，排序完成
//
//	 算法实现
//
//	     public class BubbleSort {
//	         /**
//	          * @param arr 需要排序的数组
//	          * @param asc 是否升序
//	          * @return 排序后的数组
//	          */
//	         public static void sort(int[] arr,boolean asc){
//	             for (int i = 0; i < arr.length; i++) {
//	                 for (int j=i+1;j<arr.length;j++){
//	                     if(asc){
//	                         if(arr[i]>arr[j]){//升序
//	                             swap(arr, i, j);
//	                         }
//	                     }else{
//	                         if(arr[i]<arr[j]){//降序
//	                             swap(arr, i, j);
//	                         }
//	                     }
//	                 }
//	             }
//	         }
//	      
//	         //交换数组中两个元素的位置
//	         private static void swap(int[] arr, int i, int j) {
//	             int temp= arr[i];
//	             arr[i] =arr[j];
//	             arr[j]=temp;
//	         }
//	      
//	         public static void main(String[] args) {
//	             int[] arr=new int[]{1,5,6,8,9,4,3};
//	             System.out.println("排序数组："+Arrays.toString(arr));
//	             sort(arr,true);
//	             System.out.println("升序排列："+Arrays.toString(arr));
//	             sort(arr,false);
//	             System.out.println("降序排列："+Arrays.toString(arr));
//	         }
//	     }
//
//	 运行程序，输出
//
//	 排序数组：[1, 5, 6, 8, 9, 4, 3]
//
//	 升序排列：[1, 3, 4, 5, 6, 8, 9]
//
//	 降序排列：[9, 8, 6, 5, 4, 3, 1]
//
//	 算法时间复杂度分析
//
//	    对于排序算法的时间复杂度分析，要从2个角度考虑，一个是比较的次数，另一个交换的次数)。 对于n个元素的数组，需要进行 n-1趟排序。每趟排序要进行n-i次关键字的比较(1≤i≤n-1)。
//
//	 比较次数的时间复杂度
//
//	 第1趟：比较n-1次
//
//	 第2趟：比较 n-2次
//
//	 ...
//
//	 第n-1趟：比较1次  
//
//	 根据等差数列的求和公式，可以算出
//
//	 Image.png
//
//	 交换次数的时间复杂度
//
//	   在比较过程中，交换不是必须的，只有在顺序不对的情况下，才会交换。如果数组是升序的，但是我们希望降序排列，那么每一次比较都需要进行交换，这个时候达到交换的最大次数，且每次比较都必须移动记录三次来达到交换记录位置。
//
//	 Image.png
//
//	 综上，因此冒泡排序总的平均时间复杂度为O(N2)。
//
//	 算法稳定性
//
//	   冒泡排序就是把小的元素往前调或者把大的元素往后调。比较是相邻的两个元 素比较，交换也发生在这两个元素之间。所以，如果两个元素相等，我想你是不会再无聊地把他们俩交换一下的；如果两个相等的元素没有相邻，那么即使通过前面 的两两交换把两个相邻起来，这时候也不会交换，所以相同元素的前后顺序并没有改变，所以冒泡排序是一种稳定排序算法。

}

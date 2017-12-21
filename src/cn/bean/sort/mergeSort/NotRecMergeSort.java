package cn.bean.sort.mergeSort;

import java.util.Arrays;

import org.junit.Test;

/** 归并排序非递归实现
 * @author chensj
 *
 */
public class NotRecMergeSort {

	public static void mergeSort(int[] array) {
		int len = 1;//每次被归并的数组的长度
		while(len < array.length) {//当每次被归并数组的长度小于原数组的长度时，则证明没有全部被归并，继续归并
			for(int i=0; i<array.length; i+=2*len) {
				merge(array, i, len);//将数组分为若干个以len为长度的小数组，并把相邻的两个小数组归并成大数组
			}
			len *= 2;//改变小数组的长度为原来的两倍，让归并排好序的小数组继续归并成更大的数组，直到全部排完序
		}
	}
	public static void merge(int[] array, int leftStartIndex, int length) {
		int startIndex = leftStartIndex;
		int leftEndIndex = leftStartIndex + length - 1;//被归并的两个小数组中的左边数组的最后一个元素的位置
		int rightStartIndex = leftStartIndex + length; //被归并的两个小数组中的右边数组的第一个元素的位置
		int rightEndIndex = rightStartIndex + length -1;//被归并的两个小数组的右边数组的最后一个元素的位置
		int[] temp = new int [2*length];//临时数组
		int count = 0;
		while(leftStartIndex <= leftEndIndex 
				&& rightStartIndex <= rightEndIndex 
				    && rightStartIndex < array.length) {//可能因数组长度不被mergeSort中的len的长度等分，而出现左边数组有元素而右边数组没有元素或数组长度不满足len的情况，或者左边数组长度不满足len的情况，
			if(array[leftStartIndex] < array[rightStartIndex]) {
				temp[count++] = array[leftStartIndex++];
			}else {
				temp[count++] = array[rightStartIndex++];
			}
		}
		while(leftStartIndex <= leftEndIndex && leftStartIndex < array.length) {//可能出现左边数组长度不满足len的情况
			temp[count++] = array[leftStartIndex++];
		}
		while(rightStartIndex <= rightEndIndex && rightStartIndex < array.length) {//可能出现右边数组没有元素或数组长度不满足len的情况
			temp[count++] = array[rightStartIndex++];
		}
	    count = 0;
		while(startIndex <= rightEndIndex && startIndex <array.length ) {//出现数组长度不被mergeSort中的len的长度等分的情况，会超出数组下标
			array[startIndex++] = temp[count++];
		}
	}
	//测试代码
	@Test
	public void testNotRecMergeSort() {
		int[] arr = new int[] {1,5,3,7,8,6,4,9,2,10,12,11};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
//归并排序非递归实现教程
//出处：田守枝Java技术博客	
//非递归的代码如下：
//
//public class WhileMergeSort {
//    public static void main(String args[]){
//        int[] array = new int[]{1,5,6,8,9,4,3};
//        System.out.println("OriginalArray:" + Arrays.toString(array));
//        mergeSort(array);
//        System.out.println("SortedArray:" + Arrays.toString(array));
//    }
// 
//    public static void mergeSort(int[] array){
//        int len = 1;
//        while(len < array.length){
//            for(int i = 0; i < array.length; i += 2*len){
//                merge(array, i, len);
//            }
//            len *= 2;
//        }
//    }
// 
//    public static void merge(int[] array, int startIndex, int endIndex){
//        int leftStartIndex = startIndex;
//        int leftHalfLength = startIndex + endIndex;//归并的前半部分数组
//        int rightStartIndex = startIndex + endIndex;
//        int rightHalfLength = rightStartIndex +endIndex;//归并的后半部分数组
//        int[] temp = new int[2*endIndex];
//        int count = 0;
//        while(startIndex < leftHalfLength && rightStartIndex < rightHalfLength && rightStartIndex < array.length){
//            if(array[startIndex] <= array[rightStartIndex]){
//                temp[count++] = array[startIndex++];
//            }
//            else{
//                temp[count++] = array[rightStartIndex++];
//            }
//        }
//        while(startIndex < leftHalfLength && startIndex < array.length){//注意：这里i也有可能超过数组长度
//            temp[count++] = array[startIndex++];
//        }
//        while(rightStartIndex < rightHalfLength && rightStartIndex < array.length){
//            temp[count++] = array[rightStartIndex++];
//        }
//        count = 0;
//        while(leftStartIndex < rightStartIndex && leftStartIndex < array.length){
//            array[leftStartIndex++] = temp[count++];
//        }
//    }
//}
//
//运行程序输出
//OriginalArray:[1, 5, 6, 8, 9, 4, 3]
//
//SortedArray:[1, 3, 4, 5, 6, 8, 9]
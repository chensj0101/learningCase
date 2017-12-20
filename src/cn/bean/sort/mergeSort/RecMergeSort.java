package cn.bean.sort.mergeSort;

import java.util.Arrays;

import org.junit.Test;

/** 归并算法递归实现
 * @author chensj
 *
 */
public class RecMergeSort {
    /** 把传进来的数组用递归的方式逐级将其分为左右两个数组直到每个数组只剩一个元素
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void mergeSort(int[] array, int startIndex, int endIndex) {
		if(startIndex < endIndex) {
			int midIndex = (startIndex + endIndex)/2;
			mergeSort(array, startIndex, midIndex);
			mergeSort(array, midIndex+1, endIndex);
			merge(array, startIndex, endIndex);
		}
	}
    
    /** 从最小长度的两个数组开始逐级往上合并
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void merge(int[] arr, int startIndex, int endIndex) {
    	int midIndex =(startIndex + endIndex)/2;
    	int indexOfLeftArray = startIndex;
    	int indexOfRightArray = midIndex+1;
    	int indexOfTempArray = 0;
    	int[] tempArray = new int[endIndex-startIndex+1];
    	while((indexOfLeftArray<=midIndex) && (indexOfRightArray<=endIndex)) {
    		if(arr[indexOfLeftArray] < arr[indexOfRightArray]) {
    			tempArray[indexOfTempArray++] = arr[indexOfLeftArray++];
    		}else {
				tempArray[indexOfTempArray++] = arr[indexOfRightArray++];
			}
    	}
    	while(indexOfLeftArray <= midIndex){
    		tempArray[indexOfTempArray++] = arr[indexOfLeftArray++];
    	}
    	while(indexOfRightArray <= endIndex) {
    		tempArray[indexOfTempArray++] = arr[indexOfRightArray++];
    	}
    	indexOfTempArray = 0;
    	while(startIndex <= endIndex) {
    		arr[startIndex++] = tempArray[indexOfTempArray++];
    	}
    }
    //测试代码
    @Test
    public void testMergeSort() {
    	int[] arr = new int[] {1,5,8,7,4,6,3,12,114,150,101,80,20,32};
//    	System.out.println(Arrays.toString(arr));
    	mergeSort(arr, 0, arr.length-1);
    	System.out.println(Arrays.toString(arr));
    }
}
//归并排序递归实现教程
//出处：田守枝Java技术博客	
//归并排序递归实现
//
//递归算法的实现代码如下：
//
//    public class RecMergeSort {
//        public static void mergeSort(int[] data,int left,int right){ //left,right均为数字元素下标
//            if(left<right){
//                int half=(left+right)/2;
//                mergeSort(data,left,half);
//                mergeSort(data,half+1,right);
//                merge(data,left,right);
//            }
//        }
//        public static void merge(int [] array,int startIndex,int endIndex){
//            int mid=(startIndex+endIndex)/2;
//            int leftStartIndex=startIndex;
//            int rightStartIndex=mid+1;
//            int count=0;
//            int temp[]=new int[endIndex-startIndex+1];
//            while(leftStartIndex<=mid&&rightStartIndex<=endIndex){
//                if(array[leftStartIndex]<array[rightStartIndex]){
//                    temp[count++]=array[leftStartIndex++];
//                }else{
//                    temp[count++]=array[rightStartIndex++];
//                }
//            }
//            while(leftStartIndex<=mid){
//                temp[count++]=array[leftStartIndex++];
//            }
//            while(rightStartIndex<=endIndex){
//                temp[count++]=array[rightStartIndex++];
//            }
//            count=0;
//            while(startIndex<=endIndex){
//                array[startIndex++]=temp[count++];
//            }
//        }
//        public static void printArray(int arr[]){
//            for(int k=0;k<arr.length;k++){
//                System.out.print(arr[k]+"\t");
//            }
//        }
//        public static int[] getArray(){
//    //      int[] data={4,2,3,1};
//            int[] data={543,23,45,65,76,1,456,7,77,88,3,9};
//            return data;
//        }
//     
//        public static void main(String args[]){
//            int[]a=getArray();
//            System.out.print("数组排序前：");
//            printArray(a);
//            System.out.print("\n");
//            mergeSort(a,0,a.length-1);
//            System.out.print("归并排序后：");
//            printArray(a);
//        }
//    }
//
//运行程序输出：
//
//数组排序前：543    23    45    65    76    1    456    7    77    88    3    9   
//
//归并排序后：1    3    7    9    23    45    65    76    77    88    456    543   
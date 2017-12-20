package cn.bean.sort.mergeSort;

import java.util.Arrays;

import org.junit.Test;

public class TwoWayMerge {
	/** 将两个有序数组(排序顺序相同)合并成大的有序数组，合成后的顺序与两个数组的顺序相同；
	 * @param firstArray 第一个数组
	 * @param nextArray 第二个数组
	 * @param asc 两个数组原来的排列顺序，true为升序，false为降序
	 * @return 返回结果数组
	 */
	public static int[] merge(int[] firstArray, int[] nextArray, boolean asc) {
		int[] resultArray = new int[firstArray.length + nextArray.length];
		int firstArrayIndex = 0, nextArrayIndex = 0, resultArrayIndex = 0;
		if(asc) {
		    while((firstArrayIndex < firstArray.length) && (nextArrayIndex < nextArray.length)) {
			    if(firstArray[firstArrayIndex] < nextArray[nextArrayIndex]) {
					resultArray[resultArrayIndex++] = firstArray[firstArrayIndex++];
				}else {
					resultArray[resultArrayIndex++] = nextArray[nextArrayIndex++];
				}
			}
		    while(firstArrayIndex < firstArray.length) {
		    	resultArray[resultArrayIndex++] = firstArray[firstArrayIndex++];
		    }
		    while(nextArrayIndex < nextArray.length) {
		        resultArray[resultArrayIndex++] = nextArray[nextArrayIndex++];
		    }
		}else {
				while((firstArrayIndex < firstArray.length) && (nextArrayIndex < nextArray.length)) {
			        if (firstArray[firstArrayIndex] < nextArray[nextArrayIndex]) {
						resultArray[resultArrayIndex++] = nextArray[nextArrayIndex++];
					} else {
                        resultArray[resultArrayIndex++] = firstArray[firstArrayIndex++];
					}
				}
				while(firstArrayIndex < firstArray.length) {
					resultArray[resultArrayIndex++] = firstArray[firstArrayIndex++];
				}
				while(nextArrayIndex < nextArray.length) {
					resultArray[resultArrayIndex++] = nextArray[nextArrayIndex++];
				}
		}
		return resultArray;
	}
	/** 将两个有序数组(排序顺序相同)合并成大的有序数组，合成后的顺序由输入参数order决定；
	 * @param firstArray 第一个数组
	 * @param nextArray 第二个数组
	 * @param asc 两个数组原来的排列顺序，true为升序，false为降序
	 * @param order 合并后的排列顺序，true为升序，false为降序
	 * @return 返回结果数组
	 */
	public static int[] merge(int[] firstArray, int[] nextArray, boolean asc, boolean order) {
		int resultArraylength = firstArray.length + nextArray.length;
		int[] resultArray = new int[resultArraylength];
		int firstArrayIndex = 0, nextArrayIndex = 0, resultArrayIndex = 0; 
		if(asc) {
			if(order){
				while((firstArrayIndex < firstArray.length) && (nextArrayIndex < nextArray.length)) {
				    if(firstArray[firstArrayIndex] < nextArray[nextArrayIndex]) {
						resultArray[resultArrayIndex++] = firstArray[firstArrayIndex++];
					}else {
						resultArray[resultArrayIndex++] = nextArray[nextArrayIndex++];
					}
				}
			    while(firstArrayIndex < firstArray.length) {
			    	resultArray[resultArrayIndex++] = firstArray[firstArrayIndex++];
			    }
			    while(nextArrayIndex < nextArray.length) {
			        resultArray[resultArrayIndex++] = nextArray[nextArrayIndex++];
			    }
			}else {
				resultArrayIndex = resultArraylength - 1;
				while((firstArrayIndex < firstArray.length) && (nextArrayIndex < nextArray.length)) {
				    if(firstArray[firstArrayIndex] < nextArray[nextArrayIndex]) {
						resultArray[resultArrayIndex--] = firstArray[firstArrayIndex++];
					}else {
						resultArray[resultArrayIndex--] = nextArray[nextArrayIndex++];
					}
				}
			    while(firstArrayIndex < firstArray.length) {
			    	resultArray[resultArrayIndex--] = firstArray[firstArrayIndex++];
			    }
			    while(nextArrayIndex < nextArray.length) {
			        resultArray[resultArrayIndex--] = nextArray[nextArrayIndex++];
			    }
			}
		    
		}else {
			if (order) {
				resultArrayIndex = resultArraylength - 1;
				while((firstArrayIndex < firstArray.length) && (nextArrayIndex < nextArray.length)) {
			        if (firstArray[firstArrayIndex] < nextArray[nextArrayIndex]) {
						resultArray[resultArrayIndex--] = nextArray[nextArrayIndex++];
					} else {
                        resultArray[resultArrayIndex--] = firstArray[firstArrayIndex++];
					}
				}
				while(firstArrayIndex < firstArray.length) {
					resultArray[resultArrayIndex--] = firstArray[firstArrayIndex++];
				}
				while(nextArrayIndex < nextArray.length) {
					resultArray[resultArrayIndex--] = nextArray[nextArrayIndex++];
				}
			} else {
				while((firstArrayIndex < firstArray.length) && (nextArrayIndex < nextArray.length)) {
			        if (firstArray[firstArrayIndex] < nextArray[nextArrayIndex]) {
						resultArray[resultArrayIndex++] = nextArray[nextArrayIndex++];
					} else {
                        resultArray[resultArrayIndex++] = firstArray[firstArrayIndex++];
					}
				}
				while(firstArrayIndex < firstArray.length) {
					resultArray[resultArrayIndex++] = firstArray[firstArrayIndex++];
				}
				while(nextArrayIndex < nextArray.length) {
					resultArray[resultArrayIndex++] = nextArray[nextArrayIndex++];
				}
			}
				
		}
		return resultArray;
	}
	@Test
	public void testTwoWayMerge() {
		int[] first = new int[]{1,3,5,7,9};
		int[] next = new int[]{2,4,6,8};
		int[] result = merge(first, next, true);
		int[] resultToDesc = merge(first, next, true,false);
		System.out.println("------------两个升序数组------------");
		System.out.println("数组1：" + Arrays.toString(first));
		System.out.println("数组2：" + Arrays.toString(next));
		System.out.println("升序合并后：" + Arrays.toString(result));
		System.out.println("升序合并成降序：" + Arrays.toString(resultToDesc));
		
		int[] firstDesc = new int[]{9,7,6,5,1};
		int[] nextDesc = new int[]{8,4,3,2,2,1};
		int[] resultDesc = merge(firstDesc, nextDesc, false);
		int[] resultEAsc = merge(firstDesc, nextDesc, false, true);
		System.out.println("------------两个降序数组------------");
		System.out.println("数组1：" + Arrays.toString(firstDesc));
		System.out.println("数组2：" + Arrays.toString(nextDesc));
		System.out.println("降序合并后：" + Arrays.toString(resultDesc));
		System.out.println("降序合并成升序：" + Arrays.toString(resultEAsc));
		
	}
//  出处：田守枝Java技术博客	
//	 2.4 归并排序
//	 2017-01-21 23:01:48 315 0
//
//	 归并排序（Merge Sort）是分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列之间有序。将两个有序数组合并成一个有序数组，称为二路归并(binary merge)。
//
//	 之前讲解的冒泡排序，选择排序，插入排序都是时间复杂度都是O(N2)，而归并排序只需要O(N*logN)，效率比前三种算法提升很多。
//
//	 归并排序的思想：
//
//	 将一个数组拆分成两半，分别对每一半进行排序，然后使用合并(merge)操作，把两个有序的子数组合并成一个整体的有序数组。我们可以把一个数组刚开始先分成两，也就是2个1/2，之后再将每一半分成两半，也就是4个1/4，以此类推，反复的分隔数组，直到得到的子数组中只包含一个数据项，这就是基值条件，只有一个数据项的子数组肯定是有序的。
//
//	 二路归并
//
//	 归并算法的中心是归并两个已经有序的数组。归并两个有序数组A和B，就生成了第三个数组C，数组C包含数组A和B的所有数据项，并且使它们有序的排列在数组C中。首先我们来看看归并的过程，然后看它是如何在排序中使用的。
//
//	 假设有两个有序数组，不要求有相同的大小。设数组A有4个数据项，数组B有6个数据项，它们要被归并到数组C中，开始时数组C有10个存储空间，归并过程如下图所示：
//
//	 归并前：
//
//	 Image.png
//
//	 归并后：
//
//	 Image.png
//
//	 在这个图中，带圈的数字显示了把A和B中的数据项转移到数组C中的顺序
//
//	 首先，我们需要注意的是需要合并的有序数组A和B都是升序的，在二路归并中，要合并的两个有序数组必须都是升序或者降序，即方向必须一致，这样可以简化我们在合并过程中的处理。
//
//	 在合并时，从两个数组中，任选一个，假设是A：
//
//	 第一轮比较：先用A[0]与B[0]比较，把较小的放入值放入C[0]中(因为是升序)，因此B[0]<A[0]，所以将C[0]=B[0]=7
//
//	 第二轮比较：用A[0]与B[1]比较，把较小的放入值放入C[1]中(因为是升序)，因此B[1]<A[0]，所以将C[1]=B[1]=14
//
//	 第三轮比较：用A[0]与B[2]比较，把较小的放入值放入C[2]中(因为是升序)，因此B[2]>A[0]，所以将C[2]=A[0]=23
//
//	 第四轮比较：用A[1]与B[2]比较，把较小的放入值放入C[3]中(因为是升序)，因此B[2]>A[1]，所以将C[3]=B[2]=39
//
//	 ...
//
//	 可以看出来，比较的原则很简单，就是将A中的数字与B中的数组进行比较，例如将A[m]与B[n]进行比较，将较小的数字放入C中下一个可以存放的位置， 假设A[m]<B[n]，那么就是将A[m]放入C中，那么下一次比较时，就需要使用A[m+1]与B[n]比较；反之则用A[m]与B[n+1]进行比较，不断的循环次过程。
//
//	 如果一个数组中的数字都放完了之后，例如上例中，B数组已经都放入C中了，但是A数组还有两个元素没有放入，此时B已经没有元素可以继续与A进行比较，不过，此时已经没有继续比较的必要的，因为是我们是按照从小到大的顺序将数字放入C中，当B放完了，而A还没有放完，那就说明A中剩余的元素必然都比B最大的元素大，因此只需要将A中剩余没有比较的元素，按照顺序依次放入C中即可
//
//	      public class TwoWayMerge {
//	         /**
//	          * 将两个有序数组，返回一个合并成后的大的有序数组，如果两个小数组是降序的，那么合并后依然是降序；反之亦然
//	          * @param firstArray
//	          * @param secondArray
//	          * @param asc 表示这两个数组是升序数组还是降序数组
//	          */
//	         public static int[] merge(int[] firstArray,int[] secondArray,boolean asc) {
//	             //创建一个临时数组，其大小等于两个要合并的数组的大小
//	             int[] resultArray=new int[firstArray.length+secondArray.length];
//	             //创建三个变量，分别表示三个数组当前迭代到的下标的位置
//	             int firstArrayIndex = 0, secondArrayIndex = 0, resultArrayIndex = 0;
//	      
//	             // firstArray secondArray同时进行迭代，在都没有迭代完的情况下，继续，否则跳出
//	             while (firstArrayIndex < firstArray.length && secondArrayIndex < secondArray.length)  {
//	                 if(asc){//升序
//	                     if (firstArray[firstArrayIndex] < secondArray[secondArrayIndex]){
//	                         resultArray[resultArrayIndex++] = firstArray[firstArrayIndex++];
//	                     }else{
//	                         resultArray[resultArrayIndex++] = secondArray[secondArrayIndex++];
//	                     }
//	                 }else{//降序
//	                     if (firstArray[firstArrayIndex] > secondArray[secondArrayIndex]){
//	                         resultArray[resultArrayIndex++] = firstArray[firstArrayIndex++];
//	                     }else{
//	                         resultArray[resultArrayIndex++] = secondArray[secondArrayIndex++];
//	                     }
//	                 }
//	      
//	             }
//	      
//	             // secondArray所有元素已经迭代结束,但是firstArray没有迭代完，将firstArray的剩余元素直接拷贝到resultArray的后面
//	             while (firstArrayIndex < firstArray.length){
//	                 resultArray[resultArrayIndex++] = firstArray[firstArrayIndex++];
//	             }
//	      
//	             // secondArray所有元素已经迭代结束,但是firstArray没有迭代完,将secondArray的剩余元素直接拷贝到resultArray的后面
//	             while (secondArrayIndex < secondArray.length){
//	                 resultArray[resultArrayIndex++] = secondArray[secondArrayIndex++];
//	             }
//	             return resultArray;
//	         }
//	      
//	         public static void main(String[] args) {
//	             //准备2个待合并升序数组进行合并
//	             int[] firstArray = {1,3,5,7};
//	             int[] secondArray = {3,4,6,7};
//	             System.out.println("待合并升序数组:\n"+(Arrays.toString(firstArray)+"\n" + Arrays.toString(secondArray)));
//	             int[] resultArray = merge(firstArray, secondArray,true);
//	             System.out.println("合并后:\n" + Arrays.toString(resultArray));
//	             System.out.println();
//	             //准备2个待合并降序数组进行合并
//	             firstArray = new int[]{9,6,3,0};
//	             secondArray =new int[] {10,5,3,-1};
//	             System.out.println("待合并降序数组:\n"+(Arrays.toString(firstArray)+"\n" + Arrays.toString(secondArray)));
//	             resultArray = merge(firstArray, secondArray,false);
//	             System.out.println("合并后:\n" + Arrays.toString(resultArray));
//	         }
//	     };
//
//	 运行程序，输出
//
//	 待合并升序数组:
//
//	 [1, 3, 5, 7]
//
//	 [3, 4, 6, 7]
//
//	 合并后:
//
//	 [1, 3, 3, 4, 5, 6, 7, 7]
//
//	 待合并降序数组:
//
//	 [9, 6, 3, 0]
//
//	 [10, 5, 3, -1]
//
//	 合并后:
//
//	 [10, 9, 6, 5, 3, 3, 0, -1]
//
//	 可以发现，待合并之前的数组是升序的，那么合并后依然是升序的，反之亦然
//
//	 merge方法中有3个while循环：
//
//	 第一个循环：
//
//	 用于同时迭代firstArray和secondArray，比较他们的数据项，并且把较小(或者较大)的数据项复制到resultArray中。在firstArray和secondArray都没有迭代完时，循环继续，否则，跳出循环。
//
//	 当跳出循环时，可能是firstArray迭代完了，econdArray没有迭代完；也有可能是相反的情况，因此有了第二个循环和第三个循环
//
//	 第二个循环：
//
//	 用于处理secondArray所有元素已经迭代结束,但是firstArray没有迭代完的情况，将firstArray的剩余元素直接拷贝到resultArray中
//
//	 第三个循环：
//
//	 用于处理firstArray所有元素已经迭代结束,但是secondArray没有迭代完的情况 ,将secondArray的剩余元素直接拷贝到resultArray中
}

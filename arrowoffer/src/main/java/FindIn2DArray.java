/**
 *
 * 题目描述

 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 思路：
 从右上角开始找，如果目标元素相等，则直接找到
 如果小于目标元素，所查元素只能在当前列的左侧
 如果大于目标元素，所查元素只能在当前行的下侧
 *
 */
public class FindIn2DArray {
    public static void main(String[] args){
        int[][] arr={{1,4,7},{2,5,8},{3,6,9}};
        System.out.print("是否找到: "+ Find(arr,13));
    }

    public static  boolean Find(int [][] array,int target) {
        boolean flag=false;
        int i=0;
        int j=array[0].length-1;
        while(i<array.length&&j>=0){
            if(target==array[i][j]) {
                flag = true;
                break;
            }else if(target > array[i][j]){
                i++;
            }else {
                j--;
            }
        }

        return flag;

    }

}

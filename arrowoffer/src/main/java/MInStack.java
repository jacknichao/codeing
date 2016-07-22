/**
 * Created by root on 7/21/16.
 */
public class MInStack {
    public static void main(String[] args) {

    }

    private int volumData=100;
    private int topData=-1;
    private int volumMin=100;
    private int topMin=-1;
    private int[] dataArr=new int[volumData];
    private int[] minArr=new int[volumMin];

    public void push(int node) {
        //enlarge data space
        if(topData==volumData-1){
            int[] tmp=new int[volumData*2];
            System.arraycopy(dataArr,0,tmp,0,volumData);
            volumData<<=1;
            dataArr=tmp;
        }

        if(topMin==volumMin-1){
            int[] tmp=new int[volumMin*2];
            System.arraycopy(minArr,0,tmp,0,volumMin);
            volumMin<<=1;
            minArr=tmp;
        }

        dataArr[++topData]=node;
        if(topMin==-1||node<minArr[topMin]){
            minArr[++topMin]=node;
        }
    }

    //need to be cation
    public void pop() {
        if(topData>=0){
            int num=dataArr[topData--];
            int num2=minArr[topMin--];
            if(num!=num2){
                minArr[++topMin]=num2;
            }
        }
    }

    public int top() {
        int num=dataArr[topData];
        return num;
    }

    public int min() {
        int min=minArr[topMin];
        return min;
    }
}

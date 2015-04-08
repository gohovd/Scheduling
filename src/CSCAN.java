import java.util.*;

class CSCAN {

    int head=0;
    int dir=0;
    Scanner obj=new Scanner(System.in);
    int start=0,end=0,beg=0;
    int sum[]=new int[2];
    int ref[][]=new int[8][2];

    void moveLeft(){
        System.out.println("ML Wrkng");
        int j=0;

        for(int i=(start-1);i>0;i--){

            ref[j][1]=Math.abs(ref[i][0]-ref[i-1][0]);
            sum[0]+=ref[j][1];
            System.out.println(ref[i][0]+" "+ref[j][1]);
            j++;
        }

    }

    void moveRight(){
        System.out.println("MR Wrkng");
        for(int i=start;i<7;i++){
            ref[i][1]=Math.abs(ref[i][0]-ref[i+1][0]);
            sum[1]+=ref[i][1];
            System.out.println(ref[i][0]+" "+ref[i][1]);
        }

    }
    void sort(){
        System.out.println("Working Sort");
        int temp=0;
        for(int i=0;i<8;i++){
            for(int j=i+1;j<8;j++){
                if(ref[i][0]>ref[j][0]){
                    temp=ref[i][0];
                    ref[i][0]=ref[j][0];
                    ref[j][0]=temp;
                }
            }
        }

        for(int i=0;i<8;i++){
            System.out.println(ref[i][0]+" ");
        }

        for(int i=0;i<8;i++){
            if(ref[i][0]>head){
                start=i;
                break;
            }

        }
        if(head>=end){
            start=7;
        }
        System.out.println("The Start Pos Is:"+ref[start][0]);
    }

    void getInput(){
        System.out.println("GI Wrkng");
        System.out.println("Enter The Head Pos:");
        head=obj.nextInt();
        System.out.println("Enter The Beg And End Points");
        beg=obj.nextInt();
        end=obj.nextInt();
        System.out.println("Enter The Direction of Head Mov '0(L) or 1(R)'");
        dir=obj.nextInt();
        System.out.println("Enter The REF String");
        for(int i=0;i<8;i++){
            ref[i][0]=obj.nextInt();
        }
    }

    void compute(){
        getInput();
        sort();
        if(dir==0){
            moveLeft();
            moveRight();
            if(start!=0)
            {sum[0]+=Math.abs((ref[0][0]-beg)+(head-ref[start-1][0]));}
            if (start!=7)
                sum[1]+=Math.abs((beg-end));
            System.out.println("Left Sum Is "+sum[0]+" Right sum is "+sum[1]);}
        else
        {
            moveRight();
            moveLeft();
            sum[1]+=Math.abs((ref[7][0]-end)+(head-ref[start][0]));
            sum[0]+=Math.abs((end-beg)+ref[0][0]);
            System.out.println("Left Sum Is "+sum[0]+" Right sum is "+sum[1]);
        }
        System.out.println("The Total Cylinder Mov Are:"+(sum[0]+sum[1]));

    }

}

class CSCANDSTest{
    public static void main(String args[]){
        CSCAN one=new CSCAN();
        one.compute();
    }
}
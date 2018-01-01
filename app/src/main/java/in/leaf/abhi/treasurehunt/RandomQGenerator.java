package in.leaf.abhi.treasurehunt;

/**
 * Created by 500060150 on 16-12-2017.
 */

import java.util.Random;
class RandomQGenerator {
    private int size=9;
    private int qSet[];
    private int pointer=-1;
    private Boolean store(int qNo) {
        qNo++;
        if(pointer==size-1) // if pointer is at size-1 then it means that a value
            return null;   // has been already kept there
        boolean stored=false;
        if(pointer==-1) {
            pointer++;
            qSet[pointer]=qNo;
            stored=true;
        }
        else if(qNo>qSet[pointer]) {
            pointer++;
            qSet[pointer]=qNo;
            stored=true;
        }
        else if(qSet[0]>qNo) {
            for(int i=pointer;i>=0;i--) {
                qSet[i+1]=qSet[i];
            }
            qSet[0]=qNo;
            pointer++;
            stored=true;

        }
        else {
            int i;
            for(i=pointer;i>0;i--) {
                if((qNo<qSet[i])&&(qNo>qSet[i-1])) {
                    for(int j=pointer;j>=i;j--)
                        qSet[j+1]=qSet[j];
                    qSet[i]=qNo;
                    pointer++;
                    stored=true;
                }
            }
        }
        return stored;
    }
    void generate(int bound,int size,int seed) {  //bound must be greater than size
        Random r = new Random(seed);
        this.size=size;
        qSet=new int[size];
        if(bound>0)
            while ((store(r.nextInt(bound))) != null) ;
    }
    int[] getqSet() { // This function will return the Question Set generated by the g
        return qSet;          // generate() function
    }
}

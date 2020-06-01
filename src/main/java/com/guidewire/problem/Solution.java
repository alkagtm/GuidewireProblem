package com.guidewire.problem;

public class Solution {

    public static int solution(int[] A, int K, int L){

        if(A.length <=0 || A.length <=1 ||A.length > 600 ){
            return -1;
        }
        if(K ==0 || K >= A.length ||L >= A.length  ){
            return -1;
        }
        if(K+L > A.length  ){
            return -1;
        }
        //to store the maximu apples that will be collected
        int[] maxCount= new int[2];
        maxCount[0] =0;
        maxCount[1] =0;
        //using recursive approach
        maximumApples(A,K,L,0,maxCount);
        if(maxCount[0] > 0 && maxCount[1] > 0){
            return maxCount[0]+maxCount[1];
        }
        return -1;


    }

    public static void maximumApples(int[] A ,int K , int L, int start,int[] maxCount){
        if(start >=A.length-1 ){
            return;
        }
        int treePicked = start;
        int countForK = 0;
        int countForL = 0;
        int bobCollected = 0;
        int aliceCollected = 0;

        //collect apples for Bob
        while(treePicked < A.length  && countForK <K){
            bobCollected = bobCollected + A[treePicked];
            ++treePicked;
            ++countForK;
        }
        maxCount[0]=Math.max(maxCount[0],bobCollected);

        //collect apples for Alice only if tree count exist
        if(treePicked+L-1 >=A.length){
            return;
        }
        while (treePicked < A.length && countForL < L) {
            aliceCollected = aliceCollected + A[treePicked];
            ++treePicked;
            ++countForL;
        }
        maxCount[1] = Math.max(maxCount[1], aliceCollected);
        maximumApples(A, K, L, start + 1, maxCount);
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[]{6,1,4,6,3,2,7,4},3,2));
        System.out.println(Solution.solution(new int[]{1,2,3},2,2));
        System.out.println(Solution.solution(new int[]{6,1,4,6,3,2,7,4},4,5));
        System.out.println(Solution.solution(new int[]{6,1,4,6,3,2,7,4},8,1));
        System.out.println(Solution.solution(new int[]{6,1,4,6,3,2,7,4},4,4));
        System.out.println(Solution.solution(new int[]{6,1,4,6,3,2,7,4},-2,-3));
        System.out.println(Solution.solution(new int[]{6,1,4,6,3,2,7,4,6,1,4,6,3,2,7,4,6,1,4,6,3,2,7,4},10,5));

    }
}


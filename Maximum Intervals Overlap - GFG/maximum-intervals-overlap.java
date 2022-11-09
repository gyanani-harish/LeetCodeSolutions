//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] entry=new int[n];
			for(int i=0;i<n;i++)
				entry[i]=sc.nextInt();
			int[] exit=new int[n];
			for(int i=0;i<n;i++)
				exit[i]=sc.nextInt();
			Solution ob= new Solution();
			int[] res=ob.findMaxGuests(entry,exit,n);
			for(int i=0;i<2;i++){
				System.out.print(res[i]);
			    System.out.print(" ");
			}
			System.out.println();
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int[] findMaxGuests(int[] Entry,int Exit[], int N){
        // add code here.
        Arrays.sort(Entry);
        Arrays.sort(Exit);
        int l = 0;
        int r = 0;
        int count = 0;
        int max = 0;
        int currentElement=0;
        int ans[] = new int[2];
        //1, 2, 5, 5, 10
        //4,5,9,12,12
        while(l<Entry.length || r<Exit.length){
            if(l<Entry.length && r<Exit.length){
                if(Entry[l]<=Exit[r]){
                    currentElement=Entry[l];
                    count++;
                    l++;
                } else {
                    currentElement=Exit[r];
                    count--;
                    r++;
                }
            } else if(l<Entry.length){
                currentElement=Entry[l];
                l++;
                count++;
            } else if(r<Exit.length){
                currentElement=Exit[r];
                r++;
                count--;
            }
            if(count>max){
                max = count;
                ans[1]=currentElement;
                ans[0] = max;
            }
        }
        return ans;
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main 
{
    private static MyScanner sc;
    private static PrintWriter out;
    private static int[] arr;
    private static int lst;
    public static void main(String[] args)
    {
    	sc = new MyScanner();
    	out = new PrintWriter(System.out);
    	int n = sc.nextInt();
    	arr = new int[n];
    	for(int i = 0; i < n; i++)
    	{
    		arr[i] = sc.nextInt();
    	}
    	
    	Arrays.sort(arr);
    	long tot = 0;
    	lst = arr.length - 1;
    	long curr_ans = compute();
    	tot += curr_ans;
    	while(curr_ans != 0)
    	{
    		curr_ans = compute();
    		tot += curr_ans;
    	}
    	
    	out.println(tot);
    	
    	out.close();
    }
    
    private static long compute()
    {
    	if(lst < 0) return 0;
    	boolean one = false;
    	boolean two = false;
    	boolean flag = true;
    	int ptr = lst;
    	long choice1 = -1;
    	long choice2 = -1;
    	int last = arr[ptr--];
    	while(flag)
    	{
    		if(ptr < 0) return 0;
    		int curr = arr[ptr];
    		if(abs(curr, last) <= 1)
    		{
    			ptr--;
    			one = true;
    			if(abs(curr, last) == 0) choice1 = last;
    			else choice1 = curr;
    			flag = false;
    		}
    		else
    		{
    			last = curr;
    			ptr--;
        		if(ptr < 0) flag = false;
    		}
    		
    	}
    	

    	if(ptr == 0)
    	{
    		two = false;
    	}
    	
    	else
    	{
    		if(ptr < 0) return 0;
    		last = arr[ptr];
    		ptr--;
    		flag = true;
    		while(flag)
        	{
        		int curr = arr[ptr];
        		if(abs(curr, last) <= 1)
        		{
        			ptr--;
        			two = true;
        			flag = false;
        			if(abs(curr, last) == 0) choice2 = last;
        			else choice2 = curr;
        			
        		}
        		else
        		{
        			last = curr;
        			ptr--;
            		if(ptr < 0) flag = false;
        		}
        		
        	}
    	}
    	lst = ptr;
    	if(one && two) return choice1 * choice2;
    	else return 0;
    }
    
 
    private static int max(int a, int b)
    {
        if(a > b) return a;
        else return b;
    }

    private static int min(int a, int b)
    {
        if(a < b) return a;
        else return b;

    }

 private static int abs(int a, int b)
    {
        return (int) Math.abs(a - b);
    }
    
     public static int modexp(int a, int b, int n) 
     {
        if (b == 0) return 1;
        long t = modexp(a, b/2, n);  
        long c = (t * t) % n;
        if (b % 2 == 1)
           c = (c * a) % n;
        return (int) c;
    }
    
 public static class MyScanner 
    {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() 
      {
         br = new BufferedReader(new InputStreamReader(System.in));
      }
 
      String next() 
      {
          while (st == null || !st.hasMoreElements()) 
          {
              try 
              {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) 
              {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }
 
      int nextInt() 
      {
          return Integer.parseInt(next());
      }
 
      long nextLong() 
      {
          return Long.parseLong(next());
      }
 
      double nextDouble() 
      {
          return Double.parseDouble(next());
      }
 
      String nextLine()
      {
          String str = "";
	  try 
          {
	     str = br.readLine();
	  } catch (IOException e) 
          {
	     e.printStackTrace();
	  }
	  return str;
      }

   }
}
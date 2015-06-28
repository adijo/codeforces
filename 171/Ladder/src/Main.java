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
    public static void main(String[] args)
    {
    	sc = new MyScanner();
    	out = new PrintWriter(System.out);
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	int[] arr = new int[n];
    	for(int i = 0; i < n; i++)
    	{
    		arr[i] = sc.nextInt();
    	}
    	// lincr indicates decreasing rightwords.
    	// ldecr indicates increasing rightwords.
    	
    	int[] lincr = new int[n];
    	int[] ldecr = new int[n];
    	
    	for(int i = 1; i < n; i++)
    	{
    		if(arr[i] >= arr[i - 1])
    		{
    			lincr[i] = lincr[i - 1] + 1;
    		}
    		
    		if(arr[i] <= arr[i - 1])
    		{
    			ldecr[i] = ldecr[i - 1] + 1;
    		}
    		
    	}
    	
    	
    	
    	for(int i = 0; i < m; i++)
    	{
    		int l = sc.nextInt() - 1;
    		int r = sc.nextInt() - 1;
    		if(r - lincr[r] <= l || r - ldecr[r] <= l) 
    			out.println("Yes");
    		else
    		{
    			int maxLr = ldecr[r];
    			int newIndex = r - maxLr;
    			if(newIndex - lincr[newIndex] <= l)
    				out.println("Yes");
    			else
    				out.println("No");
    		}
    		
    	}
    	out.close();
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
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
    private static int[][] dp;
    private static Tree[] arr;
    public static void main(String[] args)
    {
    	sc = new MyScanner();
    	out = new PrintWriter(System.out);
    	int n = sc.nextInt();
    	arr = new Tree[n];
    	dp = new int[2][n];
    	for(int i = 0; i < n; i++)
    	{
    		arr[i] = new Tree(sc.nextInt(), sc.nextInt());
    		dp[0][i] = -1;
    		dp[1][i] = -1;
    	}
    	out.println(1 + recurse(0, 1));
    	
    	out.close();
    }
    
    private static int recurse(int mode, int i)
    {
    	if(i >= arr.length) return 0;
    	else if(i == arr.length - 1) return 1;
    	else if(dp[mode][i] != -1) return dp[mode][i];
    	
    	else
    	{
    		int space = arr[i].x - arr[i - 1].x;
    		if(mode == 1) space -= arr[i - 1].h;
    		
    		if(space > arr[i].h)
    		{
    			dp[mode][i] = 1 + recurse(0, i + 1);
    		}
    		
    		else
    		{
    			int forward_space = arr[i + 1].x - arr[i].x;
    			if(forward_space > arr[i].h)
    			{
    				dp[mode][i] = max(recurse(0, i + 1), 1 + recurse(1, i + 1));
    			}
    			
    			else
    			{
    				dp[mode][i] = recurse(0, i + 1);
    			}
    		}
    		return dp[mode][i];
    		
    	}
    	
    }
    
  
    
    static class Tree
    {
    	public int x;
    	public int h;
    	public Tree(int x, int h) {this.x = x; this.h = h;}
    	
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
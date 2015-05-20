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
   
    public static void main(String[] args)
    {
    	sc = new MyScanner();
    	out = new PrintWriter(System.out);
    	int n = sc.nextInt();
    	
    	int[] arr = new int[n + 1];
    	
    	for(int i = 1; i <= n; i++) arr[i] = sc.nextInt();
    	
    	Arrays.sort(arr);
    	long[] s = new long[n + 1];
    	int answer = 0;
    	for(int i = 1; i <= n; i++)
    	{
    		if(arr[i] >= s[i - 1]) answer += 1;
    		s[i] = s[i - 1] + arr[i];
    		
    	}
    	out.println(answer + compute_last(arr, s, n));
    	out.close();
    	
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

    private static int compute_last(int[] arr, long[] s, int n)
    {
    	int op = 0;
    	for(int i = 2; i <= n; i++)
    	{
    		if(arr[i] >= s[i - 2] && arr[i] < s[i - 1] && arr[i - 1] < s[i - 2])
    		{
    			op++;
    			break;
    		}
    		
    	}
    	return op;
    	
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
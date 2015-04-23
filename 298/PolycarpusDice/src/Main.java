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
    private static int n, m, k;
    private int[] map;
    
    public static void main(String[] args)
    {
    	sc = new MyScanner();
    	out = new PrintWriter(System.out);
    	StringBuilder answer = new StringBuilder();
    	int n = sc.nextInt();
    	long A = sc.nextLong();
    	long[] d = new long[n];
    	long sum = 0;
    	for(int i = 0; i < n; i++)
    	{
    		d[i] = sc.nextLong();
    		sum += d[i];
    	} 
    	
    	if(n == 1)
    	{
    		out.println(d[0] - 1);
    	}
    	else
    	{
    		for(int i = 0; i < n; i++)
    		{
    			long sub1 = max(1, A - sum + d[i]);
    			
    			long sub2 = min(d[i], A - n + 1);
    			
    			long ans = d[i] - (sub2 - sub1 + 1);
    			answer.append(ans).append(" ");
    			
    			
    		}
    		
    	}
    	
    	out.println(answer.toString());
    	out.close();
    }
    
    private static long max(long a, long b)
    {
        if(a > b) return a;
        else return b;
    }

    private static long min(long a, long b)
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
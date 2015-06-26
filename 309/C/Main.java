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
    private static int[][] binomial;
    private static final Integer LIMIT = 1001;
    private static final Integer MOD = 1000000007;
    public static void main(String[] args)
    {
    	sc = new MyScanner();
    	out = new PrintWriter(System.out);
    	precompute();
    	int n = sc.nextInt();
    	int total = 0;
    	int[] arr = new int[n];
    	for(int i = 0; i < n; i++)
    	{
    		arr[i] = sc.nextInt();
    		total += arr[i];
    	}
    	long answer = 1;
    	int choosing = total;
    	for(int k = arr.length - 1; k >= 0; k--)
    	{
    		choosing--;
    		int left = arr[k] - 1;
    		answer = (answer * binomial[choosing][left]) % MOD;
    		choosing -= left;
    	}
    	
    	out.println(answer);
    	out.close();
    }
    
    private static void precompute()
    {
    	binomial = new int[LIMIT][LIMIT];
    	for(int n = 1; n < LIMIT; n++)
    	{
    		for(int k = 0; k < LIMIT; k++)
    		{
    			if(k == 0) binomial[n][k] = 1;
    			else if(n == k) binomial[n][k] = 1;
    			else
    			{
    				binomial[n][k] = (binomial[n - 1][k - 1] + binomial[n - 1][k])  % MOD;
    			}
    		}
    		
    	}
    	binomial[0][0] = 1;
    	
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
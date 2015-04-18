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
    private static int[][][] dp;
    private static boolean[] weights;
    private static StringBuilder answer;
    private static int m;
    public static void main(String[] args)
    {
    	sc = new MyScanner();
    	out = new PrintWriter(System.out);
    	String in = sc.next();
    	m = sc.nextInt();
    	
    	dp = new int[m + 1][11][11];
    	weights = new boolean[11];
    	answer = new StringBuilder();
    	for(int i = 0; i < m + 1; i++)
    	{
    		for(int j = 0; j < 11; j++)
    		{
    			Arrays.fill(dp[i][j], -1);
    		}
    	}
    	
    	for(int i = 0; i < 10; i++)
    	{
    		if(in.charAt(i) == '1') weights[i + 1] = true;
    		else weights[i + 1] = false;
    	}
    	int ans = recurse(0, 0, 0);
    	if(ans == 1)
    	{
    		out.println("YES");
    		String[] pieces = answer.toString().split("\\s+");
    		
    		StringBuilder a = new StringBuilder();
    		for(int i = pieces.length - 1; i >= 0; i--)
    		{
    			
    			a.append(pieces[i]).append(" ");
    		}
    		out.println(a.toString());
    	}
    	else
    	{
    		out.println("NO");
    	}
    	out.close();
    }
    
    private static int recurse(int lvl, int diff, int last)
    {
    	if(lvl == m && diff > 0)
    	{
    		return 1;
    	}

    	else if(dp[lvl][diff][last] != -1)
    	{
    		return dp[lvl][diff][last];
    	}
    	
    	else
    	{
    		for(int i = 1; i <= 10; i++)
    		{
    			if(i != last && weights[i])
    			{
    				if(diff - i < 0)
    				{
    					int res = recurse(lvl + 1, -1 * (diff - i), i);
    					if(res == 1)
    					{
    						answer.append(i).append(" ");
    						dp[lvl][diff][last] = 1;
    						return 1;
    					}
    				}
    			}
    			
    		}
    		dp[lvl][diff][last] = 0;
    		return 0;
    	}
    	
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
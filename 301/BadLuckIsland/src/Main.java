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
    private static double[][][] rock;
    private static double[][][] scissors;
    
    
    public static void main(String[] args)
    {
    	sc = new MyScanner();
    	out = new PrintWriter(System.out);
    	int r = sc.nextInt();
    	int s = sc.nextInt();
    	int p = sc.nextInt();
    	rock = new double[101][101][101];
    	scissors = new double[101][101][101];
    	
    	for(int i = 0; i < 101; i++)
    	{
    		for(int j = 0; j < 101; j++)
    		{
    			for(int k = 0; k < 101; k++)
    			{
    				rock[i][j][k] = -1.0;
    				scissors[i][j][k] = -1.0;
    			}
    		}
    	}
    	double a = fill_rock(r, s, p);
    	double b = fill_scissors(r, s, p);
    	
    	out.println(a + " " + b + " " + (1.0 - (a + b)));
    	
    	out.close();
    }
    
    private static double fill_rock(int r, int s, int p)
    {
    	
    	if(r == 0) return 0;
    	else if(rock[r][s][p] != -1) return rock[r][s][p];
    	else
    	{
    		if(r > 0 && (s == 0 && p == 0)) return 1.0;
    		else
    		{
    			// here r is not equal to zero and either of the two p or s are greater than 0.
    			if(p == 0)
    			{
    				return 1.0;
    			}
    			
    			else if(s == 0)
    			{
    				return 0.0;
    				
    			}
    			
    			else
    			{
    				// p and s are both not zero.
    				double total = (double) r  + s + p;
    				double rs = r * s;
    				double rp = r * p;
    				double ps = p * s;
    				double tot = rs + rp + ps;
    				rs = (rs / tot);
    				ps = (ps / tot);
    				rp = (rp / tot);
    				rock[r][s][p] = rs * fill_rock(r, s - 1, p) + rp * fill_rock(r - 1, s, p) + ps * fill_rock(r, s, p - 1);
    				return rock[r][s][p];
    				
    			}
    		}
    	}
    }
    
    private static double fill_scissors(int r, int s, int p)
    {
    	
    	if(s == 0) return 0;
    	else if(scissors[r][s][p] != -1) return scissors[r][s][p];
    	else
    	{
    		if(s > 0 && (r == 0 && p == 0)) return 1.0;
    		else
    		{
    			if(r == 0)
    			{
    				return 1.0;
    			}
    			
    			else if(p == 0)
    			{
    				return 0.0;
    			}
    			
    			else
    			{
    				double total = (double) r  + s + p;
    				double rs = r * s;
    				double rp = r * p;
    				double ps = p * s;
    				double tot = rs + rp + ps;
    				rs = (rs / tot);
    				ps = (ps / tot);
    				rp = (rp / tot);
    				scissors[r][s][p] = rs * fill_scissors(r, s - 1, p) + rp * fill_scissors(r - 1, s, p) + ps * fill_scissors(r, s, p - 1);
    				return scissors[r][s][p];
    				
    				
    			}
    			
    			
    		}
    		
    		
    	}
    	
    	
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
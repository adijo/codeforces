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
    	Day[] arr = new Day[m];
    	for(int i = 0; i < m; i++)
    	{
    		arr[i] = 
    				new Day(sc.nextInt(), sc.nextInt());
    	}
    	
    	int first_day = arr[0].d;
    	int days_left = first_day - 1;
    	int max_height = arr[0].h + days_left;
    	
    	boolean possible = true;
    	
    	for(int i = 1; i < m; i++)
    	{
    		if(!possible) break;
    		Day curr = arr[i];
    		Day prev = arr[i - 1];
    		days_left = curr.d - prev.d;
    		
    		if(curr.h < prev.h)
    		{
    			if(prev.h - curr.h > days_left)
    			{
    				possible = false;
    				break;
    			}
    			else
    			{
    				int need = prev.h - curr.h;
    				int left = days_left - need;
    				max_height = max(max_height, prev.h + (left / 2));
    				
    			}
    		}
    		
    		else if(curr.h > prev.h)
    		{
    			if(curr.h - prev.h > days_left)
    			{
    				possible = false;
    				break;
    			}
    			else
    			{
    				int need = curr.h - prev.h;
    				int left = days_left - need;
    				max_height = max(max_height, curr.h + (left / 2));
    				
    			}
    			
    		}
    		
    		else
    		{
    			// curr.h == prev.h
    			max_height = max(max_height, curr.h + (days_left / 2));
    			
    		}
    		
    		
    	}
    	max_height = max(max_height, (n - arr[arr.length - 1].d) + arr[arr.length - 1].h);
    	
    	
    	
    	if(!possible) out.println("IMPOSSIBLE");
    	else out.println(max_height);
    	
    	out.close();
    }
    
    private static class Day 
    {
    	public int d;
    	public int h;
    	
    	public Day(int d, int h) {this.d = d; this.h = h;}
    	
    }
    
    
    private static int max(int a, int b)
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
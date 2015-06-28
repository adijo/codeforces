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
    	int v = sc.nextInt() - 1;
    	
    	long maxPossible = ((n - 2) * (n - 3) / 2) + n - 1;
    	if(maxPossible < m || m < (n - 1))
    	{
    		out.println(-1);
    	}
    	else
    	{
    		solve(n, m, v);
    	}
    	
    	out.close();
    }
    
    private static boolean solve(int n, int m, int v)
    {
    	int need = m;
    	int random = -1;
    	boolean selected = false;
		for(int i = 0; i < n; i++)
		{
			if(need == 0) 
				return true;
			if(i != v)
			{
				out.println((v + 1) + " " + (i + 1));
				need--;
			} 
			
			if(!selected && i != v)
			{
				random = i;
				selected = true;
			}
		}
		
		for(int i = 0; i < n; i++)
		{
			for(int j = i + 1; j < n; j++)
			{
				if(i != random && j != random && i != v && j != v)
				{
					if(need == 0)
						return true;
					out.println((i + 1) + " " + (j + 1));
					need--;
				}
			}
		}
		
    	return true;
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
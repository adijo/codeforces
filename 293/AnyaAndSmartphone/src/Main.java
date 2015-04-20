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
    	n = sc.nextInt();
    	m = sc.nextInt();
    	k = sc.nextInt();
    	int ctr = 0;
    	int[] holder = null;
    	for(int i = 0; i < n; i++)
    	{
    		if(ctr == 0)
    		{
    			holder = new int[k];
    			holder[ctr++] = sc.nextInt();
    		}
    		else holder[ctr++] = sc.nextInt();
    		
    		
    	}
    	
    	
    	out.close();
    }
    
    private static class Container
    {
    	public int[] arr;
    	private int[] in;
    	public Container(int[] a)
    	{
    		this.arr = a;
    		in = new int[n + 1];
    		for(int i = 0; i < k; i++)
    		{
    			if(arr[i] != -1)
    			{
    				in[arr[i]] = i;
    			}
    		}
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
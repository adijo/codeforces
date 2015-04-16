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
    	Interval[] arr = new Interval[n];
    	for(int i = 0; i < n; i++)
    	{
    		int x = sc.nextInt();
    		int w = sc.nextInt();
    		arr[i] = new Interval(x - w, x + w);
    	}
    	
    	Arrays.sort(arr);
    	int count = 1;
    	Interval first = arr[0];
    	for(int i = 1; i < arr.length; i++)
    	{
    		Interval curr = arr[i];
    		if(curr.start >= first.end)
    		{
    			count++;
    			first = curr;
    		}
    		
    	}
    	
    	out.println(count);
    	out.close();
    }
    
    
    private static class Interval implements Comparable<Interval>
    {

    	int start;
    	int end;
    	public Interval(int a, int b)
    	{
    		this.start = a;
    		this.end = b;
    	}
    	
		@Override
		public int compareTo(Interval that) 
		{
			if(this.end > that.end) return 1;
			else if(this.end < that.end) return -1;
			else return 0;
			
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main 
{
    private static MyScanner sc;
    private static PrintWriter out;
    private static int[] dfreq;
    public static void main(String[] args)
    {
    	sc = new MyScanner();
    	out = new PrintWriter(System.out);
    	dfreq = new int[201];
    	int n = sc.nextInt();
    	int[] arr = new int[n];
    	Pair[] pairs = new Pair[n];
    	for(int i = 0; i < n; i++)
    	{
    		arr[i] = sc.nextInt();
    		pairs[i] = new Pair(arr[i]);
    	}
    	
    	for(int i = 0; i < n; i++)
    	{
    		pairs[i].cost = sc.nextInt();
    		dfreq[pairs[i].cost]++;
    	}
    	
    	Arrays.sort(pairs);
    	Leg curr = new Leg();
    	curr.cost = pairs[0].cost;
    	curr.freq = 1;
    	curr.length = pairs[0].length;
    	curr.dfreq[pairs[0].cost]++;
    	List<Leg> processList = 
    			new ArrayList<Leg>();
    	for(int i = 1; i < n; i++)
    	{
    		if(pairs[i].length != curr.length)
    		{
    			processList.add(curr);
    			curr = new Leg();
    			curr.length = pairs[i].length;
    			curr.freq = 1;
    			curr.cost = pairs[i].cost;
    			curr.dfreq[pairs[i].cost]++;
    		}
    		else
    		{
    			curr.cost += pairs[i].cost;
    			curr.freq++;
    			curr.dfreq[pairs[i].cost]++;
    		}
    	}
    	processList.add(curr);
    	
		long answer = Long.MAX_VALUE;
		long cumulativeCost = 0;
		int tot = 0;
		for(int i = processList.size() - 1; i >= 0; i--)
		{
			// delete this leg.
			
			Leg l = processList.get(i);
			for(int j = 1; j <= 200; j++)
			{
				dfreq[j] -= l.dfreq[j];
			}
			
			// if this is deleted, how many are wanted?
			int left = n - tot;
			if (l.freq > (left / 2))
			{
				// do nothing.
				answer = min(answer, cumulativeCost);
			}
			else
			{
				//int want = (left - ((2 * l.freq) + 1)) - l.freq;
				int needed = (2 * l.freq) - 1;
				int want = left - needed;
				
				answer = min(answer, cumulativeCost + find(want));
			}
			
			tot += l.freq;
			cumulativeCost += l.cost;
			
		}
		out.println(answer);
    	out.close();
    }
    
    private static long find(int want)
    {
    	long tot = 0;
    	for(int i = 1; i <= 200; i++)
    	{
    		if(dfreq[i] > 0)
    		{
    			if(dfreq[i] >= want)
    			{
    				tot += (want * i);
    				return tot;
    			}
    			
    			else
    			{

    				tot += (i * dfreq[i]);
    				want -= dfreq[i];
    			}
    		}
    	}
    	
    	return -1;
    
    	
    }
    
    
    
    private static class Leg implements Comparable<Leg>
    {
    	public int length;
    	public long cost;
    	public int[] dfreq;
    	int freq;
    	
    	public Leg()
    	{
    		dfreq = new int[201];
    	}
    	
		@Override
		public int compareTo(Leg that) 
		{
			if(this.length > that.length)
				return -1;
			else if(this.length < that.length)
				return 1;
			else
				return 0;
		}

		@Override
		public String toString() {
			return "Leg [length=" + length + ", cost=" + cost + ", freq="
					+ freq + "]";
		}
		
		
    }
    
    private static class Pair implements Comparable<Pair>
    {
    	int length;
    	int cost;
    	public Pair(int l) {this.length = l;}
		@Override
		public int compareTo(Pair that) 
		{
			if(this.length > that.length)
				return 1;
			else if(this.length < that.length)
				return -1;
			else
				return 0;
			
		}
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
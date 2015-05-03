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
    private static char[][] grid;
    private static boolean[][] visited;
    private static int N;
    private static int M;
    private static int r;
    private static int c;
    
    
    public static void main(String[] args)
    {
    	sc = new MyScanner();
    	out = new PrintWriter(System.out);
    	
    	N = sc.nextInt();
    	M = sc.nextInt();
    	grid = new char[N][M];
    	visited = new boolean[N][M];
    	for(int i = 0; i < N; i++)
    	{
    		String line = sc.next();
    		for(int j = 0; j < M; j++)
    		{
    			grid[i][j] = line.charAt(j);
    		}
    		
    	}
    	
    	int x = sc.nextInt() - 1;
    	int y = sc.nextInt() - 1;
    	
    	r = sc.nextInt() - 1;
    	c = sc.nextInt() - 1;
    	
    	if(x == r && y == c)
    	{
    		
    		boolean ans = false;
    		// start and end are the same.
    		if(inGrid(x + 1, y)) ans = true;
    		if(inGrid(x, y + 1)) ans = true;
    		if(inGrid(x - 1, y)) ans = true;
    		if(inGrid(x, y - 1)) ans = true;
    		
    		if(!ans) out.println("NO");
    		else out.println("YES");
    		
    	}
    	else if(areNeighbours(x, y))
    	{
    		if(grid[r][c] == 'X') out.println("YES");
    		else
    		{
    			boolean ans = false;
    			if(inGrid(r + 1, c)) ans = true;
    			if(inGrid(r, c + 1)) ans = true;
    			if(inGrid(r - 1, c)) ans = true;
    			if(inGrid(r, c - 1)) ans = true;
    			
    			if(ans) out.println("YES");
    			else out.println("NO");
    			
    		}
    		
    	}
    	
    	else
    	{
    		boolean reachable = dfs(x, y);
    		if(!reachable) out.println("NO");
    		else
    		{
    			if(grid[r][c] == 'X') out.println("YES");
    			else
    			{
    				int count = 0;
        			if(inGrid(r + 1, c)) count++;
        			if(inGrid(r, c + 1)) count++;
        			if(inGrid(r - 1, c)) count++;
        			if(inGrid(r, c - 1)) count++;
        			
        			if(count >= 2) out.println("YES");
        			else out.println("NO");
    				
    				
    			}
    			
    		}
    	}
    	
    	out.close();
    }
  
    
  
    
    public static boolean dfs(int x, int y)
    {
    	visited[x][y] = true;
    	if(x ==  r && y == c)
    	{
    		return true;
    	}
    	
    	if(isValid(x + 1, y))
    	{
    		boolean res = dfs(x + 1, y);
    		if (res) return res;
    	}
    	
    	if(isValid(x, y + 1))
    	{
    		boolean res = dfs(x, y + 1);
    		if (res) return res;
    	} 
    	
    	if(isValid(x - 1, y))
    	{
    		boolean res = dfs(x - 1, y);
    		if (res) return res;
    	} 
    	
    	if(isValid(x, y - 1))
    	{
    		boolean res = dfs(x, y - 1);
    		if (res) return res;
    		
    	} 
    	
    	// last check
    	
    	if(x + 1 == r && y == c)
    	{
    		return true;
    	}
    	
    	if(x == r && y + 1 == c)
    	{
    		return true;
    	} 
    	
    	if(x - 1 == r && y == c)
    	{
    		return true;
    	} 
    	
    	if(x == r && y - 1 == c)
    	{
    		return true;
    		
    	} 
    	
    	return false;
    }
    
    private static boolean isValid(int x, int y)
    {
    	return (x >= 0 && x < N && y >= 0 && y < M && grid[x][y] == '.' && !visited[x][y]);
    }
  
    private static boolean inGrid(int x, int y)
    {
    	return (x >= 0 && x < N && y >= 0 && y < M && grid[x][y] == '.');
    }
    
    private static boolean areNeighbours(int x, int y)
    {
    	if(x + 1 == r && y == c) return true;
    	else if(x - 1 == r && y == c) return true;
    	else if(x == r && y + 1 == c) return true;
    	else if(x == r && y - 1 == c) return true;
    	else return false;
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
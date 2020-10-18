/*

	Title	:	To implement kruskal's algorithm to find minimum spanning tree
	
*/

import java.util.*;

class edge
{
	int src,dest;
	int cost;
	
	edge(int s,int d,int wt)
	{
		src=s;
		dest=d;
		cost=wt;
	}
	
	public String toString()
	{
		return this.src+"  "+this.dest+"  "+this.cost;
	}
}


class sortByCost implements Comparator<edge>
{
	public int compare(edge e1,edge e2)
	{
		return e1.cost-e2.cost;
	}
}


class algo 
{	
	int AdjMat[][];
	int arr[];
	int n;
	int e;
	ArrayList<edge> list=new ArrayList<edge>();
	
	void createMat()
	{		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the no. of cities: ");
		n=sc.nextInt();
		
		AdjMat=new int[n][n];
		arr=new int[n];
		
		
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter city number: ");
			arr[i]=sc.nextInt();
			
		}
			
		System.out.println("Enter the no. of pairs: ");
		e=sc.nextInt();
		
		for(int i=0;i<e;i++)
		{
			System.out.println("Enter the pair of cities: ");
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			System.out.print("Enter its amount of money : ");
			int w=sc.nextInt();
			
			int u=-1,v=-1;
			
			for(int k=0;k<n;k++)
			{
				if(x==arr[k])
				{
					u=k;
					break;
				}
				
			}
			for(int l=0;l<n;l++)
			{
				
				if(y==arr[l])
				{
					v=l;
					break;
				}
			}
			
			if((u==-1)||(v==-1))
			{
				System.out.println("Vertices not found! ");
				return;
			}
			
			addEdge(u,v,w);
			
		}
		
		
	}
	
	void addEdge(int u,int v,int w)	
	{
		AdjMat[u][v]=w;	
		AdjMat[v][u]=w;

		edge e=new edge(u,v,w);
		list.add(e);
	}
	
	
	void mst()
	{
			
		Scanner sc=new Scanner(System.in);
		
		Collections.sort(list,new sortByCost());
		
		/*		
		//Sorted List
		
		for(int p=0;p<list.size();p++)
		{			
			System.out.println("\n"+list.get(p)+"\n");
		}
		System.out.println("\n\n\n");
		*/
		
		int i=0,j=0,w=0,sum=0;
		int parent[]=new int[n];
		int count=0;
		
		for(int a=0;a<n;a++)
		{
			parent[a]=-1;
		}
		
		
		//Minimum Spanning tree
		System.out.println("Connect all offices in this manner:\n\n");
		while(count<n-1)
		{
				
			edge e=list.remove(0);
			i=e.src;
			j=e.dest;
			w=e.cost;
				
			while(parent[i]!=-1)
			{
				i=parent[i];
			}	
			while(parent[j]!=-1)
			{
				j=parent[j];
			}
			
			if(i!=j)
			{
				parent[j]=i;
				sum=sum+w;
			
				count++;
				System.out.println("("+arr[e.src]+","+arr[e.dest]+") with cost  "+ e.cost);
			}
			/*
			else
			{
				System.out.println("Restricted edge: ("+e.src+","+e.dest+")");
			}
			*/
		}
		
		System.out.println("\n\nTotal money required =  "+sum+"\n");
		
	}
	
	
	void displayMat()
	{
		
		System.out.println("\nAdjacency Matrix: \n");


		System.out.print("\t");
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+"\t");
		}
		System.out.println("\n_________________________________________________________________________");

		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+"\t|");
			for(int j=0;j<n;j++)
			{
				System.out.print(AdjMat[i][j]+"\t");
			}
				
			System.out.println();
		}


	}
	

}


public class Kruskal
{
	public static void main(String args[])
	{
		algo k=new algo();
		
		Scanner sc=new Scanner(System.in);
		int ch;
		
		
		System.out.println("*****----Kruskal's Algorithm-----******");
		System.out.println();
		
		k.createMat();
		
		do
		{	
			System.out.println("\n------------");
			System.out.println("----MENU----");
			System.out.println("1.Display Matrix");
			System.out.println("2.Display MST using Kruskal's algo");
			System.out.println("3.Exit");
			System.out.println("------------");
			System.out.println();
			
			System.out.println("Enter your choice: ");
			ch=sc.nextInt();
			
			switch(ch)
			{
				case 1:
						k.displayMat();						
						break;

				case 2:					
						k.mst();						
						break;						
			}
			
			
		}while(ch>0&&ch<3);	
		
		
	}
}


/*


OUTPUT:


*****----Kruskal's Algorithm-----******

Enter the no. of cities:
9
Enter city number: 1
Enter city number: 2
Enter city number: 3
Enter city number: 4
Enter city number: 5
Enter city number: 6
Enter city number: 7
Enter city number: 8
Enter city number: 9
Enter the no. of pairs:
14
Enter the pair of cities:
1
3
Enter its amount of money :
12
Enter the pair of cities:
1
2
Enter its amount of money :
16
Enter the pair of cities:
1
7
Enter its amount of money :
27
Enter the pair of cities:
2
3
Enter its amount of money :
25
Enter the pair of cities:
3
7
Enter its amount of money :
24
Enter the pair of cities:
2
4
Enter its amount of money :
15
Enter the pair of cities:
4
3
Enter its amount of money :
12
Enter the pair of cities:
5
4
Enter its amount of money :
3
Enter the pair of cities:
3
5
Enter its amount of money :
11
Enter the pair of cities:
5
9
Enter its amount of money :
2
Enter the pair of cities:
3
6
Enter its amount of money :
10
Enter the pair of cities:
6
9
Enter its amount of money :
8
Enter the pair of cities:
9
8
Enter its amount of money :
5
Enter the pair of cities:
7
8
Enter its amount of money :
18

------------
----MENU----
1.Display Matrix
2.Display MST using Kruskal's algo
3.Exit
------------

Enter your choice:
1

Adjacency Matrix:

        1       2       3       4       5       6       7       8       9
_______________________________________________________________________________
1       |0      16      12      0       0       0       27      0       0
2       |16     0       25      15      0       0       0       0       0
3       |12     25      0       12      11      10      24      0       0
4       |0      15      12      0       3       0       0       0       0
5       |0      0       11      3       0       0       0       0       2
6       |0      0       10      0       0       0       0       0       8
7       |27     0       24      0       0       0       0       18      0
8       |0      0       0       0       0       0       18      0       5
9       |0      0       0       0       2       8       0       5       0

------------
----MENU----
1.Display Matrix
2.Display MST using Kruskal's algo
3.Exit
------------

Enter your choice:
2
Connect all offices in this manner:


(5,9) with cost  2
(5,4) with cost  3
(9,8) with cost  5
(6,9) with cost  8
(3,6) with cost  10
(1,3) with cost  12
(2,4) with cost  15
(7,8) with cost  18


Total money required =  73


*/

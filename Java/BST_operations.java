/*

	Title	:	To implement binary search tree and perform operations on it.
	
*/

import java.util.*;

class node
{
	int data;
	node lc;
	node rc;
	
	node(int d)
	{
		data=d;
		lc=null;
		rc=null;
	}
}

class BST
{
	Scanner sc=new Scanner(System.in);
	node root;
	int count=0;
	node temp,ptr;
	 
 
	BST()
	{
		root=null;
	}
	 
	void create()
	{

	    int flag=0,data;
	    char ch;

	    do
		{
			flag=0;
			
		    System.out.println("Enter the value for node : ");
		    data=sc.nextInt();
		    temp=new node(data);
			if(root==null)
			{
		 
		  		root=temp;
		  		flag=1;
			}
	 
			else
			{
			   ptr=root;
	   
			    while(flag==0)
			    {
			       
			        //System.out.println(ptr.data);
			       
			        if(temp.data<ptr.data)
			        {
				        if(ptr.lc==null)
				        {
				            ptr.lc=temp;
				            flag=1;
				           
				        }
				        else
				        {
				            ptr=ptr.lc;
				           
				        }

			        }
			        else if(temp.data>ptr.data)
			        {
			            if(ptr.rc==null)
			            {
			               
			                ptr.rc=temp;
			                flag=1;
			               
			            }
			            else
			            {
			                ptr=ptr.rc;
			               
			            }   
			       
			        }
			        else
			        {
			        	System.out.println("Node already exist!");
			        }
			    }
			}

			if(flag==1)
				System.out.println("Node inserted!");
			
			
			System.out.println("\n\nDo you want to continue creating? (Y/N)");
			ch=sc.next().charAt(0);
			
		}while(ch=='y'||ch=='Y');

	}
 
	void display()
	{
	   
	    node ptr=root;
		Stack<node> s=new Stack<node>();
		
		while(true)
		{
			while(ptr!=null)
			{
				s.push(ptr);
				ptr=ptr.lc;
			}
			
			if(s.isEmpty())
				break;
			
			ptr=s.pop();
			System.out.println(ptr.data);
			ptr=ptr.rc;			
			
		}
	   
	}
	 
	void levelOrder()
	{

	    Queue<node> q=new LinkedList<node>();
	  
	    ptr=root;
	    while(true)
	    {
		    System.out.print(ptr.data+" ");
	        if(ptr.lc!=null)
	        {
	      		q.add(ptr.lc);
	        }
	        if(ptr.rc!=null)
	        {
	            q.add(ptr.rc);
	        }
	        if(q.isEmpty())
	        {
	            break;
	        }
	        else
	        {
	            ptr=q.remove();
	           
	        }
	    }
	     
	}

	void findMaxMin()
	{
	    int ch;
	    do
	    {
		    System.out.println("==========MENU=========\n");
		    
		    System.out.println("1.Find Maximum Node in a BST\n");
		    
		    System.out.println("2.Find Minimum Node in a BST\n");
		    
		    System.out.println("3.Exit\n");
		    
		    System.out.println("Enter your choice : ");
		    ch=sc.nextInt();
		   

		   
		    switch(ch)
		    {

			    case 1:
			        
			        ptr=root;
			        while(ptr.rc!=null)
			        {
			           			              
			            ptr=ptr.rc;
			               		   	           
			        }
					System.out.println("Maximum node in a BST is : "+ptr.data);
		  		    break;

			    case 2:
			        
			        ptr=root;
			        while(ptr.lc!=null)
			        {
			           			              
			            ptr=ptr.lc;
			               		   	           
			        }
					System.out.println("Maximum node in a BST is : "+ptr.data);
		  		    break;
	       
	   		}

	    }while(ch<3 && ch>0);
	   

	}


	void descorder()
	{
	    Stack<node> s=new Stack<node>();
	    ptr=root;
	    while(true)
	    {
	        while(ptr!=null)
	        {
	            s.push(ptr);
	            ptr=ptr.rc;
	           
	        }
	        if(s.isEmpty())
	            return;
	 
	        ptr=s.pop();
	        System.out.print(ptr.data+" ");
	        ptr=ptr.lc;	        
	    }
	}

	int count(node l_root)
	{
	     
	    if(l_root.lc==null&&l_root.rc==null)
	    {
	    	count++;
	    }
	    else
	    {
		    if(l_root.lc!=null)
		    {
		    	count(l_root.lc);
		    }
		    if(l_root.rc!=null)
		    {
		   		count(l_root.rc);   
		    }
	    }
	    
	    return count;
	     
	}
   
	void countleaf()
	{
	   
	    int c=count(root);
	    System.out.println("Total no of leaf nodes are : "+c);
	   
	}


	int height(node root)
	{

		int hleft=0;
	    int hright=0;
	    if(root.lc!=null)
	    {
	        hleft=height(root.lc);
	    }
	    if(root.rc!=null)
	    {
	        hright=height(root.rc);
	    }
	    if(hleft>hright)
	    {
	        return hleft+1;
	    }
	    else
	    {
	        return hright+1;
	    }                 
	}

	void findHeight()
	{
	    int h=height(root);
	    System.out.println("Height of a BST is : "+h);
	     
	}

	node copy1(node r)
	{
		node root1,ptr1=null;

	    if(r==null)
	    {
	        return null;
	    }
	    else
	    {
	        node temp1=new node(r.data);
	         
	        if(r.lc!=null)
	        {	

	    	    temp1.lc=copy1(r.lc);

	        }
	        if(r.rc!=null)
	        {
	        
	        	temp1.rc=copy1(r.rc);
	             
	        }

	        return temp1;
	    }         
	       
	}

	void copy()
	{
	    node p=copy1(root);
	    Stack<node> s=new Stack<node>();
	    while(true)
	    {
	        while(p!=null)
	        {
	            s.push(p);
	            p=p.lc;
	           
	        }
	        if(s.isEmpty())
	        {
	            return;
	        }
	        else
	        {
	            p=s.pop();
	            System.out.print(p.data+"  ");
	            p=p.rc;
	        }
	    }   
	   
	}
}
class BST_Main
{
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		BST t=new BST();
		int ch;
		do
		{
			System.out.println("");
			System.out.println("==================MENU================");
			System.out.println("");
			System.out.println("1.Create Tree");
			System.out.println("2.Display Tree");
			System.out.println("3.Find Maximum and Minimum node in a tree");
			System.out.println("4.Display Tree Levelwise");
			System.out.println("5.Find height of the tree");
			System.out.println("6.Display tree in descending order");
			System.out.println("7.Count no of leaf nodes in recursive");
			System.out.println("8.Copy tree");
			System.out.println("9.Exit");
			System.out.println("");
			System.out.println("Enter your choice : ");
			ch=sc.nextInt();
			System.out.println("");
			switch(ch)
			{

				  case 1:
				     t.create();
				     break;
				  case 2:
				      t.display();
				      break;
				  case 3:
				      t.findMaxMin();
				      break;
				  case 4:
				      t.levelOrder();
				      break;
				  case 5:
				      t.findHeight();
				      break;
				  case 6:
				      t.descorder();
				      break;
				  case 7:
				     t.countleaf();
				      break;
				  case 8:
				      t.copy();
				      break;   

			  }
		
		}while(ch>0&&ch<9);

	}
}

/*

OUTPUT:

==================MENU================

1.Create Tree
2.Display Tree
3.Find Maximum and Minimum node in a tree
4.Display Tree Levelwise
5.Find height of the tree
6.Display tree in descending order
7.Count no of leaf nodes in recursive
8.Copy tree
9.Exit

Enter your choice : 
1

Enter the value for node : 
100
Node inserted!


Do you want to continue creating? (Y/N)
y
Enter the value for node : 
50
Node inserted!


Do you want to continue creating? (Y/N)
y
Enter the value for node : 
150
Node inserted!


Do you want to continue creating? (Y/N)
y
Enter the value for node : 
25
Node inserted!


Do you want to continue creating? (Y/N)
y
Enter the value for node : 
75
Node inserted!


Do you want to continue creating? (Y/N)
y
Enter the value for node : 
125
Node inserted!


Do you want to continue creating? (Y/N)
n

==================MENU================

1.Create Tree
2.Display Tree
3.Find Maximum and Minimum node in a tree
4.Display Tree Levelwise
5.Find height of the tree
6.Display tree in descending order
7.Count no of leaf nodes in recursive
8.Copy tree
9.Exit

Enter your choice : 
2

25
50
75
100
125
150

==================MENU================

1.Create Tree
2.Display Tree
3.Find Maximum and Minimum node in a tree
4.Display Tree Levelwise
5.Find height of the tree
6.Display tree in descending order
7.Count no of leaf nodes in recursive
8.Copy tree
9.Exit

Enter your choice : 
1

Enter the value for node : 
175
Node inserted!


Do you want to continue creating? (Y/N)
n

==================MENU================

1.Create Tree
2.Display Tree
3.Find Maximum and Minimum node in a tree
4.Display Tree Levelwise
5.Find height of the tree
6.Display tree in descending order
7.Count no of leaf nodes in recursive
8.Copy tree
9.Exit

Enter your choice : 
2

25
50
75
100
125
150
175

==================MENU================

1.Create Tree
2.Display Tree
3.Find Maximum and Minimum node in a tree
4.Display Tree Levelwise
5.Find height of the tree
6.Display tree in descending order
7.Count no of leaf nodes in recursive
8.Copy tree
9.Exit

Enter your choice : 
3

==========MENU=========

1.Find Maximum Node in a BST

2.Find Minimum Node in a BST

3.Exit

Enter your choice : 
1
Maximum node in a BST is : 175
==========MENU=========

1.Find Maximum Node in a BST

2.Find Minimum Node in a BST

3.Exit

Enter your choice : 
2
Maximum node in a BST is : 25
==========MENU=========

1.Find Maximum Node in a BST

2.Find Minimum Node in a BST

3.Exit

Enter your choice : 
3

==================MENU================

1.Create Tree
2.Display Tree
3.Find Maximum and Minimum node in a tree
4.Display Tree Levelwise
5.Find height of the tree
6.Display tree in descending order
7.Count no of leaf nodes in recursive
8.Copy tree
9.Exit

Enter your choice : 
4

100 50 150 25 75 125 175 
==================MENU================

1.Create Tree
2.Display Tree
3.Find Maximum and Minimum node in a tree
4.Display Tree Levelwise
5.Find height of the tree
6.Display tree in descending order
7.Count no of leaf nodes in recursive
8.Copy tree
9.Exit

Enter your choice : 
5

Height of a BST is : 3

==================MENU================

1.Create Tree
2.Display Tree
3.Find Maximum and Minimum node in a tree
4.Display Tree Levelwise
5.Find height of the tree
6.Display tree in descending order
7.Count no of leaf nodes in recursive
8.Copy tree
9.Exit

Enter your choice : 
6

175 150 125 100 75 50 25 
==================MENU================

1.Create Tree
2.Display Tree
3.Find Maximum and Minimum node in a tree
4.Display Tree Levelwise
5.Find height of the tree
6.Display tree in descending order
7.Count no of leaf nodes in recursive
8.Copy tree
9.Exit

Enter your choice : 
7

Total no of leaf nodes are : 4

==================MENU================

1.Create Tree
2.Display Tree
3.Find Maximum and Minimum node in a tree
4.Display Tree Levelwise
5.Find height of the tree
6.Display tree in descending order
7.Count no of leaf nodes in recursive
8.Copy tree
9.Exit

Enter your choice : 
8

25  50  75  100  125  150  175  
==================MENU================

1.Create Tree
2.Display Tree
3.Find Maximum and Minimum node in a tree
4.Display Tree Levelwise
5.Find height of the tree
6.Display tree in descending order
7.Count no of leaf nodes in recursive
8.Copy tree
9.Exit

Enter your choice : 
9



*/

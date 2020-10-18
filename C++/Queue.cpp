#include <iostream>
using namespace std;
const int MAX=3;

class Queue
{
	int front,rear;
	int data[MAX];
	public:
		Queue()
		{
			front=-1;
			rear=0;
		}
		int isEmpty()
		{
			if(front==-1||front==rear)
				return 1;
			else
				return 0;
		}
		int isFull()
		{
			if(rear==MAX)
				return 1;
			else
				return 0;
		}
		void enqueue()
		{
			if(isFull()==1)
			{
				cout<<"Queue is full!"<<endl;
				return;
			}
			else
			{
				int elem;
				cout<<"Enter element to be inserted"<<endl;
				cin>>elem;
				if(front==-1)
					front=0;
				data[rear]=elem;
				rear++;
				cout<<"Element inserted!"<<endl;
			}
		}
		int dequeue()
		{
			if(isEmpty()==1)
			{
				return -1;
			}
			else
			{
				int temp;
				temp=data[front];
				front++;
				return temp;
			}
		}
		void display()
		{
		    if(isEmpty()==1)
			{
				cout<<"Queue is empty!"<<endl;
			}
			else
            {
                cout<<"Queue: "<<endl;
                for(int i=front;i<rear;i++)
                    cout<<data[i]<<"\t";
                cout<<endl;
			}
		}

};

int main() {

	Queue q1;
	int ch;

	cout<<"---QUEUE---"<<endl;
	cout<<"1.Insert"<<endl;
	cout<<"2.Delete"<<endl;
	cout<<"3.Display"<<endl;
	cout<<"4.Exit"<<endl;
	cout<<"-----------"<<endl;

	while(1)
	{
	    cout<<"\n";
		cout<<"Enter your choice:"<<endl;
		cin>>ch;
		switch(ch)
		{
			case 1:
					q1.enqueue();
					break;
			case 2:
					int temp;
					temp=q1.dequeue();
					if(temp==-1)
						cout<<"Queue is empty!"<<endl;
					else
						cout<<temp<<" is deleted!"<<endl;
					break;
			case 3:
					q1.display();
					break;
			case 4:
					cout<<"Program closed!"<<endl;
					//exit(1);
					break;
			default:
					cout<<"Invalid choice!"<<endl;
					break;
		}
	}

	return 0;
}


/*

OUTPUT:

---QUEUE---
1.Insert
2.Delete
3.Display
4.Exit
-----------

Enter your choice:
2
Queue is empty!

Enter your choice:
1
Enter element to be inserted
1
Element inserted!

Enter your choice:
1
Enter element to be inserted
2
Element inserted!

Enter your choice:
1
Enter element to be inserted
3
Element inserted!

Enter your choice:
1
Queue is full!

Enter your choice:
3
Queue:
1       2       3

Enter your choice:
2
1 is deleted!

Enter your choice:
3
Queue:
2       3

Enter your choice:
2
2 is deleted!

Enter your choice:
3
Queue:
3

Enter your choice:
2
3 is deleted!

Enter your choice:
3
Queue is empty!

Enter your choice:
2
Queue is empty!

Enter your choice:
4
Program closed!

*/

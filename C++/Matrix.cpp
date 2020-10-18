#include <iostream>
using namespace std;

class Matrix
{
	int row,col,element;
    int a[10][10];
    int add[10][10];
    int mul[10][10];
    public:

	void accept()
	{
	    int i,j;
	    while(1)
        {
            cout<<"Enter number of rows and columns: "<<endl;
            cin>>row>>col;
            if(row<=0||col<=0)
                cout<<"Row and column cannot be less than 1"<<endl;
            else
                break;
        }
		for(i=0;i<row;i++)
		{
			for(j=0;j<col;j++)
			{
				cout<<"enter element at: a["<<i<<"]["<<j<<"]"<<endl;
				cin>>element;
				a[i][j]=element;
			}
		}

	}
	void display()
	{
	    int i,j;
		cout<<"Matrix is : "<<endl;
		for(i=0;i<row;i++)
        {
			for(j=0;j<col;j++)
			{
				cout<<a[i][j]<<"    ";
			}
			cout<<endl;
		}

	}

	void square()
	{
		if(row==col)
			cout<<"Matrix is square matrix"<<endl;
		else
			cout<<"Matrix is not square"<<endl;
	}

	void uppertriangular()
	{
	    int i,j;
		int isUpper=0;
		for(i=0;i<row;i++)
		{
			for(j=0;j<col;j++)
			{
				if(j<i && a[i][j]!=0)
				{
					isUpper=1;
				}
			}
		}
		if(isUpper==1)
			cout<<"Matrix is not upper triangular matrix"<<endl;
		else
			cout<<"It is upper triangular matrix"<<endl;

	}

	void Addition(Matrix m1)
	{
	    Matrix c;
	    int i,j;

		if(row==m1.row&&col==m1.col)
		{
			for(i=0;i<row;i++)
			{
				for(j=0;j<col;j++)
				{
					c.a[i][j]=a[i][j]+m1.a[i][j];
				}
			}
			cout<<"Addition is :"<<endl;
            for(i=0;i<row;i++)
			{
				for(j=0;j<col;j++)
                {
					cout<<c.a[i][j]<<"    ";
				}
				cout<<endl;
			}
		}
		else
			cout<<"Matrix addition is not possible"<<endl;
	}

	void Multiplication(Matrix m1)
	{
	    Matrix c;
	    int i,j;

		if(col==m1.row)
		{
			for(i=0;i<row;i++)
			{
				for(j=0;j<m1.col;j++)
                {
                    int temp=0;
					for(int k=0;k<col;k++)
					{
						temp=temp+a[i][k]*m1.a[k][j];
						c.a[i][j]=temp;
					}
                }
			}
			cout<<"Multiplication is :"<<endl;
            for(i=0;i<row;i++)
            {
                for(j=0;j<m1.col;j++)
                {
                    cout<<c.a[i][j]<<"    ";
                }
                cout<<endl;
            }
		}
		else
            cout<<"Matrix multiplication is not possible!"<<endl;
	}

	void transpose()
	{
	    int i,j;
        int T[10][10];
        int temp;

		if(row==col)
		{
			for(i=0;i<row;i++)
			{
				for(j=0;j<i;j++)
                {
                    temp=a[i][j];
                    a[i][j]=a[j][i];
                    a[j][i]=temp;
                }
			}
			cout<<"Transposition is :"<<endl;
            for(i=0;i<row;i++)
            {
                for(j=0;j<col;j++)
                {
                    cout<<a[i][j]<<"    ";
                }
				cout<<endl;
            }
		}
		else
        {
			for(i=0;i<row;i++)
			{
				for(j=0;j<col;j++)
				{
					T[j][i]=a[i][j];
				}
            }
            cout<<"Transposition is :"<<endl;
            for(i=0;i<col;i++)
            {
                for(j=0;j<row;j++)
                {
                    cout<<T[i][j]<<"    ";
                }
                cout<<endl;
            }
        }
    }
};

int main()
{

    Matrix m1,m2;
    int ch,row,col;
    m1.accept();
    m1.display();
    m2.accept();
    m2.display();
    cout<<"1.Find if square matrix"<<endl;
    cout<<"2.Find if upper triangular matrix"<<endl;
    cout<<"3.Addition"<<endl;
    cout<<"4.Multiplication"<<endl;
    cout<<"5.Transpose"<<endl;
    cout<<"6.Exit"<<endl;

    while(1)
    {
        cout<<"Enter your choice"<<endl;
        cin>>ch;
        switch(ch)
        {

        case 1:
            m1.square();
            break;

        case 2:
            m1.uppertriangular();
            break;

        case 3:
            m1.Addition(m2);
            break;

        case 4:
            m1.Multiplication(m2);
            break;

        case 5:
            m1.transpose();
            break;

        case 6:
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


// OUTPUT:

// Enter number of rows and columns:
// 3
// 3
// enter element at: a[0][0]
// 1
// enter element at: a[0][1]
// 2
// enter element at: a[0][2]
// 3
// enter element at: a[1][0]
// 0
// enter element at: a[1][1]
// 2
// enter element at: a[1][2]
// 3
// enter element at: a[2][0]
// 0
// enter element at: a[2][1]
// 0
// enter element at: a[2][2]
// 3
// Matrix is :
// 1    2    3
// 0    2    3
// 0    0    3
// Enter number of rows and columns:
// 2
// 2
// enter element at: a[0][0]
// 1
// enter element at: a[0][1]
// 2
// enter element at: a[1][0]
// 3
// enter element at: a[1][1]
// 4
// Matrix is :
// 1    2
// 3    4
// 1.Find if square matrix
// 2.Find if upper triangular matrix
// 3.Addition
// 4.Multiplication
// 5.Transpose
// 6.Exit
// Enter your choice
// 1
// Matrix is square matrix
// Enter your choice
// 2
// It is upper triangular matrix
// Enter your choice
// 3
// Matrix addition is not possible
// Enter your choice
// 4
// Multiplication is :
// 65536    -2    0
// 127    127    208
// 42817860    42815040    2008140572
// Enter your choice
// 5
// Transposition is :
// 1    0    0
// 2    2    0
// 3    3    3
// Enter your choice
// 6
// Program closed!

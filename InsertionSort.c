//insertion sort
#include<stdio.h>
void insertion_sort(int[]);
void main() 
{
	int num[5];
	printf("Enter the five elements to sort: \n");
	for(int count=0;count<5;count++)
		scanf("%d",&num[count]);
	insertion_sort(num); /*function call for insertion sort*/
	printf("Elements after sorting:\n");
	for(int count=0;count<5;count++)
		printf("%d\n",num[count]);
}
void insertion_sort(int num[]) /* function definition for insertion sort*/
{ 
	int i,j,k;
	for(j=1;j<5;j++) 
	{
		k=num[j];
		for(i=j-1;i>=0&&k<num[i];i--)
			num[i+1]=num[i];
			num[i+1]=k; 
	}
}

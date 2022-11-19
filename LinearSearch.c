#include<stdio.h>
#include<stdlib.h>
int main(void)
{
	int a[30],search,length,value=0;
	printf("Enter the size of the array required: ");
	scanf("%d",&length);
	printf("Enter the array elements: \n");
	for(int i=0;i<length;i++)
	{
		scanf("%d",&a[i]);
	}	
	printf("Enter seach element: ");
	scanf("%d",&search);
	for(int i=0;i<length;i++)
	{
		if(a[i]==search)
		{
			printf("Search element found at %d\n",i+1);
			value=1;
		}
	}
	if(value==0)
	{
		printf("Element not found\n");
	}
	else
	{
		return 0;
	}
}

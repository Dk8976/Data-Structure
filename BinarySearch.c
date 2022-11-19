#include<stdio.h> 
#include<stdlib.h>
int main(void)
{
	int arr[50],length,search,flag=0,first,last,mid;
	printf("Enter size of array: "); 
	scanf("%d",&length);
	printf("Enter array element(ascending order): \n");
	for(int i=0;i<length;++i) 
	scanf("%d",&arr[i]);
	printf("Enter the element to search: "); 
	scanf("%d",&search);
	first=0; last=length-1;
	while(first<=last)
	{
		mid=(first+last)/2; 
		if(search==arr[mid])
		{
			flag=1; 
			break;
		}
		else
			if(search>arr[mid]) 
				first=mid+1;
			else
			last=mid-1;
	}
	if(flag==1)
		printf("Element found at position %d\n",mid+1); 
	else
		printf("Element not found\n");
}

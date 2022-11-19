#include <stdio.h>
void swap(int *a, int *b) 
{
  int temp = *a;
  *a = *b;
  *b = temp;
}
void selectionSort(int array[], int size) 
{
  for (int step = 0; step < size - 1; step++) 
  {
    int min_id= step;
    for (int i = step + 1; i < size; i++) 
    {
      if (array[i] < array[min_id])
        min_id = i;
    }
    swap(&array[min_id], &array[step]);
  }
}
void printArray(int array[], int size)
{
  for (int i = 0; i < size; ++i) 
  {
    printf("%d  ", array[i]);
  }
  printf("\n");
}
int main()
{
  	int arr[50];
  	int length;
	printf("Enter the size of array: ");
	scanf("%d",&length);
	printf("Enter the array elements: \n");
	for(int i=0;i<length;i++)
	{
		scanf("%d",&arr[i]);
	}
  selectionSort(arr, length);
  printf("Sorted array in Acsending Order...\n");
  printArray(arr,length);
}

#include <stdio.h>
void shellsort(int array[], int n) 
{
  for (int interval = n / 2; interval > 0; interval /= 2) 
  {
    for (int i = interval; i < n; i += 1) 
    {
      int temp = array[i];
      int j;
      for (j = i; j >= interval && array[j - interval] > temp; j -= interval) 
      {
        array[j] = array[j - interval];
      }
      array[j] = temp;
    }
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
  int data[50],length;
  printf("Enter the size of array: ");
  scanf("%d",&length);
  printf("Enter array elements: \n");
  for(int i=0;i<length;i++)
  {
  	scanf("%d",&data[i]);
  }
  shellsort(data, length);
  
  printf("Sorted Array in Ascending Order...\n");
  printArray(data, length);
}

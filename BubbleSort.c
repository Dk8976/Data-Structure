#include <stdio.h>
void bubbleSort(int array[], int size) 
{
  for (int step = 0; step < size - 1; ++step) 
  {
    for (int i = 0; i < size - step - 1; ++i) 
    {
      if (array[i] > array[i + 1]) 
      {
        int temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;
      }
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
  bubbleSort(data, length);
  
  printf("Sorted Array in Ascending Order...\n");
  printArray(data, length);
}

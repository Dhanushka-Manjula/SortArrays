
class SortArrays {

    void merge(int arr[], int startIndex, int medianIndex, int lastIndex) {

        int leftArraySize = medianIndex - startIndex + 1;
        int rightArraySize = lastIndex - medianIndex;

        /* Create temp arrays */
        int leftArray[] = new int[leftArraySize];
        int rightArray[] = new int[rightArraySize];

        /*Copy data to temp arrays*/
        for (int i = 0; i < leftArraySize; ++i) {
            leftArray[i] = arr[startIndex + i];
        }
        for (int j = 0; j < rightArraySize; ++j) {
            rightArray[j] = arr[medianIndex + 1 + j];
        }
        mergeArrays(leftArray,rightArray,leftArraySize,rightArraySize,arr,startIndex);
    }

    public static void mergeArrays(int[] leftArray, int[] rightArray, int leftArraySize,
                                   int rightArraySize, int[] arr,int startIndex) {

        int i = 0, j = 0;
        int k = startIndex;
        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < leftArraySize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < rightArraySize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {

            int median = (firstIndex + lastIndex) / 2;
            sort(arr, firstIndex, median);
            sort(arr, median + 1, lastIndex);
            merge(arr, firstIndex, median, lastIndex);
        }
    }

    /**
     * input the 2 unsorted arrays and return a sorted single array
     * @param firstArray
     * @param secondArray
     * @return
     */
    int[] sortTwoArrays(int firstArray[] , int secondArray[]){

        int sortedArray[] = new int[firstArray.length + secondArray.length];
        sort(firstArray, 0, firstArray.length - 1);
        sort(secondArray, 0, secondArray.length - 1);
        mergeArrays(firstArray ,secondArray , firstArray.length , secondArray.length , sortedArray , 0 );
        return sortedArray;
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int arr1[] = {18, 0, 2, 9, 6, 100};
        SortArrays ob = new SortArrays();
        printArray(ob.sortTwoArrays(arr,arr1));
    }
}


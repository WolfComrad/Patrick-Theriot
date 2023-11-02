public class bubble {
    int comp = 0;

    void bubbleSort(int num[]) {
        int k, j;
        int len = num.length;
        for (k = 0; k < len - 1; k++) {
            // comp = 999
            for (j = 0; j < len-k-1; j++) {
                // comp = 499,500
                comp = comp + 1;
                if (num[j] > num[j+1]) {
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                    // comp = 245,652
                   
                }
            }
        }
    }

    void printArray(int arr[]) {
        int len = arr.length;
        int k;

        for (k = 0; k < len; k++) {
            System.out.print(arr[k] + " ");
        }
    }
}

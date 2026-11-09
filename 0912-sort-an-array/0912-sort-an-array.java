class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    void mergeSort(int[] a, int lo, int hi, int[] temp){
        if(lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid, temp);
        mergeSort(a, mid + 1, hi , temp);
        merge(a, lo, mid, hi, temp);
    }

    void merge(int[] a, int lo, int mid, int hi, int[] temp){
        int i = lo, j = mid + 1, k = lo;

        while(i <= mid && j <= hi){
            if(a[i] <= a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }
        while(i <= mid) temp[k++] = a[i++];
        while(j <= hi) temp[k++] = a[j++];

        for(int x = lo; x <= hi; x++) a[x] = temp[x];
    }
}
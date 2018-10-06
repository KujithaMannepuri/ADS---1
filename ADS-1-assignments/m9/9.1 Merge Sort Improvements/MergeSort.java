class MergeSort {
	/**
	 * constructor.
	 */
    MergeSort() {
       
    }
    
    public void insertionSort(final Comparable[] arr, final int low, final int hi) {
        for (int i = low; i <= hi; i++) {
            for (int j = i; j > low && less(arr[j], arr[j - 1]); j--) {
                exchange(arr, j, j - 1);
            }
        }
    }
    public boolean isSorted(final Comparable[] arr) {
        return isSorted(arr, 0, arr.length - 1);
    }
    
    public boolean isSorted(final Comparable[] arr,
                            final int low, final int hi) {
        for (int i = low + 1; i <= hi; i++) {
            if (less(arr[i], arr[i - 1])) {
                return false;
            }
        }
        return true;
    }
    
    public void sorting(final Comparable[] arr, final Comparable[] aux,
                     final int low, final int hi) {
        if (hi <= low + 7) {
            insertionSort(aux, low, hi);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = low + (hi - low) / 2;
        sorting(aux, arr, low, mid);
        sorting(aux, arr, mid + 1, hi);
        if (!less(arr[mid + 1], arr[mid])) {
            for (int i = low; i <= hi; i++) {
                aux[i] = arr[i];
            }
            System.out.println(
                "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        msort(arr, aux, low, mid, hi);
    }
    
    public void sorting(final Comparable[] arr) {
        Comparable[] a = arr.clone();
        sorting(a, arr, 0, arr.length - 1);
        assert isSorted(arr);
    }
    public boolean less(final Comparable m, final Comparable n) {
        return m.compareTo(n) < 0;
    }
    public void exchange(final Comparable[] orgArr, final int i, final int j) {
        Comparable temp = orgArr[i];
        orgArr[i] = orgArr[j];
        orgArr[j] = temp;
    }
    public void msort( Comparable[] orgArr,  Comparable[] aux, int low,  int mid,  int hi) {
        assert isSorted(orgArr, low, mid);
        assert isSorted(orgArr, mid + 1, hi);
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= hi; k++) {
            if (i > mid) {
                aux[k] = orgArr[j++];
            } else if (j > hi) {
                aux[k] = orgArr[i++];
            } else if (less(orgArr[j], orgArr[i])) {
                aux[k] = orgArr[j++];
            } else {
                aux[k] = orgArr[i++];
            }
        }
        assert isSorted(aux, low, hi);
    }
    
    public String tostring(final Comparable[] orgarr) {
        String s = "[";
        int i;
        for (i = 0; i < orgarr.length - 1; i++) {
            s += orgarr[i] + ", ";
        }
        s += orgarr[i] + "]";
        return s;
    }
}

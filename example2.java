class Solution {
    private int[] elements;
    private int targetIndex;

    public int findKthLargest(int[] elements, int k) {
        this.elements = elements;
        this.targetIndex = elements.length - k;
        return performQuickSort(0, elements.length - 1);
    }

    private int performQuickSort(int left, int right) {
        if (left == right) {
            return elements[left];
        }
        int low = left - 1, high = right + 1;
        int pivot = elements[(left + right) >>> 1];

        while (low < high) {
            while (elements[++low] < pivot) {}
            while (elements[--high] > pivot) {}

            if (low < high) {
                swap(low, high);
            }
        }

        if (high < targetIndex) {
            return performQuickSort(high + 1, right);
        }
        return performQuickSort(left, high);
    }

    private void swap(int a, int b) {
        int temp = elements[a];
        elements[a] = elements[b];
        elements[b] = temp;
    }
}

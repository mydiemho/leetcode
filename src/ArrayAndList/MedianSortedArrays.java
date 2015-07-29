package ArrayAndList;

/**
 * Created by myho on 7/27/15.
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianSortedArrays {

    /**
     *
     * @param nums1
     * @param nums2
     * @return median of 2 sorted arrays
     *
     * repeatedly compare the median of the 2 arrays and
     * discarding the part that cannot contains the median
     *
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianSortedArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length);
    }

    private double findMedianSortedArrays(int[] nums1, int left1, int righ1, int[] nums2, int left2, int right2) {
        double median1 = getMedian(nums1);
        double median2 = getMedian(nums2);

        int mid1 = nums1.length / 2;
        int mid2 = nums2.length / 2;

        if(median1 < median2) {
            findMedianSortedArrays(nums1, mid1, nums1.length, nums2, 0, nums2.length);
        }

        return 0;
    }

    private double getMedian(int[] arr)
    {
        int mid = arr.length / 2;
        if(arr.length % 2 == 0) {
            return (arr[mid-1] + arr[mid]) / 2;
        } else {
            return arr[mid];
        }
    }
}

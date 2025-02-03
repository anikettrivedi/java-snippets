package coding.leetcode150._01_arrays_and_strings;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class _01_MergeSortedArrays_Test {

    @Test
    public void test_Merge(){
        int[] nums1 = {1,3,5,7,0,0,0};
        int m = 4;
        int[] nums2 = {2,4,6};
        int n = 3;
        int[] expected = {1,2,3,4,5,6,7};

        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));

        _01_MergeSortedArrays target = new _01_MergeSortedArrays();
        target.merge(nums1, m, nums2, n);
        System.out.println("nums1 = " + Arrays.toString(nums1));
        assertEquals(Arrays.toString(nums1), Arrays.toString(expected));
    }

}

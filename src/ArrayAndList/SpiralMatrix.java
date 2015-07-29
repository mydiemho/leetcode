package ArrayAndList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myho on 7/27/15.
 *
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowCnt = matrix.length;

        if (rowCnt == 0) {
            return new ArrayList<>();
        }

        int colCnt = matrix[0].length;

        int leftLimit = 0;
        int rightLimit = colCnt - 1;
        int topLimit = 0;
        int botLimit = rowCnt - 1;

        int elementCnt = rowCnt * colCnt;
        int cnt = 0;

        int r = 0;
        int c = 0;

        List<Integer> vals = new ArrayList<>();

        while (true) {

            // keep going right
            while (r == topLimit && c <= rightLimit) {
                int val = matrix[r][c++];
                vals.add(val);
                cnt++;

                if (cnt == elementCnt) {
                    return vals;
                }
            }

            // over count when getting out of loop
            c--;
            r++;
            topLimit++;

            while (c == rightLimit && r <= botLimit) {
                // keep going down
                int val = matrix[r++][c];
                vals.add(val);
                cnt++;

                if (cnt == elementCnt) {
                    return vals;
                }
            }

            r--;
            c--;
            rightLimit--;

            while (r == botLimit && c >= leftLimit) {
                // keep going left
                int val = matrix[r][c--];
                vals.add(val);
                cnt++;

                if (cnt == elementCnt) {
                    return vals;
                }
            }

            c++;
            r--;
            botLimit--;

            // keep going up
            while (c == leftLimit && r >= topLimit) {
                int val = matrix[r--][c];
                vals.add(val);
                cnt++;

                if (cnt == elementCnt) {
                    return vals;
                }
            }

            r++;
            c++;
            leftLimit++;
        }
    }

}

package ArrayAndList;

/**
 * Created by myho on 7/6/15.
 */

/*
 * https://leetcode.com/problems/gas-station/
 */
public class GasStation {

    /*
     * start from station 0 and move forward.
     * If I encounter a station that I can not reach(result < 0),
     *   look backward to find the station from which I can make the unreachable station reachable.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int stationCount = gas.length;

        int gasNeeded = 0;  // gas needed to travel from current station to next
        int gasInTank = 0; // amt of gas left in tank
        int start = 0;      // starting station

        for (int i = 0; i < stationCount; i++) {

            // whatever was leftover from the previous station and what I can get
            // from this station
            gasInTank += (gas[i] - cost[i]);


            gasNeeded += (gas[i] - cost[i]);

            // the amt of gas left after traveling from station i to i+1
            if (gasInTank < 0) {

                // there's no way to start from this station
                gasInTank = 0;

                // gotta try the next station as starting point
                start = i + 1;
            }
        }

        return (gasNeeded < 0 ? -1 : start);
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {

        int totalDist = 0;
        for(int val : cost) {
            totalDist += val;
        }

        int stationCount = gas.length;

        int gasNeeded = 0;  // gas needed to travel from current station to next
        int gasInTank = 0; // amt of gas left in tank
        int start = 0;      // starting station

        for (int i = 0; i < stationCount; i++) {

            // whatever was leftover from the previous station and what I can get
            // from this station
            gasInTank = gasInTank + gas[i];

            gasNeeded += cost[i];

            // the amt of gas needed to travel from station i to i+1
            if (gasInTank < cost[i]) {

                // there's no way to start from this station
                gasInTank = 0;

                // gotta try the next station as starting point
                start = i + 1;
            }
        }

        return (gasNeeded > totalDist ? -1 : start);
    }
}

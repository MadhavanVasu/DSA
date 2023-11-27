package LeetCode.Medium;

import java.util.PriorityQueue;

public class SeatReservationManager {

    class SeatManager {

        PriorityQueue<Integer> availableSeats = new PriorityQueue<>();
        int n;

        public SeatManager(int n) {
            this.n = n;
            for (int i = 1; i <= n; i++)
                availableSeats.add(i);
        }

        public int reserve() {
            return availableSeats.poll();
        }

        public void unreserve(int seatNumber) {
            availableSeats.add(seatNumber);
        }
    }

    public static void main(String[] args) {

    }

}

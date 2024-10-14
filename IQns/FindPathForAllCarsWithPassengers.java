package IQns;

import java.util.HashMap;
import java.util.Map;

public class FindPathForAllCarsWithPassengers {

    public class Neighbor {
        public String node;
        public int dist;

        public Neighbor(String node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public class MinValCar {
        public String car;
        public int val;

        public MinValCar(String car, int val) {
            this.car = car;
            this.val = val;
        }
    }

    public void findPath(String[][] roads, String[] starts, String[][] people) {

        Map<String, Neighbor> neighborMap = new HashMap<>();
        for (String[] road : roads) {
            neighborMap.put(road[0], new Neighbor(road[1], Integer.parseInt(road[2])));
        }
        Map<String, String> peopleMap = new HashMap<>();
        for (String[] p : people) {
            peopleMap.put(p[1], p[0]);
        }
        Map<String, MinValCar> minValMap = new HashMap<>();
        int car = 1;
        for (String start : starts) {
            String next = start;
            int totalDist = 0;
            while (true) {
                if (!minValMap.containsKey(next) || minValMap.get(next).val > totalDist) {
                    minValMap.put(next, new MinValCar("Car" + car, totalDist));
                }
                if (!neighborMap.containsKey(next)) break;
                else {
                    totalDist += neighborMap.get(next).dist;
                    next = neighborMap.get(next).node;
                }
            }
            car++;
        }
        car = 1;
        for (String start : starts) {
            String next = start;
            StringBuilder sb = new StringBuilder();
            sb.append("Car").append(car).append(" -> ");
            while (true) {
                sb.append(next);
                if (minValMap.get(next).car.equals("Car" + car)) {
                    sb.append("(").append(peopleMap.get(next)).append(")");
                }
                if (!neighborMap.containsKey(next)) break;
                else {
                    next = neighborMap.get(next).node;
                    sb.append(" ");
                }
            }
            System.out.println(sb);
            car++;
        }
    }

    public static void main(String[] args) {
        String[][] roads = {{"A", "B", "0"}, {"B", "C", "35"},
                {"C", "D", "15"}, {"E", "D", "5"}, {"D", "F", "10"}};

        String[] starts = {"A", "E"};

        String[][] people = {{"Jake", "A"}, {"Steve", "B"}, {"John", "C"},
                {"George", "D"}, {"Brooke", "E"}, {"Holt", "F"}};

        new FindPathForAllCarsWithPassengers().findPath(roads, starts, people);
    }
}

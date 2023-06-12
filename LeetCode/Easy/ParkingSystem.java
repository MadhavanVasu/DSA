package LeetCode.Easy;

public class ParkingSystem {

    static int big, medium, small;

    public ParkingSystem(int big, int medium, int small) {
        ParkingSystem.big = big;
        ParkingSystem.medium = medium;
        ParkingSystem.small = small;
    }

    public boolean addCar(int carType) {

        switch (carType) {
            case 1:
                if (big != 0) {
                    big--;
                    return true;
                }
                return false;
            case 2:
                if (medium != 0) {
                    medium--;
                    return true;
                }
                return false;
            case 3:
                if (small != 0) {
                    small--;
                    return true;
                }
                return false;
            default:
                return false;
        }
    }
}

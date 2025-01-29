package IQns;

import java.util.Arrays;

public class LoadBalancingToServers {


    public int[] findRequestServerId(int num_servers, int n, int[] requests) {
        int[] serverUtilization = new int[num_servers];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = requests[i];
            int server = 0;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (serverUtilization[mid] > serverUtilization[end]) start = mid + 1;
                else if (mid - 1 >= 0 && serverUtilization[mid] == serverUtilization[mid - 1]) end = mid - 1;
                else {
                    server = mid;
                    break;
                }
            }
            result[i] = server;
            serverUtilization[server]++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] request1 = new int[]{3, 2, 3, 2, 4};
        int num_servers1 = 5;
        int n1 = 5;

        int[] request2 = new int[]{4, 0, 1};
        int num_servers2 = 6;
        int n2 = 3;

        System.out.println(Arrays.toString(new LoadBalancingToServers().findRequestServerId(num_servers1, n1, request1)));
        System.out.println(Arrays.toString(new LoadBalancingToServers().findRequestServerId(num_servers2, n2, request2)));
    }

}

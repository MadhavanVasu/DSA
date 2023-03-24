package Gfg.Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NMeetingInRoom {

    public static class Meeting {
        public int start;
        public int end;
        public int pos;

        public Meeting(int start, int end, int pos)
        {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    public static class MeetingComparator implements Comparator<Meeting>
    {

        @Override
        public int compare(Meeting o1, Meeting o2) {
            if(o1.end<o2.end)
                return -1;
            else if(o1.end>o2.end)
                return 1;
            else if(o1.pos < o2.pos)
                return -1;
            return 1;
        }
    }

    public static int maxMeetings(int start[], int end[], int n)
    {
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            Meeting meeting = new Meeting(start[i], end[i], i);
            meetings.add(meeting);
        }
        Comparator<Meeting> comparator = new MeetingComparator();
        Collections.sort(meetings, comparator);
        int count = 1;
        int endTime = meetings.get(0).end;
        for(int i = 1; i<n; i++)
        {
            if(meetings.get(i).start>endTime){
                count++;
                endTime = meetings.get(i).end;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int n = 6;
        int[] start = {1,3,0,5,8,5};
        int[] end =  {2,4,6,7,9,9};
        System.out.println(maxMeetings(start, end, n));

    }

}

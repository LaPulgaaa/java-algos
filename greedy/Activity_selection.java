package greedy;

import java.util.Arrays;

public class Activity_selection {

    class Job implements Comparable<Job>
    {
        int start;
        int end;
        Job(int s,int e)
        {
            start=s;
            end=e;
        }
        public int compareTo(Job j)
        {
            return this.end-j.end;
        }
    }
    public  int activitySelection(int start[], int end[], int n)
    {
        
        Job jobs[]=new Job[n];
        for(int i=0;i<n;i++)
        {
            jobs[i]=new Job(start[i],end[i]);
        }
        Arrays.sort(jobs);
        
        int ans=1;
        int end_time=jobs[0].end;
        
        for(int i=1;i<n;i++)
        {
            if(jobs[i].start>end_time)
            {
                ans++;
                end_time=jobs[i].end;
            }
        }
        
        return ans;
    
    }
    
}

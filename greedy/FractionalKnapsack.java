package greedy;


//drivers code
import java.io.*;
// 
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new FractionalKnapsack().fractionalKnapsack(w, arr, n)));
        }
    }
}
public class FractionalKnapsack {
    class Compare implements Comparator<Item>
    {
        public int compare(Item i,Item j){
            return j.value*i.weight-j.weight*i.value;
        }
        
        
    }
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr,new Compare());
        double value=0.00;
        for(int i=0;i<n;i++)
        {
            if(arr[i].weight<=W)
            {
                value=value+arr[i].value;
                W=W-arr[i].weight;
            }
            else if(arr[i].weight>W)
            {
                
                value+=(double)(arr[i].value*W)/arr[i].weight;
                return (value);
            }
            // System.out.println(W);
        }
        return (value);
        
    }
}

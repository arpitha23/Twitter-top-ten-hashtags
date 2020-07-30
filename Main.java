
import java.util.*;

public class Main {
    static class DescOrder implements Comparator<Integer> {
    	@Override
    	public int compare(Integer o1, Integer o2) {	    
    	    return o1 - o2;
    	}
    }
    
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<String> al=new ArrayList<String>();
        for(int i=0;i<=n;i++)
            al.add(sc.nextLine());
        TreeMap<String,Integer> treeMap = new TreeMap<String,Integer>();
        for(int i=1;i<=n;i++){
            String arr[]=al.get(i).split(" ");
            for(int j=0;j<arr.length;j++)
            {
                if(arr[j].contains("#")){
                    int c = 1;
                    if(treeMap.containsKey(arr[j])){
                        c = treeMap.get(arr[j]);
                        c += 1;
                    }
                    treeMap.put(arr[j], c);
                }
            }
        }
        TreeMap<String,Integer> treeMapSorted = new TreeMap<String,Integer>(new Comparator<String>()
        {
            public int compare(String o1, String o2)
            {
                int i1 = treeMap.get(o1), i2 = treeMap.get(o2);
                return i1 > i2 ? -1 : 1;
            }
        });
        treeMapSorted.putAll(treeMap);
        int count=treeMapSorted.size()>10?10:treeMapSorted.size(), i = 0;
        System.out.println(count);
        for (String key : treeMapSorted.keySet()) {
            System.out.println(key + ": " + treeMap.get(key));
        }
    }
}

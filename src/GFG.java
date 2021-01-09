// A Java program to find maximal
// Bipartite matching.
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG extends MainMatch
{
    // M is number of applicants
    // and N is number of jobs
    static final int M = 3;
    static final int N = 3;

    // A DFS based recursive function that
    // returns true if a matching for
    // vertex u is possible
    boolean bpm(boolean bpGraph[][], int u,
                boolean seen[], int matchR[])
    {
        // Try every job one by one
        for (int v = 0; v < N; v++)
        {
            // If volenteer u is able to accept call
            // in call v and v is not matched
            if (bpGraph[u][v] && !seen[v])
            {

                // Mark v as visited
                seen[v] = true;

                // If call 'v' is not assigned to
                // an volenteer OR previously
                // assigned volenteer for elder v (which
                // is matchR[v]) has an alternate job available.
                // Since v is marked as visited in the
                // above line, matchR[v] in the following
                // recursive call will not get call 'v' again
                if (matchR[v] < 0 || bpm(bpGraph, matchR[v],
                        seen, matchR))
                {
                    matchR[v] = u;
                   // System.out.println(u +" : vol index can be  matched ");
                    return true;
                }
            }
        }
        System.out.println("index of vol that cannot be matched: " + u);
        return false;
    }

    // Returns maximum number
    // of matching from M to N
    int maxBPM(boolean bpGraph[][])
    {
        // An array to keep track of the
        // applicants assigned to jobs.
        // The value of matchR[i] is the
        // applicant number assigned to job i,
        // the value -1 indicates nobody is assigned.
        int matchR[] = new int[N];

        // Initially all calls are available
        for(int i = 0; i < N; ++i)
            matchR[i] = -1;

        // Count of jobs assigned to applicants
        int result = 0;
        for (int u = 0; u < M; u++)
        {
            // Mark all calls as not seen
            // for next volenteer.
            boolean seen[] =new boolean[N] ;
            for(int i = 0; i < N; ++i)
                seen[i] = false;

            // Find if the volenteer 'u' can get a match
            if (bpm(bpGraph, u, seen, matchR)) {
                System.out.println(u+": index of vol matched");
                result++;
            }
        }
        for(int i = 0; i < N; ++i)//array that holds
            System.out.println(i+" is the index of elder that matche to vol in "+matchR[i]+ " place");
        return result;
    }

    // Driver Code
    public static void main (String[] args)
            throws java.lang.Exception
    {
        Scanner inputScan = new Scanner(System.in);

        final int MAXSIZE=3;
        int nextList=0;
        int elderNextList=0;



        Elder davidKadosh = new Elder("David Kadosh","0529999999",
                true,false,"Havatzelet 3 ,apt 24");

        Elder haimForever = new Elder("Haim forever","0522222222",
                true,false,"hapina 34 floor 5 apt 46");
        Elder sabaZaken = new Elder("saba","012021021",
                true,false,"nahal oz ooo11");
        davidKadosh.setHelp();//tech
        haimForever.setHelp();//house repair
        sabaZaken.setHelp();//general  request



        Volenteer nik = new Volenteer("Nik sou","058798213",
                false,true,true);
        Volenteer lironSun = new Volenteer("Liron Shemesh","0587999999",
                false,false,true);
        Volenteer yosi = new Volenteer("yosi yosi","2131123132",
                false,true,false);



//
        Elder [] elderList = new Elder[MAXSIZE];//array of elder objects
        Volenteer [] volList = new Volenteer[MAXSIZE];//array of volenteer objects

        elderList[0]=haimForever;
        elderList[1]=davidKadosh;
        elderList[2]=sabaZaken;

        volList[1]=lironSun;
        volList[0]=nik;
        volList[2]=yosi;



       // boolean [][] twoDBool = twoDBoolean(volList,elderList);

        //System.out.println(Arrays.deepToString(twoDBool));
        // Let us create a bpGraph shown
        // in the above example
        boolean bpGraph[][] = twoDBoolean(volList,elderList);
        System.out.println(Arrays.deepToString(bpGraph));
        GFG m = new GFG();
        System.out.println( "Maximum number of applicants that can"+
                " get job is "+m.maxBPM(bpGraph));


    }
}

import java.lang.*;
import java.util.*;

public class Tennis {


    public static  void  setsScore(String gamesinput,int scores[],int offset,int condition[]){

        String gamesoutput="";
        if(offset==8){
            return ;
        }
        for(int x=0;x<gamesinput.length();x++){
          // display_score(scores);
            scores[offset+gamesinput.charAt(x)-'A']++;
          for(int i=0;i<scores.length;i++)
            if((scores[offset+ gamesinput.charAt(x)-'A']>=condition[offset/2])&&(Math.abs(scores[offset]-scores[offset+1])>=2)){
                if(scores[offset]>scores[offset+1]){
                    gamesoutput=gamesoutput+"A";
                }else{
                    gamesoutput=gamesoutput+"B";
                }
                scores[offset]=0;
                scores[offset+1]=0;
            }
        }


        setsScore(gamesoutput,scores,offset+2,condition) ;
    }

    public static void  display_score(int a[])
    {

        System.out.println("Player:    A     B");
        System.out.println("Sets:      "+a[4]+"     "+a[5]);
        System.out.println("Games:     "+a[2]+"     "+a[3]);
        if(a[0]>=3 && a[1]>=3)
        {
            if(a[0]>a[1])
            {
                System.out.println("Points:    40    A");
            }
            else if(a[0]<a[1])
            {
                System.out.println("Points:    A     40");
            }
            else
            {
                System.out.println("Points:    40    40");
            }
        }
        else
        {
            String map[]={"0","15","30","40"};
            System.out.println("Points:    "+map[a[0]]+"    "+map[a[1]]);


        }
        System.out.println();

    }


    public static void main(String args[]){
        int []conditions={4,6,10};
        int []scores={0,0,0,0,0,0};
        Scanner scanner = new Scanner(System.in);
        String input=scanner.nextLine();
        setsScore(input,scores,0,conditions);
        display_score(scores);

    }
}
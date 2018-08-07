import java.util.Scanner;

public class Game {

    int pA,pB,gA,gB,sA,sB;
    int tA,tB;
    String input;


    public Game(String input) {
        this.input = input;
        this.pA = this.pB = this.gA = this.gB = this.sA = this.sB = this.tA = this.tB = 0;

    }


    public void updatePoints() {

        for (int i = 0; i < input.length(); i++) {
            if(!(this.gA==6 && this.gB ==6))
            {if (input.charAt(i) == 'A')
                this.pA++;
            else this.pB++;
            this.gamestatusCheck();}

            else
            {
                this.handleTieBreak(i);
            }

        }
    }

    public void handleTieBreak(int i)
    {
        this.pA = 0;
        this.pB = 0;
        if (input.charAt(i) == 'A')
            this.tA++;
        else
            this.tB++;



        if (this.tA >= 7 && this.tA - this.tB >= 2) {
            this.tA = 0;
            this.tB = 0;
            this.gA=0;
            this.gB=0;
            this.sA++;
        }
        else if(this.tB >= 7 && this.tB - this.tA >= 2) {
            this.tA = 0;
            this.tB = 0;
            this.gA=0;
            this.gB=0;
            this.sB++;
        }
        else if(i==input.length()-1)
        {
            System.out.println("Tie Break:  "+this.tA+"   "+this.tB);
        }
    }
    public void gamestatusCheck () {
        if (this.pA >= 4 && this.pA - this.pB >= 2) {
            this.pA = 0;
            this.pB = 0;
            this.gA++;
            this.setstatusCheck();
        }
        else if(this.pB >= 4 && this.pB - this.pA >= 2) {
            this.pA = 0;
            this.pB = 0;
            this.gB++;
            this.setstatusCheck();
        }
    }

        public void setstatusCheck() {


                if (this.gA >= 6 && this.gA - this.gB >= 2) {
                    this.gA = 0;
                    this.gB = 0;
                    this.sA++;
                } else if (this.gB >= 6 && this.gB - this.gA >= 2) {
                    this.gA = 0;
                    this.gB = 0;
                    this.sB++;
                }


        }

    public void printScore() {
        System.out.println("Player:\t\tA\tB");
        System.out.println("Sets:\t\t" + this.sA + "\t" + this.sB);
        System.out.println("Games:\t\t" + this.gA + "\t" + this.gB);
        int points[] = {0, 15, 30, 40};
        System.out.print("Points:\t\t");

        if(this.pA >= 3 && this.pB >= 3) {
            if(this.pA == this.pB)
                System.out.println("40\t40");
            else if(this.pA > this.pB)
                System.out.println("A\t40");
            else
                System.out.println("40\tA");
        }
        else
            System.out.println(points[this.pA] + "\t" + points[this.pB]);
    }




    public static void main(String args[]) {
        System.out.println("Enter the games: ");
        Scanner in= new Scanner(System.in);
        String input = in.next();
        Game tennis = new Game(input);
        tennis.updatePoints();
        tennis.printScore();
    }
}
package studio2;
import java.lang.Math;
import java.util.Scanner;
public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int countWin = 0;
		int countLose = 0;
		System.out.println("What's your starting amount?");
		int startAmount = in.nextInt();
		System.out.println("What's the likelihood you'll win as a decimal between 0 and 1?");
		double winChance = in.nextFloat();
		System.out.println("What's your win limit?");
		int winLimit = in.nextInt();
		System.out.println("How many days do you want to play?");
		int totalSimulations = in.nextInt();
		int dayNumber = 1;
		int currentAmount = startAmount;
		for(; totalSimulations>0; totalSimulations--)
		{
			int playCount = 0;
			currentAmount = startAmount;
			while (0<currentAmount && currentAmount<winLimit)
			{
				//System.out.println("You have $" + currentAmount + " left.");
				double Run = Math.random();
				if (winChance>Run)
					{
					currentAmount = currentAmount + 1;
					playCount = playCount + 1;
					//System.out.println("You Win!");
					}
				else
				{
					currentAmount = currentAmount-1;
					playCount = playCount + 1;
					//System.out.println("You Lose!");
				}
			}
			if (currentAmount == winLimit)
			{
				countWin = countWin+1;
				//System.out.println("You feel satisfied with $" +currentAmount+" and go home.");
				System.out.println("Day " + dayNumber + ": You reached your win limit in " + playCount + " plays!");
				dayNumber = dayNumber + 1;
			}
			else if (currentAmount == 0)
			{
				countLose = countLose+1;
				//System.out.println("You are broke and thrown out of the casino.");ffffff
				System.out.println("Day " + dayNumber + ": You lost all your money in " + playCount + " plays!");
				dayNumber = dayNumber + 1;
			}
		}
		double winPercentage = ((double)(countWin)/(double)(countWin + countLose));
		System.out.println("You won " + (winPercentage * 100) + "% of the time!");
		double alpha = (1-winChance) / winChance;
		if (winChance == 0.5)
		{
			double expectedRuin = (1- ((double)startAmount / (double)winLimit));
			System.out.println("The expected rate of ruin is " + (expectedRuin * 100) + "%.");
		}
		else
		{
			double expectedRuin = ((Math.pow(alpha, startAmount)) - (Math.pow(alpha, winLimit))) / (1 - Math.pow(alpha, winLimit));
			System.out.println("The expected rate of ruin is " + (expectedRuin * 100) + "%.");
		}
	}
}
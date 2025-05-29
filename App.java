import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;
import java.lang.Math;

public class App {
    private static Random rand = new Random();

    public static void main(String[] args) throws Exception {
        System.out.println("What would you like to name your pet?");
        Scanner input = new Scanner(System.in);

        int game = 9;

        String petName = input.nextLine();
        Pet pet = new Pet(petName);

        System.out.println(pet.getName() + " says hello!");

        System.out.println("Let's play a game!");

        while (game != 0) {
            System.out.println("""
                    What would you like to play? If you'd like to be done, press 0.
                    1. fetch the ball!
                    2. guess my age!
                    3.
                            """);
            try {
                String inputString = input.nextLine();
                game = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                input.next(); 
            }
            if (game == 1) {
                int waitTime = rand.nextInt(5000 - 1000 + 1) + 1000;
                while (waitTime > 0) {
                    System.out.println("waiting...");
                    Thread.sleep(1000);
                    waitTime -= 1000;
                }
                System.out.println(pet.getName() + " has returned with the ball!");
            }
            if (game == 2) {
                int age = rand.nextInt(20 - 1 + 1) + 1;
                System.out.println("Guess my age! (between 1 and 20) You get 5 tries.");
                int tries = 5;
                while (tries > 0) {
                    int guess = input.nextInt();
                    if (guess == age) {
                        System.out.println("You guessed it! " + pet.getName() + " is " + age + " years old!");
                        break;
                    } else if (guess < age) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                    tries--;
                }
                if (tries == 0) {
                    System.out.println(
                            "Sorry, you ran out of tries! Play another game and then come back to try again :)");
                }
            }

        }
        input.close();
        example();

        System.out.println("Thanks for playing with " + pet.getName() + "! See you next time :)");
    }

    private static void example() {
        return;
    }

}

import java.util.*;

public class App {
    private static Random rand = new Random();

    public static void main(String[] args) throws Exception {
        System.out.print("Let's start personalizing your virtual pet! What would you like to name them? ");
        Scanner input = new Scanner(System.in);

        int game = 9;

        String petName = input.nextLine();
        Pet pet = new Pet(petName);

        System.out.println("\n" + pet.getName() + " says hello!");
        System.out.println("  .\r\n" + //
                        " ..^____/\r\n" + //
                        "`-. ___ )---|\r\n" + //
                        "  ||  ||");

        int fetchSkill = 50;
        while (game != 0) {
            Thread.sleep(1000);
            System.out.print("\n" + pet.getName()
                    + " is feeling bored and wants to play a game. What would you like to play with " + pet.getName() +
                    "? If you'd like to be done, press 0.\n\n" +
                    "1. play fetch with " + pet.getName() + "!\n" +
                    "2. guess " + pet.getName() + "'s age!\n" +
                    "3. feed " + pet.getName() + "! ");
            String inputString = input.nextLine();
            try {
                game = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
            if (game == 1) {
                System.out.println("  .\r\n" + //
                                    " ..^____/\r\n" + //
                                    "`-. ___ )---|      whoosh\r\n" + //
                                    "\\\\ \\\\       ");
                System.out.println("\nwaiting for " + pet.getName() + " to return...\n");
                int waitTime = rand.nextInt(5000 - 1000 + 1) + 1000;
                while (waitTime > 0) {
                    Thread.sleep(1000);
                    waitTime -= 1000;
                }
                if (rand.nextInt(100) < fetchSkill) {
                    System.out.println(pet.getName() + " has come back with the ball!");
                    Thread.sleep(1000);
                    System.out.println("\n" + pet.getName()
                            + " is so happy to play fetch with you! You both had a great time.");
                    Thread.sleep(1000);
                    fetchSkill += 5;
                } else {
                    System.out.print(pet.getName()
                            + " got distracted and ran off chasing a squirrel! Maybe some more training will help. Do you want to go run after "
                            + pet.getName() + ", or let them have some fun? (yes/no) ");
                    while (true) {
                        String response = input.nextLine().trim().toLowerCase();
                        if (response.equals("yes") || response.equals("no")) {
                            if (response.equals("yes")) {
                                System.out.println(
                                        "\nYou ran after " + pet.getName() + " and caught up! You both return home safely.");
                            } else if (response.equals("no")) {
                                System.out.println(
                                        "\nYou decided to let " + pet.getName() + " go play. You wait for a while and then "
                                                + pet.getName() + " returns on their own." + "\n");
                            }
                            break;
                        }
                        System.out.print("\nInvalid response. Please answer with 'yes' or 'no'. ");
                    }
                    }
                    }
            if (game == 2) {
                int age = rand.nextInt(20 - 1 + 1) + 1;
                System.out.println("Guess my age! (between 1 and 20) You get 5 tries.\n");
                int tries = 5;
                while (tries > 0) {
                    System.out.print("Enter your guess: ");
                    if (input.hasNextInt()) {
                        int guess = input.nextInt();
                        input.nextLine(); // Clear the newline after nextInt
                        if (guess == age) {
                            System.out.println("You guessed it! " + pet.getName() + " is " + age + " years old!");
                            break;
                        } else if (guess < age) {
                            System.out.println("Too low! Try again.\n");
                        } else {
                            System.out.println("Too high! Try again.\n");
                        }
                        tries--;
                    } else {
                        System.out.println("Please enter a valid number.\n");
                        input.nextLine();
                    }
                }
                if (tries == 0) {
                    System.out.println(
                            "Sorry, you ran out of tries! Play another game and then come back to try again :)");
                }
            }
            if (game == 3) {
                System.out.println("\nGood idea! " + pet.getName() + " is getting hungry. No wonder they're already waiting for you at their food bowl!");
                System.out.println(" ,    /-.\r\n" + //
                                        "((___/ __>\r\n" + //
                                        "/      }\r\n" + //
                                        "\\ .--.(    ___\r\n" + //
                                        "\\\\   \\\\   /___\\");
                Thread.sleep(2000);
                System.out.println("\n" + "However, " + pet.getName() +
                        " is a picky eater and will only eat their food in a certain order.");
                Thread.sleep(2000);
                System.out.println();
                System.out.println(pet.getName()
                        + " will tell you what they want, but it will only show up on screen for a few seconds before disappearing, so pay close attention!");
                Thread.sleep(3000);
                System.out.println("\n" + "See if you can remember what "
                        + pet.getName() + " asked for in the right order before it's too late!" + "\n");
                Thread.sleep(3000);
                System.out.println("Ready...");
                Thread.sleep(1000);
                System.out.println("Set...");
                Thread.sleep(1000);
                System.out.println("Go!" + "\n");
                String[] choices = { "meat", "cheese", "veggies", "fruit", "spinach", "rice", "treats" };
                int level = 1;

                boolean playing = true;

                while (playing) {
                    String[] pattern = new String[level];
                    for (int i = 0; i < level; i++) {
                        pattern[i] = choices[rand.nextInt(choices.length)];
                    }

                    System.out.print("Pattern: ");
                    for (String s : pattern) {
                        System.out.print(s + " ");
                    }

                    Thread.sleep(1000 * level);

                    System.out.print("\rNow it's your turn! Enter the pattern: ");
                    String userInput = input.nextLine();
                    String[] userPattern = userInput.split("\\s+");

                    if (userPattern.length != pattern.length) {
                        System.out.println("Not enough food entered! Game over.");
                        playing = false;
                    } else {
                        boolean correct = true;
                        for (int i = 0; i < pattern.length; i++) {
                            if (!userPattern[i].equals(pattern[i])) {
                                correct = false;
                                System.out.println("Incorrect food at position " + (i + 1) + "!");
                                break;
                            }
                        }

                        if (correct) {
                            System.out.println("Correct! Moving to level " + (level + 1) + "\n");
                            level++;
                        } else {
                            System.out.println(pet.getName() + " asked for " + Arrays.toString(pattern) +
                                    ". Game over.");
                            playing = false;
                        }
                    }
                }

                System.out.println("\n" + "Your highest score is " + level + ". Great job!" + "\n");
            }

        }
        game = 9;
        input.close();
        System.out.println("Thanks for playing with " + pet.getName() + "! See you next time :)");
    }
}
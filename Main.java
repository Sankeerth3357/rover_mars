import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for grid size
        System.out.print("Enter grid size (format: X Y): ");
        int gridSizeX = scanner.nextInt();
        int gridSizeY = scanner.nextInt();

        // Input for starting position and direction
        System.out.print("Enter starting position (format: X Y Direction): ");
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        char startDirection = scanner.next().charAt(0);

        // Input for commands
        System.out.print("Enter commands (e.g., 'MMLR'): ");
        String commandInput = scanner.next();

        List<Character> commandChars = new ArrayList<>();
        for (char commandChar : commandInput.toCharArray()) {
            commandChars.add(commandChar);
        }

        // Create grid, rover, and control center
        Grid grid = new Grid(gridSizeX, gridSizeY);
        Rover rover = new Rover(startX, startY, startDirection);
        MarsRoverControlCenter controlCenter = new MarsRoverControlCenter(rover, grid);

        // Convert command characters to Command objects
        List<Command> commands = new ArrayList<>();
        for (char commandChar : commandChars) {
            switch (commandChar) {
                case 'M':
                    commands.add(new MoveForward());
                    break;
                case 'L':
                    commands.add(new TurnLeft());
                    break;
                case 'R':
                    commands.add(new TurnRight());
                    break;
                default:
                    System.out.println("Invalid command: " + commandChar);
            }
        }

        // Input for obstacles
        System.out.print("Enter number of obstacles: ");
        int numObstacles = scanner.nextInt();
        System.out.println("Enter obstacle positions (format: X Y):");
        for (int i = 0; i < numObstacles; i++) {
            int obstacleX = scanner.nextInt();
            int obstacleY = scanner.nextInt();
            grid.addObstacle(obstacleX, obstacleY);
        }

        // Execute commands
        controlCenter.executeCommands(commands);

        // Print final position and status report
        System.out.println("Final Position: " + rover.getPosition());
        if (controlCenter.isObstacleInFront()) {
            System.out.println("Status Report: Rover is blocked by an obstacle.");
        } else {
            System.out.println("Status Report: Rover is at " + rover.getPosition() + ". No Obstacles detected.");
        }

        // Close the scanner
        scanner.close();
    }
}


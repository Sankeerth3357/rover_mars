import java.util.List;

class MarsRoverControlCenter {
    private Rover rover;
    private Grid grid;

    public MarsRoverControlCenter(Rover rover, Grid grid) {
        this.rover = rover;
        this.grid = grid;
    }

    public void executeCommands(List<Command> commands) {
        for (Command command : commands) {
            if (!isObstacleInFront()) {
                command.execute(rover);
            }
        }
    }

    public boolean isObstacleInFront() {
        int x = rover.getX();
        int y = rover.getY();
        switch (rover.getDirection()) {
            case 'N':
                y++;
                break;
            case 'S':
                y--;
                break;
            case 'E':
                x++;
                break;
            case 'W':
                x--;
                break;
        }
        return grid.hasObstacle(x, y);
    }
}

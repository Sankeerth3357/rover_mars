class MoveForward implements Command {
    @Override
    public void execute(Rover rover) {
        rover.move();
    }
}
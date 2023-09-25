class Grid {
    private int width;
    private int height;
    private boolean[][] obstacles;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new boolean[width][height];
    }

    public void addObstacle(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            obstacles[x][y] = true;
        }
    }

    public boolean hasObstacle(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height && obstacles[x][y];
    }
}
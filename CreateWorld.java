package byow.Core;

import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;
import org.junit.jupiter.api.MethodOrderer;

import java.util.Random;

public class World {
    private TETile[][] tiles;

    private int width;
    private int height;
    private Random random;
    private int ranSeed;

    public World(int width, int height, int seed) {
        tiles = new TETile[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = Tileset.NOTHING;
            }
        }
        //Generates a new random object given a seed
        Random random = new Random(seed);
        ranSeed = seed;
    }

    public TETile[][] accessGrid() {
        return tiles;
    }

    private void makeRoom(TETile[][] world) {
        // Sets min and max bounds for how big/small the rooms can be
        double upper = 0.30;
        double lower = 0.10;

        int upperWidth = (int) (upper * width);
        int lowerWidth = (int) (lower * width);

        int upperHeight = (int) (upper * height);
        int lowerHeight = (int) (lower * height);

        // Creates room width and height
        int roomWidth = random.nextInt(upperWidth);
        int roomHeight = random.nextInt(upperHeight);

        if (roomWidth < lowerWidth) {
            roomWidth = lowerWidth;
        }
        if (roomHeight < lowerHeight) {
            roomHeight = lowerHeight;
        }

        //Width and height starting point for the room
        int widthStartingPoint = random.nextInt(width);
        int heightStartingPoint = random.nextInt(height);

        //Generate floor plan
        for (int x = widthStartingPoint; x < widthStartingPoint + roomWidth; x++) {
            for (int y = heightStartingPoint; y < heightStartingPoint + roomHeight; y++) {
                tiles[x][y] = Tileset.FLOOR;
            }
        }
    }


    private void connectRooms(int x1, int y1, int x2, int y2) {

        int xdist = Math.abs(x2 - x1);
        int ydist = Math.abs(y2 - y1);

        if(x1 < x2 && y1 < y2){
            for(int x = x1; x < x + xdist; x++){
                for(int y = y1; y < y + ydist; y++){
                    tiles[x][y] = Tileset.FLOOR;
                }
            }
        }

        else-if (x2 < x1 && y2 < y1){
            for(int x = x2; x < x + xdist; x++){
                for(int y = y2; y < y + ydist; y++){
                    tiles[x][y] = Tileset.FLOOR;
                }
            }
        }











    }



}


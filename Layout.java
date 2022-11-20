package byow.Core;
import byow.TileEngine.TERenderer;
import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Layout {
    public HashMap<Position, TETile> checkTile;
    public HashMap<Position, Tileset> insideSet;
    public WeightedQuickUnionUF wall;
    public WeightedQuickUnionUF floor;


    public static class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Position shift(int dx, int dy) {
            return new Position(this.x + dx, this.y + dy);
        }
    }
    public void addRoom(TETile[][] tiles, int w, int l, Position p) {
        for (int x = 0; x < w; x++) {
            tiles[x][p.y] = Tileset.FLOOR;
            checkTile.put(p, Tileset.FLOOR);
            floor.union(x, p.y);
        }
        for (int y = 0; y < l; y++) {
            tiles[p.x][y] = Tileset.FLOOR;
        }
    }
//    public void create(TETile[][] tiles, int w, int l, Position p) {
//        drawWorld(tiles, w, l, p);
//
//    }
//    /** Draw a column of length L at position P with tile WALL on board TILES */
//    public void drawWallColumn(TETile[][] tiles, int l, Position p) {
//        for (int i = 0; i < l; i++) {
//            tiles[p.x][p.y + i] = Tileset.WALL;
//        }
//    }
//    /** Draw a column of length L at position P with tile FLOOR on board TILES */
//    public void drawFloorColumn(TETile[][] tiles, int l, Position p) {
//        for (int i = 0; i < l; i++) {
//            tiles[p.x][p.y + i] = Tileset.FLOOR;
//        }
//    }
//    public void drawWallRow(TETile[][] tiles, int w, Position p) {
//        Position leftCorner = p.shift(-1, 0);
//        for (int i = 0; i < w + 2; i++) {
//            tiles[leftCorner.x][leftCorner.y + i] = Tileset.WALL;
//        }
//    }
//    public void drawHorizontalHallWay(TETile[][] tiles, int w, Position p) {
//        drawWallColumn(tiles, 1, p);
//        Position floor = p.shift(1, 0);
//        for (int i = 0; i < w; i++) {
//            drawFloorColumn(tiles, 1, floor);
//            floor = floor.shift(1, 0);
//        }
//        Position wall = floor;
//        drawWallColumn(tiles, 1, wall);
//    }
//    public void drawVerticalHallWay(TETile[][] tiles, int l, Position p) {
//        drawWallColumn(tiles, l, p);
//        Position floor = p.shift(1, 0);
//        drawFloorColumn(tiles, l, floor);
//        Position wall = floor.shift(1, 0);
//        drawWallColumn(tiles, l, wall);
//    }
//    /** Randomly add HORIZONTAL or VERTICAL HALLWAYS of length L or width W at position P. */
//    public void addHallway(TETile[][] tiles, int w, int l, Position p) {
//        Random r = new Random();
//
//        if (r.nextInt() % 2 == 0) {
//            drawHorizontalHallWay(tiles, w, p);
//        } else {
//            drawVerticalHallWay(tiles, l, p);
//        }
//    }
//    public void addRoom(TETile[][] tiles, int l, int w, Position p) {
//        drawWallColumn(tiles, l, p);
//        Position floor = p.shift(1, 0);
//        for (int i = 0; i < w; i++) {
//            drawFloorColumn(tiles, l, floor);
//            floor = floor.shift(1, 0);
//        }
//        Position wall = floor;
//        drawWallColumn(tiles, l, wall);
//    }
//    public void drawWorld(TETile[][] tiles, int w, int l, Position p) {
//        Random r = new Random();
//        int numTimes = r.nextInt(20);
//        int dx = r.nextInt(10);
//        int dy = r.nextInt(10);
//        int randomLength = r.nextInt(5);
//        int randomWidth = r.nextInt(5);
//
//        for (int i = 0; i < numTimes; i++) {
//            addHallway(tiles, w, l, p);
//            p = p.shift(dx, dy);
//            addRoom(tiles, randomLength, randomWidth, p);
//        }
//    }
}

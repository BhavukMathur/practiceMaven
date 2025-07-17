package target2024.systemDesign.snakeGame;

import java.util.LinkedList;

/**
 * Init length: 3, starts towards right
 * 5 moves --> longer by 1 unit
 * Moves: 4 directions
 * Game ends: Snake hits the wall or itself
 */
interface SnakeGame {
	void moveSnake(Direction snakeDirection);
	boolean isGameOver();
}

class Snake implements SnakeGame {
	int length;
	LinkedList<Point> snakePoints;
	int MAX_X = 20, MAX_Y = 20;
	static int moveCount = 0;

	Snake() {
		this.length = 3;
		this.snakePoints = new LinkedList<>();
		Point head = new Point(2, 0);
		Point h2 = new Point(1, 0);
		Point h3 = new Point(0, 0);
		snakePoints.add(head);
		snakePoints.add(h2);
		snakePoints.add(h3);
	}

	public void moveSnake(Direction snakeDirection) {
		moveCount++;
		Point head = snakePoints.getFirst();

		if(moveCount % 5 != 0) {
			snakePoints.removeLast();
		}
		Point newHead = null;
		switch (snakeDirection) {
			case RIGHT:
				newHead = new Point(head.x + 1, head.y);
				break;
			case LEFT:
				newHead = new Point(head.x - 1, head.y);
				break;
			case UP:
				newHead = new Point(head.x, head.y + 1);
				break;
			case DOWN:
				newHead = new Point(head.x, head.y - 1);
				break;
		}
		snakePoints.addFirst(newHead);
		System.out.print(snakePoints.getFirst().x + " " + snakePoints.getFirst().y + "--");
		System.out.println(snakePoints.getLast().x + " " + snakePoints.getLast().y);
	}

	public boolean isGameOver() {
		Point head = snakePoints.getFirst();

		//Grid Boundary
		if(head.x < 0 || head.x >= MAX_X || head.y < 0 || head.y >= MAX_Y) {
			return true;
		}

		//Snake hit itself
		for(int i=1; i<snakePoints.size(); i++) {
			if(compare(snakePoints.get(i), head)) {
				return true;
			}
		}
		return false;
	}

	private boolean compare(Point body, Point head) {
		if((body.x == head.x) && (body.y == head.y)) {
			return true;
		}
		return false;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

//class Grid {
//	int m, n;
//	Grid(int m, int n) {
//		this.m = m;
//		this.n = n;
//	}
//}

enum Direction {
	UP,
	DOWN,
	LEFT,
	RIGHT
}


public class SnakeGameDemo {
	public static void main(String[] args) {
//		Grid grid = new Grid(20, 20);
		SnakeGame sg = new Snake();

		//"RIGHT","RIGHT","RIGHT","UP","LEFT","LEFT","LEFT","LEFT","DOWN","RIGHT","UP"

		sg.moveSnake(Direction.RIGHT);
		sg.moveSnake(Direction.RIGHT);
//		sg.moveSnake(Direction.RIGHT);
//		sg.moveSnake(Direction.RIGHT);
//		sg.moveSnake(Direction.RIGHT);
//		sg.moveSnake(Direction.RIGHT);
//		sg.moveSnake(Direction.RIGHT);
//
//		sg.moveSnake(Direction.UP);
		sg.moveSnake(Direction.LEFT);
//		sg.moveSnake(Direction.UP);
//		sg.moveSnake(Direction.UP);
//		sg.moveSnake(Direction.UP);
//		sg.moveSnake(Direction.UP);

		if(sg.isGameOver()) {
			System.out.println("GAME OVER..!!");
		} else {
			System.out.println("ALIVE");
		}


	}
}

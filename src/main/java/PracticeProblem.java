public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String[][] arr) {

		//start at the bottom left
		int curRow = arr.length - 1; //last the row
		int curCol = 0; //first column

		//keep track of number of moves
		int noOfMoves = 0;

		return searchMazeMovesHelper(arr, curRow, curCol, noOfMoves);
		
	}

	public static int searchMazeMovesHelper(String[][] arr, int curRow, int curCol, int noOfMoves) {

		if (curRow < 0 || curCol < 0 || curRow >= arr.length || curCol >= arr[curRow].length){
			return -1;
		}

		if (arr[curRow][curCol].equals("F")){
			return noOfMoves;
		}

		if (arr[curRow][curCol].equals("*")){
			return -1;
		}

		String temp = arr[curRow][curCol];
		arr[curRow][curCol] = "*";


		int rightMoves = searchMazeMovesHelper(arr, curRow, curCol + 1, noOfMoves + 1);

		int upMoves = searchMazeMovesHelper(arr, curRow - 1, curCol, noOfMoves + 1);
	
		int leftMoves = searchMazeMovesHelper(arr, curRow, curCol - 1, noOfMoves + 1);

		int downMoves = searchMazeMovesHelper(arr, curRow + 1, curCol, noOfMoves + 1);

	
		arr[curRow][curCol] = temp;

		if (rightMoves == -1 && upMoves == -1 && leftMoves == -1 && downMoves == -1){
			return Math.min(Math.min(rightMoves, upMoves), Math.min(leftMoves, downMoves));
		}
		else if (rightMoves != -1  && (upMoves == -1 || rightMoves < upMoves) && (leftMoves == -1 || rightMoves < leftMoves) && (downMoves == -1 || rightMoves < downMoves)){
			return rightMoves;
		}
		else if (upMoves != -1 && (leftMoves == -1 || upMoves < leftMoves) && (downMoves == -1 || upMoves < downMoves)){
			return upMoves;
		}
		else if (leftMoves != -1 && (downMoves == -1 || leftMoves < downMoves)){
			return leftMoves;
		}
		else {
			return downMoves;
		}
	}
}

class Homework8_3 {
	public static void main(String[] args){
		/*8.3 (Sort students on grades)
		Rewrite Listing 8.2, GradeExam.java, to display the students in increasing order of the number of correct answers.*/

		char[][] answers = fillArray();
		char[] key = getKey();

		int[][] scores = showGrades(answers, key);
		scores = bubbleSort(scores);
		showInOrder(scores);
	}

	public static char[][] fillArray(){
		char[][] array ={
			{'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
			{'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
			{'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
			{'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
			{'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
			{'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
			{'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
			{'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}
		};
		return array;
	}

	public static char[] getKey(){
		char[] key = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};
		return key;
	}

	public static int[][] showGrades(char[][] answers, char[] key){
		System.out.println("The original order is:");
		int[][] grades = new int [8][2];
		for(int studentNumber = 0; studentNumber < answers.length; studentNumber++){
			int correctCount = 0;
			for(int answerNumber = 0; answerNumber < answers[studentNumber].length; answerNumber++){
				if(answers[studentNumber][answerNumber] == key[answerNumber]){
					correctCount++;
				}
			}
			grades[studentNumber][0] = correctCount;
			grades[studentNumber][1] = studentNumber;
			System.out.println("Student " + studentNumber + "'s correct count is " + correctCount);
		}
		return grades;
	}

	public static int[][] bubbleSort(int[][] scores){
		int[] temp = new int[2];
		boolean outOfOrder = true;
		while(outOfOrder){
			outOfOrder = false;
			for(int outerIndex = 0; outerIndex < scores.length; outerIndex++){
				for(int innerIndex = 0; innerIndex < scores.length - 1; innerIndex++){
					if(scores[innerIndex][0] > scores[innerIndex + 1][0]){
						outOfOrder = true;
						temp[0] = scores[innerIndex][0];
						temp[1] = scores[innerIndex][1];
						scores[innerIndex][0] = scores[innerIndex + 1][0];
						scores[innerIndex][1] = scores[innerIndex + 1][1];
						scores[innerIndex + 1][0] = temp[0];
						scores[innerIndex + 1][1] = temp[1];
					}
				}
			}
		}
		return scores;
	}

	public static void showInOrder(int[][] scores){
		System.out.println("The sorted order is:");
		for(int i = 0; i < scores.length; i++){
			System.out.println("Student " + scores[i][1] + "'s correct count is " + scores[i][0]);
		}
	}
}

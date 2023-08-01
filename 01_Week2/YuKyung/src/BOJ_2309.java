import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2309 {
	// ����Լ� �����
	// Step 1. �Է¹��� 9���� ���� �߿��� 1������ 9�������� ���ڸ� �����Ͽ� ���� ����غ��� ������ ��� ������ ã��
	// Step 2. ��� �Լ��� ����Ͽ� ��� ������ Ž���ϰ� ������ 7, ���� 100�� �Ǵ� ��츸 ����� ���Խ�Ŵ
	
	public static void main(String[] args) {
		
		// �����̵� Ű �Է¹���
		// System.out.println("�����̵��� Ű��?");
		Scanner sc = new Scanner(System.in);
		
		// 9���̴ϱ� 1���� �迭�� ����
		int[] nan = new int[9];
		
		// ��ǥ sum�� �Ǵ� targetSum �� 100���� ����
		int targetSum = 100;
		
		// �Է¹��� Ű�� �迭�� ����
		for (int i = 0; i < nan.length; i++) {
			nan[i] = sc.nextInt();
		}
		
		// 7���� ���� 100�� �Ǵ� ������ ã�� ���� findCombinations �޼��� ȣ��
		// 1) nan �迭�� ����� Ű��� ���� targetSum �� ��� ������ ã��
		// 2-1) 'ArrayList<Integer>': 1���� ArrayList��, ���� ������
		//   2-2) 'ArrayList<ArrayList<Integer>>': 2���� ArrayList��, 1���� ArrayList���� ����
		ArrayList<ArrayList<Integer>> combinations = findCombinations(nan, 100, 7);
		
		// ��� ���
		for (ArrayList<Integer> combination : combinations) {
			// ������������ ����(�̰� ���ϰ� �־���)
			Collections.sort(combination);
			for (int num:combination) {
				System.out.println(num); // ���ٿ� �ϳ���
			}
		}
		
    }
	
	// ���� targetSum�� �Ǵ� ��� ������ ã�� �޼��� ����
    public static ArrayList<ArrayList<Integer>> findCombinations(int[] numbers, int targetSum, int count) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentCombination = new ArrayList<>();
        
        // ����Լ��� ȣ���Ͽ� ������ ã��
        findCombinationsHelper(numbers, targetSum, count, 0, currentCombination, result);
        return result;
    }
    
    // ��������� ������ ã�� �޼���
    private static void findCombinationsHelper(int[] numbers, int targetSum, int count, int currentIndex, ArrayList<Integer> currentCombination, ArrayList<ArrayList<Integer>> result) {
   
    	// Base case: count���� �����̵��� �����Ͽ� ���� 100�� �Ǹ� ����� �߰��ϰ� �Լ� ����
        if (count == 0 && targetSum == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // Recursive case: ���� �ε������� �������� ���ڵ�� ������ ������ ã��
        for (int i = currentIndex; i < numbers.length; i++) {
            int currentNumber = numbers[i];

            // ���� ���ڰ� ���� �պ��� ũ�� �� �̻� ������ �Ұ����ϹǷ� ��ŵ
            if (currentNumber <= targetSum) {
                currentCombination.add(currentNumber);
                // ���� ���ڵ�� ������ ������ ã�� ���� ��� ȣ��
                findCombinationsHelper(numbers, targetSum - currentNumber, count - 1, i + 1, currentCombination, result);
                currentCombination.remove(currentCombination.size() - 1); // Backtracking
            }
        }
    }
}
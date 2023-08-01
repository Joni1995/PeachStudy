import java.util.Scanner;

public class BOJ_1592 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // ��� ��
        int M = sc.nextInt(); // ���� ���� Ƚ��
        int L = sc.nextInt(); // ���� ������κ����� �Ÿ�

        int[] people = new int[N + 1]; // �� ����� ���� ���� Ƚ���� ������ �迭
        int current = 1; // ���� ���� �ް� �ִ� ����� ��ġ
        int throwCount = 0; // ���� ���� Ƚ��

        while (true) {
            people[current]++; // ���� ���� �ް� �ִ� ����� Ƚ�� ����
            if (people[current] == M) // ���� ���� �ް� �ִ� ����� M�� �޾����� �ݺ� ����
                break;

            // ���� ���� �ް� �ִ� ����� Ƚ���� Ȧ���� ��� �ð� �������� L��° ������� �� ����
            // ���� ���� �ް� �ִ� ����� Ƚ���� ¦���� ��� �ݽð� �������� L��° ������� �� ����
            if (people[current] % 2 == 1)
                current = (current + L) % N;
            else
                current = (current - L + N) % N;

            throwCount++; // ���� ���� Ƚ�� ����
        }

        System.out.println(throwCount);
    }
}
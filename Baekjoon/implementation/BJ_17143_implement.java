package Baekjoon.implementation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_17143_implement {

	static class Shark {
		int speed, direction, size;
	}

	static int R, C, M;
	static int answerSumOfSize = 0;
	static Shark[][] sharks;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// �������� ũ�� R, C, ����� �� M
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sharks = new Shark[R][C];

		// M ���� �ٿ� ����� ����
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			Shark shark = new Shark();
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			shark.speed = Integer.parseInt(st.nextToken());
			shark.direction = Integer.parseInt(st.nextToken());
			shark.size = Integer.parseInt(st.nextToken());
			sharks[r - 1][c - 1] = shark;
		}

		solution();
		System.out.println(answerSumOfSize);
	}

	// ���ÿ��� ���������� ��ĭ �̵��ϴ°� �ݺ����� index �� ǥ��
	// ���� ����� ��ġ �� ���� ����� �� ��� ��� �̵� �ݺ�
	private static void solution() {
		for (int i = 0; i < C; i++) {
			fishing(i);
			moveAllSharks();
		}
	}

	// ���� ��ġ���� ���� �����̿� �ִ� �� ��´�.
	private static void fishing(int col) {
		for (int i = 0; i < R; i++) {
			if (sharks[i][col] != null) {
				answerSumOfSize += sharks[i][col].size;
				sharks[i][col] = null;
				return;
			}
		}
	}

	private static void moveAllSharks() {
		Shark[][] nextSharks = new Shark[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				moveShark(nextSharks, i, j);
			}
		}

		// �̵� �Ϸ��� �迭�� ���� �����
		for (int i = 0; i < R; i++) {
			sharks[i] = Arrays.copyOf(nextSharks[i], C);
		}
	}

	private static void moveShark(Shark[][] nextSharks, int i, int j) {
		Shark shark = sharks[i][j];

		if (shark == null) {
			return;
		}

		// direction 1�� ���� ��, 2�� ���� �Ʒ�, 3�� ���� ������, 4�� ���� ����
		// ���Ʒ��� R, �¿�� C �� X ��� �� �� (X - 1) * 2 ��ŭ �̵��ϸ� ������ ��ġ, �������� ���ƿ´�.
		// �׷��Ƿ� ����� �ӵ����� (X - 1) * 2 �� ���� ��������ŭ�� �̵��ϸ� �ȴ�.
		// �� �̵��ؾ� �� �Ÿ� = shark.speed % ((X - 1) * 2)
		int X = shark.direction < 3 ? R : C;
		int moveDistance = shark.speed % ((X - 1) * 2);
		int row = i;
		int col = j;

		// �����̴� �Ÿ��� ���� �Ŀ��� ���� �̵���Ŵ
		// (���� ��ġ�� ������ �� ������� ����ϱ� �����Ƽ�.. ���� �̵�)
		for (int k = 0; k < moveDistance; k++) {
			if (shark.direction == 1) {
				row--;
				if (row < 0) {
					shark.direction = 2;
					row = 1;
				}
			} else if (shark.direction == 2) {
				row++;
				if (row > R - 1) {
					shark.direction = 1;
					row = R - 2;
				}
			} else if (shark.direction == 3) {
				col++;
				if (col > C - 1) {
					shark.direction = 4;
					col = C - 2;
				}
			} else {
				col--;
				if (col < 0) {
					shark.direction = 3;
					col = 1;
				}
			}
		}

		// ���� �̹� �� ������ ũ�⸦ ���ؼ� ������ ū ���� �����
		if (nextSharks[row][col] != null && nextSharks[row][col].size > shark.size) {
			return;
		}

		nextSharks[row][col] = shark;
	}

}


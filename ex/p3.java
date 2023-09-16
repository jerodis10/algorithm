package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class p3 {

	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(System.out);

			int n = Integer.parseInt(br.readLine());
			List<String> inputs = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				inputs.add(br.readLine());
			}
			BankOperations opt = new BankOperations();
			for (String item : inputs) {
				pw.println((int)opt.processOperation(item));
			}
			pw.flush();
			pw.close();
		}
	}
}

interface IBankAccountOperation {
	void deposit(double d);
	void withdraw(double d);
	double processOperation(String message);
}

//Create the BankOperations class by implementing the IBankAccountOperation interface

class BankOperations implements IBankAccountOperation {
	private double balance = 0;

	public void deposit(double d) {
		balance += d;
	}

	public void withdraw(double d) {
		if (balance >= d) {
			balance -= d;
		}
	}

	public double processOperation(String message) {
		String lowerMessage = message.toLowerCase();
		String[] strList = lowerMessage.split(" ");

		for (int i = 0; i < strList.length; i++) {
			String curStr = strList[i];
			String countStr = strList[i + 1];
			if ("see".equals(curStr) || "show".equals(curStr)) {
				return balance;
			} else if ("deposit".equals(curStr) || "put".equals(curStr) || "invest".equals(curStr) || "transfer".equals(curStr)) {
				deposit(Double.parseDouble(countStr));
				return balance;
			} else if ("withdraw".equals(curStr) || "pull".equals(curStr)) {
				withdraw(Double.parseDouble(countStr));
				return balance;
			}
		}

		throw new RuntimeException("processOperation error");
	}
}
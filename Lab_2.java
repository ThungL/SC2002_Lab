package lab2;

import java.util.Scanner;
import java.util.Random;

public class Lab2p1 {
	public static void main(String[] args){
		int choice;
		Scanner sc = new Scanner(System.in);
		do {
		System.out.println("Perform the following methods:");
		System.out.println("1: multiplication test");
		System.out.println("2: quotient using division by subtraction");
		System.out.println("3: remainder using division by subtraction");
		System.out.println("4: count the number of digits");
		System.out.println("5: position of a digit");
		System.out.println("6: extract all odd digits");
		System.out.println("7: quit");
		choice = sc.nextInt();
		
		switch (choice) {
			case 1: /* add mulTest() call */
				mulTest();
				break;
			case 2: /* add divide() call */				
				System.out.println("What is the dividend?");
				int dividend_for_divide = sc.nextInt();
				System.out.println("What is the divisor?");
				int divisor_for_divide = sc.nextInt();
				int ans_for_divide = divide(dividend_for_divide, divisor_for_divide);				
				System.out.printf("%d/%d = %d\n", dividend_for_divide, divisor_for_divide, ans_for_divide);
				break;
			case 3: /* add modulus() call */
				System.out.println("What is the dividend?");
				int dividend_for_modulus = sc.nextInt();
				System.out.println("What is the divisor?");
				int divisor_for_modulus = sc.nextInt();
				int ans_for_modulus = modulus(dividend_for_modulus, divisor_for_modulus);
				System.out.println(dividend_for_modulus + "%" + divisor_for_modulus + "=" + ans_for_modulus);
				break;
			case 4: /* add countDigits() call */
				System.out.println("What is the number?");
				int num_for_counting = sc.nextInt();
				int ans_for_counting = countDigits(num_for_counting);
				if (ans_for_counting == -1) {
					System.out.printf("n: %d - Error input!!\n", num_for_counting);
				} else {
				System.out.println("n: " + num_for_counting + " - count = " + ans_for_counting);
				// doesnt work for some reason -- System.out.printf("n: &d - count = %d \n", num_for_counting, ans_for_counting);
				}
				break;
			case 5: /* add position() call */
				System.out.println("What is the number?");
				int num_position = sc.nextInt();
				System.out.println("What is the digit?");
				int digit_position = sc.nextInt();
				int ans_position = position(num_position, digit_position);				
				System.out.printf("position = %d\n", ans_position);
				break;
			case 6: /* add extractOddDigits() call */
				System.out.println("What is the number?");
				long num_odd = sc.nextInt();
				long ans_odd = extractOddDigits(num_odd);
				if (ans_odd == -2) {
					System.out.println("oddDigits = Error input!!");
				} else {
				System.out.printf("oddDigits = %d\n", ans_odd);
				}
				break;
			case 7: System.out.println("Program terminating...");
		}
		
		} while (choice < 7);
	}
	/* add method code here */
	public static void mulTest() {
	
		int checkedAns = 0;
		
		for (int i = 0; i<5; i++) {
			Random rand = new Random();
			int num1 = rand.nextInt(9)+ 1;
			int num2 = rand.nextInt(9)+ 1;
			
			Scanner sc = new Scanner(System.in);
			System.out.println("How much is " + num1 + " times " + num2 + "?");
			int ans = sc.nextInt();
			
			if (ans == num1 * num2) {
				checkedAns++;
			}
		}
		System.out.println(checkedAns + " answers out of 5 are correct");
	}
	
	public static int divide(int m, int n) {
		int i = -1;
		int dividend = m;
		while (dividend > 0) {
			dividend = dividend - n;
			i++;
		}
		return i;
	}
	
	public static int modulus(int m, int n) {
		while (m > 0) {
			if (m<n) {
				return m;
			}
			m = m - n;
			;
		}
		return 0;
	}
	
	public static int countDigits(int n) {
		int i = 0;
		if (n<0) {
			return -1;
		}
		while (n>0) {
			n = n / 10;
			i++;
		}
		return i;
	}
	
	public static int position(int n, int digit) {
		
		int divisor = 10;
		int ans;
		int index = 0;
		while (n > 0) {
			ans = n % divisor;
			n = n - ans;
			index++;
			divisor = divisor * 10;
			if (digit == ans/(divisor/100)) {
				return index;
			}
		}
		return -1;
	}
	
	public static long extractOddDigits(long n) {
		if (n<0) {
			return -2;
		}
		int divisor = 10;
		long ans;
		long num= 0;
		int len_ans = 1;
		while (n > 0) {
			ans = n % divisor;
			n = n - ans;
			divisor = divisor * 10;
			if ((ans/(divisor/100))%2 == 1) {
				num = num + ((ans/(divisor/100)) * len_ans);
				len_ans = len_ans * 10;
			}
		}
		if (num == 0) {
			return -1;
		}
		return num;
	}
	
}

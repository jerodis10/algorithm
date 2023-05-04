package ex;

import java.util.List;

public class ex2 {

	public static void main(String[] args) {
//     System.out.println(mkLongStr(10_240_000));
//     System.out.println(mkLongStrBuffer(10_240_000));
		System.out.println(mkLongStr(10_2400));
		System.out.println(mkLongStrBuffer(10_2400));
		System.out.println(mkLongStrBuilder(10_2400));
	}

	public static double mkLongStr(int len) {
		long start = System.nanoTime();

		String str = "";
		for(int i=0 ; i < len ; i++)    str += "a";

		long end = System.nanoTime();
		return (end-start)/(double)1_000_000_000;
	}

	public static double mkLongStrBuffer(int len) {
		long start = System.nanoTime();

		StringBuffer sb = new StringBuffer();
		for(int i=0 ; i < len ; i++)    sb.append("a");

		long end = System.nanoTime();
		return (end-start)/(double)1_000_000_000;
	}

	public static double mkLongStrBuilder(int len) {
		long start = System.nanoTime();

		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i < len ; i++)    sb.append("a");

		long end = System.nanoTime();
		return (end-start)/(double)1_000_000_000;
	}

}

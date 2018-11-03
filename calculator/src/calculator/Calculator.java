package calculator;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class Calculator {


    public BigDecimal calculte(String s) {

		BigDecimal count = new BigDecimal("0");
		String[] st = s.split("[+,[-]]");
		Pattern p1 = Pattern.compile("[+,[-]]?");
		Matcher m1 = p1.matcher(s);
		List<String> l1 = new ArrayList<>();// 按顺序存放加减符号
		while (m1.find()) {
			String v1 = m1.group();
			if (v1.replaceAll(" ", "").length() == 0) {
				continue;
			}
			if (v1.contains("+")) {
				l1.add("+");
			} else if (v1.contains("-")) {
				l1.add("-");
			}

		}
		List<BigDecimal> l2 = new ArrayList<>();// 按顺序存放乘除运算后待进行加减运算的数字
		for (String s1 : st) {
			if (s1.contains("*") || s1.contains("/")) {
				Pattern p = Pattern.compile("[*,/]?");
				Matcher m = p.matcher(s1);
				List<String> l3 = new ArrayList<>();// 存放运算符号
				while (m.find()) {
					String v1 = m.group();
					if (v1.replaceAll(" ", "").length() == 0) {
						continue;
					}
					if (v1.contains("*")) {
						l3.add("*");
					} else if (v1.contains("/")) {
						l3.add("/");
					}
				}
				String[] st1 = s1.split("[*,/]");
				BigDecimal i1 = new BigDecimal(st1[0]);
				for (int i = 0; i < l3.size(); i++) {
					String v2 = l3.get(i);
					if (v2.contains("*")) {
						i1 = i1.multiply(new BigDecimal(st1[i + 1]));
					} else if (v2.contains("/")) {
						i1 = i1.divide(new BigDecimal(st1[i + 1]), MathContext.DECIMAL128);
					}
					l2.add(i1);
				}
			} else {
				l2.add(new BigDecimal(s1));
			}

		}
		count = l2.get(0);
		for (int i = 0; i < l1.size(); i++) {
			String v3 = l1.get(i);
			if (v3.contains("+")) {
				count = count.add(new BigDecimal(l2.get(i + 1).toString()));
			} else if (v3.contains("-")) {
				count = count.subtract(new BigDecimal(l2.get(i + 1).toString()));
			}
		}
		return count;
	}
    

    public static void main(String[] args) {
        //Scanner ac=new Scanner(System.in);
        new frame().jframe();
        //System.out.println("put in string");
    
   
    	//String s = ac.nextLine();
        //int answer = calculte("#"+s+"#");
        //System.out.println("the answer is " + answer);
    }
}
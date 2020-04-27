package application;

import java.util.ArrayList;

/**
 * This class computes the result of the given complex expression
 * 
 * @author Jesse, Archer
 *
 */
public class Calculator {

  /**
   * Handling complex expressions
   * 
   * @param  expression
   * @return            String
   */
  public static String calcul(String expression) {

    // Handling Absolute values
    expression = expression.replaceAll("\\|\\-?(.+)\\|", "$1");

    // Handling PI
    expression = expression.replaceAll("\\u03c0", String.valueOf(Math.PI));

    // Handling e
    expression = expression.replaceAll("e", String.valueOf(Math.E));

    String result = String.valueOf(calculate(expression));

    return result.endsWith(".0") ? result.replace(".0", "") : result;
  }

  /**
   * Build up calculation expression and calculate result.
   * 
   * @param  expression String math expression
   * @return            result after calculation
   */
  private static double calculate(String expression) {

    expression = expression.replaceAll("(\\d+)\\(", "$1*(");

    if (expression.matches("\\-?\\d+"))
      return Double.valueOf(expression);
    ArrayList<String> s = new ArrayList<String>();
    char[] chs = expression.toCharArray();
    String temp = "";
    boolean tag = false;
    for (int i = 0; i < chs.length; i++) {
      if (chs[i] - '0' >= 0 && chs[i] - '0' <= 9) {
        temp += chs[i];

      } else if (chs[i] == '.') {
        temp += chs[i];

      } else if (chs[i] == ' ') {
        if (temp.length() != 0)
          s.add(temp);
        temp = "";

      } else if (chs[i] == '-') {
        if (temp.length() != 0)
          s.add(temp);
        temp = "-";
        if (chs[i + 1] == '(') {
          if (s.get(s.size() - 1).equals("/")
              || s.get(s.size() - 1).equals("*")) {
            s.add("(");
            tag = true;
          } else if (s.get(s.size() - 1).equals("-")) {
            s.set(s.size() - 1, "+");
            s.add("(");
          } else if (s.get(s.size() - 1).equals(")")
              || s.get(s.size() - 1).matches("\\d+")) {
            s.add("-");
            s.add("(");
          } else {
            s.add("0");
            s.add("-");
            s.add("(");
          }
          temp = "";
          i++;

        } else if (chs[i + 1] - '0' >= 0 && chs[i + 1] - '0' <= 9) {
          if (s.get(s.size() - 1).matches("\\d+")) {
            s.add("+");
          } else {
            continue;
          }
        } else {
          if (temp.length() != 0)
            s.add(temp);
          temp = "";
        }

      } else if (chs[i] == ')' && tag) {
        s.add(temp);
        temp = "";
        s.add(")");
        s.add("*");
        s.add("-1");
        tag = false;
      } else {
        if (temp.length() != 0)
          s.add(temp);
        temp = "";
        temp += chs[i];
        s.add(temp);
        temp = "";
      }
    }
    if (temp.length() != 0)
      s.add(temp);
    String[] spliter = s.toArray(new String[0]);
    SimpleCalculator cal = new SimpleCalculator(spliter);
    double result = cal.doCal();
    return result;
  }
}



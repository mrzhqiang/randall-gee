package com.github.mrzhqiang.randall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BaseAbils {

  // 1战士，2法师，3道士，0不变化
  private static int ZY = 0;

  public static void main(String[] args) throws IOException {
    StringBuilder stringBuffer = new StringBuilder();

    File file = new File(".\\Mir200\\BaseAbil.ini");

    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    String line = bufferedReader.readLine();
    while (line != null) {
      // 只修改人物的职业属性，没有英雄的，暂不修改
      if (line.startsWith("[")) {
        if (line.contains("Hum_0")) {
          ZY = 1;
        } else if (line.contains("Hum_1")) {
          ZY = 2;
        } else if (line.contains("Hum_2")) {
          ZY = 3;
        } else {
          ZY = 0;
        }
      }
      // 通过职业修改对应的属性
      line = changeFiledByZY(line);

      stringBuffer.append(line).append("\r\n");
      line = bufferedReader.readLine();
    }
    stringBuffer.append("\r\n");

    bufferedReader.close();

    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
    bufferedWriter.write(stringBuffer.toString());
    bufferedWriter.flush();

    bufferedWriter.close();

    System.out.println("OK");
  }

  private static String changeFiledByZY(String line) {
    if (ZY == 1) {
      // 战士
      line = change(line, "AC1_", "1");
      line = change(line, "AC2_", "1");
      line = change(line, "MAC1_", "1");
      line = change(line, "MAC2_", "1");
      line = change(line, "DC1_", "1");
      line = change(line, "DC2_", "1");
      line = change(line, "MC1_", "0");
      line = change(line, "MC2_", "0");
      line = change(line, "SC1_", "0");
      line = change(line, "SC2_", "0");
      line = changeNumber(line, "MaxHP_", 100, 3);
      line = changeNumber(line, "MaxMP_", 50, 1);
      line = change(line, "MaxWeight_", "1000");
      line = change(line, "MaxWearWeight_", "1000");
      line = change(line, "MaxHandWeight_", "1000");
    } else if (ZY == 2) {
      // 法师
      line = change(line, "AC1_", "1");
      line = change(line, "AC2_", "1");
      line = change(line, "MAC1_", "1");
      line = change(line, "MAC2_", "1");
      line = change(line, "DC1_", "0");
      line = change(line, "DC2_", "0");
      line = change(line, "MC1_", "1");
      line = change(line, "MC2_", "1");
      line = change(line, "SC1_", "0");
      line = change(line, "SC2_", "0");
      line = changeNumber(line, "MaxHP_", 100, 1);
      line = changeNumber(line, "MaxMP_", 50, 3);
      line = change(line, "MaxWeight_", "1000");
      line = change(line, "MaxWearWeight_", "1000");
      line = change(line, "MaxHandWeight_", "1000");
    } else if (ZY == 3) {
      // 道士
      line = change(line, "AC1_", "1");
      line = change(line, "AC2_", "1");
      line = change(line, "MAC1_", "1");
      line = change(line, "MAC2_", "1");
      line = change(line, "DC1_", "0");
      line = change(line, "DC2_", "0");
      line = change(line, "MC1_", "0");
      line = change(line, "MC2_", "0");
      line = change(line, "SC1_", "1");
      line = change(line, "SC2_", "1");
      line = changeNumber(line, "MaxHP_", 100, 2);
      line = changeNumber(line, "MaxMP_", 50, 2);
      line = change(line, "MaxWeight_", "1000");
      line = change(line, "MaxWearWeight_", "1000");
      line = change(line, "MaxHandWeight_", "1000");
    }
    return line;
  }

  private static String changeNumber(String value, String check, int startIndex, int i) {
    if (value.startsWith(check)) {
      String[] split = value.split("=");
      String number = split[0].replace(check, "");
      int n = Integer.parseInt(number);
      n = startIndex + n * i;
      value = split[0] + "=" + n;
    }
    return value;
  }

  private static String change(String value, String check, String replace) {
    if (value.startsWith(check)) {
      String newStr = value.substring(0, value.indexOf("=") + 1);
      newStr += replace;
      value = newStr;
    }
    return value;
  }
}

package com.github.mrzhqiang.randall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exps {

  private static int EXP = 0;
  private static long value = 90;

  public static void main(String[] args) throws IOException {
    StringBuilder stringBuffer = new StringBuilder();
    File file = new File(".\\Mir200\\Exps.ini");
    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    String line = bufferedReader.readLine();
    while (line != null) {
      if (line.startsWith("[")) {
        // 只调整人物经验，不对其他经验做安排
        if (line.equals("[Exp]")) {
          EXP = 1;
        } else {
          EXP = 0;
        }
      }

      line = change(line, "Level");

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

  private static String change(String line, String level) {
    if (EXP == 1) {
      // 不修正按等级的比例经验，以及其他参数
      if (line.startsWith(level) && !line.contains("ExpRate")) {
        String[] numbers = line.split("=");
        String lvl = numbers[0].replace(level, "");
        int l = Integer.valueOf(lvl);
        int interval = 0;
        if (l <= 200) {
          // 1级 90 + 20  = 110
          // 2级 90 + 20 * 2 = 130
          // 200级 90 + 20 * 200 = 4090
          interval = 90 + 20 * l;
        } else if (l <= 300) {
          interval = (90 + 20 * l) * 2;
        } else if (l <= 700) {
          interval = (90 + 20 * l) * 4;
        } else if (l <= 800) {
          interval = (90 + 20 * l) * 16;
        }
        if (l == 201) {
          value = value * 2 + interval;
        } else if (l == 301) {
          value = value * 2 + interval;
        } else if (l == 701) {
          value = value * 4 + interval;
        } else if (l < 800) {
          value = value + interval;
        } else {
          value = 2000000000;
        }
        line = numbers[0] + "=" + value;
      }
    }
    return line;
  }
}

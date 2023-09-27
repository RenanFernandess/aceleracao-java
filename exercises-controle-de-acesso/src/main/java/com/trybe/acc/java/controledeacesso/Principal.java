package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * class.
 */
public class Principal {
  static ArrayList<Short> minorList = new ArrayList<Short>();
  static ArrayList<Short> adultsList = new ArrayList<Short>();
  static ArrayList<Short> elderlyList = new ArrayList<Short>();

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String selectedOption = "";

    while (!selectedOption.equals("2")) {
      System.out.println("Entre com o número correspondente à opção desejada: \n"
          + "1 - Acessar o estabelecimento \n" + "2 - Finalizar sistema e mostrar relatório");
      selectedOption = scanner.next();
      if (selectedOption.equals("1")) {
        System.out.println("Entre com a sua idade:");
        short age = Short.parseShort(scanner.next());
        checkCustomer(age);
      } else if (!selectedOption.equals("2")) {
        System.out.println("Entre com uma opção válida!");
      }
    }

    createReport();
    scanner.close();
  }

  private static void checkCustomer(short age) {
    if (age < 18) {
      minorList.add(age);
      System.out.println("Pessoa cliente menor de idade, catraca liberada!");
    } else if (age >= 18 & age <= 49) {
      adultsList.add(age);
      System.out.println("Pessoa adulta, catraca liberada!");
    } else {
      elderlyList.add(age);
      System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
    }
  }

  private static void createReport() {
    int minor = minorList.size();
    int adults = adultsList.size();
    int elderly = elderlyList.size();
    System.out.println("----- Quantidade ----- \n" + ("menores: " + minor + "\n")
        + ("adultas: " + adults + "\n") + ("a partir de 50: " + elderly + "\n"));

    int total = minor + adults + elderly;
    System.out
        .println("----- Percentual ----- \n" + ("menores: " + calcPercentage(minor, total) + "\n")
            + ("adultas: " + calcPercentage(adults, total) + "\n")
            + ("a partir de 50: " + calcPercentage(elderly, total) + "\n"));

    System.out.println("TOTAL: " + total);
  }

  private static String calcPercentage(int value, int total) {
    DecimalFormat df = new DecimalFormat("0.00");
    return df.format((value * 100.0) / total) + "%";
  }
}

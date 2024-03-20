package Java_Seminar3;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateInfo {
    static final String OUT_DATA = "Нет данных";

    public static ArrayList<String> createInfoList(ArrayList<String> info) {
        ArrayList<String> infoList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            infoList.add(OUT_DATA);
        }
        try {
            Methods.addFio(infoList, info.getFirst(), 0);
            Methods.addFio(infoList, info.get(1), 1);
            Methods.addFio(infoList, info.get(2), 2);
            Methods.addDate(infoList, info.get(3), 3);
            Methods.addPhoneNumber(infoList, info.get(4), 4);
            Methods.addSex(infoList, info.get(5), 5);
        } catch (NullPointerException | NoSuchElementException e1) {
            System.out.println("Пустая строка, необходимо ввести данные");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Недостаточно данных");
        }

        return infoList;
    }

    public static int checkInfo(ArrayList<String> array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(OUT_DATA)) {
                return i;
            }
        }
        return -1;
    }

    public static String complete(int index) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Пожалуйста, введите данные. " + Methods.DATA_RU[index] + " -> ");
            return scanner.next();
        } catch (NoSuchElementException e) {
            return OUT_DATA;
        }
    }

    public static StringBuilder toString(ArrayList<String> array) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < array.size(); i++) {
            string = new StringBuilder(string + " " + array.get(i));

        }
        return string;
    }
}

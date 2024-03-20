package Java_Seminar3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные через пробел: фамилия имя отчество || дата рождения в формате dd.mm.YYYY || номер телефона || пол (f/m)");
        ArrayList<String> info = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        ArrayList<String> infoList = CreateInfo.createInfoList(info);
        int index = CreateInfo.checkInfo(infoList);
        while (index != -1) {
            String string = " ";
            System.out.println("Вы ввели недостаточно данных или их формат не поддерживается. " + Methods.DATA_RU[index] + " -> ");
            string = scanner.nextLine();
            switch (index) {
                case 0, 1, 2:
                    Methods.addFio(infoList, string, index);
                    break;
                case 3:
                    Methods.addDate(infoList, string, index);
                    break;
                case 4:
                    Methods.addPhoneNumber(infoList, string, index);
                    break;
                case 5:
                    Methods.addSex(infoList, string, index);
                    break;
            }
            index = CreateInfo.checkInfo(infoList);
        }
        scanner.close();
        try (FileWriter writer = new FileWriter(infoList.getFirst() + ".txt", true)) {
            writer.write(CreateInfo.toString(infoList).toString());
            writer.write("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
// Неверный Алексей Алексеевич 15.03.1990 79252151525 мужской

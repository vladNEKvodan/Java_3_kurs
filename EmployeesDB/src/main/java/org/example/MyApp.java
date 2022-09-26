package org.example;

import java.util.Arrays;
import java.util.Scanner;

class Employee {
    private int Id = 0;
    private static int counter = 0;
    private String Name = "";
    private String Surname = "";
    private int God_rozdeniya = 0;
    private String Mesto_rozhdeniya = "";
    private int Pay = 0;
    private String Polozenie = "";

    public Employee(String Name, String Surname)
    {

        counter++;
        if (counter > 100)
        {
            return;
        }
        this.setName(Name);
        this.setSurname(Surname);
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }

    public String getSurname() {
        return Surname;
    }
    public void setSurname(String surname) {
        this.Surname = surname;
    }

    public int getGod_rozdeniya(){
        return God_rozdeniya;
    }

    public void setGod_rozdeniya(int year) {
        this.God_rozdeniya = year;
    }

    public String getMesto_rozhdeniya(){
        return Mesto_rozhdeniya;
    }

    public void setMesto_rozhdeniya(String place){
        this.Mesto_rozhdeniya = place;
    }

    public int getPay(){
        return Pay;
    }

    public void setPay(int Pay){
        this.Pay = Pay;
    }

    public String getPolozenie(){
        return Polozenie;
    }

    public void setPolozenie(String Polozenie){
        this.Polozenie = Polozenie;
    }

    public int getId(){
        return Id;
    }

    public void setId(int id){
        this.Id = id;
    }


    public String[] getArr(){
        return new String[]{String.valueOf(Id), Name, Surname, String.valueOf(God_rozdeniya), Mesto_rozhdeniya, String.valueOf(Pay), Polozenie};
    }

}

public class MyApp {
    static Employee[] employees = new Employee[5];
    static int id = 0;
    static int sum = 0;
    static int i = 0;

    public static void main(String[] args) {
        Employee Anton = new Employee("Anton", "Meskin");
        Anton.setId(id += 1);
        Anton.setGod_rozdeniya(1996);
        Anton.setMesto_rozhdeniya("Moscow");
        Anton.setPay(1000);
        Anton.setPolozenie("free");
        employees[0] = Anton;

        Employee Evgeniy = new Employee("Evgeniy", "Krabov");
        Evgeniy.setId(id += 1);
        Evgeniy.setGod_rozdeniya(1984);
        Evgeniy.setMesto_rozhdeniya("Rostov");
        Evgeniy.setPay(5223);
        Evgeniy.setPolozenie("married");
        employees[1] = Evgeniy;

        Employee Alexander = new Employee("Alexander", "Seledkin");
        Alexander.setId(id += 1);
        Alexander.setGod_rozdeniya(1985);
        Alexander.setMesto_rozhdeniya("Twer");
        Alexander.setPay(2288);
        Alexander.setPolozenie("married");
        employees[2] = Alexander;

        Employee Andrey = new Employee("Andrey", "Ramov");
        Andrey.setId(id += 1);
        Andrey.setGod_rozdeniya(1998);
        Andrey.setMesto_rozhdeniya("Saint_Petersburg");
        Andrey.setPay(2800);
        Andrey.setPolozenie("free");
        employees[3] = Andrey;

        Employee Victor = new Employee("Victor", "Kerasov");
        Victor.setId(id += 1);
        Victor.setGod_rozdeniya(1985);
        Victor.setMesto_rozhdeniya("Stavropol");
        Victor.setPay(2687);
        Victor.setPolozenie("free");
        employees[4] = Victor;

        Poisk();
    }

    public static void Poisk() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберете необходимую функцию: \n" +
                "1. Вывести сотрудика \n" +
                "2. Вывести сотрудника по дате рождения \n" +
                "3. Вывести сумму зарплат сотрудников \n" +
                "4. Вывести первых четырех сотрудников \n" +
                "5. Изменить информацию о сотруднике");
        int number = scanner.nextInt();
        if (number == 1) {
            Scanner sec_scnner = new Scanner(System.in);
            System.out.println("Введите номер идентификационного номера сотрудника: ");
            int second_number = sec_scnner.nextInt();
            System.out.println(Arrays.toString(SelectById(second_number).getArr()));
        } else if (number == 2) {
            Scanner third_scanner = new Scanner(System.in);
            System.out.println("Введите дату рождения сотрудника: ");
            int second_number = third_scanner.nextInt();
            System.out.println(Arrays.toString(SelectByDate(second_number)[0].getArr()));
        } else if (number == 3 ) {
            for (Employee employee : employees) {
                sum += employee.getPay();
            }
            System.out.println(sum);
        } else if (number == 4) {
            System.out.println(Arrays.toString(SelectById(1).getArr()));
            System.out.println(Arrays.toString(SelectById(2).getArr()));
            System.out.println(Arrays.toString(SelectById(3).getArr()));
            System.out.println(Arrays.toString(SelectById(4).getArr()));
        } else if (number == 5) {
                    Scanner scanner_for_replace = new Scanner(System.in);
                    System.out.println("Выберете сотрудника для замены значения по идентификационному номеру");
                    int replace_number = scanner_for_replace.nextInt();
                    if (replace_number == 1) {
                        System.out.println("Введите новое значение");
                        Scanner new_name = new Scanner(System.in);
                        String namee = String.valueOf(new_name.nextLine());
                        String name = Arrays.toString(SelectById(1).getArr()).replace("Anton", namee);
                        System.out.println(name);
                    }
                    else if (replace_number == 2) {
                        System.out.println("Введите новое значение");
                        Scanner new_name = new Scanner(System.in);
                        String namee = String.valueOf(new_name.nextLine());
                        String name = Arrays.toString(SelectById(2).getArr()).replace("Evgeniy", namee);
                        System.out.println(name);
                    }
                    else if (replace_number == 3) {
                        System.out.println("Введите новое значение");
                        Scanner new_name = new Scanner(System.in);
                        String namee = String.valueOf(new_name.nextLine());
                        String name = Arrays.toString(SelectById(3).getArr()).replace("Alexander", namee);
                        System.out.println(name);
                    }
                    else if (replace_number == 4) {
                        System.out.println("Введите новое значение");
                        Scanner new_name = new Scanner(System.in);
                        String namee = String.valueOf(new_name.nextLine());
                        String name = Arrays.toString(SelectById(4).getArr()).replace("Andrey", namee);
                        System.out.println(name);
                    }
                    }
                }
    public static Employee SelectById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id)
                return employee;
        }
        return null;
    }

    public static Employee[] SelectByDate(int date) {
        Employee[] employees_date = new Employee[5];
        for (Employee employee : employees) {
            if (employee.getGod_rozdeniya() == date) {
                employees_date[i] = employee;
                i++;
            }
        }
        return Arrays.copyOfRange(employees_date, 0, i);
    }
}
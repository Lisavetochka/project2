package firma;
import java.util.Scanner;
class Employee {
    String fam, im, secFam, position;
    int salary;
    int kolDet;
    Child[]reb= null;
}
class Child {
    String imaR;
    int years;
}

public class Firma {		// головний клас
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Введіть кількість співробітників => ");
        int kol = sc.nextInt();
        sc.nextLine();                //очищення буфера після введення числа


        Employee[] eml = new Employee[kol];//отримано посилання на масив
// співробітників
        System.out.println("Введіть інформацію про кожного співробітника:");
        for (int i = 0; i < eml.length; i++) {
            eml[i] = new Employee();    // отримано посилання на i-тий елемент

// Присвоєння значень полям
            System.out.print("Введіть прізвище " + (i + 1) + " співробітника => ");
            eml[i].fam = sc.nextLine();

            System.out.print("Введіть його ім'я => ");
            eml[i].im = sc.nextLine();

            System.out.print("Введіть його по батькові => ");
            eml[i].secFam = sc.nextLine();

            System.out.print("Введіть його посаду => ");
            eml[i].position = sc.nextLine();

            System.out.print("Введіть його оклад => ");
            eml[i].salary = sc.nextInt();
            System.out.print("Введіть кількість дітей =>");
            eml[i].kolDet=sc.nextInt();

            sc.nextLine();                //очищення буфера
            if(eml[i].kolDet != 0) {
                eml[i].reb=new Child[eml[i].kolDet];
                System.out.println("Діти =>");
                for(int j = 0; j < eml[i].reb.length; j++) {
                    eml[i].reb[j]=new Child();
                    System.out.print("Введіть ім'я "+(j + 1)+" дитини => ");
                    eml[i].reb[j].imaR = sc.nextLine();

                    System.out.print("Введіть його вік =>");
                    eml[i].reb[j].years = sc.nextInt();
                    sc.nextLine(); 			// очищення буфера
                } } }

// Виведення інформації про співробітників
        System.out.println("\nСпівробітники фірми \n прізвище \t ім'я \t по-батькові \t посада \t оклад");
        for(Employee s: eml) {
            System.out.print(s.fam + "\t" + s.im + "\t" + s.secFam + "\t " + s.position + "\t" + s.salary);
            System.out.println("\n\nДіти: ");
            if( s.kolDet != 0) {
                for (Child r : s.reb) System.out.println("\t" + r.imaR + "\t" + r.years);
            }
            else System.out.println("Дітей немає");
        }

    }
}

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

public class Firma {		// �������� ����
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("������ ������� ����������� => ");
        int kol = sc.nextInt();
        sc.nextLine();                //�������� ������ ���� �������� �����


        Employee[] eml = new Employee[kol];//�������� ��������� �� �����
// �����������
        System.out.println("������ ���������� ��� ������� �����������:");
        for (int i = 0; i < eml.length; i++) {
            eml[i] = new Employee();    // �������� ��������� �� i-��� �������

// ��������� ������� �����
            System.out.print("������ ������� " + (i + 1) + " ����������� => ");
            eml[i].fam = sc.nextLine();

            System.out.print("������ ���� ��'� => ");
            eml[i].im = sc.nextLine();

            System.out.print("������ ���� �� ������� => ");
            eml[i].secFam = sc.nextLine();

            System.out.print("������ ���� ������ => ");
            eml[i].position = sc.nextLine();

            System.out.print("������ ���� ����� => ");
            eml[i].salary = sc.nextInt();
            System.out.print("������ ������� ���� =>");
            eml[i].kolDet=sc.nextInt();

            sc.nextLine();                //�������� ������
            if(eml[i].kolDet != 0) {
                eml[i].reb=new Child[eml[i].kolDet];
                System.out.println("ĳ�� =>");
                for(int j = 0; j < eml[i].reb.length; j++) {
                    eml[i].reb[j]=new Child();
                    System.out.print("������ ��'� "+(j + 1)+" ������ => ");
                    eml[i].reb[j].imaR = sc.nextLine();

                    System.out.print("������ ���� �� =>");
                    eml[i].reb[j].years = sc.nextInt();
                    sc.nextLine(); 			// �������� ������
                } } }

// ��������� ���������� ��� �����������
        System.out.println("\n����������� ����� \n ������� \t ��'� \t ��-������� \t ������ \t �����");
        for(Employee s: eml) {
            System.out.print(s.fam + "\t" + s.im + "\t" + s.secFam + "\t " + s.position + "\t" + s.salary);
            System.out.println("\n\nĳ��: ");
            if( s.kolDet != 0) {
                for (Child r : s.reb) System.out.println("\t" + r.imaR + "\t" + r.years);
            }
            else System.out.println("ĳ��� ����");
        }

    }
}

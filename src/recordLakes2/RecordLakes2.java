package recordLakes2;
import java.util.Scanner;

class Lake{
    String name, location; //name and location of the lake
    double square; 	//lake square
}

public class RecordLakes2{

    public static Lake [] setLakesArr(int k) {
// Input information about lakes
        Scanner sc=new Scanner(System.in,"cp1251");
        Lake[] lakes=new Lake[k];

        System.out.println("������ ���������� ��� �����: ");
        for (int i = 0; i < lakes.length; i++) {
            lakes [i] = new Lake ();
            System.out.print("����� " + (i + 1) + "-�� ����� => ");
            lakes[i].name = sc.nextLine();
            System.out.print("����� ������������ " + (i + 1) + "-�� ����� => ");
            lakes[i].location = sc.nextLine();
            System.out.print("����� " + (i + 1) + "-�� ����� => ");
            lakes[i].square = sc.nextDouble();
            sc.nextLine();  //clearing the buffer
        }
        return lakes;
    }
    public static Lake[] setEditLakeArr(int k) {
//Introduction of variable lake
        Scanner sc=new Scanner(System.in,"cp1251");
        Lake[] lakes=new Lake[k];
        System.out.println("������ ���� ���������� ��� �����: ");
        for (int i = 0; i < 1; i++) {
            lakes [i] = new Lake ();
            System.out.print("����� ����� => ");
            lakes[i].name = sc.nextLine();
            System.out.print("����� ������������ ����� => ");
            lakes[i].location = sc.nextLine();
            System.out.print("����� ����� => ");
            lakes[i].square = sc.nextDouble();
            sc.nextLine();   //clearing the buffer
        }
        return lakes;
    }
    public static void showArray (Lake [] lk) {
//Output of received information
        System.out.println("�����    �����    ����� ");
        for(int i = 0; i < lk.length; i++) {
            System.out.println(" "+ lk[i].name + "\t" + lk[i].location +"\t" + lk[i].square + " ��. ��");
        }
    }
    public static void showEditArray (Lake [] lk) {
//Output of received information
        System.out.println("�����    �����    ����� ");
        for(int i = 0; i < 1; i++) {
            System.out.println(" "+ lk[i].name + "\t" + lk[i].location +"\t" + lk[i].square + " ��. ��");
        }
    }
    public static void showLakes	(Lake lk){
//Information about one lake
        System.out.println("�����    �����    ����� ");
        System.out.println(""+lk.name+"\t"+lk.location+"\t"+lk.square+" ��. ��"); }

    public static int NomMax	(Lake [] lk) {
//lake's number with max square
        int indMax=0;	//country element number with max square
        double max=lk[indMax].square;	//max square (initial value)
        for (int i = 0; i <lk.length; i++)
            if (lk[i].square>max) {
                max = lk [i]. square;
                indMax=i;
            }
        return indMax;
    }

    //Separation between points
    public static void Next() {
        System.out.println("--------------------------------");
    }

    public static void sortByName	(Lake [] lk) {
//Sorting the list of lakes by name
        for (int i = 0; i < lk.length-1; i++)
            for (int j = 0; j < lk.length-i-1; j++)
                if(lk[j].name.compareTo(lk[j+1].name)>0) {
                    Lake rem = lk[j];	//rem � variable for permutation
                    lk[j] = lk[j + 1];
                    lk[j + 1] = rem;
                }
    }
    public static double avgSquare(Lake [] lk) {
//average square
        double s=0;	//total square
        for (int i = 0; i < lk.length; i++)
            s+=lk[i].square;
        return s/lk.length; }

    public static Lake [] Less(Lake[] lk){
//The square is less than average
        double avg=avgSquare(lk);
        int amount=0;	//amount of lakes
        for (int i = 0; i < lk.length; i++) {
            if (lk[i].square<avg)
                ++amount;
        }

        if (amount != 0) {
            Lake [] lilLake = new Lake [amount];
            int n=-1;
            for (int i = 0; i <lk.length; i++)
                if (lk[i].square<avg) {
                    lilLake[++n]=lk[i];
                }
            return lilLake;
        } else return null;
    }

    public static int amountLilLakes(Lake [] lk) {
        int amountLil = 0;
        double avg=avgSquare(lk);
        for (int i = 0; i <lk.length; i++)
            if (lk[i].square<avg) {
                amountLil++; //number of lakes
            }
        return amountLil;
    }

    public static Lake findForName(Lake[] lk, String name) {
        //Searching for a lake by name
        int n=-1;			//-1 � the lake with the searched name doesn't exist
        for (int i = 0; i < lk.length; i++)
            if (name.equals(lk[i].name))
                n=i;
        if (n != -1) { return lk[n];
        } else return null;
    }

    public static void main(String[] args) {
//MAIN CLASS WITH METHODS
        Scanner sc=new Scanner(System.in,"cp1251");
        System.out.print("������ ������� ���� => ");
        int n=sc.nextInt();	//number of lakes
        Lake[] lakes = setLakesArr(n);	//Input information about countries

        System.out.println("\n�������������� ����:");
        showArray(lakes); // Output of received information
        Next();

//Lake with the largest square
        int indMax=NomMax(lakes);
        System.out.println("\n����� � ��������� ������:");
        showLakes (lakes [indMax]);
        Next();


// Sorting the list of lakes by name
        sortByName(lakes);
        System.out.println("\n³����������� ������ �� ������:");
        showArray(lakes);
        Next();


//Average square
        System.out.printf("\n������� ����� = %.2f", avgSquare(lakes));



//The square is less than average
        System.out.println("\n�����, � ������ ����� ��������");
        Lake [] less = Less (lakes);
        assert less != null;
        showArray(less);
        System.out.println("ʳ������ ����, � ������ ����� ��������:"+amountLilLakes(lakes));
        Next();


//Searching for a lake by name
        System.out.println("\n����� ����� \n ������ ����� ����� => "); sc.nextLine();
        String name=sc.nextLine();
        Lake find = findForName(lakes, name); if (find != null) {
            System.out.println("\n���� ����� ���� \n �������� ����������: ");
            showLakes(find);
        } else {
            System.out.println("������ ����� ���� � ������!");
        }
        Next();

//Request about which lake to change information
        System.out.println("\n ������ ����� �����, ��� ��� ������ ������ ���������� => ");
        String editName=sc.nextLine();
        Lake editFind = findForName(lakes, editName); if (editFind != null) {
            System.out.println("\n���� ����� ���� \n �������� ����������: ");
            showLakes(editFind);
            Lake[] editLakes = setEditLakeArr(n); //Filling in new information
            System.out.println("\n³����������� ����������: ");
            showEditArray(editLakes);
        } else {
            System.out.println("������ ����� ���� � ������!");
        }Next();
    }
}
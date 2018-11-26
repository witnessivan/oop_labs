package lab_1_2;

// ������ �������
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

// �������� �����
public class Lab_1_2 {

    // ������� �����
    public static void main(String[] args) 
    {
        int command;
        short[] array = null;
        Scanner input = new Scanner(System.in);
        outputMenu();//��������� ����
        do
        {
            System.out.print("\n������� �������: ");
            command = input.nextInt();
            switch (command)
            {
                case 1:
                    array = createArray(array);
                    break;
                case 2:
                    autoInputArray(array);
                    break;
                case 3:
                    outputArray(array);
                    break;
                case 4:
                    inverseOutputArray(array);
                    break;
                case 5:
                    searchDiv(array);
                    break;
                case 6:
                    evenElements(array);
                    break;
                case 7:
                    outputMenu();
                    break;
                case 0:
                    System.out.print("��������� ���������\n");
                    break;
                default:
                    System.out.print("������� ������� �������!\n");
                  
                
                    
            }
    
        } while(command != 0);
    }         
    
    // ����� ����
    public static void outputMenu()
    {
        System.out.println("���� ���������:\n"
                + "1  �������� ��������� ����������� �������\n"
                + "2  �������������� ���������� �������\n"
                + "3  ����� �������\n"
                + "4  �������� ����� �������\n"
                + "5  ����������� ���������� ��������� ������ ��������� ��������\n"
                + "6  ����� ������ ���������  �������\n"
                + "7  ��������� ����� ����\n"
                + "0  ���������� ���������\n");
    }
    
    // ����� �������� ��������� ����������� �������
    public static short[] createArray(short[] array)
    {
        int size;
        size = (int) (Math.random() * (20 - 10) + 10);
        array = new short[size];
        System.out.print("������ ������� ������\n");
        return array;
    }
    
    // ����� �������������� ���������� �������
    public static void autoInputArray(short[] array)
    {
        if (array != null)
        {
            for (int index = 0; index < array.length; index++)
            {
                array[index] = (short) (Math.random() * 10);
            }
            System.out.print("������ �������� ���������� �������\n");
        }
        else System.out.print("������ �� �����\n");
    }
    
    // ����� ������ �������
    public static void outputArray(short[] array)
    {
        System.out.print(Arrays.toString(array));// ����� ������ �������
    }
    
    // ����� ��������� ������ �������
    public static void inverseOutputArray(short[] array)
    {
        if(array != null)
        {
            int temp = 0;
            int size = array.length - 1;
            short[] array2 = null;
            array2 = new short[array.length];
            for (int index = size; index >= 0; index --)
            {
                array2[temp] = array[index];
                temp++;
            }
            System.out.print(Arrays.toString(array2));
        }
        else System.out.print("������ �� ������");
    }
    
    // ����� ����������� ���������� ���������,������� ��������� ��������
    public static void searchDiv(short[] array)
    {
        if (array != null)
        {
            int firstCount = 0, lastCount = 0;
            final Random random = new Random();
            int number = random.nextInt(10);
            System.out.print("��������� �����: " + number);
            for (int index = 0; index < array.length; index++)
            {
                for (short value = 1; value < array[index]; value++)
                {
                    if((array[index]/value) == 0) firstCount++;
                }
                if (firstCount < number) lastCount++;
            }
            if (lastCount > 0) System.out.print("���������� ���������,������� ������� ������ ��������� �����: " + lastCount + "\n");
            else System.out.print("����� ��������� ���\n");
        }
        else System.out.print("������ �� ������\n");
    }
    
    // ����� �������� ����� �� ��������
    public static boolean checkEven(int value)
    {
        int residue = 0;
        value = Math.abs(value);
        while (value != 0)
        {
            residue = value % 10;
            value = value / 10;
        }
        if ((residue % 2) == 0) return true;
        else return false;
    }
    
    // ����� ������ ������ ������ ��������� �������
    public static void evenElements(short[] array)
    {
        if(array != null)
        {    
            int temp = 0;
            for (int firstIndex = 0; firstIndex < array.length; firstIndex++)
            {
                if(checkEven(array[firstIndex]) == true)
                    temp++;
            }
            if(temp != 0){
                short[] arrayEven = new short[temp];
                int lastIndex = 0;
                for (int firstIndex = 0; firstIndex < array.length; firstIndex++)
                {
                    if(checkEven(array[firstIndex]))
                    {
                        arrayEven[lastIndex] = array[firstIndex];
                        lastIndex++;
                    }
                }
                array = arrayEven;
                outputArray(array);
                
            }
            else System.out.print("� ������� ���� ������ ��������� \n");
        }
        else System.out.print("������ �� ������\n");
    }
}

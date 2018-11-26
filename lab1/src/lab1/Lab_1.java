package lab1;

// Импорт классов
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

// Основной класс
public class Lab_1 
{
    // Главный метод
    public static void main(String[] args) {
        int command;
        short[] array = null;
        Scanner input = new Scanner(System.in);
        outputMenu();//Выведение меню
        do
        {
            System.out.print("\nВведите команду: ");
            command = input.nextInt();
            switch (command)
            { 
                case 1:
                    array = createArray(array); 
                    break;
                case 2:
                    inputArray(array);
                    break;
                case 3:
                    autoInputArray(array);
                    break;
                case 4:
                    outputArray(array);
                    break;
                case 5:
                    inverseOutputArray(array);
                    break;
                  case 6:
                    searchDiv(array);
                    break;
                case 7: 
                    evenElements(array);
                    break;
                case 8: 
                    outputMenu();
                    break;
                case 0:
                    System.out.print("Программа завершена");
                    break;
                default:
                    System.out.print("Неверно введена команда!\n");
            }
        } while (command != 0);
    }
    
    // Метод вывода меню
    public static void outputMenu()
    {
        System.out.print("Меню программы:\n"
                + "1  Создание массива\n"
                + "2  Заполнение массива\n"
                + "3  Автоматическое заполнение массива\n"
                + "4  Вывод массива\n"
                + "5  Обратный вывод массива\n"
                + "6  Определение количества делителей меньше заданного значения\n"
                + "7  Вывод четных элементов  массива\n"
                + "8  Повторный вывод меню\n"
                + "0  Завершение программы\n");
    }
    
    // Метод создания массива
    public static short[] createArray(short[] array)
    {
        int size;
        Scanner input = new Scanner(System.in);
        // 
        System.out.print("Введите длину массива: ");
        size = input.nextInt();
        // 
        if (size > 0)
        {
            array = new short[size];
            System.out.print("Массив успешно создан\n");
        }
        else System.out.print("Введено недопустимое значение!\n");
        return array;
    }
    
    // Метод заполнения массива
    public static void inputArray(short[] array)
    {
        if (array != null)
        {
            Scanner input = new Scanner(System.in);
            System.out.print("Введите элементы массива: ");
            for (int index = 0; index < array.length; index++)
            {
                array[index] = input.nextShort();
            }
        }
        else System.out.print("Массив не создан\n");
    }
    
    // Метод заполнения массива случайными числами
    public static void autoInputArray(short[] array)
    {
        if (array != null)
        {
            for (int index = 0; index < array.length; index++)
            {
            array[index] = (short) (Math.random() * 10);
            }
            System.out.print("Массив заполнен случайными числами!\n");
        }
        else System.out.print("Массив не создан\n");
    }
    
    // Метод вывода массива
    public static void outputArray(short[] array)
    {
        if (array != null)
        {
            System.out.print("Элементы массива: ");
            for (int index = 0; index < array.length; index++)
            {
                if (index != 0) System.out.print(", ");
                System.out.print(array[index]);
            }
            System.out.print("\n");
        }
        else System.out.print("Массив не создан\n");
    }
    
    // Метод обратного вывода массива
    public static void inverseOutputArray(short[] array)
    {
        if (array != null)
        {
            int size = array.length - 1;
            System.out.print("Элементы массива: ");
            for (int index = size; index >= 0; index--)
            {
                if (index != size) System.out.print(", ");
                System.out.print(array[index]);
            }
            System.out.print("\n");
        }
        else System.out.print("Массив не создан\n");
    }
    
    // Метод поиска количества делителей, у котрых количество делителей меньше заданного числа
    public static void searchDiv(short[] array)
    {
        if (array != null)
        {
            int firstCount = 0, lastCount = 0;
            Scanner input = new Scanner(System.in);
            System.out.print("Введите число: ");
            short number = input.nextShort();//Ввод числа
            for (int index = 0; index < array.length; index++)
            {
                for (short value = 1; value < array[index]; value++)
                {
                    if((array[index]/value) == 0) firstCount++;
                }
                if (firstCount < number) lastCount++;
            }
            if (lastCount > 0) System.out.print("Количество элементов,дилтели которых меньше заданного числа: " + lastCount + "\n");
            else System.out.print("Таких элементов нет\n");
        }
        else System.out.print("Массив не создан\n");
    }
    
    // Метод проверки числа на чётность
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
    
    // Метод вывода только чётных элементов массива
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
            else System.out.print("В массиве нету чётных элементов \n");
        }
    }
}
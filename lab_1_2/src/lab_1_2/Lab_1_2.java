package lab_1_2;

// Импорт классов
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

// Основной класс
public class Lab_1_2 {

    // Главный метод
    public static void main(String[] args) 
    {
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
                    System.out.print("Программа завершена\n");
                    break;
                default:
                    System.out.print("Неверно введена команда!\n");
                  
                
                    
            }
    
        } while(command != 0);
    }         
    
    // Вывод меню
    public static void outputMenu()
    {
        System.out.println("Меню программы:\n"
                + "1  Создание случайной размерности массива\n"
                + "2  Автоматическое заполнение массива\n"
                + "3  Вывод массива\n"
                + "4  Обратный вывод массива\n"
                + "5  Определение количества делителей меньше заданного значения\n"
                + "6  Вывод четных элементов  массива\n"
                + "7  Повторный вывод меню\n"
                + "0  Завершение программы\n");
    }
    
    // Метод создания случайной размерности массива
    public static short[] createArray(short[] array)
    {
        int size;
        size = (int) (Math.random() * (20 - 10) + 10);
        array = new short[size];
        System.out.print("Массив успешно создан\n");
        return array;
    }
    
    // Метод автоматичского заполнения массива
    public static void autoInputArray(short[] array)
    {
        if (array != null)
        {
            for (int index = 0; index < array.length; index++)
            {
                array[index] = (short) (Math.random() * 10);
            }
            System.out.print("Массив заполнен случайными числами\n");
        }
        else System.out.print("Массив не созда\n");
    }
    
    // Метод вывода массива
    public static void outputArray(short[] array)
    {
        System.out.print(Arrays.toString(array));// Метод вывода массива
    }
    
    // Метод обратного вывода массива
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
        else System.out.print("Массив не создан");
    }
    
    // Метод определения количества делителей,меньших заданного значения
    public static void searchDiv(short[] array)
    {
        if (array != null)
        {
            int firstCount = 0, lastCount = 0;
            final Random random = new Random();
            int number = random.nextInt(10);
            System.out.print("Случайное число: " + number);
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
        else System.out.print("Массив не создан\n");
    }
}

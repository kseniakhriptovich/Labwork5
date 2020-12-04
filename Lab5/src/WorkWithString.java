//меню:
//        а) Чтение текста из файла (исходного).
//        б) Редактирование текста исходного файла (добавление текста в начало файла, добавление текста в конец файла, добавление текста в произвольную позицию в файле).
//        в) Выполнение действий над текстом.
//        Определить, содержит ли текст слова «Java» и «Hello», и определить их количество.
//        г) Запись текста в файл.
//        д) Выход.

import java.io.*;
import java.nio.charset.StandardCharsets;

    public class WorkWithString {
        String data;
        String filename;
        String choice;
        String choice2;
        RandomAccessFile fio;
        BufferedReader in;

        public WorkWithString() throws UnsupportedEncodingException {
            this.in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
            //создание объекта класса BufferedReader
        }

        public void runConsole() throws IOException {
            while (true) {
                printMenu();
                choice = in.readLine(); //ввод выбранного пункта меню
                if (choice.compareTo("1") == 0) {//сравнение выбранного пользователем пункта меню
                    //textIntoFile(); //вызов метода ввода текста и записи его в файл
                    textFromFile(); //вызов метода чтения текста из исходного файла
                    continue;
                } else if (choice.compareTo("3") == 0) {
                    textExamined();
                    continue;
                } else if (choice.compareTo("4") == 0) {
                    textIntoFile();
                    continue;
                } else if (choice.compareTo("5") == 0) {
                    return; //выход из программы
                } else if (choice.compareTo("2") == 0) {
                    printRedactMenu(); //вызов метода вывода возможных действий редактирования текста на экран
                    choice2 = in.readLine();
                } //вызов метода вывода возможных действий редактирования текста на экран
                if (choice2.compareTo("1") == 0) {
                    addStart(); //вызов метода добавления текста в начало файла
                    continue;
                } else if (choice2.compareTo("2") == 0) {
                    addEnd();
                    continue;
                } else if (choice2.compareTo("3") == 0) {
                    addRandom(); //вызов метода добавления текста в указаную позицию в файле
                    continue;
                }
            }
        }

        public void printMenu() { //метод вывода меню на экран
            System.out.println("Введите ваш выбор:");
            System.out.println("1. Прочитать текст из файла (исходного)");
            System.out.println("2. Редактировать текст в файле");
            System.out.println("3. Определить, содержит ли текст слова «Java» и «Hello», и определить их количество");
            System.out.println("4. Запись текста в файл");
            System.out.println("5. Выход");
        }

        public void textFromFile() throws IOException { //метод чтения текста из файла и определение количества гласных, пробелов и общего количества букв
            System.out.println("Введите имя файла:");
            filename = in.readLine(); //ввод имени файла, которое следует вводить учитывая расширение, например text.txt
            fio = new RandomAccessFile(new File("C:\\Documents\\1.txt"), "r");
            data = fio.readLine();//чтение информации из заданного файла
            fio.close();
            System.out.println("Информация из файла: " + data);//вывод информации из файла
        }


        public static void printRedactMenu() { //метод вывода возможных действий редактирования текста на экран
            System.out.println("Выберите действие:");
            System.out.println("1 - добавление текста в начало файла");
            System.out.println("2 - добавление текста в конец файла");
            System.out.println("3 - добавление текста в произвольную позицию в файле");
        }

        public void addStart() throws IOException { ////метод добавления текста в начало файла
            System.out.println("Введите имя файла:");
            filename = in.readLine(); //ввод имени файла, которое следует вводить учитывая расширение, например text.txt
            fio = new RandomAccessFile(new File("C:\\Documents\\1.txt"), "rw");
            data = fio.readLine();//чтение информации из заданного файла
            System.out.println("Введите строку для добавления в начало:");
            String s;
            s = in.readLine(); //ввод строки
            fio.seek(0); //переход в начало файла
            fio.writeBytes(s); //запись введённой строки
            fio.seek(s.length()); //переход в конец записанной строки
            fio.writeBytes(data); //запись исходного текста после введённой строки
            fio.close();
            System.out.println("Строка записана в начало файла.");
        }

        public void addEnd() throws IOException {
            System.out.println("Введите имя файла:");
            filename = in.readLine(); //ввод имени файла, которое следует вводить учитывая расширение, например text.txt
            fio = new RandomAccessFile(new File("C:\\Documents\\1.txt"), "rw");
            data = fio.readLine();//чтение информации из заданного файла
            System.out.println("Введите строку для добавления в конец:");
            String s;
            s = in.readLine(); //ввод строки
            fio.seek(fio.length()); //переход в конец файла
            fio.writeBytes(s); //запись введённой строки в конец файла
            fio.close();
        }

        public void addRandom() throws IOException {
            System.out.println("Введите имя файла:");
            filename = in.readLine(); //ввод имени файла, которое следует вводить учитывая расширение, например text.txt
            fio = new RandomAccessFile("1.txt", "rw");
            data = fio.readLine();//чтение информации из заданного файла
            System.out.println("Введите строку для добавления в конец:");
            String s;
            s = in.readLine(); //ввод строки
            System.out.println("Введите необходимую позицию в файле:");
            int n;
            n = Integer.parseInt(in.readLine()); //ввод позиции
            fio.seek(n); //смещение на n позицию в файле
            data = fio.readLine();
            fio.seek(n);
            fio.writeBytes(s); //запись введённой строки с позиции n
            fio.writeBytes(data); //запись прочитанного с позиции n текста после введенной строки
            fio.close();
            System.out.println("Строка записана в файл.");
        }

        public void textExamined() throws IOException {
            System.out.println("Введите имя файла:");
            filename = in.readLine(); //ввод имени файла, в котором следует выполнить задание
            fio = new RandomAccessFile(new File("C:\\Documents\\1.txt"), "r");
            data = fio.readLine();//чтение информации из заданного файла
            String pattern1 = "Java";
            String pattern2 = "Hello";
            System.out.println("Количество попаданий слова \"Java\" в тексте: ");
            System.out.println(substringCount1(data, pattern1));
            System.out.println("Количество попаданий слова \"Hello\" в тексте: ");
            System.out.println(substringCount2(data, pattern2));
            fio.close();
        }

        public static int substringCount1(String data, String pattern1) {
            int result1 = 0;
            for (int i = 0; i < data.length()-pattern1.length()+1; i++) {
                if (data.substring(i, i + pattern1.length()).equalsIgnoreCase(pattern1)) {
                    result1++;
                    i += pattern1.length() - 1;
                }
            }
            return result1;
        }
        public static int substringCount2(String data, String pattern2) {
            int result2 = 0;
            for (int i = 0; i < data.length()-pattern2.length()+1; i++) {
                if (data.substring(i, i + pattern2.length()).equalsIgnoreCase(pattern2)) {
                    result2++;
                    i += pattern2.length() - 1;
                }
            }
            return result2;
        }


        public void textIntoFile() throws IOException { //метод ввода текста и записи его в файл
            System.out.println("Введите текст:");
            data = in.readLine(); //ввод текста
            System.out.println("Введите имя файла:");
            filename = in.readLine(); //ввод имя файла, которое следует вводить учитывая расширение, например text.txt
            fio = new RandomAccessFile(new File("C:\\Documents\\1.txt"), "rw"); //создание файла с заданным именем
            fio.writeBytes(data); //запись текста в заданный файл
            fio.close();
            System.out.println("Ваш текст сохранён.");
        }

        public static void main(String[] args) throws IOException {
            WorkWithString n = new WorkWithString(); //создание объекта класса WorkWithString
            n.runConsole(); //вызов метода, выполняющего действия над файлом и строкой
        }
    }


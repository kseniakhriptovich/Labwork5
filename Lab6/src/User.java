/*Разработать приложение с 5 (минимум) элементами управления библиотеки Swing
(кнопка (JButton), список (JList), текстовое поле (JTextField), раскрывающий список (JComboBox), текстовая область (JTextArea), флажок (JCheckBox), радиокнопки (JRadioButton), лэйбл (JLabel)) исходя из задания вариантов.
Подгрузку данных осуществлять из файла (при необходимости), сохранять данные также в файл. Обязательна реализация механизма закрытия окна. Также можно использовать систему подсветки данных, при желании.*/
//10.	Регистрация поступлений в продуктовый магазин (учесть дату поступления).

public class User {
    public static void main(String[] args) {
        Reader product = new Reader("Поступления в продуктовый магазин");
        product.setVisible (true);
        product.setResizable (false);
        product.setLocationRelativeTo(null);
    }
}

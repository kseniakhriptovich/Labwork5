import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Reader {
    JButton addButton, deleteButton, clearButton, searchButton;
    static JTextField newName;
    static JTextField newArticle;
    static JTextField newModel;
    static JTextField newProducer;
    static JTextField newColor;
    static JTextField newSize;
    static JTextField newDate;
    static JTextField newPrice;
    static JLabel l1, l2, l3, l4, l5, l6, l7, l8;

    JFrame jFrame;
    JPanel panelButton, panelButton1;
    JTable wthTable;

    ClothingStoreTableModel tableModel;
    ClothingStore g = null, g1 = null, g2 = null, g3 = null;

    public Reader() {
        jFrame = new JFrame("Магазин одежды");
        jFrame.setSize(new Dimension(600, 400));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new BorderLayout());

        addButton = new JButton("Добавить");
        Color c1 = new Color(164, 210, 213);
        addButton.setBackground(c1);
        addButton.addActionListener(new AddActionListener());
        deleteButton = new JButton("Удалить");
        Color c2 = new Color(214, 168, 165);
        deleteButton.setBackground(c2);
        deleteButton.addActionListener(new DeleteActionListener());

        clearButton = new JButton("Очистить");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.clear();
                tableModel.fireTableDataChanged();
            }
        });
        Color c3 = new Color(169, 166, 215);
        clearButton.setBackground(c3);

        searchButton = new JButton("Поиск по наименованию");
        searchButton.addActionListener(new SearchActionListener());
        Color c4 = new Color(213, 216, 166);
        searchButton.setBackground(c4);

        tableModel = new ClothingStoreTableModel();
        wthTable = new JTable(tableModel);
        jFrame.add(new JScrollPane(wthTable), BorderLayout.CENTER);
        jFrame.setVisible(true);

        try {
            g =  new ClothingStore("Юбка", "В-4785", "-карандаш", "Польша", "чёрный", "XS", "11.2018", "43 р.");
            g1 = new ClothingStore("Кардиган", "Р-603", "жакет", "Китай", "бежевый", "XXL", "08.2020", "85 p.");
            g2 = new ClothingStore("Джинсы", "Н-6785", "клёш", "Китай", "светлый голубой", "S, M", "04.2020", "63 р.");
            g3 = new ClothingStore("Джинсы", "Н-7878", "скинни", "Турция", "чёрный", "XS, S", "04.2018", "25 р.");
        } catch (MyException myException) {
            myException.getException();
        }
        tableModel.addData(g);
        tableModel.addData(g1);
        tableModel.addData(g2);
        tableModel.addData(g3);

        newName = new JTextField(15);
        newArticle = new JTextField(15);
        newModel = new JTextField(15);
        newProducer = new JTextField(15);
        newColor = new JTextField(15);
        newSize = new JTextField(15);
        newDate = new JTextField(15);
        newPrice = new JTextField(15);

        l1 = new JLabel("Наименование товара");
        l2 = new JLabel("Артикул");
        l3 = new JLabel("Модель");
        l4 = new JLabel("Производитель");
        l5 = new JLabel("Цвет");
        l6 = new JLabel("Размер");
        l7 = new JLabel("Дата выпуска");
        l8 = new JLabel("Цена");

        panelButton = new JPanel();
        panelButton.setLayout(new GridLayout());

        panelButton.add(addButton);
        panelButton.add(searchButton);
        panelButton.add(deleteButton);
        panelButton.add(clearButton);
        panelButton.setVisible(true);
        jFrame.add(panelButton, BorderLayout.SOUTH);

        panelButton1 = new JPanel();
        panelButton1.setLayout(new BoxLayout(panelButton1, BoxLayout.Y_AXIS));

        panelButton1.add(l1);
        panelButton1.add(newName);
        panelButton1.add(l2);
        panelButton1.add(newArticle);
        panelButton1.add(l3);
        panelButton1.add(newModel);
        panelButton1.add(l4);
        panelButton1.add(newProducer);
        panelButton1.add(l5);
        panelButton1.add(newColor);
        panelButton1.add(l6);
        panelButton1.add(newSize);
        panelButton1.add(l7);
        panelButton1.add(newDate);
        panelButton1.add(l8);
        panelButton1.add(newPrice);

        panelButton.setVisible(true);
        jFrame.add(panelButton1, BorderLayout.WEST);
        jFrame.pack();
    }

    public class SearchActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String searchInfo = JOptionPane.showInputDialog(null, "Введите название одежды",
                    "Поиск информацию о погоде", JOptionPane.QUESTION_MESSAGE);
            ArrayList<ClothingStore> similarArrayList = tableModel.findSimilar(searchInfo);
            SimilarData similarData = new SimilarData(similarArrayList);
            similarData.setVisible(true);
            similarData.setLocationRelativeTo(null);
        }
    }

    public class AddActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = newName.getText();
            String article = newArticle.getText();
            String model = newModel.getText();
            String producer = newProducer.getText();
            String color = newColor.getText();
            String size = newSize.getText();
            String date = newDate.getText();
            String price = newPrice.getText();


            try {
                tableModel.addData(new ClothingStore(name, article, model, producer, color, size, date, price));
            } catch (MyException myException) {
                myException.getException();
            }

            tableModel.fireTableDataChanged();
            newName.setText("");
            newArticle.setText("");
            newModel.setText("");
            newProducer.setText("");
            newColor.setText("");
            newSize.setText("");
            newDate.setText("");
            newPrice.setText("");
        }

    }

    public class DeleteActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int i = wthTable.getSelectedRow();
            if (i >= 0) {
                tableModel.removeRow(i);
                tableModel.fireTableDataChanged();
            } else
                JOptionPane.showMessageDialog(null, "Выберите строку для удаления", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}
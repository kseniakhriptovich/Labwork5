import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SimilarData extends JFrame{
    JTable similarTable;
    ClothingStoreTableModel model;

    public SimilarData(ArrayList<ClothingStore> similarArrayList)
    {
        super("Наименование одежды");
        setSize(new Dimension(600, 200));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        model = new ClothingStoreTableModel();
        similarTable = new JTable(model);
        add(new JScrollPane(similarTable), BorderLayout.CENTER);
        for(int i = 0; i <  similarArrayList.size();i++)
        {
            model.addData(similarArrayList.get(i));
        }
    }
}
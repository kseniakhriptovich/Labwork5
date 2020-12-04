import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;

public class ClothingStoreTableModel extends AbstractTableModel
{

    private int columnCount = 8;
    private ArrayList<ClothingStore> dataArrayList;

    public ClothingStoreTableModel()
    {
        dataArrayList = new ArrayList();
    }
    @Override
    public int getRowCount()
    {
        return dataArrayList.size();
    }

    public ClothingStore getRow(int i)
    {
        return dataArrayList.get(i);
    }

    @Override
    public int getColumnCount()
    {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        ClothingStore rows = dataArrayList.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return rows.getName();
            case 1: return rows.getArticle();
            case 2: return rows.getModel();
            case 3: return rows.getProducer();
            case 4: return rows.getColor();
            case 5: return rows.getSize();
            case 6: return rows.getDate();
            case 7: return rows.getPrice();


        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Наименование товара";
            case 1:
                return "Артикул";
            case 2:
                return "Модель";
            case 3:
                return "Производитель";
            case 4:
                return "Цвет";
            case 5:
                return "Размер";
            case 6:
                return "Дата выпуска";
            case 7:
                return "Цена";
        }
        return "";
    }

    public void addData(ClothingStore row)
    {
        dataArrayList.add(row);
        Collections.sort(dataArrayList);
    }

    public  ArrayList<ClothingStore> findSimilar(String city)
    {
        ArrayList<ClothingStore>  similarArrayList = new ArrayList();
        for(int i = 0; i < dataArrayList.size(); i++)
        {
            ClothingStore row = dataArrayList.get(i);
            String currBrand = row.getName();
            if (currBrand.equals(city))
            {
                similarArrayList.add(row);
            }
        }
        return similarArrayList;
    }

    public void clear()
    {
        dataArrayList.clear();
    }

    public void removeRow(int i)
    {
        dataArrayList.remove(i);
    }
}

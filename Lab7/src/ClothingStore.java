public class ClothingStore implements Comparable<ClothingStore>
{

    private String name;
    private String article;
    private String model;
    private String producer;
    private String color;
    private String size;
    private String date;
    private String price;


    public ClothingStore(String name, String article, String model, String producer, String color, String size, String date, String price) throws MyException
    {
        if(name.isEmpty()) throw new MyException("Ошибка ввода!");
        this.name = name;

        if(article.isEmpty()) throw new MyException ("Ошибка ввода!");
        this.article = article;

        if(model.isEmpty()) throw new MyException("Ошибка ввода!");
        this.model = model;

        if(producer.isEmpty()) throw new MyException ("Ошибка ввода!");
        this.producer = producer;

        if(color.isEmpty()) throw new MyException ("Ошибка ввода!");
        this.color = color;

        if(color.isEmpty()) throw new MyException ("Ошибка ввода!");
        this.size = size;

        if(color.isEmpty()) throw new MyException ("Ошибка ввода!");
        this.date = date;

        if(price.isEmpty()) throw new MyException ("Ошибка ввода!");
        this.price = price;
    }


    public String getName()
    {
        return name;
    }

    public String getArticle()
    {
        return article;
    }

    public String getModel()
    {
        return model;
    }

    public String getProducer()
    {
        return producer;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArticle (String article) {
        this.article = article;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    @Override
    public int compareTo(ClothingStore o) {
        return this.name.compareTo(o.name);
    }
}


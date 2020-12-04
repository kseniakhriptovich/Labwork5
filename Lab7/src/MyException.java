import javax.swing.*;

public class MyException extends Exception {
    private String exception;

    public MyException (String i)
    {
        exception = i;
    }

    public void getException()
    {
        JOptionPane.showMessageDialog(null, this.exception, "Ошибка!", JOptionPane.ERROR_MESSAGE);
    }
}

import java.sql.SQLException;

import bean.MedicosBean;
import controller.MedicosController;
import database.PostgreConnection;

//@SpringBootApplication
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PostgreConnection postgreConn = new PostgreConnection();
        MedicosController medTeste = new MedicosController(postgreConn);
        MedicosBean bean = (MedicosBean) medTeste.select(1);
        System.out.println(bean.getNome());
    }
}

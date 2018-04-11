package model.DAO;

import java.util.ArrayList;
import java.util.List;
import model.MyBatisUtils;
import model.pojos.Clase;
import org.apache.ibatis.session.SqlSession;

/**
 * Acceso de Datos de Clases para MySQL
 * @author Daniela Hernandez
 * @since 08/04/2018
 * @version 1.1
 */
public class ClaseDAO {
    /**
     * Busca todos las Clases almacenadas
     * @return Lista de Clases encontradas
     */
    public static List<Clase> getAllClases() {
        List<Clase> lista = new ArrayList<Clase>();
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            lista = conn.selectList("Clase.getAllClases");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return lista;
    }

    /**
     * Se almacena una nueva Clase en la BD
     * @param Clase Objeto Clase para registrar
     * @return Confirmación de registro exitoso de la Clase
     */
    public static boolean registrar(Clase clase) {
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            conn.insert("Clase.registrar", clase);
            conn.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    /**
     * Se actualiza una Clase ya registrada en la BD
     * @param Clase Objeto Clase con un idClase definido
     * @return Confirmación de actualizacion exitosa de la Clase
     */
    public static boolean actualizar(Clase clase) {
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            conn.update("Clase.actualizar", clase);
            conn.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    /**
     * Se elimina una Clase de la BD a partir de su idClase
     * @param idClase Identificador de una Clase ya registrada en la BD
     * @return Confirmación de eliminado exitoso de la Clase
     */
    public static boolean eliminar(int idClase) {
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            conn.delete("Clase.eliminar", idClase);
            conn.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }
}

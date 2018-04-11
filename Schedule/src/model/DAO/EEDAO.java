package model.DAO;

import java.util.ArrayList;
import java.util.List;
import model.MyBatisUtils;
import model.pojos.EE;
import org.apache.ibatis.session.SqlSession;

/**
 * Acceso de Datos de Experiencias Educativas para MySQL
 * @author Daniela Hernandez Valenzuela
 * @since 07/04/2018
 * @version 1.1
 */
public class EEDAO {
    /**
     * Busca todas las Experiencias Educativas almacenadas
     * @return Lista de las Experiencias Educativas encontradas
     */
    public static List<EE> getAllEEs() {
        List<EE> lista = new ArrayList<EE>();
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            lista = conn.selectList("EE.obtener");
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
     * Se almacena una nueva Experiencia Educativa en la BD
     * @param EE Objeto EE para registrar
     * @return Confirmación de registro exitoso de la Experiencia Educativa
     */
    public static boolean registrar(EE ee) {
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            conn.insert("EE.registrar", ee);
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
     * Se actualiza una Experiencia Educativa ya registrada en la BD
     * @param EE Objeto EE con un idEE definido
     * @return Confirmación de actualizacion exitosa de la Experiencia Educativa
     */
    public static boolean actualizar(EE ee) {
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            conn.update("EE.actualizar", ee);
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
     * Se elimina un Experiencia Educativa de la BD a partir de su idEE
     * @param idEE Identificador de un EE ya registrado en la BD
     * @return Confirmación de eliminado exitoso de la Experiencia Educativa
     */
    public static boolean eliminar(int idEE) {
        SqlSession conn = null;
        try {
            conn = MyBatisUtils.getSession();
            conn.delete("EE.eliminar", idEE);
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

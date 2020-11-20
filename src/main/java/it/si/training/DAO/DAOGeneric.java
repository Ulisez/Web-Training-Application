package it.si.training.DAO;

import java.util.List;

/**
 * @author Ulises Ezequiel
 * Interfaccia parametrizzata che definisce i metodi crud base
 * che ogni interfaccia DAO deve possodere
 * @param <T>
 */
public interface DAOGeneric<T> {

    /**
     *
     * @param element definisce l'oggetto da salvare nel database
     * @return
     */

    public void save(T element);

    /**
     * Elimina dalla base diti l'oggetto il cui id corrisponde con quello passato come parametro
     * @param id id dell'oogetto da eliminare
     */
    public void delete (Long id);

    /**
     * Aggiornare i dati dell'oogetto passato come parametro
     * @param element
     */
    public void update(T element);

    /**
     * Restituisce la lista con tutti gli oggetti
     * @return la lista degli elementi di tipo T
     */
    List<T> findAll();

}

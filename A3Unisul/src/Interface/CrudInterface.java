
package Interface;

import java.util.ArrayList;


public interface CrudInterface<T> {
   boolean cadastrar(T object);
   ArrayList<T> buscar();
   boolean editar(Long id, T object);
   boolean excluir(Long id);
    
}

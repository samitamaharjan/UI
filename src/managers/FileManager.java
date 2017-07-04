package managers;
import java.util.List;

public interface FileManager<T> {
	public List<T> findAll();
	public T findByPrimaryKey(String id);
	public void insert(T t);
	public void clean();
	public void delete(String id);
	//public void edit(T t);
}

package DAO;
import java.util.List;

import Model.History;
public interface HistoryDAO {
	public List<History> getAll(String username);
}

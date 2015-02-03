package newssystem.socket.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public abstract class Repository<T> {
	private DbConnection connection;
	
	public Repository() {
		this.connection = DbConnection.getInstance();
	}

	protected Collection<T> all(String sql) {
		
		Collection<T> items = new ArrayList<T>();
		ResultSet set = connection.executeQuery(sql);
		try {
			while (set.next()) {
				  T item = readValues(set);
				  items.add(item);
				  set.getStatement().close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return items;	
	}
        
        protected ArrayList<String> get_col_data(String sql, String col_name) {
		
		ArrayList<String> names = new ArrayList<String>();
		ResultSet set = connection.executeQuery(sql);
                try {
			while (set.next()) {
                                String name = set.getString(col_name);
				names.add(name);
				  
			}set.getStatement().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return names;	
	}
	
	public T get(String sql) {
		T item = null;
		ResultSet set = connection.executeQuery(sql);
		try {
			if (set.next()) {
				item = this.readValues(set);
			}
			set.getStatement().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return item;
	}
	
	public void save(String sql) {
		connection.execute(sql);
	}

	public abstract Collection<T> all();
	
	public abstract T get(int id);
	
	abstract T readValues(ResultSet resultSet) throws SQLException;
	
	public abstract void save(T item);
}

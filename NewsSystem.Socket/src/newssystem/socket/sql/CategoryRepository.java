package newssystem.socket.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import newssystem.socket.models.Category;

public class CategoryRepository extends Repository<Category> {
	@Override
	public Collection<Category> all() {
	    return this.all("SELECT * FROM Categories;");
	}

	@Override
	public Category get(int id) {
		String sql = "SELECT * FROM Categories WHERE Id = " + id + ";";
		return this.get(sql);
	}
	
        public ArrayList<String> get_names(){
            ArrayList<String> names= new ArrayList<String>();
            String col="Name";
            String sql="SELECT "+col+" FROM Categories;";
            names=this.get_col_data(sql, col);
            return names;
        }
        
	@Override
	public void save(Category item) {
		String sql = null;
		if(item.getId() == 0) {
			sql = "INSERT INTO Categories (Name) VALUES ('" + item.getName() + "');";
		} else {
			sql = "UPDATE Categories SET Name = '" + item.getName() +
					"' WHERE Id = " + item.getId() + ";";
		}
		System.out.println(sql);
		this.save(sql);
	}
	
	@Override
	protected Category readValues(ResultSet resultSet) 
			throws SQLException {
		Category item = new Category();
		item.setId(resultSet.getInt("Id"));
		item.setName(resultSet.getString("Name")); 
		return item;
	}
}

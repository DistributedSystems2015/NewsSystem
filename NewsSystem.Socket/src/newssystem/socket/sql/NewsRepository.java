package newssystem.socket.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import newssystem.socket.models.News;

public class NewsRepository extends Repository<News> {
	@Override
	public Collection<News> all() {
		return this.all("SELECT * FROM News;");
	}

	@Override
	public News get(int id) {
		String sql = "SELECT * FROM News WHERE Id = " + id + ";";
		return this.get(sql);
	}
	
        public ArrayList<String> get_titles(){
            ArrayList<String> titles= new ArrayList<String>();
            String col="title";
            String sql="SELECT "+col+" FROM News;";
            titles=this.get_col_data(sql, col);
            return titles;
        }
        
	@Override
	public void save(News item) {
		String sql = null;
		if(item.getId() == 0) {
			sql = "INSERT INTO News (Title, CategoryId, Date, Content) " + 
		        " VALUES ('" + item.getTitle() + "', " + item.getCategoryId() + ", " +
					item.getDateAsLong() + ", '" + item.getContent() + "');";
		} else {
			sql = "UPDATE News SET Title = '" + item.getTitle() +
					"', CategoryId = " + item.getCategoryId() + ", Date = " +
					item.getDateAsLong() + ", Content = '" + item.getContent() +
					"' WHERE Id = " + item.getId() + ";";
		}
		System.out.println(sql);
		this.save(sql);
	}
	
	protected News readValues(ResultSet resultSet) throws SQLException {
		News item = new News();
		item.setId(resultSet.getInt("Id"));
		item.setTitle(resultSet.getString("Title"));
		item.setCategoryId(resultSet.getInt("CategoryId"));
		item.setDateAsLong(resultSet.getLong("Date"));
		item.setContent(resultSet.getString("Content")); 
		return item;
	}
}

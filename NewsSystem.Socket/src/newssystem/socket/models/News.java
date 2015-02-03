package newssystem.socket.models;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class News extends BaseModel  {
	@SerializedName("Title")
    public String title;
	
	@SerializedName("CategoryId")
    public int categoryId;
	
	@SerializedName("Date")
    public Date date;
	
	@SerializedName("Content")
    public String content;
    
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getCategoryId() {
		return this.categoryId;
	}
	
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public long getDateAsLong() {
		return this.date.getTime();
	}
	
	public void setDateAsLong(long dateAsLong) {
		this.date = new Date(dateAsLong);
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", title=" + title + ", categoryId="
            + categoryId + ", date=" + date + ", content=" + content;
	}
}

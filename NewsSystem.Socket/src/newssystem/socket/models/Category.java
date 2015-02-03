package newssystem.socket.models;

import com.google.gson.annotations.SerializedName;

public class Category extends BaseModel {
	@SerializedName("Name")
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;		
	}
	
	@Override
	public String toString() {
		return super.toString() + ", name=" + name;
	}
}

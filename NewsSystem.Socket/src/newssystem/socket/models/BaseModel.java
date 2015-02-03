package newssystem.socket.models;

import com.google.gson.annotations.SerializedName;

public abstract class BaseModel {
	@SerializedName("Id")
	private int id = 0;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;	
	}
	
	@Override
	public String toString() {
		return "id=" + id;
	}
}

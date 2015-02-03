package newssystem.socket.commnication;

import java.util.Map;

public class SocketRequest {
    public String entityType;
    
    public String method;
    
    public Map<String, Object> params;
    
	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}

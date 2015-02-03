package newssystem.socket.commnication;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;

import newssystem.socket.sql.CategoryRepository;
import newssystem.socket.sql.NewsRepository;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

public class NewsWorker implements Runnable {
	private Socket clientSocket = null;
	
	public NewsWorker(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	public void run() {
		try {
			while(true) {
			String requestJSON = this.getRequestJSON();
			SocketRequest request = this.getRequestFromJSON(requestJSON);
			String responseJSON = this.getResponseData(request);
			this.setResponseData(responseJSON);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getResponseData(SocketRequest request) {
		Object result = null;
		String entityType = request.getEntityType();
		String method = request.getMethod();
		if (entityType.equals("News")) {
	    	NewsRepository repository = new NewsRepository();
	    	if(method.equals("All")) {
	    		result = repository.all();
	    	} else if(method.equals("Get")){
	    		int id = ((Double)request.getParams().get("id")).intValue();
	    		result = repository.get(id);
	    	}
	    } else if (entityType.equals("Category")) {
	    	CategoryRepository repository = new CategoryRepository();
	    	if(method.equals("All")) {
	    		result = repository.all();
	    	} else if(method.equals("Get")){
	    		int id = ((Double)request.getParams().get("id")).intValue();
	    		result = repository.get(id);
	    	}
	    }
		
		Gson gson = new Gson();
		return gson.toJson(result);
	}
	
	private SocketRequest getRequestFromJSON(String json) {
		Gson gson = new Gson();
		LinkedTreeMap jsonObj = gson.fromJson(json , LinkedTreeMap.class);
		SocketRequest request = new SocketRequest();
		request.setEntityType((String)jsonObj.get("EntityType"));
		request.setMethod((String)jsonObj.get("Method"));
		request.setParams((Map)jsonObj.get("Params"));
		return request;
	}
	
	private String getRequestJSON() throws IOException {
		InputStream inputStream = this.clientSocket.getInputStream();
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    byte[] buffer = new byte[1024];
	    int available;
	    try {
	    	do {
	    		Thread.sleep(100);
		    	available = inputStream.available();
		    } while(available == 0);
	    	
		    int length = inputStream.read(buffer, 0, available);
		    baos.write(buffer, 0, length);
	    } catch (InterruptedException e) {
			e.printStackTrace();
		}
	    byte[] bytes = baos.toByteArray();
	    baos.flush();
		return new String(bytes, "UTF-8");
	}
	
	private void setResponseData(String str) throws IOException {
		OutputStream outputStream = this.clientSocket.getOutputStream();
		OutputStreamWriter osw =new OutputStreamWriter(outputStream, "UTF-8");
        osw.write(str, 0, str.length());
        osw.flush();
	}
}

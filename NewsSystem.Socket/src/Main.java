import java.util.Collection;
import java.util.Date;

import newssystem.socket.commnication.NewsServer;
import newssystem.socket.models.Category;
import newssystem.socket.models.News;
import newssystem.socket.sql.CategoryRepository;
import newssystem.socket.sql.NewsRepository;

public class Main {
	
	public static void main(String[] args) {
		NewsServer server = new NewsServer();
		server.run();
		
		//newsTests();
		//categoryTests();
	}
	
	private static void categoryTests() {
		CategoryRepository categoryRepository = new CategoryRepository();

		// Saving a new category;
		//Category itNewsCategory = new Category();
		//itNewsCategory.setName("IT news");
		//categoryRepository.save(itNewsCategory);
		
		// Update existing category
		//Category hardwareCategory = categoryRepository.get(2);
		//hardwareCategory.setName("Hardware");
		//categoryRepository.save(hardwareCategory);
		
		// Get all categories
		Collection<Category> categories = categoryRepository.all();
	    System.out.println(categories);
	}
	
	private static void newsTests() {
		NewsRepository newsRepository = new NewsRepository();

		// Saving a new news;
		News news1 = new News();
		news1.setTitle("Facebook �������� �� �������� ����������� �� ������� ���� Bing");
		news1.setCategoryId(1);
		@SuppressWarnings("deprecation")
		// Current year minus base year 1900, current month minus one month
		Date date = new Date(2014 - 1900, 12 - 1, 14, 11, 54, 0);
		news1.setDateAsLong(date.getTime());
		news1.setContent("Facebook ���� ���� �� ������ ��������� �� ���������� Bing, ���� " + 
		    "���� ��-���� ���� ������� ���������� ����� �������� �������� ��������� �� " + 
            "��������� �� ��������� � ����� �������� ����������. ����� Facebook, ���� � " + 
            "Microsoft ���������� ��������. ��������� � ������������ ����� �� ����� 1.35 " + 
            "�������� ������� �� Facebook, ����� ��������� �� ������� �� �������� ����������� " + 
            "� �������� ��� ���������� ���� �����.");
        //newsRepository.save(news1);
		
		News news3 = newsRepository.get(1);
		//System.out.println(news3);
		
		// Get all categories
		Collection<News> news = newsRepository.all();
	    System.out.println(news);
	}
}

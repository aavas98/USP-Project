package CSS;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Menu {
	public void MainMenu() {
		Scanner sc = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);
		int choice;
		System.out.println("Welcome to the Main Menu");
		System.out.println("1. Add a Vehicle");
		System.out.println("2. Vehicle List");
		System.out.println("3. Brand Listing");
		System.out.println("4. Model Listing");
		System.out.println("5. Year Listing");
		System.out.println("0. Exit Program");
		do {
			System.out.println("Select Option: ");
			choice = sc.nextInt();
		} while(choice < 0 || choice > 5);
		
		switch(choice) {
		case 1:
			AddVehicle();
			System.out.println("Vehicle Added to Database");
			MainMenu();
			break;
		case 2:
			VehicleList();
			MainMenu();
			break;
		case 3:
			BrandListing();
			MainMenu();
			break;
		case 4:
			ModelListing();
			MainMenu();
			break;
		case 5:
			YearListing();
			MainMenu();
			break;
		case 0:
			
			break;
	}
}
	public void AddVehicle() {
		String Brand, Model, Features;
		int Year;
		Scanner sc = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);
		System.out.println("Vehicle Brand: ");
		Brand = sc.next();
		System.out.println("Vehicle Model: ");
		Model = sc.next();
		System.out.println("Vehicle Release Year: ");
		Year = sc.nextInt();
		System.out.println("Vehicle Features: ");
		Features = sc.next();
		Car Car = new Car(Brand, Model, Year, Features);
		
	}
	
	public void VehicleList() {
		SessionFactory factory;
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		System.out.println("List of Vehicles");
		Query query = session.createQuery("FROM  Car");
	    List list = query.list();

	    for (int i = 0; i < list.size(); i++) {
	        System.out.println((i + 1) + ". " + list.get(i).toString());
	    }
	    t.commit();
		session.close();
		
	}
	
	public void BrandListing() {
		String Brand;
		Scanner scS = new Scanner(System.in);
		System.out.println("Search by Brand: ");
	    Brand = scS.next();
		SessionFactory factory;
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
	    Query query = session.createQuery("FROM  Car WHERE Brand = ?0");
	    query.setParameter(0, Brand);
	    List list = query.list();
	    
	    for	 (int i = 0; i < list.size(); i++) {
	    	(( Car ) list.get(i)).PrintCar();
	    }
	    
	    t.commit();
		session.close();		
	}
	
	public void ModelListing() {
		String Model;
		Scanner scS = new Scanner(System.in);
		System.out.println("Search by Model: ");
	    Model = scS.next();
		SessionFactory factory;
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
	    Query query = session.createQuery("FROM  Car WHERE Model = ?0");
	    query.setParameter(0, Model);
	    List list = query.list();
	    
	    for	 (int i = 0; i < list.size(); i++) {
	    	(( Car ) list.get(i)).PrintCar();
	    }
	    
	    t.commit();
		session.close();		
	}
	
	public void YearListing() {
		int Year;
		Scanner scS = new Scanner(System.in);
		System.out.println("Search by Model: ");
	    Year = scS.nextInt();
		SessionFactory factory;
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
	    Query query = session.createQuery("FROM  Car WHERE Year = ?0");
	    query.setParameter(0, Year);
	    List list = query.list();
	    
	    for	 (int i = 0; i < list.size(); i++) {
	    	(( Car ) list.get(i)).PrintCar();
	    }
	    
	    t.commit();
		session.close();		
	}
}

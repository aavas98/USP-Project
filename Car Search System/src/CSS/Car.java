package CSS;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="car_details")
public class Car {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int car_id;
	private String Brand;
	private String Model;
	private int Year;
	private String Features;
	
	public Car() {}
	
	public Car(String brand, String model, int year, String features) {
		Brand = brand;
		Model = model;
		Year = year;
		Features = features;
		try {
			SessionFactory factory;
			factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			session.save(this);
			t.commit();
			session.close();
		} catch (Exception E) {
			E.printStackTrace();
		}
	}
	
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public String getFeatures() {
		return Features;
	}
	public void setFeatures(String features) {
		Features = features;
	}
	@Override
	public String toString() {
		return "[ " +  Brand + " " + Model + " " + Year + " " + Features + " ]";
	}
	
	public void PrintCar() {
		System.out.println("[ " +  Brand + " " + Model + " " + Year + " " + Features + " ]");
	}
	

}

package cart.dto;

public class Car {
	private String carName;
	
	public Car() {}
	public Car(String carName) {
		super();
		this.carName = carName;
	}
	
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}

	@Override
	public String toString() {
		return "Car [carName=" + carName + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if( o instanceof Car) {
			Car car = (Car) o;
			if(this.carName.equals(car.carName)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return this.carName.hashCode();
	}
  
}

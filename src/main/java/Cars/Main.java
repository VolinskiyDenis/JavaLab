package Cars;

public class Main {
	public static void main(String[] args){
		Car bmw1 = new Car.Builder(Brand.BMW,"AC6776BM","X6",270)
				.setColor("red")
				.setOwner("Evgen Zaliznyak")
				.buidl();
		Car mercedes1 = new Car.Builder(Brand.Mercedes_Benz,"AO6009AB","Vito",280)
				.setColor("yellow")
				.setOwner("Ivan Semenyak")
				.buidl();
		Car audi1 = new Car.Builder(Brand.Audi,"AA4792BO","A6",260)
				.setColor("gray")
				.setCurrentSpeed(20)
				.setOwner("Denis Volinskiy")
				.buidl();
		Park park = new Park();
		ParkServiceStreamAPI parkServiceStreamAPI = new ParkServiceStreamAPI(park);
		parkServiceStreamAPI.addCar(bmw1);
		parkServiceStreamAPI.addCar(audi1);
		parkServiceStreamAPI.addCar(mercedes1);

		System.out.println("Comparable:\n" + parkServiceStreamAPI.streamSortByBrand());

		System.out.println("Comparator:\n"+ parkServiceStreamAPI.streamSortByMaxSpeed());

		Park clearPark = new Park(parkServiceStreamAPI.streamClearPark());
		ParkServiceStreamAPI clearParkService = new ParkServiceStreamAPI(clearPark);
		clearParkService.addCar(audi1);
		System.out.println("Clear and add one:\n" + clearParkService.getCars());
	}
}
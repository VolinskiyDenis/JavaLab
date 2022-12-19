package Cars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ParkServiceStreamAPI {
	private Park park;
	public ParkServiceStreamAPI(Park park){
		this.park=park;
	}

	public List<Car> getCars(){
		return park.getCars();
	}

	public boolean addCar(Car car){
		return park.getCars().add(car);
	}

	public List<Car> streamSortByBrand(){
		return park.getCars().stream().sorted().toList();
	}
	public List<Car> streamSortByMaxSpeed(){
		return park.getCars().stream().sorted(new MaxSpeedComparator()).toList();
	}
	public List<Car> streamClearPark(){
		List<Car> cars = new ArrayList<>();
		cars.addAll(park.getCars());
		Collection<Car> list = cars;
		list.clear();
		return cars;
	}
	public List<Car> streamFindByOwner (String owner){
		return park.getCars().stream().filter(x -> x.getOwner().equals(owner)).toList();
	}
}

package zsolt.example.jsontutorial;

public class Vehicle {
private long ID;
private String model;
private String lpn;
private String color;

public Vehicle(String model, String lpn, String color, long iD){
	this.model=model;
	this.lpn=lpn;
	this.color=color;
	ID=iD;
}

public Vehicle(String model, String lpn, String color){
	this.model=model;
	this.lpn=lpn;
	this.color=color;
}

public String getModel(){
	return model;
}

public void setModel(String model){
	this.model=model;
}

public String getLpn(){
	return lpn;
}

public void setLpn(String lpn){
	this.lpn=lpn;
}

public String getColor(){
	return color;
}

public void setColor(String color){
	this.color=color;
}

public long getID(){
	return ID;
}

public void setID(long iD){
	ID=iD;
}

@Override
public String toString() {
	return "Vehicle[Model=" + model + ", Lpn=" + lpn
			+ ", Color=" + color + "]";
   }
}

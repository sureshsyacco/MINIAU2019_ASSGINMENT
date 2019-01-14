package advanced_java_au_assignment;

public class Address {
	private String city,street;
	private int pin_code;
	
	
	//declaring properties as private and using getters and setters to get and set values to achieve\
	//data encapsulation and data abstraction
	public void setCity(String city)
	{
		this.city=city;
	}
	
	public void setStreet(String street)
	{
		this.street=street;
	}
	
	public void setPinCode(int pin)
	{
		this.pin_code=pin;
	}
	
	public String getCity()
	{
		return this.city;
	}
	
	public String getStreet()
	{
		return this.street;
	}
	
	public int getPinCode()
	{
		return this.pin_code;
	}

}

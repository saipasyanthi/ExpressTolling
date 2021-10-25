package demo;

public class LocationID {

	private String id;
	private String name;
	private Double lat;
	private Double lng;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LocationID [id=" + id + ", name=" + name + ", lat=" + lat + ", lng=" + lng + ", getName()=" + getName()
				+ ", getLat()=" + getLat() + ", getLng()=" + getLng() + ", getId()=" + getId() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}

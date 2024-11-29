package flyable;


public class Aircraft extends Flyable{
	
	@Override
	public void updateCondition() {
		System.out.println("call update condition");
	}

	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
	}

	public class Coordinates {
	
		private int longitude;
		private int latitude;
		private int height;
	
	
		private Coordinates(int longitude, int latitude, int height) {
			this.longitude = longitude;
			this.latitude = latitude;
			this.height = height;
		}	
	
		public int getLongitude() {
			return this.longitude;
		}
	
		public int getLatitude() {
			return this.latitude;
		}
	
		public int getHeight() {
			return this.height;
		}
	}
}

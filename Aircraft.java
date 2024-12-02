
public class Aircraft extends Flyable{
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected String type;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}

	@Override
	public void updateCondition() {
		System.out.println("call update condition");
	}

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
	}
}

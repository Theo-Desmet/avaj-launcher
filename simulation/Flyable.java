package simulation;
public abstract class Flyable {
	
	protected WeatherTower weatherTower;

	public abstract void updateCondition();
	public abstract String getName();
	public abstract String getType();
	public abstract long getId();

	public void registerTower(WeatherTower p_tower) {
		this.weatherTower = p_tower;
		p_tower.register(this);
	}

}
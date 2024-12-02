public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_Coordinates) {
		super(p_id, p_name, p_Coordinates);
	}

	public void updateCondition() {
		System.out.println("i'm fast");
	}
}
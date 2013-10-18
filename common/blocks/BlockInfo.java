package blocks;

public class BlockInfo {

	public static int MACHINE_ID;
	public static final String MACHINE_KEY = "Machine";
	
	/*
	 * Range
	 * from 0 - 4096
	 */
	public static final int MACHINE_DEFAULT = 2075;
	
	public static final String MACHINE_UNLOCALIZED_NAME = "sillyMachine";
	public static final String MACHINE_NAME = "Silly Machine";
	
	/*
	 * Enabled
	 */
	public static final String TEXTURE_LOCATION = "example";
	public static final String MACHINE_TOP = "machine_top";
	public static final String MACHINE_BOT = "machine_bottom";
	public static final String MACHINE_SIDES[] = {"machine_side", "machine_side_arrow", "machine_side_box", "machine_side_cross"};
	
	/*
	 * Disabled
	 */
	public static final String MACHINE_DISABLED = "machine_disabled";
}

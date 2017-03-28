package art.utils;

public class Version {

	private int minorVersion;
	private int majorVersion;
	private int build;

	// Version
	public static Version versionConstant = new Version(1, 1, 4);

	public Version(int minorVersion, int majorVersion, int build) {
		super();
		this.minorVersion = minorVersion;
		this.majorVersion = majorVersion;
		this.build = build;
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}

	public int getBuild() {
		return build;
	}

	public void setBuild(int build) {
		this.build = build;
	}

	@Override
	public String toString() {
		return "version: " + minorVersion + "." + majorVersion + "." + build;
	}

}

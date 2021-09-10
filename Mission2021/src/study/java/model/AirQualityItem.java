package study.java.model;

public class AirQualityItem {
	private String MSRSTE_NM = null;
	private double O3 = 0D;
	private int PM10 = 0;
	private int PM25 = 0;
	
	public AirQualityItem(String mSRSTE_NM, double o3, int pM10, int pM25) {
		super();
		MSRSTE_NM = mSRSTE_NM;
		O3 = o3;
		PM10 = pM10;
		PM25 = pM25;
	}
	public String getMSRSTE_NM() {
		return MSRSTE_NM;
	}
	public void setMSRSTE_NM(String mSRSTE_NM) {
		MSRSTE_NM = mSRSTE_NM;
	}
	public double getO3() {
		return O3;
	}
	public void setO3(float o3) {
		O3 = o3;
	}
	public int getPM10() {
		return PM10;
	}
	public void setPM10(int pM10) {
		PM10 = pM10;
	}
	public int getPM25() {
		return PM25;
	}
	public void setPM25(int pM25) {
		PM25 = pM25;
	}
	@Override
	public String toString() {
		return "AirQualityItem [MSRSTE_NM=" + MSRSTE_NM + ", O3=" + O3 + ", PM10=" + PM10 + ", PM25=" + PM25 + "]";
	}
	
	
	
	
	
	
}

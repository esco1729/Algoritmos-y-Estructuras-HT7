
public class ComparableAssociation<K, V> {
	String spanish;
	String english;
	String french;
	
	public String getSpanish() {
		return spanish;
	}
	
	public void setSpanish(String spanish) {
		this.spanish = spanish;
	}
	
	public String getEnglish() {
		return english;
		
	}
	
	public void setEnglish() {
		this.english = english;
	}
	
	public String getFrench() {
		return french;
	}
	
	public void  setFrench() {
		this.french = french;
	}
	
	
	public String toString1() {
		return getEnglish();
	}

	public String toString2() {
		return getFrench();
	}
}

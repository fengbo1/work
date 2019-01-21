package work.percl.pojo;
// default package

/**
 * Percl entity. @author MyEclipse Persistence Tools
 */
public class Percl extends AbstractPercl implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Percl() {
	}

	/** full constructor */
	public Percl(String time, Integer sumljcl, Integer sumljsxts, Double percl) {
		super(time, sumljcl, sumljsxts, percl);
	}

}

package work.percl.pojo;
// default package

/**
 * AbstractPercl entity provides the base persistence definition of the Percl
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPercl implements java.io.Serializable {

	// Fields

	private Integer id;
	private String time;
	private Integer sumljcl;
	private Integer sumljsxts;
	private Double percl;

	// Constructors

	/** default constructor */
	public AbstractPercl() {
	}

	/** full constructor */
	public AbstractPercl(String time, Integer sumljcl, Integer sumljsxts,
			Double percl) {
		this.time = time;
		this.sumljcl = sumljcl;
		this.sumljsxts = sumljsxts;
		this.percl = percl;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getSumljcl() {
		return this.sumljcl;
	}

	public void setSumljcl(Integer sumljcl) {
		this.sumljcl = sumljcl;
	}

	public Integer getSumljsxts() {
		return this.sumljsxts;
	}

	public void setSumljsxts(Integer sumljsxts) {
		this.sumljsxts = sumljsxts;
	}

	public Double getPercl() {
		return this.percl;
	}

	public void setPercl(Double percl) {
		this.percl = percl;
	}

}
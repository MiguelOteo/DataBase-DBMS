package db.pojos;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import java.sql.Date;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Biomaterial")
@XmlType(propOrder = {"biomaterial_id", "utility_id", "name_product", "price_unit", "available_units", "expiration_date", "maintenance_id"})
public class Biomaterial implements Serializable{

	private static final long serialVersionUID = 1L;

	@XmlTransient
	private Integer biomaterial_id;
	@XmlTransient
	private Integer utility_id;
	@XmlTransient
	private Integer maintenance_id;
	@XmlElement
	private String name_product;
	@XmlAttribute
	private Float price_unit;
	@XmlAttribute
	private Integer available_units;
	@XmlAttribute
	private Date expiration_date;
	
	
	public Biomaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Biomaterial(Integer utility_id, Integer maintenance_id, String name_product, Float price_unit,
			Integer available_units, Date expiration_date) {
		super();
		this.utility_id = utility_id;
		this.maintenance_id = maintenance_id;
		this.name_product = name_product;
		this.price_unit = price_unit;
		this.available_units = available_units;
		this.expiration_date = expiration_date;
	}
	
	public Integer getBiomaterial_id() {
		return biomaterial_id;
	}
	
	public void setBiomaterial_id(Integer biomaterial_id) {
		this.biomaterial_id = biomaterial_id;
	}
	
	public Integer getUtility_id() {
		return utility_id;
	}
	
	public void setUtility_id(Integer utility_id) {
		this.utility_id = utility_id;
	}
	
	public Integer getMaintenance_id() {
		return maintenance_id;
	}
	
	public void setMaintenance_id(Integer maintenance_id) {
		this.maintenance_id = maintenance_id;
	}
	
	public String getName_product() {
		return name_product;
	}
	
	public void setName_product(String name_product) {
		this.name_product = name_product;
	}
	
	public Float getPrice_unit() {
		return price_unit;
	}
	
	public void setPrice_unit(Float price_unit) {
		this.price_unit = price_unit;
	}
	
	public Integer getAvailable_units() {
		return available_units;
	}
	
	public void setAvailable_units(Integer available_units) {
		this.available_units = available_units;
	}
	
	public Date getExpiration_date() {
		return expiration_date;
	}
	
	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}	
}


package com.fptxurdinaga.springbootmvc.domain.onetoone;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "PhoneDetails")
@Data
public class PhoneDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String provider;

    private String technology;

    public PhoneDetails() {
		super();
		//this.id = id;
		this.provider = "Xiaomi";
		this.technology = "5G";
	}
    
	public PhoneDetails(Long id, String provider, String technology) {
		super();
		this.id = id;
		this.provider = provider;
		this.technology = technology;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}


}

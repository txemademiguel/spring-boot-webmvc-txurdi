package com.fptxurdinaga.springbootmvc.domain.onetoone;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Phone")
@Data
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "`number`")
    private String number;

    @OneToOne
    @JoinColumn(name = "details_id")
    private PhoneDetails details;

    // constructores
    public Phone() {
		super();
		//this.id = 0;
		this.number = "555555555";
		this.details = new PhoneDetails() ;
	}
    public Phone(Long id, String number, PhoneDetails details) {
		super();
		this.id = id;
		this.number = number;
		this.details = details;
	}
    
    // Getters and Setters
	public Long getId() {
		return id;
	}

	

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneDetails getDetails() {
		return details;
	}

	public void setDetails(PhoneDetails details) {
		this.details = details;
	}

    //Se omiten los getter y setters por brevedad

}

package com.fptxurdinaga.springbootmvc.domain.complex;

import lombok.ToString;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USERS_GROUPS")
@ToString
public class UserGroup {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "USER_GROUP_ID")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    // additional fields
    private boolean activated;
    @Column(name = "REGISTERED_DATE")
    @Temporal(TemporalType.DATE)
    private Date registeredDate;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    
    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
}
